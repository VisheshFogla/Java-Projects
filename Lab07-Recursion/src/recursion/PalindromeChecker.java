/**
 * 
 */
package recursion;

/**
 * @author Vishesh
 * @version 03/02/2020.
 */
public class PalindromeChecker {
    
    /**
     * 
     * @param str takes a string input to check for palindrome.
     * @return boolean value if it is a palindrome.
     */
    public static boolean isPalindrome(String str) {
        String first = str.toLowerCase();
        first = first.replaceAll("[.,!?/\"\\|' ]", "");
        if ((first.length() == 0) || (first.length() == 1)) {
            return true;
        }
        else {
            if (first.charAt(0) == first.charAt(first.length() - 1)) {
                boolean found = isPalindrome(first.substring(1, first.length()
                    - 1));
                if (found) {
                    return true;
                }
            }

        }

        return false;
    }

}
