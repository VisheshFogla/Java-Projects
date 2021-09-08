/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh Fogla (visheshfogla)

/**
 * 
 */
package spacecolonies;

import queue.EmptyQueueException;

/**
 * 
 * @author Vishesh
 * @version 19.04.2020
 * 
 *
 * @param <T>
 */
public class ArrayQueueTest<T> extends student.TestCase {
    private ArrayQueue<T> aq;
    private ArrayQueue<T> aq2;

    /**
     * setup
     */
    public void setUp() {
        aq = new ArrayQueue<T>();
        aq2 = new ArrayQueue<T>();
    }


    /**
     * test generic methods.
     * 
     * @throws Exception
     *             if array was empty
     */
    @SuppressWarnings({ "unchecked", "unlikely-arg-type" })
    public void testAll() throws Exception {

        aq.enqueue((T)"One");
        assertEquals(aq.dequeue(), "One");
        aq.clear();
        aq.getLength();
        assertEquals(aq.getSize(), 0);
        assertTrue(aq.isEmpty());
        aq.enqueue((T)"Two");
        assertFalse(aq.isEmpty());
        for (int i = 0; i < 10; i++) {
            aq.enqueue((T)"something");
        }
        aq.toString();
        assertEquals(aq.getFront(), "Two");
        assertTrue(aq.equals(aq));
        aq.toArray();
        aq.clear();
        assertTrue(aq.isEmpty());
        assertEquals(aq.getLength(), 11);
        try {
            aq.getFront();
        }
        catch (EmptyQueueException e) {
            System.out.println("Caught empty queue.");
        }
        try {

            aq.dequeue();

        }
        catch (EmptyQueueException e) {
            System.out.println("Caught empty queue.");
        }
        try {
            aq.toArray();
        }
        catch (EmptyQueueException e) {
            System.out.println("Caught empty queue.");
        }
        assertTrue(aq2.isEmpty());
        aq2.enqueue((T)"Impossible");
        // System.out.println(aq2.toString());
        assertFalse(aq.equals(aq2));
        assertFalse(aq.equals("CannotBeEquals"));
    }


    /**
     * test enqueue and getting length.
     */
    @SuppressWarnings("unchecked")
    public void testEnqueue() {

        aq.enqueue((T)"One");
        aq.enqueue((T)"Two");
        System.out.println("aq after enqueuing one and two: " + aq.toString());
        assertEquals(2, aq.getSize());
        assertEquals(11, aq.getLength());
        for (int i = 3; i < 11; i++) {
            String s = String.valueOf(i);
            aq.enqueue((T)s);
        }
        assertEquals(10, aq.getSize());
        assertEquals(11, aq.getLength());
        System.out.println("aq after enqueuing 11 elements: " + aq.toString());

        aq.enqueue((T)"Eleven");
        assertEquals(11, aq.getSize());
        assertEquals(21, aq.getLength());
        System.out.println(aq.toString());

        try {
            int i = 0;
            while (i < 100) {
                String s = String.valueOf(i);
                aq.enqueue((T)s);
                i++;
            }
        }
        catch (IllegalStateException e) {
            System.out.println(aq.toString());
            System.out.println(
                "Successfully caught error when capacity exceeded maximum");
        }
    }


    /**
     * test the equal methods.
     */
    @SuppressWarnings("unchecked")
    public void testEquals() {
        assertTrue(aq.equals(aq2));
        aq.enqueue((T)"One");
        assertFalse(aq.equals(aq2));
        assertEquals(aq2.toString(), "[]");
        aq2.enqueue((T)"One");
        assertTrue(aq.equals(aq2));
        aq.dequeue();
        assertEquals(aq.toString(), "[]");
        aq2.dequeue();
        assertTrue(aq.equals(aq2));
        aq.enqueue((T)"Two");
        aq2.enqueue((T)"Three");
        assertFalse(aq.equals(aq2));
        aq2.dequeue();
        aq2.enqueue((T)"Two");
        assertTrue(aq.equals(aq2));
    }


    /**
     * test toArray.
     */
    @SuppressWarnings("unchecked")
    public void testToArray() {
        System.out.println("Testing toArray");
        aq.enqueue((T)"One");
        aq.enqueue((T)"Two");
        Object[] answer = new Object[2];
        answer[0] = "One";
        answer[1] = "Two";
        assertEquals(aq.getSize(), 2);
        assertEquals(aq.toArray()[0], answer[0]);
        assertEquals(aq.toArray()[1], answer[1]);
    }


    /**
     * tests the equals method in the ArrayQueue class.
     */
    public void testEquals2() {

        ArrayQueue<String> q1 = new ArrayQueue<>();
        ArrayQueue<String> q2 = new ArrayQueue<>();
        ArrayQueue<String> q3 = null;

        q1.enqueue("apple");
        q1.enqueue("mango");
        q2.enqueue("apple");
        q2.enqueue("mango");

        assertTrue(q1.equals(q2));
        assertTrue(q1.equals(q1));
        assertFalse(q1.equals(q3)); 
        assertFalse(q1.equals("apple"));

        q2.enqueue("mango");

        assertFalse(q1.equals(q2));

        q1.enqueue("papaya");

        assertFalse(q1.equals(q2));

    }
}
