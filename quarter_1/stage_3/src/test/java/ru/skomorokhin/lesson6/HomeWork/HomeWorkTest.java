package ru.skomorokhin.lesson6.HomeWork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class HomeWorkTest {

    Integer[] array1 = {7, 4, 23, 5, 4, 8, 9, 10};
    Integer[] array2 = {1, 14, 3, 5, 2, 8, 9, 10};
    Integer[] array3 = {8, 9, 22, 5, 32, 8, 3, 12};
    Integer[] array4 = {4, 9, 22, 5, 31, 8, 3, 11};
    HomeWork homeWork6 = new HomeWork();


    @Test
    void test_containsOneOrFour1() {
        boolean result = homeWork6.containsOneOrFour(array1);
        Assertions.assertTrue(result);
    }

    @Test
    void test_containsOneOrFour2() {
        boolean result = homeWork6.containsOneOrFour(array2);
        Assertions.assertTrue(result);
    }

    @Test
    void test_containsOneOrFour3() {
        boolean result = homeWork6.containsOneOrFour(array3);
        Assertions.assertFalse(result);
    }


    @Test
    void test_getArrayAfterNumberFour1() {
        Integer[] result = homeWork6.getArrayAfterNumberFour(array1);
        Assertions.assertArrayEquals(new Integer[]{8, 9, 10}, result);
    }

    @Test()
    void test_getArrayAfterNumberFour2() {
        Assertions.assertThrows(RuntimeException.class, () -> homeWork6.getArrayAfterNumberFour(array2));
    }

    @Test
    void test_getArrayAfterNumberFour3() {
        Integer[] result = homeWork6.getArrayAfterNumberFour(array4);
        Assertions.assertArrayEquals(new Integer[]{9, 22, 5, 31, 8, 3, 11}, result);
    }

}