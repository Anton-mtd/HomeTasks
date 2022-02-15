package ru.skomorokhin.lesson1.generic;

import java.io.Serializable;

public class GenericStorageImpl<E extends Object & Comparable<? super E> & Serializable> implements GenericStorage<E> {

    private E[] data;
    private int currentSize;

    public GenericStorageImpl(int size) {
        this.data = (E[]) new Object[size];
//        this.data = new E[size];
    }

    public E get(int index) {
        return data[index];
    }

    @Override
    public boolean contains(E value) {
        for (int i = 0; i < currentSize; i++) {
            if (value.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    public void add(E value) {
        add(value, currentSize);
    }

    public void add(E value, int index) {
        data[index] = value;
        currentSize++;
    }

    public void remove(int index) {
        data[index] = null;
        currentSize--;
    }

    public void display() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    @Override
    public Pair<E, Integer> min() {
        if (currentSize == 0) {
            return new Pair<>(null, -1);
        }

        int minIndex = 0;
        for (int i = 1; i < currentSize; i++) {
            if (data[i].compareTo(data[minIndex]) < 0) {
                minIndex = i;
            }
        }

        return new Pair<>(data[minIndex], minIndex);
    }


}
