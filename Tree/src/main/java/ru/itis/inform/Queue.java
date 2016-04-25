package ru.itis.inform;

import java.util.LinkedList;

/**
 * Created by Тимур on 28.03.2016.
 */
public class Queue<T> {
    private LinkedList<Root<T>> queue;
    private int iLength;

    public void setiLength(int iLength) {
        this.iLength = iLength;
    }

    public void setQueue(Root<T> queue) {
        this.queue.clear();
        this.queue.addLast(queue);
        this.iLength++;
    }

    public int summQueue() {
        int summVariable = 0;
        for (int i = 0; i < queue.size(); i++) {
            summVariable += (Integer) queue.get(i).getValue();
        }
        return summVariable;
    }

    public Root<T> getQueueLast() {
        return queue.getLast();
    }

    public Queue(LinkedList<Root<T>> queue) {
        this.queue = queue;
    }

    public Queue() {
        this.queue = new LinkedList<Root<T>>();
    }


    public void enqueue(Root<T> root) {
        this.queue.addFirst(root);
        this.iLength++;
    }

    public int getiLength() {
        return iLength;
    }

    public Root<T> dequeue() {
        Root<T> x = queue.getLast();

        this.queue.removeLast();
        this.iLength--;
        return x;
    }


    @Override
    public String toString() {
        String s = "";
        for (int i = queue.size() - 1; i >= 0; i--) {
            s = s + queue.get(i).getValue();
            if (i != 0) {
                s += ", ";
            }
        }
        return s;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
