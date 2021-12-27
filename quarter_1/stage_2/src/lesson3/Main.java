package lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] stringsArray = {"Андрей", "Стас", "Дмитрий", "Роман", "Ярослав",
                                 "Денис", "Станислав", "Евгений", "Леонид", "Константин",
                                 "Андрей", "Стас", "Дмитрий", "Андрей"};
        Set<String> set = new HashSet<>(Arrays.asList(stringsArray));  // Создаем коллекцию типа Set чтобы убрать повторения

        int counterTimes;  // переменная для подсчета повторений
        for (String setElement : set) {
            counterTimes = 0;
            for (String string : stringsArray) {
                if (setElement.equals(string)) {
                    counterTimes++;
                }
            }
            System.out.println("Значение \"" + setElement + "\" встречается в массиве " + counterTimes + " раз");
        }
        System.out.println("______________________________________________");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Сидоров", "8 962 352 23 44");
        phoneBook.add("Петров", "8 905 782 33 44");
        phoneBook.add("Иванов", "8 988 101 55 35");
        phoneBook.add("Кузнецов", "8 905 889 33 44");
        phoneBook.add("Кирсанова", "8 922 782 33 44");
        phoneBook.add("Кирсанова", "8 972 344 41 40");
        phoneBook.add("Ромащенко", "8 910 082 82 14");
        phoneBook.add("Рябая", "8 905 782 38 44");
        phoneBook.add("Сидоров", "8 912 452 33 44");

        phoneBook.get("Кирсанова");
        phoneBook.get("Рябая");
        phoneBook.get("Сидоров");
    }
}
