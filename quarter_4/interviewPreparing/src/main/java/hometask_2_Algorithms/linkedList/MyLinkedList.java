package hometask_2_Algorithms.linkedList;

import hometask_2_Algorithms.MyListInterface;


public class MyLinkedList<E> implements MyListInterface<E> {

    Node<E> first;
    Node<E> last;
    private int size = 0;


    @Override
    public void add(int index, E e) {
        checkIndex(index);
        if (index == 0) {
            Node<E> insertNode = new Node<>(e, first, null);
            first.previous = insertNode;
            first = insertNode;
        } else if (index == size - 1) {
            Node<E> insertNode = new Node<>(e, null, last);
            last.next = insertNode;
            last = insertNode;
        } else {
            Node<E> currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            Node<E> insertNode = new Node<>(e, currentNode, currentNode.previous);
            currentNode.previous.next = insertNode;
            currentNode.previous = insertNode;
        }
        size++;
    }


    @Override
    public void add(E e) {
        if (first == null) {
            first = new Node<E>(e, null, null);
            last = first;

        } else if (last == first) {
            Node<E> insertNode = new Node<>(e, null, first);
            last = insertNode;
            first.next = insertNode;
        } else {
            Node<E> insertNode = new Node<>(e, null, last);
            last.next = insertNode;
            last = insertNode;
        }

        size++;
    }

    @Override
    public void delete(E e) {
        Node<E> currentNode = first;
        int index = 0;
        boolean isFind = false;
        for (int i = 0; i < size; i++) {
            if (currentNode.value == e){
                isFind = true;
                break;
            }
            index++;
            currentNode = currentNode.next;
        }
        if (isFind) {
            delete(index);
        }
    }

    @Override
    public void delete(int index) {
        checkIndex(index);
        if (index == 0) {
            first.next.previous = null;
            first = first.next;
        } else if (index == size - 1) {
            last.previous.next = null;
            last = last.previous;
        } else {
            Node<E> currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
            currentNode.value = null;
            currentNode.next = null;
            currentNode.previous = null;
        }
        size--;
    }

    @Override
    public E get(Integer index) {
        checkIndex(index);

        Node<E> currentNode = first;
        if (index == 0) {
            return first.value;
        } else if (index == size - 1) {
            return last.value;
        } else {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.value;
        }
    }


    private void checkIndex(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("index " + index + " is bigger then last index " + (size - 1));
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> currentNode = first;
        for (int i = 0; i < size; i++) {
            if (i != 0 && first != null) {
                sb.append(", ");
            }
            sb.append(currentNode.value);
            currentNode = currentNode.next;
        }
        return sb.toString();
    }
}
