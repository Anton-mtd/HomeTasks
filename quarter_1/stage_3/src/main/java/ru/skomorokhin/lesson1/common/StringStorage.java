package ru.skomorokhin.lesson1.common;

public class StringStorage  {

    private String[] data;
    private int currentSize;

    public StringStorage(int size) {
        this.data = new String[size];
    }

    public String get(int index) {
        return data[index];
    }

    public void add(String value) {
        add(value, currentSize);
    }

    public void add(String value, int index) {
        data[index] = value;
        currentSize++;
    }

    public void remove(int index) {
        data[index] = "";
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