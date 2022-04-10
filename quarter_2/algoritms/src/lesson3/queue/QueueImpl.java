package lesson3.queue;


public class QueueImpl<E> implements Queue<E> {

    private final E[] data;
    private int size;
    private int tail;
    private int head;

    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        tail = -1;
        head = 0;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }

        ++tail;
        if (tail == data.length) {
            tail = 0;
        }
        data[tail] = value;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        if (head == data.length) {
            head = 0;
        }
        E value = data[head];
        data[head] = null;
        head++;

        size--;
        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
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
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        int index;

        for (int i = 0; i < size; i++) {
            index = head + i;
            if (index > data.length - 1) {
                index = index - data.length;
            }
            sb.append(data[index]);
            if (i != size - 1) {
                 sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
}
