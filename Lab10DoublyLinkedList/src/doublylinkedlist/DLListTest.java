/**A
 *
 */
package doublylinkedlist;

import student.TestCase;
import java.util.Iterator;

/**
 * @author Eric
 * @author maellis1
 * @version 11-2-15
 *
 */
public class DLListTest extends TestCase {
    /**
     * the list we will use
     */
    private DLList<String> list;
    private Iterator iter;
    private Iterator reviter;

    /**
     * run before every test case
     */
    @Override
    public void setUp() {
        list = new DLList<String>();
    }


    /**
     * Tests that an IndexOutOfBounds exception is thrown when the index is
     * greater than or equal to size and less than zero
     */
    public void testRemoveException() {
        list.add("A");
        Exception e = null;
        try {
            list.remove(2);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.remove(-1);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests that objects can be removed at the beginning and end and that the
     * size is changed
     */
    public void testRemoveIndex() {
        list.add("A");
        list.add("B");
        assertTrue(list.remove(1));
        assertEquals(1, list.size());
        list.add("B");
        assertTrue(list.remove(0));
        assertEquals(1, list.size());
    }


    /**
     * Tests the add method. Ensures that it adds the object is added at the end
     * and the size is increased
     */
    public void testAdd() {
        assertEquals(0, list.size());
        list.add("A");
        assertEquals(1, list.size());
        list.add("B");
        assertEquals(2, list.size());
        assertEquals("B", list.get(1));

    }


    /**
     * Tests that objects can be added at the beginning and end and that they
     * are placed correctly
     */
    public void testAddIndex() {
        list.add("B");
        list.add(0, "A");
        assertEquals("A", list.get(0));
        assertEquals(2, list.size());
        list.add(2, "D");
        assertEquals("D", list.get(2));
        list.add(2, "C");
        assertEquals("C", list.get(2));
    }


    /**
     * This tests that the add method throws a null pointer exception when
     * adding null data to the list
     */
    public void testAddNullException() {
        Exception e = null;
        try {
            list.add(null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests that the add method throws a Invalid argument when adding null
     * data to the list
     */
    public void testAddIndexNullException() {
        Exception e = null;
        try {
            list.add(0, null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests when the add method is called and the index is greater than
     * size or less than zero
     */
    public void testAddException() {
        list.add("A");
        Exception e = null;
        try {
            list.add(2, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.add(-1, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests removing a object changes the size appropiately and that you can
     * remove the first and last elements
     */
    public void testRemoveObj() {
        assertFalse(list.remove(null));
        list.add("A");
        list.add("B");
        assertTrue(list.remove("A"));
        assertEquals("B", list.get(0));
        assertEquals(1, list.size());
        list.add("C");
        assertTrue(list.remove("C"));
        assertEquals("B", list.get(0));
    }


    /**
     * Tests get when the index is greater than or equal to size and when the
     * index is less than zero
     */
    public void testGetException() {
        Exception exception = null;
        try {
            list.get(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        list.add("A");
        try {
            list.get(1);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test contains when it does and does not contain the object
     */
    public void testContains() {
        assertFalse(list.contains("A"));
        list.add("A");
        assertTrue(list.contains("A"));
        assertFalse(list.contains("B"));
        list.add("B");
        assertTrue(list.contains("B"));
    }


    /**
     * Test lastIndexOf when the list is empty, when the object is not in the
     * list, and when it is at the beginning or end
     */
    public void testLastIndexOf() {
        assertEquals(-1, list.lastIndexOf("A"));
        list.add("A");
        assertEquals(0, list.lastIndexOf("A"));
        list.add("A");
        assertEquals(1, list.lastIndexOf("A"));
        list.add("B");
        assertEquals(1, list.lastIndexOf("A"));
        assertEquals(2, list.lastIndexOf("B"));
        list.add("A");
        assertEquals(3, list.lastIndexOf("A"));
    }


    /**
     * Tests isEmpty when empty and full
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }


    /**
     * Ensures that all of the objects are cleared and the size is changed
     */
    public void testClear() {
        list.add("A");
        list.clear();
        assertEquals(0, list.size());
        assertFalse(list.contains("A"));
    }


    /**
     * Tests the toString when there are 0, 1, and 2 objects in the list
     */
    public void testToString() {
        assertEquals("{}", list.toString());
        list.add("A");
        assertEquals("{A}", list.toString());
        list.add("B");
        assertEquals("{A, B}", list.toString());
    }


    /**
     * Tests removing from an empty list
     */
    public void testRemoveFromEmpty() {
        list.add("dance");
        list.add(0, "safety");
        list.clear();
        assertFalse(list.remove("safety"));
        Exception exception;
        exception = null;
        try {
            list.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        DLList<String> emptyList = new DLList<String>();
        exception = null;
        try {
            emptyList.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * tests the hasNext method in the iterator class.
     */
    public void testHasNext() {
        iter = list.iterator();
        assertFalse(iter.hasNext());

        list.add("apple");
        list.add("mango");
        assertTrue(iter.hasNext());

    }


    /**
     * tests the Next method.
     */
    public void testNext() {
        try {
            iter = list.iterator();
            iter.next();
        }
        catch (Exception e) {
            System.out.println("Exception caught - " + e);
        }

        list.add("apple");
        list.add("mango");
        iter = list.iterator(); 

        assertEquals("apple", iter.next());

        assertEquals("mango", iter.next());

        try {
            iter.next();
        }
        catch (Exception e) {
            System.out.println("Exception caught - " + e);
        }
    }


    /**
     * tests the remove method in the iterator class.
     */
    public void testRemove() {
        try { 
            iter = list.iterator();
            iter.remove();
        }
        catch (Exception e) {
            System.out.println("Exception caught - " + e);
        }

        list.add("apple");
        list.add("mango");
        list.add("pineapple");

        iter = list.iterator();
        iter.next();
        iter.next();
        iter.remove();
        

        assertEquals(2, list.size());
        assertEquals("{apple, pineapple}", list.toString());

        try {
            iter.remove();
        }
        catch (Exception e) {
            System.out.println("Next() has not been called - " + e);
        }

    }
    
    /**
     * tests the remove method in the reverse Iterator class.
     */
    public void testRemove2() {
        try {
            reviter = list.reverseIterator();
            reviter.remove();
        }
        catch (Exception e) {
            System.out.println("Exception caught - " + e);
        }

        list.add("apple");
        list.add("mango");
        list.add("pineapple");

        reviter = list.reverseIterator();
        reviter.next();
        reviter.next();
        reviter.remove(); 
        

        assertEquals(2, list.size());
        assertEquals("{apple, pineapple}", list.toString());

        try {
            reviter.remove();
        }
        catch (Exception e) {
            System.out.println("Next() has not been called - " + e);
        }

    }
    
    /**
     * tests the Next method in the reverse Iterator class.
     */
    public void testNext2() {
        try {
            reviter = list.reverseIterator();
            reviter.next();
        }
        catch (Exception e) {
            System.out.println("Exception caught - " + e);
        }

        list.add("apple");
        list.add("mango");
        reviter = list.reverseIterator();  

        assertEquals("mango", reviter.next()); 

        assertEquals("apple", reviter.next());

        try {
            reviter.next();
        }
        catch (Exception e) {
            System.out.println("Exception caught - " + e);
        }
    }
    
    /**
     * tests the hasNext method in the reverse Iterator class.
     */
    public void testHasNext2() {
        reviter = list.reverseIterator();
        assertFalse(reviter.hasNext());

        list.add("apple");
        list.add("mango");  
        assertTrue(reviter.hasNext());

    }

}
