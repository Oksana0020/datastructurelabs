package Lab4;

public class TestFibonacci {
    public static void main(String[] args) {
        int n = 30; // Choose a moderately large value for testing

        // Test recursive Fibonacci
        long startRecursive = System.nanoTime();
        int resultRecursive = Fibonacci.fibonacciRecursive(n);
        long endRecursive = System.nanoTime();
        System.out.println("Recursive Fibonacci(" + n + "): " + resultRecursive + " Time: " + (endRecursive - startRecursive) + " ns");

        // Test iterative Fibonacci
        long startIterative = System.nanoTime();
        int resultIterative = Fibonacci.fibonacciIterative(n);
        long endIterative = System.nanoTime();
        System.out.println("Iterative Fibonacci(" + n + "): " + resultIterative + " Time: " + (endIterative - startIterative) + " ns");
    }
}

//Recursive Fibonacci(30): 832040 Time: 5868600 ns

//Iterative Fibonacci(30): 832040 Time: 2400 ns
