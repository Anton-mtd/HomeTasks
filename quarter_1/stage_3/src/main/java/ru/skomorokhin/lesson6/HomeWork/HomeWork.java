package ru.skomorokhin.lesson6.HomeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HomeWork {


    public boolean containsOneOrFour(Integer[] array) {
        List<Integer> list = Arrays.asList(array);
        if (list.contains(4) || list.contains(1)) {
            return true;
        } else return false;
    }

    public Integer[] getArrayAfterNumberFour(Integer[] array) {
        List<Integer> list = Arrays.asList(array);
        if (!list.contains(4)) {
            throw new RuntimeException("В массиве нет числа 4");
        }
        List<Integer> readyList = new ArrayList<>();
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) == 4) {
                break;
            }
            readyList.add(list.get(i));
        }
        Collections.reverse(readyList);
        return readyList.stream().toArray(Integer[]::new);
    }
}
