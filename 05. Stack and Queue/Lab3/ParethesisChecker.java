package Lab3;

import java.util.Deque;
import java.util.LinkedList;

public class ParethesisChecker {

    public static boolean isBalanced(String expression) {
        Deque<Character> stack = new LinkedList<>();
        boolean balanced = true;
        int index = 0;

        while (balanced && index < expression.length()) {
            char ch = expression.charAt(index);

            if (isOpen(ch)) {
                stack.push(ch);
            } else if (isClose(ch)) {
                if (stack.isEmpty()) {
                    balanced = false;
                } else {
                    char topChar = stack.pop();
                    if (!areMatching(topChar, ch)) {
                        balanced = false;
                    }
                }
            }
            index++;
        }

        return balanced && stack.isEmpty();
    }

    private static boolean isOpen(char ch) {
        return ch == '(' || ch == '{' || ch == '[' || ch == '<';
    }

    private static boolean isClose(char ch) {
        return ch == ')' || ch == '}' || ch == ']' || ch == '>';
    }

    private static boolean areMatching(char c1, char c2) {
        return (c1 == '(' && c2 == ')') ||
                (c1 == '{' && c2 == '}') ||
                (c1 == '[' && c2 == ']') ||
                (c1 == '<' && c2 == '>');
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test cases
        System.out.println(isBalanced("( a + b * ( c / ( d – e ) ) ) + ( d / e )")); // true
        System.out.println(isBalanced("( a + b * { c / ( d – e )} ) + [ d / e ]")); // true
        System.out.println(isBalanced("(2+[5+7]+1)")); // true
        System.out.println(isBalanced("((2+3)")); // false
        System.out.println(isBalanced("{[()]}")); // true
        System.out.println(isBalanced("{[(])}")); // false
        System.out.println(isBalanced("")); // true
        System.out.println(isBalanced("abc")); // ?? true?
    }
}
