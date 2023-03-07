package hometask_2_Algorithms.arrayList;


import hometask_2_Algorithms.linkedList.MyLinkedList;
import hometask_2_Algorithms.linkedList.Node;

public class Main {



    public static void main(String[] args) {

        MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
        for (int i = 1; i < 10; i++) {
            linkedList.add(i);
        }
        System.out.println(linkedList);
        linkedList.add(2,100);
        linkedList.add(100);
        System.out.println(linkedList);
        linkedList.delete(3);
        System.out.println(linkedList);
        linkedList.delete((Integer) 100);
        System.out.println(linkedList);
        System.out.println(linkedList.get(4));

        System.out.println("___________________________________________");


        MyArrayList <Integer> myArrayList = new MyArrayList<Integer>();

        for (int i = 1; i <= 10; i++) {
            myArrayList.add(i);
        }
        System.out.println(myArrayList);
        myArrayList.add(5,100);
        myArrayList.add(100);
        System.out.println(myArrayList);
        myArrayList.delete((Integer) 100);
        myArrayList.delete(0);
        System.out.println(myArrayList);
        System.out.println(myArrayList.get(8));


    }
}
