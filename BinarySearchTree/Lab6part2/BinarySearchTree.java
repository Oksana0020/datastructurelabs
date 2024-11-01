package Lab6part2;

import java.util.Deque;
import java.util.LinkedList;

public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        public E data;
        public Node left;
        public Node right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert method (recursive)
    public void insert(E element) {
        Node newNode = new Node(element);
        if (root == null) {
            root = newNode;
        } else {
            insertSub(newNode, root);
        }
    }

    private void insertSub(Node newNode, Node node) {
        int result = newNode.data.compareTo(node.data);
        // duplicates go to the right
        if (result >= 0) {
            if (node.right == null) {
                node.right = newNode;
            } else {
                insertSub(newNode, node.right);
            }
        } else {
            if (node.left == null) {
                node.left = newNode;
            } else {
                insertSub(newNode, node.left);
            }
        }
    }

    // Iterative insert method
    public void insertIterative(E element) {
        Node newNode = new Node(element);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            while (true) {
                int result = newNode.data.compareTo(current.data);
                if (result >= 0) {
                    if (current.right == null) {
                        current.right = newNode;
                        return;
                    }
                    current = current.right;
                } else {
                    if (current.left == null) {
                        current.left = newNode;
                        return;
                    }
                    current = current.left;
                }
            }
        }
    }

    // Check if the tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Check if the tree contains a particular element
    public boolean contains(E element) {
        Node current = root;
        while (current != null) {
            int result = element.compareTo(current.data);
            if (result == 0) {
                return true;
            } else if (result > 0) {
                current = current.right; // searching in right subtree
            } else {
                current = current.left; // search in left subtree
            }
        }
        return false; // when not found element return false
    }

    // Recursive version of contains method
    public boolean containsRecursive(E element) {
        return containsRecursiveHelper(root, element);
    }

    private boolean containsRecursiveHelper(Node node, E element) {
        if (node == null) {
            return false;
        }
        int result = element.compareTo(node.data);
        if (result == 0) {
            return true;
        } else if (result > 0) {
            return containsRecursiveHelper(node.right, element); // search in right subtree
        } else {
            return containsRecursiveHelper(node.left, element); // search in left subtree
        }
    }

    // Inorder Traversal (Recursive)
    public void print() {
        if (root != null) {
            printSub(root);
        }
    }

    private void printSub(Node node) {
        // Inorder traversal
        if (node != null) {
            printSub(node.left);
            System.out.println(node.data);
            printSub(node.right);
        }
    }

    // Preorder Traversal
    public void printPreOrder() {
        printPreOrderSub(root);
    }

    private void printPreOrderSub(Node node) {
        if (node != null) {
            System.out.println(node.data); // visit node
            printPreOrderSub(node.left);    // go left
            printPreOrderSub(node.right);   // go right
        }
    }

    // Postorder Traversal
    public void printPostOrder() {
        printPostOrderSub(root);
    }

    private void printPostOrderSub(Node node) {
        if (node != null) {
            printPostOrderSub(node.left);   // go left
            printPostOrderSub(node.right);  // go right
            System.out.println(node.data);   // visit the node
        }
    }

    // Non-recursive Inorder Traversal
    public void printInOrderIterative() {
        Deque<Node> stack = new LinkedList<>();
        Node current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current); // Push current node onto the stack
                current = current.left; // Move to left child
            } else {
                current = stack.pop(); // Pop from stack
                System.out.println(current.data); // Visit the node
                current = current.right; // Move to right child
            }
        }
    }

    // Breadth-First Traversal (Level Order)
    public void printBreadthFirst() {
        if (root == null) return;

        Deque<Node> queue = new LinkedList<>();
        queue.add(root); // Start with the root

        while (!queue.isEmpty()) {
            Node current = queue.remove(); // Remove from the front
            System.out.println(current.data); // Visit the node

            // Insert children in left-to-right order
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
