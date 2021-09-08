/**
 * 
 */
package game;

import student.TestCase;
import student.TestableRandom;

/**
 * @author Vishesh visheshfogla
 * @version 02/26/2020.
 * 
 */
public class SimpleLinkedBagTest extends TestCase {

    private SimpleLinkedBag<Integer> bag1;
    private SimpleLinkedBag<Integer> bag2;

    /**
     * Sets up the initial conditions for the methods to be tested.
     */
    public void setUp() {
        bag1 = new SimpleLinkedBag<Integer>(); 
        bag2 = new SimpleLinkedBag<Integer>();
    }


    /**
     * Tests the add method.
     */
    public void testAdd() {
        bag1.add(10);
        assertEquals(1, bag1.getCurrentSize());
        assertFalse(bag2.add(null));
    }


    /**
     * Tests the isEmpty method.
     */
    public void testIsEmpty() {
        assertTrue(bag1.isEmpty());
    }


    /**
     * Tests the pick method
     */
    public void testPick() {
        bag1.add(123);
        bag1.add(34);
        bag1.add(111);
        TestableRandom.setNextInts(1);
        assertEquals(34, bag1.pick(), 0.1);
        assertNull(bag2.pick());

    }


    /**
     * Tests the remove method.
     */
    public void testRemove() {

        bag1.add(15);
        bag1.add(22);
        bag1.add(56);
        bag1.add(45);
        assertTrue(bag1.remove(15));
        assertTrue(bag1.remove(45));
        assertTrue(bag1.remove(22));
        assertFalse(bag1.remove(67));
        assertFalse(bag2.remove(13));
    }

}
