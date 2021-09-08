// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh Fogla (visheshfogla)

/**
 * The class tests the SpaceColonyDataException.
 */
package spacecolonies;

/**
 * @author Vishesh
 * @version 19.04.2020
 * 
 */ 
@SuppressWarnings("serial")
public class SpaceColonyDataExceptionTest extends Exception {

    /**
     * The method tests the exception with a try catch block.
     */
    public void testException() {
        try {
            throw (new SpaceColonyDataException("Exception caught"));
        }
        catch (SpaceColonyDataException e) {
            e.printStackTrace();
        }

        
    }

}
