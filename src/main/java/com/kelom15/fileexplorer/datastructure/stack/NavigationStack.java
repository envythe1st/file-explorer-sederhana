package com.kelom15.fileexplorer.datastructure.stack;

import java.util.ArrayList;
import java.util.List;

public class NavigationStack<T> {

    private final List<T> stack;

    public NavigationStack() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {

        if (isEmpty()) {
            return null;
        }

        return stack.remove(stack.size() - 1);

    }

    public T peek() {

        if (isEmpty()) {
            return null;
        }

        return stack.get(stack.size() - 1);

    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void clear() {
        stack.clear();
    }

    public void printStack() {

        System.out.println("===== Navigation Stack =====");

        for (int i = stack.size() - 1; i >= 0; i--) {

            System.out.println(stack.get(i));

        }

    }

}
