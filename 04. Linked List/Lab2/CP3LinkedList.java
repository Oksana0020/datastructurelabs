package Lab2;
import java.util.NoSuchElementException;

// Singly linked list with first reference only
/**
 * A linked list is a sequence of links with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
 */
public class CP3LinkedList<E> {
    // Node class represents each element in the linked list
    private class Node {
        public E data;
        public Node next;
        public Node prev;
    }

    private Node first;
    private Node last;

    // Constructor initializes an empty linked list
    public CP3LinkedList() {
        first = null;
        last = null;
    }

    /**
     * Adds an element to the front of the linked list.
     * If the list is empty, the new node becomes both the first and last node.
     * oterwise, the new node's next pointer will point to the current first node,
     * and the current first node's prev pointer will be updated to point back to the new node.
     * @param element the element to be added to the front of the list
     */
    public void addFirst(E element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        newNode.prev = null;

        if (first != null) {
            first.prev = newNode;
        } else {
            last = newNode;
        }
        first = newNode;
    }

    /**
     * Adds an element to the end of the linked list.
     * If the list is empty, the new node becomes both the first and last node.
     * Otherwise, the current last node's next pointer is updated to point to the new node.
     * @param element the element to be added to the end of the list
     */
    public void addLast(E element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = null;
        newNode.prev = last;

        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
    }

    /**
     * Gets the first element of the list. Throws NoSuchElementException if the list is empty .
     * @return the data of the first node
     */
    public E getFirst() {
        if (first == null)
            throw new NoSuchElementException();
        return first.data;
    }

    /**
     * Removes the first element from the list.
     * Throws NoSuchElementException if the list is empty.
     * Updates the first pointer to the next node, and if the list becomes empty,
     * the last pointer is also set to null.
     * @return the data of the removed first node
     */
    public E removeFirst() {
        if (first == null)
            throw new NoSuchElementException();
        E element = first.data;
        first = first.next;

        if (first != null) {
            first.prev = null;
        } else {
            last = null;
        }
        return element;
    }

    /**
     * Calculates the size of the linked list.
     * Iterates through the list, counting the number of nodes.
     * @return the total count of nodes in the list
     */
    public int size() {
        int count = 0;
        Node current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Checks if the list contains a particular element.
     * Iterates through the list, comparing the data of each node to the given element.
     * @param element the element to be searched for
     * @return true if the element is found
     */
    public boolean contains(E element) {
        Node current = first;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

     //prints the data of all nodes in the list

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

/*
 I found it interesting that the implementation of the linked list uses a doubly linked list
 approach where each node has references to both the previous and next nodes.
 This allows efficient insertion and removal of elements at the beginning and end.
*/