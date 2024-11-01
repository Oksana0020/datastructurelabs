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

    public void printPreOrder() {
        printPreOrder(root);
    }

    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + "\n");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    public void printPostOrder() {
        printPostOrder(root);
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.data + "\n");
        }
    }

    public void printInOrder() {
        Deque<Node> stack = new LinkedList<>();
        Node current = root;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.data + "\n");
            current = current.right;
        }
    }

    public void printBreadthFirst() {
        if (root == null) return;

        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + "\n");

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public void printPreOrderTraversal() {
        printPreOrder();
    }

    public void printPostOrderTraversal() {
        printPostOrder();
    }

    public void printInOrderTraversal() {
        printInOrder();
    }

    public void printBreadthFirstTraversal() {
        printBreadthFirst();
    }
}
