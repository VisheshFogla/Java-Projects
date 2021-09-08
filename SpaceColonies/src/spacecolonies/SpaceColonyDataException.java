// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh Fogla (visheshfogla)

/**
 * Throws an exception in standard format. Used in ColonyReader when
 * planets are wrong, or when skills are off
 */
package spacecolonies;

/**
 * @author Vishesh
 * @version 19.04.2020
 *
 */
@SuppressWarnings("serial")
public class SpaceColonyDataException extends Exception {

    /**
     * 
     * Initializes the constructor for the class that displays a string message
     * if the exception is caught.
     * 
     * @param string
     *            error message that is to be displayed.
     */
    public SpaceColonyDataException(String string) {
        super(string);
    }
}
