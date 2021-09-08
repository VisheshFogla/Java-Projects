/**
 * 
 */
package recursivetree;

import student.TestCase;

/**
 * @author Vishesh
 * @version 04.26.2020
 */
public class BinaryTreeTest extends TestCase {

    /**
     * declares the fields of the test class.
     */
    private BinaryTree<String> bt;
    private BinaryTree<String> child1;
    private BinaryTree<String> child2;
    private BinaryTree<String> bt2;

    private BinaryTree<String> bt3;
    private BinaryTree<String> bt4;

    /**
     * sets up the method for the test class.
     */
    public void setUp() {
        child1 = new BinaryTree<>("50");
        child2 = new BinaryTree<>("75");

        bt = new BinaryTree<>("100", child1, child2);
        bt2 = new BinaryTree<>("150", child1, null);
        bt3 = new BinaryTree<>("150", null, child2);
        bt4 = new BinaryTree<>("150", child1, null);

    }


    /**
     * tests the getElement method.
     */
    public void testGetElement() {
        assertEquals("50", child1.getElement());
    }


    /**
     * tests the setElement method.
     */
    public void testSetElement() {
        child1.setElement("55");
        assertEquals("55", child1.getElement());
    }


    /**
     * tests the getLeft method.
     */
    public void testGetLeft() {
        assertEquals(child1, bt.getLeft());
    }


    /**
     * tests the setLeft method.
     */
    public void testSetLeft() {
        bt.setLeft(child2);
        assertEquals(child2, bt.getLeft());
    }


    /**
     * tests the getRight method.
     */
    public void testGetRight() {
        assertEquals(child2, bt.getRight());
    }


    /**
     * tests the setRight method.
     */
    public void testSetRight() {
        bt.setRight(child1);
        assertEquals(child1, bt.getRight());
    }


    /**
     * tests the size method.
     */
    public void testSize() {
        assertEquals(3, bt.size());
        assertEquals(2, bt2.size());
        assertEquals(2, bt3.size());

        child1.setLeft(child2);

        assertEquals(3, bt4.size());
    }


    /**
     * tests the height method.
     */
    public void testHeight() {
        assertEquals(2, bt.height());
        assertEquals(2, bt2.height());
        assertEquals(2, bt3.height());
 
        child1.setLeft(child2);

        assertEquals(3, bt.height());
        
        
        
        
    }


    /**
     * tests the toPreOrderString method.
     */
    public void testToPreOrderString() {
        assertEquals("(100(50)(75))", bt.toPreOrderString());

    }


    /** 
     * tests the toInOrderString method.
     */
    public void testToInOrderString() {
        assertEquals("((50)100(75))", bt.toInOrderString());
    }


    /**
     * tests the toPostOrderString method.
     */
    public void testToPostOrderString() {
        assertEquals("((50)(75)100)", bt.toPostOrderString());
    }

}
