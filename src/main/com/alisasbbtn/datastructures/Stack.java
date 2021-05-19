package com.alisasbbtn.datastructures;

import java.util.NoSuchElementException;

public class Stack<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    static private class Node<T> {

        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            next = null;
        }
    }

    public Stack() {
        first = null;
        last = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int push(T value) {
        // The function should accept a value
        // Create a new node with that value
        // If there are no nodes in the stack, set the first and last property to be the newly created node
        // If there is at least one node, create a variable that stores the current first property on the stack
        // Reset the first property to be the newly created node
        // Set the next property on the node to be the previously created variable
        // Increment the size of the stack by 1

        Node<T> node = new Node<>(value);

        if (first == null) {
            last = node;
            first = node;
        } else {
            Node<T> currentFirst = first;
            first = node;
            first.next = currentFirst;
        }

        return ++size;
    }

    public T pop() {
        // If there are no nodes in the stack, return null
        // Create a temporary variable to store the first property on the stack
        // If there is only 1 node, set the first and last property to be null
        // If there is more than one node, set the first property to be the next property on the current first
        // Decrement the size by 1
        // Return the value of the node removed

        if (first == null) throw new NoSuchElementException();

        Node<T> currentFirst = first;

        if (first == last) {
            last = null;
        }
        first = first.next;
        size--;

        return currentFirst.value;
    }
}
