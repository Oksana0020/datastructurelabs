package Lab4;

public class Lab4ArraysTest {
    public static void main(String[] args) {
        // Test 1 Empty array
        int[] emptyArray = {};
        System.out.println("Sum of empty array: " + Lab4Arrays.sum(emptyArray)); // output 0

        // Test 2 Array with one element
        int[] singleElementArray = {5};
        System.out.println("Sum of single element array: " + Lab4Arrays.sum(singleElementArray)); // output 5

        // Test3 Array with multiple elements
        int[] multipleElementsArray = {11, 12, 13, 14, 15};
        System.out.println("Sum of multiple elements array: " + Lab4Arrays.sum(multipleElementsArray)); //output: 65

        // Test 4 Array with negative numbers
        int[] negativeElementsArray = {-111, -112, -113};
        System.out.println("Sum of negative elements array: " + Lab4Arrays.sum(negativeElementsArray)); // output -336

        // Test  5 Mixed positive and negative numbers
        int[] mixedArray = {7, -1, 2, -9};
        System.out.println("Sum of mixed elements array: " + Lab4Arrays.sum(mixedArray)); //output -1

        // Test 6 Large array
        int[] largeArray = {1111, 2222, 3456, 4321, 5678};
        System.out.println("Sum of large array: " + Lab4Arrays.sum(largeArray)); // output 16788
    }
}

