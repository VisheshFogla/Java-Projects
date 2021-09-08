/**
 * 
 */
package recursion;

import student.TestCase;

/**
 * @author Vishesh
 * @version 03/02/2020.
 *
 */
public class FibonacciGeneratorTest extends TestCase {

    /**
     * tests the method in Fibonacci Generator class.
     */
    public void testFib() {
        FibonacciGenerator fib = new FibonacciGenerator();
        fib.toString();

        assertEquals(2, FibonacciGenerator.fib(3));
        assertEquals(13, FibonacciGenerator.fib(7));
    }

}
