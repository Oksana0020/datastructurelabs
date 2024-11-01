package Lab6part2;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;

    @Before
    public void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    public void testInsertAndContains() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        assertTrue(bst.contains(10));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(15));
        assertFalse(bst.contains(7)); // 7 not inserted
    }

    @Test
    public void testIsEmpty() {
        assertTrue(bst.isEmpty());
        bst.insert(10);
        assertFalse(bst.isEmpty());
    }

    @Test
    public void testPrintInOrder() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);

        // print method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.print();

        String expectedOutput = "3\n5\n7\n10\n15\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintPreOrder() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.printPreOrder(); // print preorder

        String expectedOutput = "10\n5\n15\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintPostOrder() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.printPostOrder(); //

        String expectedOutput = "5\n15\n10\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintInOrderIterative() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.printInOrderIterative();

        String expectedOutput = "5\n10\n15\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintBreadthFirst() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.printBreadthFirst();

        String expectedOutput = "10\n5\n15\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}

