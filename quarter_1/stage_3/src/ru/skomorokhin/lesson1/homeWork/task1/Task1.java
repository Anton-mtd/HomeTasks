package ru.skomorokhin.lesson1.homeWork.task1;

public class Task1 {

    public static void main(String[] args) {
        String [] strings = {"one", "two", "three", "four", "five"};

        reverseElementsInArray(strings, 1, 4);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void reverseElementsInArray(Object[] array, int srcPosition, int dstPosition) {
        Object valueInMemory = array[dstPosition];
        array[dstPosition] = array[srcPosition];
        array[srcPosition] = valueInMemory;
    }
}
