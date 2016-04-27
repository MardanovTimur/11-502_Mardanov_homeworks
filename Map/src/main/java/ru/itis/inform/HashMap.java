package ru.itis.inform;

import java.util.ArrayList;

/**
 * Created by Тимур on 27.04.2016.
 */
public class HashMap<K, V> implements Map<K,V> {

    private static int CAPACITY = 16;
    private int capacity_elements = 0;
    private Node<K,V>[] hashTable = new Node[16];

    static class Node<K, V> {
        private int hashCode;
        private K key;
        private V value;
        private Node<K,V> next;

        public Node() {
        }

        Node(int hashCode, K key, V value, Node<K,V> next) {
            this.hashCode = hashCode;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getHash() {
            return hashCode;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public static int hashCode(String key){
            int hashCode = 0;
            for (int i = 0; i < key.length(); i++) {
                hashCode += key.charAt(i)*Math.pow(31,key.length()-1-i);
            }
            return hashCode;
        }

        private int hash() {
            return (this.hashCode % CAPACITY);
        }
    }


    public HashMap() {
        for (int i = 0; i < CAPACITY; i++) {
            hashTable[i] = new Node<K, V>();
        }
    }

    public HashMap(int capacity) {
        this.CAPACITY = capacity;
        hashTable = new Node[capacity];
    }

    public void put(K key, V value) {
        capacity_elements++;
        Node<K,V> newNode = new Node<K, V>(Node.hashCode((String)key),key,value,null);
        for (int i = 0; i < CAPACITY; i++) {
            int hash =  newNode.hash();

            if (i==hash) {
                newNode.setNext(hashTable[i]);
                hashTable[i] = newNode;
            }
        }
    }

    public void delete(K key) {

    }

    public int size() {
        return CAPACITY;
    }

    public boolean isEmpty() {
        if (capacity_elements<0) {
            return true;
        } else
            return false;
    }

    public boolean containsKey(K key) {
        return false;
    }

    public V get(Object key) {
        return null;
    }

    public void clear() {

    }
}
