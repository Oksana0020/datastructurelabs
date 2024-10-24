package Lab4;

public class FactorialTest {
    public static void main(String[] args) {
        // Test cases for factorial calculation
        System.out.println("Factorial of 0: " + Factorial.factorial(0));  // Expected 1
        System.out.println("Factorial of 1: " + Factorial.factorial(1));  // Expected 1
        System.out.println("Factorial of 7: " + Factorial.factorial(7));  // Expected 5040
        System.out.println("Factorial of 10: " + Factorial.factorial(10)); // Expected 3628800

        //StackOverflowError
        try {
            System.out.println("Factorial of 10000 should cause StackOverflow:");
            System.out.println(Factorial.factorial(10000));
            // this will cause StackOverflowError
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError encountered for factorial(10000) because of deep recursion.");
        }
    }
}

