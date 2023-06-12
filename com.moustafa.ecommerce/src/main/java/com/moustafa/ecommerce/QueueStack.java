package com.moustafa.ecommerce;

import java.util.Stack;

public class QueueStack{
    private Stack<Integer> stack;

    public QueueStack() {
        stack = new Stack<Integer>();
    }

    public void enqueue(int value) {
        stack.push(value);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        if (stack.size() == 1) {
            return stack.pop();
        }

        int front = stack.pop();
        int dequeuedItem = dequeue();
        stack.push(front);
        return dequeuedItem;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        if (stack.size() == 1) {
            return stack.peek();
        }

        int front = stack.pop();
        int peekedItem = peek();
        stack.push(front);
        return peekedItem;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getSize() {
        return stack.size();
    }
}