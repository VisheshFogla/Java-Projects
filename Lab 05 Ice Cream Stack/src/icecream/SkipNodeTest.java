/**
 * 
 */
package icecream;

import student.TestCase;
import static org.junit.Assert.assertEquals;


/**
 * @author Vishesh
 *
 */
public class SkipNodeTest {
    
    public SkipNodeTest()
    {
        Rectangle rec = new Rectangle("a", 10, 10, 5, 5);
        SkipNode temp = new SkipNode("trying", 10);
    }
    
    public void testGetName()
    {
        SkipNode temp = new SkipNode("trying", 10);
        assertEquals(temp.getName().compareTo("trying"), 0);
    }

}
