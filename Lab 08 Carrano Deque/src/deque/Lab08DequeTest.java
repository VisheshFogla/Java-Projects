package deque;

import student.TestCase;

/**
 * Tests for the DLinkedDeque class.
 *
 * @author <vishesh> <visheshfogla>
 * @version <03/24/2020>
 */
public class Lab08DequeTest extends TestCase {

    private Lab08Deque<String> deque;

    /**
     * Creates two brand new, empty sets for each test method.
     */
    public void setUp() {
        deque = new Lab08Deque<String>();
    }


    /**
     * checks the addToFront method
     */
    public void testAddToFront() {
        deque.addToFront("orange");
        assertEquals("orange", deque.getFront());
    }


    /**
     * checks the addToBack method
     */
    public void testAddToBack() {
        deque.addToBack("pineapple");
        assertEquals("pineapple", deque.getBack());
    }


    /**
     * checks the removeFront method.
     */
    public void testRemoveFront() {
        try {
            deque.removeFront();
        }
        catch (EmptyQueueException e) {

            // to tests the method inserting a catch block
        }

        deque.addToFront("apple");
        deque.addToFront("mango");
        assertEquals("mango", deque.removeFront());
    }


    /**
     * checks the removeBack method.
     */
    public void testRemoveBack() {
        try {
            deque.removeBack();
        }
        catch (EmptyQueueException e) {

            // to test the method inserting a catch block.
        }

        deque.addToBack("orange");
        deque.addToBack("apple");
        assertEquals("apple", deque.removeBack());
    }


    /**
     * checks the GetFront method
     */
    public void testGetFront() {
        try {
            deque.getFront();
        }
        catch (EmptyQueueException e) {

            // to test the method inserting a catch block.

        }

        deque.addToFront("apple");
        assertEquals("apple", deque.getFront());
    }


    /**
     * checks the GetBack method
     */
    public void testGetBack() {
        try {
            deque.getBack();
        }
        catch (EmptyQueueException e) {

            // to tests the method inserting a catch block.
        }

        deque.addToBack("orange");
        assertEquals("orange", deque.getBack());
    }


    /**
     * checks the TestClear method.
     */
    public void testClear() {
        deque.addToFront("apple");
        deque.addToBack("orange");
        deque.clear();

        assertEquals(0, deque.size());
    }


    /**
     * checks the ToString method.
     */
    public void testToString() {
        deque.addToFront("orange");
        deque.addToBack("apple");
        deque.addToBack("mango");

        assertEquals("[orange, apple, mango]", deque.toString());
    }

    
    public void testRemoveSecond() {
        try {
            deque.removeSecond();
        }
        catch (EmptyQueueException e) {

        }

        deque.addToFront("apple");

        assertEquals(null, deque.removeSecond());

        deque.addToFront("orange");

        assertEquals("apple", deque.removeSecond());

        deque.addToFront("mango");

        assertEquals("orange", deque.removeSecond());

    }


    public void testRemoveSecondToLast() {
        try {
            deque.removeSecondToLast();
        }
        catch (EmptyQueueException e) {
            System.out.println("Exception caught - "+e);
        }

        deque.addToFront("apple");

        assertEquals(null, deque.removeSecondToLast());

        deque.addToFront("orange");

        assertEquals("orange", deque.removeSecondToLast());

        deque.addToFront("orange");
        deque.addToFront("mango");  

        assertEquals("orange", deque.removeSecondToLast());

    }
 

}
