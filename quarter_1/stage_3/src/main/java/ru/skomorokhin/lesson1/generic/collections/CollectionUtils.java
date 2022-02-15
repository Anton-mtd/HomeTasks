package ru.skomorokhin.lesson1.generic.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CollectionUtils {

    public static <T, R> List<R> transform(List<T> collection, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T value : collection) {
            result.add(function.apply(value));
        }

        return result;

        // <? super T>        любые родители класса Т
        // <T extends Number> любые наследники Number

    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("1");
        input.add("2");
        input.add("2");
        input.add("2");
        input.add("2");
        input.add("2");
        input.add("1");



//        List<Integer> out = CollectionUtils.transform(input, new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return Integer.parseInt(s);
//            }
//        });

       /* List<Integer> out = CollectionUtils.transform(input, Integer::parseInt);

        for (Integer integer : out) {
            System.out.println(integer + " " + integer.getClass().getSimpleName());
        }*/

    }

}
