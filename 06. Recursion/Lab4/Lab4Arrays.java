package Lab4;

public class Lab4Arrays {
    public static int sum(int[] values) {
        return sumHelper(values, values.length - 1);
    }

    // Recursive helper method
    private static int sumHelper(int[] values, int index) {
        if (index < 0) return 0; // Base case
        return values[index] + sumHelper(values, index - 1); // recursive
    }
}

