package com.alisasbbtn.datastructures;

import java.util.NoSuchElementException;

public class BinarySearchTree {

    Node root;

    static private class Node {

        private final int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }


    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree insert(int value) {
        // -   Create a new node
        // -   Starting at the root
        //    -   Check if there is a root, if not - the root now becomes that new node!
        //    -   If there is a root, check if the value of the new node is greater than or less than the value of the root
        //    -   If it is greater
        //        -   Check to see if there is a node to the right
        //            -   If there is, move to that node and repeat these steps
        //            -   If there is not, add that node as the right property
        //    -   If it is less
        //        -   Check to see if there is a node to the left
        //            -   If there is, move to that node and repeat these steps
        //            -   If there is not, add that node as the left property

        Node node = new Node(value);

        if (root == null) root = node;
        else searchInsertionPoint(root, node);

        return this;
    }

    private void searchInsertionPoint(Node root, Node node) {
        if (node.value > root.value) {
            Node rightNode = root.right;
            if(rightNode != null) {
                searchInsertionPoint(rightNode, node);
            } else {
                root.right = node;
            }
        } else {
            Node leftNode = root.left;
            if(leftNode != null) {
                searchInsertionPoint(leftNode, node);
            } else {
                root.left = node;
            }
        }
    }

    public int find(int value) {
        // -   Starting at the root
        //    -   Check if there is a root, if not - we're done searching!
        //    -   If there is a root, check if the value of the new node is the value we are looking for. If we found it, we're done!
        //    -   If not, check to see if the value is greater than or less than the value of the root
        //    -   If it is greater
        //        -   Check to see if there is a node to the right
        //            -   If there is, move to that node and repeat these steps
        //            -   If there is not, we're done searching!
        //    -   If it is less
        //        -   Check to see if there is a node to the left
        //            -   If there is, move to that node and repeat these steps
        //            -   If there is not, we're done searching!

        if (root == null) throw new NoSuchElementException();

        return findNode(root, value).value;
    }

    private Node findNode(Node root, int value) {
        if (root.value == value) return root;

        if (value > root.value) {
            Node rightNode = root.right;
            if(rightNode != null) {
                return findNode(rightNode, value);
            } else {
                throw new NoSuchElementException();
            }
        } else {
            Node leftNode = root.left;
            if(leftNode != null) {
                return findNode(leftNode, value);
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    public SinglyLinkedList<Integer> breadthFirstSearch() {
        // Create a queue (this can be an array) and a variable (list) to store the values of nodes visited
        // Place the root node in the queue
        // Loop as long as there is anything in the queue
        // Dequeue a node from the queue and push the value of the node into the variable that stores the nodes
        // If there is a left property on the node requeued - add it to the queue
        // If there is a right property on the node dequeued - add it to the queue

        Queue<Node> queue = new Queue<>();
        SinglyLinkedList<Integer> visited = new SinglyLinkedList<>();

        queue.enqueue(root);

        while (queue.size() != 0) {
            Node node = queue.dequeue();
            visited.push(node.value);
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
        return visited;
    }

    @Override
    public String toString() {
        return breadthFirstSearch().toString();
    }
}
