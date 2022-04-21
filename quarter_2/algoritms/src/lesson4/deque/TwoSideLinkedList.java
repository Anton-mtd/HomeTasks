package lesson4.deque;

public interface TwoSideLinkedList<E> extends LinkedList<E> {

    void insertLast(E value);

    E removeLast();

    E getLast();

}
