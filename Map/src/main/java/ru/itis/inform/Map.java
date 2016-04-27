package ru.itis.inform;

/**
 * Created by Тимур on 27.04.2016.
 */
public interface Map<K, V> {
    void put(K key, V value);
    void delete(K key);
    int size();
    boolean isEmpty();
    boolean containsKey(K key);
    V get(Object key);
    void clear();

}
