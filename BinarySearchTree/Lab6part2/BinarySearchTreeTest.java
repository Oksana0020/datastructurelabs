package Lab6part2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;

    @BeforeEach
    public void setUp() {
        bst = new BinarySearchTree<>();
        bst.insert(110);
        bst.insert(105);
        bst.insert(115);
        bst.insert(103);
        bst.insert(107);
        bst.insert(112);
        bst.insert(118);
    }

    @Test
    public void testPrintPreOrder() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.printPreOrderTraversal();

        assertEquals("110\n105\n103\n107\n115\n112\n118\n", outContent.toString());
    }

    @Test
    public void testPrintPostOrder() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.printPostOrderTraversal();

        assertEquals("103\n107\n105\n112\n118\n115\n110\n", outContent.toString());
    }

    @Test
    public void testPrintInOrder() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.printInOrderTraversal();

        assertEquals("103\n105\n107\n110\n112\n115\n118\n", outContent.toString());
    }

    @Test
    public void testPrintBreadthFirst() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.printBreadthFirstTraversal();

        assertEquals("110\n105\n115\n103\n107\n112\n118\n", outContent.toString());
    }
}
