package Lab4;

public class MySearch {
    public static int binarySearch(int[] array, int target) {
        return binarySearchHelper(array, target, 0, array.length - 1);
    }

    // Recursive helper method
    private static int binarySearchHelper(int[] array, int target, int low, int high) {
        if (low > high) return -1; // Base case: target not found
        int mid = (low + high) / 2;
        if (array[mid] == target) return mid;
        else if (array[mid] < target) return binarySearchHelper(array, target, mid + 1, high);
        else return binarySearchHelper(array, target, low, mid - 1);
    }
}
