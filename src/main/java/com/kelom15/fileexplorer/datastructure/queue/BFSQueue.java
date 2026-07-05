package com.kelom15.fileexplorer.datastructure.queue;

import java.util.ArrayList;
import java.util.List;

public class BFSQueue<T> {

    private final List<T> queue;

    public BFSQueue() {
        queue = new ArrayList<>();
    }

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    public T peek() {

        if (isEmpty()) {
            return null;
        }

        return queue.get(0);

    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public void clear() {
        queue.clear();
    }

    public void printQueue() {

        System.out.println("===== BFS Queue =====");

        for (T item : queue) {

            System.out.println(item);

        }

    }

}
