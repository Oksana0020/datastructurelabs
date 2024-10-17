package Lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class CP3LinkedListTest {
    private CP3LinkedList<Integer> list;

    // Initializes a new CP3LinkedList before each test
    @BeforeEach
    public void setUp() {
        list = new CP3LinkedList<>();
    }

    // Test for size
    @org.junit.Test
    @Test
    public void testSize() {
        assertEquals(0, list.size());  // should be 0 for a new list
        list.addFirst(1);
        assertEquals(1, list.size());  // Size should be 1 after adding an element
        list.addFirst(2);
        assertEquals(2, list.size());  // should be 2 after adding another element
        list.removeFirst();
        assertEquals(1, list.size());  // should be 1 after removing an element
    }

    // Test for the contains method
    @Test
    public void testContains() {
        assertFalse(list.contains(1));  // Should not contain any elements at the beginning
        list.addFirst(1);
        assertTrue(list.contains(1));  // Should contain 1 after adding
        list.addFirst(2);
        assertTrue(list.contains(2));  // Should contain 2 after adding
        assertFalse(list.contains(3));  // Should not contain 3
    }

    // Test for the addLast method
    @Test
    public void testAddLast() {
        list.addLast(1);
        assertEquals(1, list.size());  // Size should be 1 after adding
        list.addLast(2);
        assertEquals(2, list.size());  // Size should be 2 after adding ment
        assertTrue(list.contains(1));  // Should contain 1
        assertTrue(list.contains(2));  // Should contain 2
    }

    // Test for the removeFirst method
    @Test
    public void testRemoveFirst() {
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(2, list.removeFirst());  // Should return 2 (the first element)
        assertEquals(1, list.size());  // Size should be 1 after removing
        assertEquals(1, list.removeFirst());  // Should return 1 (the last element)
        assertEquals(0, list.size());  // Size should be 0 after removing
    }

    // Additional test: Attempt to remove from an empty list
    @Test
    public void testRemoveFirstFromEmptyList() {
        assertThrows(NoSuchElementException.class, () -> {
            list.removeFirst();
        });
    }

    // Additional test: Add and remove first
    @Test
    public void testAddFirstAndRemoveFirst() {
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(2, list.removeFirst());  // Should return 2
        assertEquals(1, list.removeFirst());  // Should return 1
        assertTrue(list.size() == 0);  // Size should be 0 after removals
        assertThrows(NoSuchElementException.class, () -> {
            list.removeFirst();  // Expect exception on empty list
        });
    }

    // Additional test: checking contains after removal
    @Test
    public void testContainsAfterRemoval() {
        list.addFirst(1);
        list.addFirst(2);
        list.removeFirst(); // remove 2
        assertFalse(list.contains(2)); // should not contain 2
        assertTrue(list.contains(1)); // should still contain 1
    }

    //passed all tests
/*Future Improvements:
 - It might be fun to test adding `null` values (if that's allowed) or make sure the list keeps its order when adding and removing multiple elements.
 */
// Future Improvement: Test adding null values
    @Test
    public void testAddNullValue() {
        list.addFirst(null);
        assertEquals(1, list.size());  // Size should be 1 after adding null
        assertTrue(list.contains(null)); // null
        list.removeFirst();
        assertEquals(0, list.size());  // Size should be 0 after removing null
    }

    // tests -test order with multiple adds and removes
    @Test
    public void testMaintainOrder() {
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(3, list.size());  // Size should be 3

        // Remove in the order they were added
        assertEquals(1, list.removeFirst());  // Should remove 1
        assertEquals(2, list.removeFirst());  // Should remove 2
        assertEquals(1, list.size());  // Size should now be 1

        // remve the last remaining element
        assertEquals(3, list.removeFirst());  // Should remove 3
        assertEquals(0, list.size());  // Size should be 0 after removing all
    }
    //I want to to add or remove elements when the list whichis empty
    // Additional attempt to add to an empty list
    @Test
    public void testAddToEmptyList() {
        list.addFirst(1);
        assertEquals(1, list.size());  // Size should be 1
        assertEquals(1, list.getFirst());  // Should  1
        assertThrows(NoSuchElementException.class, () -> {
            list.removeFirst();  // Should not throw as there's an element
        });
    }

    // Additional test: Attempt to remove from a list that has just been empty
    @Test
    public void testRemoveFirstAfterEmptying() {
        list.addFirst(1);
        list.removeFirst();
        assertEquals(0, list.size()); // Size should be 0
        assertThrows(NoSuchElementException.class, () -> {
            list.removeFirst(); // Attempt to remove fromempty list
        });
    }
}

