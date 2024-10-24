package Lab4;

public class MySearchTest {
    public static void main(String[] args) {
        // target present in the array
        int[] sortedArray1 = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
        int target1 = 105;
        int result1 = MySearch.binarySearch(sortedArray1, target1);
        System.out.println("Index of " + target1 + ": " + result1); // result 4

        // target present at the beginning
        int target2 = 101;
        int result2 = MySearch.binarySearch(sortedArray1, target2);
        System.out.println("Index of " + target2 + ": " + result2); // result 0

        // target present at the end
        int target3 = 110;
        int result3 = MySearch.binarySearch(sortedArray1, target3);
        System.out.println("Index of " + target3 + ": " + result3); // result 9

        // target not present at all
        int target4 = 111;
        int result4 = MySearch.binarySearch(sortedArray1, target4);
        System.out.println("Index of " + target4 + ": " + result4); // result -1

        // empty array
        int[] sortedArray2 = {};
        int target5 = 102;
        int result5 = MySearch.binarySearch(sortedArray2, target5);
        System.out.println("Index of " + target5 + ": " + result5); // result -1

        // array with one element, target found
        int[] sortedArray3 = {105};
        int target6 = 105;
        int result6 = MySearch.binarySearch(sortedArray3, target6);
        System.out.println("Index of " + target6 + ": " + result6); // result 0

        // array with one element, target not found
        int target7 = 100;
        int result7 = MySearch.binarySearch(sortedArray3, target7);
        System.out.println("Index of " + target7 + ": " + result7); // result -1
    }
}
