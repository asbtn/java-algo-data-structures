package com.alisasbbtn.datastructures;

import java.util.NoSuchElementException;

public class Queue<T> {
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

    public Queue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int enqueue(T value) {
        // This function accepts some value
        // Create a new node using that value passed to the function
        // If there are no nodes in the queue,
        //  set this node to be the first and last property of the queue
        // Otherwise, set the next property on the current last to be that node,
        //  and then set the last property of the queue to be that node
        // Increment the size of the queue by 1

        Node<T> node = new Node<>(value);

        if (first == null) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;

        return ++size;
    }

    public T dequeue() {
        // If there is no first property, just return null
        // Store the first property in a variable
        // See if the first is the same as the last (check if there is only 1 node).
        // If so, set the first and last to be null
        // If there is more than 1 node, set the first property to be the next property of first
        // Decrement the size by 1
        // Return the value of the node dequeued

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
