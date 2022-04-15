package lesson4.deque;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {

    protected Node<E> first;
    protected int size;

    @Override
    public void insertFirst(E value) {
        Node<E> newNode = new Node<>(value, first, null);
        if (first != null) {
            first.previous = newNode;
        }
        first = newNode;
        size++;
    }


    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;
        if (size > 1) {
            first.previous = null;
            size--;
            return removedNode.value;
        }
        size--;
        return removedNode.value;
    }

    @Override
    public boolean remove(E value) {

        if (isEmpty()) return false;

        Node<E> current = first;

        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }
            current = current.next;
        }

        if (current == first) {
            removeFirst();
            return true;
        }

        if (current.next == null) {
            current.previous.next = null;
            current.previous = null;
            return true;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            current.previous = null;
            current.next = null;
            return true;
        }

    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != null;
    }

    private Node<E> indexOf(E value) {
        Node<E> current = first;

        while (current != null) {
            if (current.value.equals(value)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Node<E> current = first;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }

    @Override
    public E getFirst() {
        return first.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator(this);
    }


    private class ListIterator implements Iterator {

        SimpleLinkedListImpl simpleLinkedList;
        Node<E> current;


        public ListIterator(SimpleLinkedListImpl simpleLinkedList) {
            this.simpleLinkedList = simpleLinkedList;
            reset();
        }


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E value = (E) current.value;
            current = current.next;
            return value;
        }

        public void reset(){
             current = simpleLinkedList.first;
        }
    }
}
