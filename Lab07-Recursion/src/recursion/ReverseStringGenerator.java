/**
 * 
 */
package recursion;

/**
 * @author Vishesh
 * @version 03/02/2020.
 */
public class ReverseStringGenerator {

    private static String first;
    /**
     * 
     * @param str takes a string input to give its reverse.
     * @return reverses a string and returns it.
     */
    public static String reverse(String str) {
        if ((str.length() == 1) || (str.length() == 0)) {
            return str;
        }
        else {
            first = str.substring(str.length() - 1, str.length()) + reverse(str
                .substring(0, str.length() - 1));
            return first;
        }

    }

}
