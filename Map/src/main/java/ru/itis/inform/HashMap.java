package ru.itis.inform;

import java.util.ArrayList;

/**
 * Created by Тимур on 27.04.2016.
 */
public class HashMap<K, V> implements Map<K, V> {

    private static int CAPACITY = 16;
    private int capacity_elements = 0;
    private Node<K, V>[] hashTable;

    static class Node<K, V> {
        private int hashCode;
        private K key;
        private V value;
        private Node<K, V> next;

        public Node() {
        }

        Node(int hashCode, K key, V value, Node<K, V> next) {
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

        public static int hashCode(String key) {
            int hashCode = 0;
            for (int i = 0; i < key.length(); i++) {
                hashCode += key.charAt(i) * Math.pow(31, key.length() - 1 - i);
            }
            return hashCode;
        }

        private int hash() {
            return (this.hashCode % CAPACITY);
        }

        private static int hashIndex(int hashCode) {
            return (hashCode % CAPACITY);
        }
    }


    public HashMap() {
        hashTable = new Node[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            hashTable[i] = new Node<K, V>();
        }
    }

    public HashMap(int capacity) {
        hashTable = new Node[capacity+1];
        this.CAPACITY = capacity;
        hashTable = new Node[capacity];
    }

    public void put(K key, V value) {
        capacity_elements++;

        if (capacity_elements > (0.75) * this.CAPACITY) {
            HashMap.CAPACITY = CAPACITY * 2;

        }

        Node<K, V> newNode = new Node<K, V>(Node.hashCode((String) key), key, value, null);
        for (int i = 0; i < CAPACITY; i++) {
            int hash = newNode.hash();

            if (i == hash) {
                newNode.setNext(hashTable[i]);
                hashTable[i] = newNode;
            }
        }

    }

    private void increaseArray() {
        Node<K,V>[] newHashTable = new Node[CAPACITY];
        for (int i = 0; i< CAPACITY; i++) {
            newHashTable[i] = new Node<K,V>();
        }
        
    }

    public void delete(K key) {
        String s = (String) key;
        int hashCode = Node.hashCode(s);
        int hash = Node.hashIndex(hashCode);
        Node<K, V> newNode = hashTable[hash];
        if (newNode.key == key) {
            hashTable[hash] = newNode.getNext();
            return;
        }
        while (newNode.getNext().key != key) {
            newNode = newNode.getNext();
        }
        newNode.setNext(newNode.getNext().getNext());
    }

    public int size() {
        return CAPACITY;
    }

    public boolean isEmpty() {
        if (capacity_elements < 0) {
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
