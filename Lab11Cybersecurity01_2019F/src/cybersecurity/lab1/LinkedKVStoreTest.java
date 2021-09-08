/**
 * 
 */
package cybersecurity.lab1;

import java.util.Iterator;
import student.TestCase;

/**
 * @author Vishesh
 * @version 04/18/2020.
 *
 */
public class LinkedKVStoreTest extends TestCase {

    private LinkedKVStore<Integer, String> store;

    /**
     * Initializes the list in the setUp for test methods.
     */
    public void setUp() {
        store = new LinkedKVStore<>();
    }


    /**
     * tests the addLast method.
     */
    public void testAddLast() {
        store.put(100, "hundread");
        assertEquals(1, store.size());
        Iterator<Integer> it = store.iterator();
        assertEquals(100, it.next().intValue());
    }


    /**
     * tests the addFirst method.
     */
    public void testAddFirst() {
        store.put(1, "one");
        store.addFirst(2, "two");
        Iterator<Integer> it = store.iterator();
        assertEquals(2, it.next().intValue());
        assertEquals(1, it.next().intValue());
        assertEquals("two", store.getFirst(2));
        assertEquals("one", store.getFirst(1));
        assertTrue(store.removeLast(1));
        assertNull(store.getLast(1));
        store.addFirst(1, "one");
        assertEquals("one", store.getLast(1));
        store.addFirst(1, "ONE");
        assertEquals("ONE", store.getFirst(1));
        assertEquals("one", store.getLast(1));

    }


    /**
     * tests the removeLast method.
     */
    public void testRemoveLast() {
        assertFalse(store.removeLast(1));
        store.put(1, "one");
        assertTrue(store.contains(1));
        assertTrue(store.removeLast(1));
        assertFalse(store.contains(1));
        store.put(1, "1.one");
        store.put(1, "1.two");
        store.put(1, "1.three");
        assertTrue(store.removeLast(1));
        assertEquals("[1, 1]", store.toString());
        assertEquals("1.two", store.getLast(1));
    }


    /**
     * tests the isEmpty method.
     */
    public void testIsEmpty() {
        assertTrue(store.isEmpty());
        store.put(1, "one");
        assertFalse(store.isEmpty());
    }


    /**
     * tests the getFirst method.
     */
    public void testGetFirst() {
        assertEquals(null, store.getFirst(1));

        store.put(1, "one");

        assertEquals("one", store.get(1));
    }


    /**
     * tests the removeFirst method.
     */
    public void testRemoveFirst() {
        assertFalse(store.removeFirst(1));

        store.put(1, "one");

        assertFalse(store.removeFirst(2));
        assertTrue(store.removeFirst(1));

    }


    /**
     * tests all conditions for removeLast method.
     */
    public void testRemoveLast1() {
        store.put(1, "one");
        assertFalse(store.removeLast(2));
    }


    /**
     * tests all conditions for contains method.
     */
    public void testContains() {
        store.put(1, "one");
        assertFalse(store.contains(2));
    }


    /**
     * tests the next method in the iterator class.
     */
    public void testNext() {
        store.put(null, null);

        assertFalse(store.isEmpty());

        Iterator<Integer> it1 = store.iterator();

        try {
            it1.next();
        }
        catch (Exception e) {

            System.out.println("Exception Caught");

        }
    }

}
