package com.alisasbbtn.datastructures;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {
    private Node head;
    private Node tail; // optional
    private int length; // optional

    public class Node {

        private T value;
        private Node next;
        private Node prev;

        Node(T value) {
            this.value = value;
            next = null;
            prev = null;
        }

        public T getValue() {
            return value;
        }
    }

    public DoublyLinkedList() {
        length = 0;
        head = null;
        tail = null;
    }

    public DoublyLinkedList<T> push(T value) {
        // 1) Create a new node with the value passed to the function
        // 2) If the head property is null set the head and tail to be the newly created node
        // 3) If not, set the next property on the tail to be that node
        // 4) Set the prev property on the newly created code to be the tail
        // 5) Set the tail to be the newly created node
        // 6) Increment the length
        // 7) Return the list

        Node node = new Node(value);

        if (length == 0) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;

        length++;

        return this;
    }

    public T pop() {
        // 1) if no head return undefined
        // 2) Store the current tail in a variable to return later
        // 3) If the length is 1, set the head and tail to be null
        // 4) Update the tail to be the previous node
        // 5) Set the newTail's next to null
        // 6) Decrement the length
        // 7) Return the value removed

        Node currentTail = tail;

        if (length == 0) throw new NoSuchElementException();

        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = currentTail.prev;
            tail.next = null;
            currentTail.prev = null;
        }

        length--;

        return currentTail.value;
    }

    public T shift() {
        // 1) If length is 0, return undefined
        // 2) Store the current head property in a variable (old head)
        // 3) If the length is 1 set head & tail null
        // 4.1) Otherwise update the head to be the next of the old head
        // 4.2) Set the head prev property to null
        // 4.3) Set old head's next to null
        // 7) Decrement the length
        // 8) Return old head

        if (length == 0) throw new NoSuchElementException();

        Node oldHead = head;

        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = oldHead.next;
            head.prev = null;
            oldHead.next = null;
        }

        length--;

        return oldHead.value;

    }

    public DoublyLinkedList<T> unshift(T value) {
        // 1) Create a new node with the value passed to the function
        // 2) If the length is 0 set the head & tail to be the new node
        // 2.1) Otherwise set the prev on the head to be the new node
        // 2.2) Set the next on the new node to be the head
        // 2.3) Update the head to be the new node
        // 3) Increment the length
        // 4) Return the list

        Node node = new Node(value);

        if (length == 0) {
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
        }
        head = node;

        length++;

        return this;
    }

    public Node get(int index) {
        // 1) If the index is less than 0 or greater or equal to the length return null
        // 2) If the index is less than or equal to half the length of the list: loop through the list starting from the head and loop towards the middle
        // 3) Otherwise, loop through the list starting from the tail and loop towards the middle
        // 4) Return the node once it found

        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();

        Node current;
        int counter;

        if (index <= length / 2) {
            counter = 0;
            current = head;

            while (counter != index) {
                current = current.next;
                counter++;
            }
        } else {
            counter = length - 1;
            current = tail;

            while (counter != index) {
                current = current.next;
                counter--;
            }
        }

        return current;
    }

    public DoublyLinkedList<T> set(int index, T value) {
        // 1) Create a variable from get()
        // 2) Set the value of that node to be value passed to the function

        Node node = get(index);
        node.value = value;

        return this;
    }

    public DoublyLinkedList<T> insert(int index, T value) {
        // 1) If the index is less than zero or greater than or equal to the length return false
        // 2) If the index is 0, unshift
        // 3) If the index is the same as the length, push
        // 4) Use the get method to access the index-1
        // 5) Set the next and prev properties on the correct nodes to link everything together
        // 6) Increment the length

        if (index < 0 || index > length) throw new IndexOutOfBoundsException();

        if (index == 0) return unshift(value);
        if (index == length) return push(value);
        
        Node newNode = new Node(value);
        Node beforeNode = get(index - 1);
        Node afterNode = beforeNode.next;

        beforeNode.next = newNode;
        newNode.prev = beforeNode;
        newNode.next = afterNode;
        afterNode.prev = newNode;

        length++;

        return this;
    }

    public T remove(int index) {
        // 1) If the index is less than zero or greater than or equal to the length return false
        // 2) If the index is 0, shift
        // 3) If the index is the same as the length-1, pop
        // 4) Use get to retrieve the item to be removed
        // 5) Update the next and prev properties to remove the found node from the list
        // 6) Set next and prev to null on found node
        // 7) Decrement the length
        // 8) Return the removed node
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();

        if (index == 0) return shift();
        if (index == length - 1) return pop();

        Node removedNode = get(index);

        removedNode.prev.next = removedNode.next;
        removedNode.next.prev = removedNode.prev;

        removedNode.next = null;
        removedNode.prev = null;

        length--;

        return removedNode.value;
    }

}
