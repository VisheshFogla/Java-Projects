/**
 * 
 */
package binarySearchTree;

import student.TestCase;

/**
 * @author Vishesh
 * @version 5.2.2020
 */
public class ContactTest extends TestCase {

    private Lab14BinarySearchTree<String> bst1;
    private Contact c1;
    private Contact c2;
    private Contact c3;
    private Contact c4;
    private Contact c5;
    private Contact c6;

    /**
     * sets up the field for testing classes.
     */
    public void setUp() {

        bst1 = new Lab14BinarySearchTree<String>();
        c1 = new Contact("Vishesh", "Fogla", "982055678");
        c2 = new Contact("Kush", "Jogi", "982055678");
        c3 = new Contact("Kush", "Shah", "982055678");
        c4 = new Contact("Vishesh", "Jogi", "982055678");
        c5 = new Contact("Vishesh", "Fogla", "506758932");
        c6 = new Contact("Vishesh", "Fogla", "982055678"); 

    }


    /**
     * tests the compareTo class.
     */
    public void testCompareTo() {
        assertEquals(-1, c1.compareTo(c2));
        assertEquals(1, c3.compareTo(c1));
        assertEquals(-1, c2.compareTo(c4)); 
        assertEquals(1, c4.compareTo(c2));
        assertEquals(-1, c5.compareTo(c1));
        assertEquals(1, c1.compareTo(c5));
        assertEquals(0, c1.compareTo(c6));
        
        bst1.insert("c1");

    }

}
