package ru.itis.inform;

import java.util.ArrayList;

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

        public int getHashCode() {
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
        hashTable = new Node[capacity + 1];
        this.CAPACITY = capacity;
    }

    private void insert(Node<K, V>[] node, K key, V value) {
        capacity_elements++;

        Node<K, V> newNode = new Node<K, V>(Node.hashCode((String) key), key, value, null);
        for (int i = 0; i < CAPACITY; i++) {
            int hash = newNode.hash();

            if (i == hash) {
                newNode.setNext(node[i]);
                node[i] = newNode;
            }
        }

        if (capacity_elements > (0.75) * this.CAPACITY) {
            HashMap.CAPACITY = CAPACITY * 2;
            increaseArray();
        }
    }

    public void put(K key, V value) {
        insert(this.hashTable, key, value);
    }

    private void increaseArray() {
        Node<K, V>[] newHashTable = new Node[CAPACITY];
        capacity_elements = 0;
        for (int i = 0; i < CAPACITY; i++) {
            newHashTable[i] = new Node<K, V>();
        }
        int j = 0;
        while (j < CAPACITY / 2) {
            if (hashTable[j] != null) {
                Node<K, V> iterator = hashTable[j];
                while (iterator != null) {
                    insert(newHashTable,iterator.getKey(), iterator.getValue());
                    iterator = iterator.next;
                }
                iterator = null;
            }
            j++;
        }
        hashTable = new Node[CAPACITY];
        this.hashTable = newHashTable;
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
        String s = (String) key;
        int hashCodeKey = Node.hashCode(s);
        int hashIndexKey = Node.hashIndex(hashCodeKey);

        if (hashTable[hashIndexKey] != null) {
            Node<K,V> node = hashTable[hashIndexKey];
            while ( node.getHashCode()!=hashCodeKey) {
                node = node.getNext();
            }
            return node.getValue();
        } else {
            System.out.println("Element not found!");
            return null;
        }
    }

    public void clear() {

    }
}