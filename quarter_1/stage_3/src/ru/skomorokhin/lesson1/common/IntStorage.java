package ru.skomorokhin.lesson1.common;

public class IntStorage {

    private Integer[] data;
    private int currentSize;

    public IntStorage(int size) {
        this.data = new Integer[size];
    }

    public Integer get(int index) {
        return data[index];
    }

    public void add(Integer value) {
        add(value, currentSize);
    }

    public void add(Integer value, int index) {
        data[index] = value;
        currentSize++;
    }

    public void remove(int index) {
        data[index] = 0;
        currentSize--;
    }

    public boolean contains(Integer value) {
        for (int i = 0; i < currentSize; i++) {
            if (value.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}