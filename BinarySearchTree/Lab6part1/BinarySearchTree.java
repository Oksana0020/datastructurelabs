package Lab6part1;

public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        public E data;
        public Node left;
        public Node right;
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(E element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.left = null;
        newNode.right = null;
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
            // go right
            if (node.right == null) {
                node.right = newNode;
            } else {
                insertSub(newNode, node.right);
            }
        } else {
            // go left
            if (node.left == null) {
                node.left = newNode;
            } else {
                insertSub(newNode, node.left);
            }
        }
    }

    // Iterative insert method
    public void insertIterative(E element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.left = null;
        newNode.right = null;

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

    // checking here if the tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // check if the tree contains a particular element
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
        return false;
        //when not found element return false
    }

    // Recursive version of contains method
    public boolean containsRecursive(E element) {
        return containsRecursiveHelper(root, element);
    }

    private boolean containsRecursiveHelper(Node node, E element) {
        if (node == null) {
            return false; //
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

    public void print() {
        if (root != null)
            printSub(root);
    }

    private void printSub(Node node) {
        // inorder traversal
        if (node != null) {
            printSub(node.left);
            System.out.println(node.data);
            printSub(node.right);
        }
    }
}
