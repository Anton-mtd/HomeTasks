package ru.skomorokhin.lesson7.HomeWork;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClassTestRunner {

    public static void main(String[] args) throws Exception {
        start(MyClassTest.class, 3,4);

    }

    public static void start(Class clazz, int numberOne, int numberTwo) throws Exception {
        Object object = clazz.getDeclaredConstructor().newInstance();

        Method[] methods = clazz.getDeclaredMethods();
        List<Method> methodsForTest = new ArrayList<>();
        Method beforeMethod = null;
        Method afterMethod = null;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                methodsForTest.add(method);
            }
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMethod == null) {
                    beforeMethod = method;
                } else {
                    throw new RuntimeException("Больше одного метода с аннотацией BeforeSuite");
                }
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod == null) {
                    afterMethod = method;
                } else throw new RuntimeException("Больше одного метода с аннотацией AfterSuite");
            }
            methodsForTest.sort(new Comparator<Method>() {
                @Override
                public int compare(Method o1, Method o2) {
                    return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
                }
            });

        }

        if (beforeMethod != null) {
            beforeMethod.invoke(object, numberOne, numberTwo);
        }
        for (Method method : methodsForTest) {
            method.invoke(object, null);
        }
        if (afterMethod != null) {
            afterMethod.invoke(object, null);
        }

    }
}
