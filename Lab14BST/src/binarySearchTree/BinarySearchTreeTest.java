/**
 * 
 */
package binarySearchTree;

import student.TestCase;

/**
 * @author Vishesh
 * @version 5.2.2020
 */
public class BinarySearchTreeTest extends TestCase {

    private Lab14BinarySearchTree<String> bst1;

    /**
     * sets up the method for testing
     */
    public void setUp() {

        bst1 = new Lab14BinarySearchTree<String>();
    }


    /**
     * tests the empty methods
     */
    public void testIsEmpty() {
        assertTrue(bst1.isEmpty());

        bst1.insert("root");

        assertFalse(bst1.isEmpty());

        bst1.makeEmpty();

        assertTrue(bst1.isEmpty());

        assertNull(bst1.find("root"));

    }


    /**
     * tests the remove method
     */
    public void testRemove() {
        bst1.insert("root");

        bst1.remove("root");

        assertTrue(bst1.isEmpty());

        bst1.insert("root2");

        bst1.insert("root");

        bst1.insert("root3");

        bst1.remove("root2");

        bst1.makeEmpty();

        try {
            bst1.remove("root");
        }
        catch (ItemNotFoundException e) {
            System.out.println("Exception caught");

        }

        bst1.insert("root2");

        bst1.insert("root");

        bst1.insert("root3");

        bst1.remove("root");

        bst1.remove("root3");

        bst1.insert("root");

        bst1.remove("root2");

        bst1.makeEmpty();

        bst1.insert("root");

        try {
            bst1.insert("root");
        }
        catch (DuplicateItemException e) {
            System.out.println("Exception caught");
        }

    }


    /**
     * tests the find methods.
     */
    public void testFind() {
        bst1.insert("root");

        bst1.insert("root2");

        assertEquals("root", bst1.findMin());

        assertEquals("root2", bst1.findMax());

        assertEquals("root2", bst1.find("root2"));

        assertEquals("(root, root2)", bst1.toString());

        bst1.makeEmpty();

        assertEquals("()", bst1.toString());

        assertNull(bst1.findMax());

        assertNull(bst1.findMin());

        bst1.insert("root2");

        bst1.insert("root");

        assertEquals("root", bst1.find("root"));

        bst1.insert("root3");

        assertEquals("root", bst1.findMin());

    }

}
