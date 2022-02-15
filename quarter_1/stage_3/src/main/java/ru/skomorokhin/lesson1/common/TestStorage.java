package ru.skomorokhin.lesson1.common;

public class TestStorage {

    public static void main(String[] args) {
        CommonStorage intStorage = new CommonStorage(5);
        intStorage.add(1);
        intStorage.add("2",3);
        intStorage.display();


//        Integer o1 = (Integer) intStorage.get(0);
//
//        Object o2 = intStorage.get(1);
//        if (o2 instanceof String) {
//            System.out.println("Error o2 is string and can't be added");
//        } else if (o2 instanceof Integer){
//            Integer v2 = (Integer) intStorage.get(1);
//            System.out.println(o1 + v2);
//        }



        /*StringStorage stringStorage = new StringStorage(5);
        stringStorage.add("first");
        stringStorage.add("second");
        stringStorage.display();*/

    }
}
