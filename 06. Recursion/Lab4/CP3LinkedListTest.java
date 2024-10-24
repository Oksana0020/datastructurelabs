package Lab4;

public class CP3LinkedListTest {
    public static void main(String[] args) {
        CP3LinkedList<Integer> list = new CP3LinkedList<>();

        // adding elements to the list
        list.addFirst(111);
        list.addFirst(222);
        list.addLast(333);
        list.addLast(444);

        // Test iterative size
        System.out.println("Iterative size: " + list.size()); // result 4

        // Test recursive size
        System.out.println("Recursive size: " + list.recursiveSize()); // result 4

        // Test iterative print
        System.out.println("\nIterative print:");
        list.print(); // result: 222 111 333 444

        // Test recursive print
        System.out.println("\nRecursive print:");
        list.recursivePrint(); // result: 222 111 333 444

        // Test recursive print in reverse order
        System.out.println("\nRecursive reverse print:");
        list.recursivePrintReverse(); // result: 444 333 111 222

        // Test empty list
        CP3LinkedList<Integer> emptyList = new CP3LinkedList<>();
        System.out.println("\nSize of empty list: " + emptyList.size()); // result 0
        System.out.println("Recursive size of empty list: " + emptyList.recursiveSize()); // result 0
        System.out.println("\nIterative print of empty list:");
        emptyList.print(); // Expected: no output
        System.out.println("\nRecursive print of empty list:");
        emptyList.recursivePrint(); // Expected: no output
        System.out.println("\nRecursive reverse print of empty list:");
        emptyList.recursivePrintReverse(); // Expected: (no output)

        // Test single element list
        CP3LinkedList<Integer> singleElementList = new CP3LinkedList<>();
        singleElementList.addFirst(999);
        System.out.println("\nSize of single element list: " + singleElementList.size()); // result 1
        System.out.println("Recursive size of single element list: " + singleElementList.recursiveSize()); // result 1
        System.out.println("\nIterative print of single element list:");
        singleElementList.print(); // result 999
        System.out.println("\nRecursive print of single element list:");
        singleElementList.recursivePrint(); // result 999
    }
}
