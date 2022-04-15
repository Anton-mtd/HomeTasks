package lesson4.deque;

public interface LinkedList<E> {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

    E getFirst();

    class Node<E> {
        E value;
        Node<E> next;
        Node<E> previous;

        public Node(E value, Node<E> next, Node<E> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}

