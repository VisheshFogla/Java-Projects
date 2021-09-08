/**
 * 
 */
package game;

import student.TestCase;

/**
 * @author Vishesh visheshfogla.
 * @version 02/26/2020.
 */
public class SimpleArrayBagTest extends TestCase {

    private SimpleArrayBag<Integer> bag1;
    private SimpleArrayBag<Integer> bag2;
    private SimpleArrayBag<Integer> bag3;

    /**
     * Sets up the initial conditions for the methods to be tested.
     */
    public void setUp() {
        bag1 = new SimpleArrayBag<Integer>();
        bag2 = new SimpleArrayBag<Integer>();
        bag3 = new SimpleArrayBag<Integer>();

        for (int i = 0; i < 27; i++) {
            bag2.add(i);
        }
    }


    /**
     * Tests the add method.
     */
    public void testAdd() {
        bag1.add(10);
        assertEquals(1, bag1.getCurrentSize());
        assertTrue(bag1.add(13));
        assertFalse(bag1.add(null));
        assertFalse(bag2.add(27));
    }


    /**
     * Tests the getCurrentSize method.
     */
    public void testGetCurrentSize() {
        bag1.add(10);
        assertEquals(1, bag1.getCurrentSize());
    }


    /**
     * Tests the isEmpty method.
     */
    public void testIsEmpty() {
        bag1.add(24);
        assertTrue(bag3.isEmpty());
        assertFalse(bag1.isEmpty());
    }


    /**
     * Tests the pick method.
     */
    public void testPick() {
        bag1.add(10);
        assertNull(bag3.pick());
        assertEquals(10, bag1.pick(), 0.1);
    }


    /**
     * Tests the remove method.
     */
    public void testRemove() {
        bag1.add(10);
        bag1.add(165);
        assertTrue(bag1.remove(10));
        assertFalse(bag1.remove(15));
        assertTrue(bag1.remove(165));
    }

}
