package Lab3;

import static org.junit.jupiter.api.Assertions.*;
        import org.junit.jupiter.api.Test;

public class ParethesisCheckerTest {

    @Test
    public void testBalancedExpressions() {
        assertTrue(ParethesisChecker.isBalanced("( a + b * ( c / ( d – e ) ) ) + ( d / e )"));
        assertTrue(ParethesisChecker.isBalanced("( a + b * { c / ( d – e )} ) + [ d / e ]"));
        assertTrue(ParethesisChecker.isBalanced("(2+[5+7]+1)"));
        assertTrue(ParethesisChecker.isBalanced("{[()]}"));
        assertTrue(ParethesisChecker.isBalanced(""));
        assertTrue(ParethesisChecker.isBalanced("abc"));
    }

    @Test
    public void testUnbalancedExpressions() {
        assertFalse(ParethesisChecker.isBalanced("((2+3)"));
        assertFalse(ParethesisChecker.isBalanced("{[(])}"));
        assertFalse(ParethesisChecker.isBalanced("(a + b))"));
        assertFalse(ParethesisChecker.isBalanced("((a + b) + (c + d)"));
    }
    //2tests passed
}
