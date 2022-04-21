package lesson4;
import lesson4.deque.Deque;
import lesson4.deque.SimpleLinkedListImpl;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {

        System.out.println("ТЕСТ DEQUE________________________");

        Deque<Integer> deque = new Deque<>();

        deque.insertFirst(1);
        deque.insertFirst(2);
        deque.insertFirst(3);
        deque.insertFirst(4);
        deque.insertFirst(5);
        deque.insertFirst(6);

        deque.display();
        deque.displayReverse();

        deque.insertLast(7);
        deque.insertLast(8);

        deque.display();


        deque.removeFirst();
        deque.display();
        deque.removeLast();
        deque.display();
        deque.remove(2);
        deque.display();
        System.out.println("_____________________________________");


        System.out.println("ТЕСТ ITERATOR в SimpleLinkedListImpl________________________");

        SimpleLinkedListImpl <Integer> linkedList = new SimpleLinkedListImpl();
        linkedList.insertFirst(4);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(9);
        linkedList.insertFirst(8);
        linkedList.insertFirst(10);
        linkedList.insertFirst(12);


        for (Integer integer : linkedList) {
            System.out.println(integer);
            if (integer == 9) break;
        }

        System.out.println();
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }

        System.out.println("_____________________________________");


    }
}
