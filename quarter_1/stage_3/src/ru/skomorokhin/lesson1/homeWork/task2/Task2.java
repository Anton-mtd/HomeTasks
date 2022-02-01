package ru.skomorokhin.lesson1.homeWork.task2;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        String [] strings = {"one", "two", "three", "four"};
        List list = transformToArrayList(strings);
        System.out.println(list);
    }

    public static <T> List<T> transformToArrayList(T[] array){
        List<T> list = new ArrayList<>();
        for (T value : array) {
            list.add(value);
        }
        return list;
    }
}
