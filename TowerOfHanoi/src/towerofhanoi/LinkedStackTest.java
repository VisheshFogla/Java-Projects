// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh (visheshfogla)

/**
 * The class tests the method that are defined in LinkedStack class.
 */
package towerofhanoi;

import student.TestCase;
import java.util.EmptyStackException;

/**
 * @author Vishesh (visheshfogla)
 * @version 2020-03-25
 */
public class LinkedStackTest extends TestCase {

    /**
     * Declares the fields that are used for testing. They represent LinkedStack
     * objects.
     */
    private LinkedStack<String> ls;
    private LinkedStack<String> ls2;

    /**
     * The method initializes the fields that have already been declared. It
     * also pushes three items in one of the stacks for testing purposes.
     */
    public void setUp() {
        ls = new LinkedStack<>();
        ls2 = new LinkedStack<>();

        // Pushing String objects in the Stack.
        ls.push("my");
        ls.push("name");
        ls.push("vishesh");
    }


    /**
     * The method tests if the object is being pushed into the stack by checking
     * the topmost object.
     */
    public void testPush() {
        assertEquals("vishesh", ls.peek());
    }


    /**
     * The method tests if the topmost object is being removed from the stack
     * when pop method is called. It also throws an exception when pop is called
     * on an empty stack.
     */
    public void testPop() {

        assertEquals("vishesh", ls.pop());

        // checks whether an exception is thrown.
        try { 
            ls2.pop();
        }
        catch (EmptyStackException e) {

            // catches an exception when pop is called on an empty stack.
        }
    }


    /**
     * The method tests whether the peek method returns the topmost object of
     * the stack without removing it. It also tests the method for every case.
     */
    public void testPeek() {

        // checks whether an exception is thrown.
        try {
            ls2.peek();
        }
        catch (EmptyStackException e) {

            // catches an exception when peek is called on an empty stack

        }
        assertEquals("vishesh", ls.peek());
    }


    /**
     * The method tests if the size of the stack corresponds to the number of
     * objects it contains.
     */
    public void testSize() {
        assertEquals(3, ls.size());
    }


    /**
     * The method tests if the clear method removes all objects from the stack
     * and makes the stack empty.
     */
    public void testClear() {
        ls2.clear();
        assertTrue(ls2.isEmpty());
        assertEquals(0, ls2.size());

        ls.clear();
        assertTrue(ls.isEmpty());
    }


    /**
     * The method tests whether toString method provides the string output for
     * the objects in the stack in the order from top to bottom.
     */
    public void testToString() {
        ls.push("fogla");
        assertEquals("[fogla, vishesh, name, my]", ls.toString());
    }

}
