package hometask_2_Algorithms.linkedList;

public class Node<E> {

    protected E value;
    protected Node<E> next;
    protected Node<E> previous;


    public Node( E value, Node<E> next, Node<E> previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
}
