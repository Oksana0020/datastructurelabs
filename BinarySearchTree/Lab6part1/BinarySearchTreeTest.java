package Lab6part1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> bst;

    @BeforeEach
    public void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    public void testInsertAndIsEmpty() {
        assertTrue(bst.isEmpty(), "The tree should be empty initially.");

        bst.insert(10);
        assertFalse(bst.isEmpty(), "The tree should not be empty after inserting an element.");

        bst.insert(5);
        bst.insert(15);
        assertFalse(bst.isEmpty(), "The tree should not be empty after inserting multiple elements.");
    }

    @Test
    public void testContains() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        assertTrue(bst.contains(10), "The tree should contain the element 10.");
        assertTrue(bst.contains(5), "The tree should contain the element 5.");
        assertTrue(bst.contains(15), "The tree should contain the element 15.");
        assertFalse(bst.contains(7), "The tree should not contain the element 7.");
        assertFalse(bst.contains(20), "The tree should not contain the element 20.");
    }

    @Test
    public void testInsertIterativeAndContains() {
        bst.insertIterative(10);
        bst.insertIterative(5);
        bst.insertIterative(15);

        assertTrue(bst.contains(10), "The tree should contain the element 10 after iterative insert.");
        assertTrue(bst.contains(5), "The tree should contain the element 5 after iterative insert.");
        assertTrue(bst.contains(15), "The tree should contain the element 15 after iterative insert.");
        assertFalse(bst.contains(7), "The tree should not contain the element 7 after iterative insert.");
        assertFalse(bst.contains(20), "The tree should not contain the element 20 after iterative insert.");
    }

    @Test
    public void testMultipleInsertions() {
        for (int i = 1; i <= 10; i++) {
            bst.insert(i);
        }

        assertTrue(bst.contains(1), "The tree should contain the element 1.");
        assertTrue(bst.contains(10), "The tree should contain the element 10.");
        assertFalse(bst.contains(11), "The tree should not contain the element 11.");
    }

    @Test
    public void testContainsRecursive() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        assertTrue(bst.containsRecursive(10), "The tree must contain element 10 using recursive search.");
        assertTrue(bst.containsRecursive(5), "The tree must contain element 5 using recursive search.");
        assertTrue(bst.containsRecursive(15), "The tree must contain element 15 using recursive search.");
        assertFalse(bst.containsRecursive(7), "The tree mujst not contain element 7 using recursive search.");
        assertFalse(bst.containsRecursive(20), "The tree must not contain element 20 using recursive search.");
    }
}

