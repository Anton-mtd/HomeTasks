package hometask_2_Algorithms.arrayList;
import hometask_2_Algorithms.MyListInterface;

import java.util.Optional;


public class MyArrayList<E> implements MyListInterface<E> {

    private E[] array;
    private int size = 0;
    private final int BASE_CAPACITY = 10;

    public MyArrayList() {
        array = (E[]) new Object[BASE_CAPACITY];
    }

    private void increaseArrayCapacity() {
        int newCapacity = array.length + array.length / 2 + 1;
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public void add(int index, E e) {
        checkIndex(index);
        moveElements(index, 1);
        array[index] = e;
        size++;
    }

    @Override
    public void add(E e) {
        if (size == array.length) {
            increaseArrayCapacity();
        }
        array[size] = (E) e;
        size++;
    }

    @Override
    public void delete(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i] == e) {
                delete(i);
                break;
            }
        }
    }

    @Override
    public void delete(int index) {
        checkIndex(index);
        moveElements(index, 0);
        size--;
    }

    @Override
    public E get(Integer index) {
        checkIndex(index);
        return array[index];
    }


    private void moveElements(Integer index, int directions) {
        if (array.length == size) {
            increaseArrayCapacity();
        }
        int i = 0;
        int nextPos = index + 1;

        E nextEl = array[nextPos];
        E currentEl = array[index];

        if (directions == 1) {
            while (nextEl != null)
            {
                nextEl = array[nextPos + i];
                array[nextPos + i] = currentEl;
                currentEl = nextEl;
                i++;
            }
        } else if (directions == 0) {
            while (nextEl != null || array[size - 1] != nextEl)
            {
                nextEl = array[nextPos + i];
                array[index + i] = nextEl;
                i++;
            }

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
        Optional<E> optional;
        for (int i = 0; i < array.length; i++) {
            optional = Optional.ofNullable(array[i]);
            if (i != 0 && optional.isPresent()) {
                sb.append(", ");
            }
            if (optional.isPresent()) {
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }
}
