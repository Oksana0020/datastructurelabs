import java.util.NoSuchElementException;
//singly linked list with first reference only 

/**
 A linked list is a sequence of links with efficient
 element insertion and removal. This class
 contains a subset of the methods of the standard
 java.util.LinkedList class.
 */

public class CP3LinkedList<E> {
	private class Node {
		public E data;
		public Node next;
	}
	private Node first;
	private int size;  // Added size variable to track the number of elements

	/**
	 Constructs an empty linked list.
	 */
	public CP3LinkedList() {
		first = null;
		size = 0;  // Initialize size to 0
	}

	/**
	 Adds an element to the front of the linked list.
	 @param element the element to add
	 */
	public void addFirst(E element) {
		Node newLink = new Node();
		newLink.data = element;
		newLink.next = first;
		first = newLink;
		size++;  // Increase size as we add a new element
	}

	public E getFirst() {
		if (first == null)
			throw new NoSuchElementException();
		return first.data;
	}

	public E removeFirst() {
		if (first == null)
			throw new NoSuchElementException();
		E element = first.data;
		first = first.next;
		size--;  // Decrease size as we remove an element
		return element;
	}

	public void print() {
		//outputs the data on the list
		Node current = first;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	/**
	 * Adds an element to the end of the linked list.
	 * @param element the element to add
	 */
	public void addLast(E element) {
		Node newLink = new Node();
		newLink.data = element;
		newLink.next = null;

		if (first == null) {
			first = newLink;
		} else {
			Node current = first;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newLink; // Attach the new node at the end
		}
		size++;  // Increase size as we add a new element
	}

	/**
	 * Removes the last element in the linked list.
	 * @return the removed element
	 */
	public E removeLast() {
		if (first == null) {
			throw new NoSuchElementException("List is empty");
		}

		// If there's only one element
		if (first.next == null) {
			E element = first.data;
			first = null;
			size--;  // Decrease size as we remove an element
			return element;
		}

		Node current = first;
		while (current.next.next != null) { // Stop at the second-to-last node
			current = current.next;
		}
		E element = current.next.data; // Get the last node's data
		current.next = null;           // Remove the last node
		size--;  // Decrease size as we remove an element
		return element;
	}

	/**
	 * Checks if a specific element is in the linked list.
	 * @param element the element to check for
	 * @return true if the element exists, false otherwise
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

	/**
	 * Returns the size of the linked list (# of elements).
	 * @return the size of the list
	 */
	public int size() {
		return size;
	}

	public static void main(String[] args) {
		CP3LinkedList<String> candyLand = new CP3LinkedList<>();

		// Adding elements to the front of the list
		candyLand.addFirst("Carrot pie");
		candyLand.addFirst("Red Velvet");
		candyLand.addFirst("Chocolate cake");

		// Adding an element to the end of the list
		candyLand.addLast("Napoleon cake");

		// Display the list and its size
		candyLand.print();
		System.out.println("Size: " + candyLand.size());

		// Checking if certain elements exist
		System.out.println("Contains 'Chocolate cake'? " + candyLand.contains("Lollipop"));
		System.out.println("Contains 'Carrot pie'? " + candyLand.contains("Chocolate"));

		// Removing elements
		candyLand.removeFirst(); // Remove from front
		candyLand.print();
		candyLand.removeLast();  // Remove from end
		candyLand.print();
		System.out.println("Size after removals: " + candyLand.size());
	}
}
