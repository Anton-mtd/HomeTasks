package ru.skomorokhin.lesson7.HomeWork;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClassTestRunner {

    public static void main(String[] args) throws Exception {
        start(MyClassTest.class, 2,4);

    }

    public static void start(Class <MyClassTest> clazz, int numberOne, int numberTwo) throws Exception {
        Object object = clazz.getDeclaredConstructor().newInstance();

        Method[] methods = clazz.getDeclaredMethods();
        List<Method> methodsForTest = new ArrayList<>();
        boolean beforeMethodIsExist = false;
        boolean afterMethodIsExist = false;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                methodsForTest.add(method);
            }
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (!beforeMethodIsExist) {
                    beforeMethodIsExist = true;
                } else {
                    throw new RuntimeException("Больше одного метода с аннотацией BeforeSuite");
                }
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (!afterMethodIsExist) {
                    afterMethodIsExist = true;
                } else throw new RuntimeException("Больше одного метода с аннотацией AfterSuite");
            }
            methodsForTest.sort(new Comparator<Method>() {
                @Override
                public int compare(Method o1, Method o2) {
                    return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
                }
            });

        }

        if (beforeMethodIsExist) {
            clazz.getDeclaredMethod("init", int.class, int.class).invoke(object, numberOne, numberTwo);
        }
        for (Method method : methodsForTest) {
            method.invoke(object);
        }
        if (afterMethodIsExist) {
            clazz.getDeclaredMethod("stop").invoke(object);
        }
    }
}
