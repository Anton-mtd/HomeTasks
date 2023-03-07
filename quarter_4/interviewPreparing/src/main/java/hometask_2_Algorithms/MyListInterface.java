package hometask_2_Algorithms;

public interface MyListInterface<E> {

    void add(int index, E e);

    void add(E e);

    void delete(E e);

    void delete(int index);

    E get(Integer index);
}
