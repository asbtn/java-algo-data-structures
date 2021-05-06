package com.alisasbbtn.datastructures;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {

    private Node head;
    private Node tail; // optional
    private int length; // optional

    public class Node {

        private T value;
        private Node next;

        Node(T value) {
            this.value = value;
            next = null;
        }

        public T getValue() {
            return value;
        }
    }

    public SinglyLinkedList() {
        length = 0;
        head = null;
        tail = null;
    }

    public int getLength() {
        return length;
    }

    public SinglyLinkedList<T> push(T value) {
        // 1) This function should accept a value
        // 2) Create a new node using the value passed to the function
        // 3) If there is no head property on the list, set the head and tail to be the newly created code
        // 4) Otherwise set the next property on the tail to be the new node
        //    and set the tail property on the list to be the newly created node
        // 5) Increment the length by one

        Node node = new Node(value);

        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;

        length++;

        return this;
    }

    public T pop() {
        // 1) If there are no nodes in the list return undefined
        // 2) Loop through the list until you reach the tail
        // 3) Set the next property of the 2nd to the last node to be null
        // 4) Set the tail to be the 2nd to the last node
        // 5) Decrement the length of the list by 1
        // 6) Return the value of the node removed

        if (head == null) throw new NoSuchElementException();

        Node current = head;
        Node newTail = current;

        while (current.next != null) {
            newTail = current;
            current = current.next;
        }

        tail = newTail;
        tail.next = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return current.value;
    }

    public T shift() {
        // 1) If there are no nodes, return undefined
        // 2) Store the current head property in a variable
        // 3) Set the head property to be the current head's next property
        // 4) Decrement the length by 1
        // 5) Return the value of the node removed

        if (head == null) return null;

        Node currentHead = head;
        head = currentHead.next;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return currentHead.value;
    }

    public SinglyLinkedList<T> unshift(T value) {
        // 1) This function should accept a value
        // 2) Create a new node using the value passed to the function
        // 3) If there is no head property on the list, set the head and tail to be the newly created node
        // 4) Otherwise set the newly created node's next property to be the current head property on the list
        // 5) Set the head property on the list to be that newly created node
        // 6) Increment the length of the list by 1
        // 7) Return the linked list

        Node node = new Node(value);

        if (head == null) {
            tail = node;
        } else {
            node.next = head;
        }
        head = node;

        length++;

        return this;
    }

    public Node get(int index) {
        // 1) This function should accept an index
        // 2) If the index is less than zero or greater than or equal to the length of the list return null
        // 3) Loop through the list until you reach the index and return the node at that specific index.

        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();

        Node current = head;

        int counter = 0;
        while (counter != index) {
            current = current.next;
            counter++;
        }

        return current;
    }

    public SinglyLinkedList<T> set(int index, T value) {
        // 1) This function should accept an index and a value
        // 2) Use your get function to find the specific node
        // 3) If the node is not found return false
        // 4) If the node is found set the value of that node to be the value passed to the function and return true

        Node node = get(index);
        node.value = value;

        return this;
    }

    public SinglyLinkedList<T> insert(int index, T value) {
        // 1) If the index is less than zero or greater than the length return false
        // 2) If the index is the same as the length, push a new node to the end of the list
        // 3) If the index is 0 unshift a new node to the start of the list
        // 4) Otherwise, using the get method, access the node at the index - 1
        // 5) Set the next property on than node to be the new node

        if (index < 0 || index > length) throw new IndexOutOfBoundsException();

        if (index == length) return push(value);
        if (index == 0) return unshift(value);

        Node newNode = new Node(value);
        Node previousNode = get(index - 1);
        Node temp = previousNode.next;
        previousNode.next = newNode;
        newNode.next = temp;

        length++;

        return this;
    }

    public T remove(int index) {
        // 1) If the index is less than zero or greater than the length return undefined
        // 2) If the index is the same as the length-1, pop
        // 3) If the index is 0, shift
        // 4) Otherwise, using the get method access the node at the index - 1
        // 5) Set the next property on that node to be the next of the next node
        // 6) Decrement the length
        // 7) Return the value of the node removed

        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();

        if (index == length - 1) return pop();
        if (index == 0) return shift();

        Node previousNode = get(index - 1);
        Node removedNode = previousNode.next;
        previousNode.next = removedNode.next;

        length--;

        return removedNode.value;
    }

    public SinglyLinkedList<T> reverse() {
        Node node = head;
        head = tail;
        tail = node;

        Node next;
        Node prev = null;

        for (int i = 0; i < length; i++) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return this;
    }

//    public void traverse() {
//        Node current = head;
//        while (current != null) {
//            current = current.next;
//        }
//        System.out.println();
//    }
}

