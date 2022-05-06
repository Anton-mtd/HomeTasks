
package lesson8;


import java.util.LinkedList;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private final LinkedList <Item<K,V>>[] data;
    private int size;


    public HashTableImpl(int initialCapacity) {
        this.data = new LinkedList[initialCapacity * 2];
    }

    public HashTableImpl() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        int indexFromHashFunc = hashFunc(key);

        if (data[indexFromHashFunc] == null) {
            LinkedList <Item<K,V>> linkedList = new LinkedList<>();
            data[indexFromHashFunc] = linkedList;
            linkedList.addFirst(new Item(key, value));
        } else {
            for (int i = 0; i < data[indexFromHashFunc].size(); i++) {
                if (isKeyEquals(data[indexFromHashFunc].get(i), key)) {
                    data[indexFromHashFunc].get(i).setValue(value);
                    return true;
                }
            }
            data[indexFromHashFunc].add(new Item(key, value));
        }

        size++;
        return true;
    }

    private boolean isKeyEquals(Item<K, V> item, K key) {
        return (item.getKey() == null) ? (key == null) : (item.getKey().equals(key));
    }

    private int hashFunc(K key) {
        return key.hashCode() * 1/4 % data.length;
    }


    @Override
    public V get(K key) {
        int index = indexOf(key);
        int indexFromHashFunc = hashFunc(key);
        return index == -1 ? null : data[indexFromHashFunc].get(index).getValue();
    }

    private int indexOf(K key) {
        int indexFromHashFunc = hashFunc(key);
        if (data[indexFromHashFunc] == null) {
           return -1;
        } else {
            for (int i = 0; i < data[indexFromHashFunc].size(); i++) {
                if (isKeyEquals(data[indexFromHashFunc].get(i),key)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public V remove(K key) {
        int indexFromHashFunc = hashFunc(key);
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }

        Item<K, V> removed = data[indexFromHashFunc].get(index);
        data[indexFromHashFunc].remove(index);
        if (data[indexFromHashFunc].isEmpty()) {
            data[indexFromHashFunc] = null;
        }

        return removed.getValue();
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
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%s = [%s]%n", i, data[i]));
        }
        return sb.toString();
    }
}
