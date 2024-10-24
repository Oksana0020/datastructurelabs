package Lab4;

import java.util.NoSuchElementException;

public class CP3LinkedList<E> {

    // Node class
    private class Node {
        public E data;
        public Node next;
        public Node prev;
    }

    private Node first;
    private Node last;

    // Constructor
    public CP3LinkedList() {
        first = null;
        last = null;
    }

    // Adds an element to the front of the linked list
    public void addFirst(E element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        newNode.prev = null;

        if (first != null) {
            first.prev = newNode;
        } else {
            last = newNode; // If list empty, new node is also the last node
        }
        first = newNode;
    }

    // Adds an element to the end of the linked list
    public void addLast(E element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = null;
        newNode.prev = last;

        if (last == null) { // List is empty
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
    }

    // Original iterative size method remains for comparison
    public int size() {
        int count = 0;
        Node current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Recursive size method
    public int recursiveSize() {
        return sizeHelper(first);
    }

    // Recursive helper for size
    private int sizeHelper(Node node) {
        if (node == null) return 0; // Base case
        return 1 + sizeHelper(node.next); // Recursive case
    }

    // Original iterative print method remains for comparison
    public void print() {
        Node current = first;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Recursive print method
    public void recursivePrint() {
        printHelper(first);
    }

    // Recursive helper for print
    private void printHelper(Node node) {
        if (node == null) return; // Base case
        System.out.println(node.data); // Print current node data
        printHelper(node.next); // Recursive call to next node
    }

    // Recursive method to print in reverse order
    public void recursivePrintReverse() {
        printReverseHelper(first);
    }

    // Recursive helper to print in reverse order
    private void printReverseHelper(Node node) {
        if (node == null) return; // Base case
        printReverseHelper(node.next);
        System.out.println(node.data);
    }
}
