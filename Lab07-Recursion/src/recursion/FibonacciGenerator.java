/**
 * 
 */
package recursion;

/**
 * @author Vishesh
 * @version 03/02/2020.
 *
 */
public class FibonacciGenerator {

    // precondition: n is non - negative.
    /**
     * 
     * @param n
     *            takes a number to calculate the fibonacci series
     * @return gives the fibonacci series up to the nth number.
     */
    public static int fib(int n) {
        if ((n == 1) || (n == 0)) {
            return 0 + n;
        }
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }

}
