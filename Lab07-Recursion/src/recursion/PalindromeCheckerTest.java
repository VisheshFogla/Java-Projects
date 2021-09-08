/**
 * 
 */
package recursion;

import student.TestCase;

/**
 * @author Vishesh
 * @version 03/02/2020.
 */
public class PalindromeCheckerTest extends TestCase {

    /**
     * tests the method in PalindromeChecker class.
     */
    public void testIsPalindrome() {
        
        PalindromeChecker pc = new PalindromeChecker();
        pc.toString();

        assertTrue(PalindromeChecker.isPalindrome(
            "\"Tie Mandie,\" I'd name it."));
        assertTrue(PalindromeChecker.isPalindrome("racecar"));
        assertTrue(PalindromeChecker.isPalindrome(
            "A Toyota! Race fast, safe car. A Toyota."));
        assertTrue(PalindromeChecker.isPalindrome("Hannah"));
        assertFalse(PalindromeChecker.isPalindrome("Vishesh"));
        assertFalse(PalindromeChecker.isPalindrome("rater"));
        assertTrue(PalindromeChecker.isPalindrome("Wonton? Not now."));

    }

}
