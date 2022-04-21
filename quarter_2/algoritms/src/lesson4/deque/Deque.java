package lesson4.deque;

public class Deque<E> extends TwoSideLinkedListImpl<E> {

    private final TwoSideLinkedListImpl<E> data;

    public Deque() {
        this.data = new TwoSideLinkedListImpl<>();
    }


    @Override
    public void insertFirst(E value) {
        data.insertFirst(value);
    }


    @Override
    public void insertLast(E value) {
        data.insertLast(value);
    }


    @Override
    public E getFirst() {
        return data.getFirst();
    }


    @Override
    public E getLast() {
        return data.getLast();
    }


    @Override
    public E removeFirst() {
        return data.removeFirst();
    }


    @Override
    public E removeLast() {
        return data.removeLast();
    }


    @Override
    public boolean remove(E value) {
        return data.remove(value);
    }


    @Override
    public boolean contains(E value) {
        return data.contains(value);
    }


    @Override
    public int size() {
        return data.size();
    }


    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }


    @Override
    public void display() {
        data.display();
    }


    @Override
    public void displayReverse() {
        data.displayReverse();
    }

}
