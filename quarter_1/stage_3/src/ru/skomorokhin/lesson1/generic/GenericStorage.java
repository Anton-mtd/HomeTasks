package ru.skomorokhin.lesson1.generic;

public interface GenericStorage<E> {

    void add(E value);

    void add(E value, int index);

    void remove(int index);

    E get(int index);

    boolean contains(E value);

    void display();

    Pair<E, Integer> min();

}
