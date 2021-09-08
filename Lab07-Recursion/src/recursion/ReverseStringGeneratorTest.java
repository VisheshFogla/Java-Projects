/**
 * 
 */
package recursion;

import student.TestCase;

/**
 * @author Vishesh
 * @version 03/02/2020.
 */
public class ReverseStringGeneratorTest extends TestCase {
    
    /**
     * tests the reverse method of the class.
     */
    public void testReverse() {
        
        ReverseStringGenerator rsg = new ReverseStringGenerator();
        rsg.toString();

        assertEquals("cba", ReverseStringGenerator.reverse("abc"));
        assertEquals("hsehsiv", ReverseStringGenerator.reverse("vishesh"));
        assertEquals("a", ReverseStringGenerator.reverse("a"));
        assertEquals("", ReverseStringGenerator.reverse(""));

    }

}
