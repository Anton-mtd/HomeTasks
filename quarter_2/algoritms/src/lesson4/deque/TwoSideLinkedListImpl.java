package lesson4.deque;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {


    protected Node<E> last;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            last = first;
        }
    }

    @Override
    public void insertLast(E value) {
        if (isEmpty()) {
            insertFirst(value);
            return;
        }
        last.next = last = new Node<>(value, null, last);
        size++;
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();

        if (isEmpty()) {
            last = null;
        }

        return removedValue;
    }


    @Override
    public E getLast() {
        return last.value;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = last;
        last = removedNode.previous;
        removedNode.previous = null;
        if (size > 1) {
            last.next = null;
            size--;
            return removedNode.value;
        }
        size--;
        return removedNode.value;
    }

    public void displayReverse() {
        StringBuilder sb = new StringBuilder("[");

        Node<E> current = last;
        while (current != null) {
            sb.append(current.value);
            if (current.previous != null) {
                sb.append(" -> ");
            }
            current = current.previous;
        }
        System.out.println(sb.append("]"));
    }
}
