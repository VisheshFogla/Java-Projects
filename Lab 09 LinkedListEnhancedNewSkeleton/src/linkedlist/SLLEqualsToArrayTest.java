package linkedlist;

import java.util.Arrays;
import student.TestCase;

/**
 * 
 * Tests the equals and toArray methods of a singly linked list.
 * 
 * @author Margaret Ellis (maellis1)
 * 
 * @author Jeff Robertson (thejar)
 * 
 * @version 03/19/2017
 *
 */
public class SLLEqualsToArrayTest extends TestCase {

    private SinglyLinkedList<String> emptyListA;
    private SinglyLinkedList<String> emptyListB;
    private SinglyLinkedList<String> smallListA;
    private SinglyLinkedList<String> smallListB;
    private SinglyLinkedList<String> bigListA;
    private SinglyLinkedList<String> bigListB;
    private String nullObject;
    
    private SinglyLinkedList<String> mango;


    /**
     * Initializes 2 empty lists, 2 lists with a small number of items, and 2
     * lists with a large number of items
     */
    public void setUp() {
        emptyListA = new SinglyLinkedList<String>();
        emptyListB = new SinglyLinkedList<String>();

        smallListA = new SinglyLinkedList<String>();
        smallListB = new SinglyLinkedList<String>();

        smallListA.add("soccer");
        smallListA.add("swimming");
        smallListA.add("gymnastics");

        smallListB.add("soccer");
        smallListB.add("swimming");
        smallListB.add("gymnastics");

        bigListA = new SinglyLinkedList<String>();

        for (int i = 0; i < 100; i++) {
            bigListA.add("sport" + i);
        }

        bigListB = new SinglyLinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }

        // to be explicit
        nullObject = null;
        
        mango = new SinglyLinkedList<String>();
        mango.add("String");

    }


    /**
     * Tests the equals method on an empty list
     */
    public void testEqualsEmptyList() {
        assertEquals(emptyListA, emptyListA);
        assertEquals(emptyListA, emptyListB);
        assertFalse(emptyListA.equals(nullObject));
        assertFalse(emptyListA.equals("soccer"));
        assertFalse(emptyListA.equals(smallListA));
        assertFalse(smallListA.equals(emptyListA));
        emptyListB.add("jump roping");
        assertFalse(emptyListA.equals(emptyListB));
        smallListA.clear();
        assertEquals(emptyListA, smallListA);
    }


    /**
     * Tests the equals method on a list with a small number of items in it
     */
    public void testEqualsSmallList() {
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(smallListA.equals(nullObject));
        assertFalse(smallListA.equals("soccer"));
        assertFalse(smallListA.equals(bigListA));
        assertFalse(smallListA.equals(emptyListA));
        smallListB.add("jump roping");
        assertFalse(smallListA.equals(smallListB));

        // Make smallListA and smallListB differ in
        // content, but have the same size
        smallListA.add("rope jumping");
        assertFalse(smallListA.equals(smallListB));

        // Replace the last element in smallListA
        // to make smallListA and smallListB equal again
        smallListA.remove("rope jumping");
        smallListA.add("jump roping");
        assertEquals(smallListA, smallListB);
    }


    /**
     * Tests the equals method on a list with a large number of items in it
     */
    public void testEqualsBigList() {
        assertEquals(bigListA, bigListA);
        assertEquals(bigListA, bigListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(bigListA.equals(smallListA));
        assertFalse(bigListA.equals(emptyListA));
        bigListB.add("jump roping");
        assertFalse(bigListA.equals(bigListB));

        // Same content, same size, but reversed
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 100; i > 0; i--) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // one a subset of the other but with dups
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // make them equal again
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }
        assertEquals(bigListA, bigListB);

    }


    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty() {

        Object[] emptyArray = {};
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(emptyListA.toArray(), smallListB.toArray()));
        Object[] oneItemArray = { "one thing" };
        emptyListA.add("one thing");
        assertTrue(Arrays.equals(emptyListA.toArray(), oneItemArray));

    }


    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents() {

        Object[] origArray = { "soccer", "swimming", "gymnastics" };
        assertTrue(Arrays.equals(smallListA.toArray(), origArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(smallListA.toArray(), bigListB.toArray()));

    }


    /**
     * tests the method remove by index.
     */
    public void testRemoveByIndex() {
        try {
            emptyListA.remove(3);
            smallListA.remove(-1);
            emptyListA.remove(-1);
        }
        catch (Exception e) {
            System.out.println("Exception Caught");
        }
        assertTrue(smallListA.remove(0));
        assertTrue(bigListA.remove(2));
        assertFalse(smallListA.remove(6));

    }


    /**
     * tests the method remove.
     */
    public void testRemoveByObject() {
        assertTrue(smallListA.remove("soccer"));
        assertTrue(bigListA.remove("sport23"));
        assertFalse(smallListA.remove("sport1"));
        assertFalse(emptyListA.remove("soccer"));
    }


    /**
     * tests the addindex method
     */
    public void testAddByIndex() {
        try {
            smallListA.add(4, "happy");
            smallListA.add(-1, "sad");
            smallListA.add(5, "null");
            smallListA.add(nullObject);
        }
        catch (Exception e) {
            
            System.out.println("Index exceeds the size.");


        }

        emptyListA.add(0, "hap");
        bigListA.add(4, "vishesh");
        assertEquals(1, emptyListA.size());

    }


    /**
     * tests the get method.
     */
    public void testGetObject() {

        smallListA.add(1, "anfield");
        try {
            smallListA.get(5);
        }
        catch (Exception e) {
            System.out.println("Index exceeds the size.");
        }

        assertEquals("soccer", smallListA.get(0));
        assertEquals("anfield", smallListA.get(1));
    }


    /**
     * tests the contains method.
     */
    public void testContians() {
        assertTrue(smallListA.contains("swimming"));
        assertFalse(emptyListA.contains("swimming"));
        emptyListA.clear();
    }


    /**
     * tests the lastIndexOf method.
     */ 
    public void testGetLastIndexOf() {
        assertEquals(0, smallListA.lastIndexOf("soccer"));
    }


    /**
     * tests the toString method.
     */
    public void testToString() {
        assertEquals("{soccer, swimming, gymnastics}", smallListA.toString());
    }
    
    /**
     * tests all the remaining condition for the code.
     */
    public void testForDifferentConditions() {
        // Tests contains
        assertTrue(mango.contains("String"));
        mango.remove("String");

        // Tests remove method.
        mango.add("String");
        mango.remove(0);
        assertEquals(mango.size(), 0, .01);

        // Tests clear method.
        mango.add("STRING");
        mango.clear();
        assertEquals(mango.size(), 0, .01);

        // Tests add at index.
        mango.add(0, "String");
        assertEquals(mango.size(), 1, .01);
        mango.add("turtle");
        mango.add(1, "pear");
        assertEquals(mango.size(), 3, .01);
        assertEquals(mango.get(1), "pear");
        mango.add(0, "bear");
        assertEquals(mango.get(0), "bear");

        Exception thrown = null;
        try {
            String pine = null;
            mango.add(0, pine);

        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        thrown = null;
        try {

            mango.add(-1, "pine");

        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        thrown = null;
        try {

            mango.add(20, "pine");

        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        thrown = null;
        try {

            mango.add(-1, "pine");

        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        // Remove
        mango.clear();
        assertFalse(mango.remove("STRING"));
        mango.add("pine");
        mango.add("bear");
        mango.add("dove");
        assertTrue(mango.remove("dove"));
        assertEquals(2, mango.size(), .01);

        // Remove Index
        mango.clear();
        thrown = null;
        try {

            mango.remove(-1);

        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        thrown = null;
        try {

            mango.remove(0);

        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        mango.add("pine");
        mango.remove(0);

        mango.add("bear");
        mango.add("dove");
        assertTrue(mango.remove(1));
        assertEquals(1, mango.size(), .01);

        mango.add("bread");
        mango.add("dove");
        mango.add("magic");
        mango.add("turtle");
        mango.remove(2);
        assertEquals(4, mango.size(), .01);
        assertFalse(mango.remove(20));

        // get Index
        mango.clear();

        thrown = null; 
        try {

            mango.get(1);

        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        // Contains
        assertFalse(mango.contains("String"));
        mango.add("string");
        mango.add("bear");
        mango.add("dove");
        assertTrue(mango.contains("dove"));

        // Clear
        mango.clear();
        mango.clear();

        // getLastIndex
        mango.add("bear");
        mango.add("string");
        mango.add("bear");
        assertEquals(2, mango.lastIndexOf("bear"), .01);

        // TOString
        mango.clear();
        mango.add("string");
        mango.add("pine");
        assertEquals("{string, pine}", mango.toString());

        // Add obj where obj is null;
        mango.clear();
        String please = null;

        thrown = null;
        try {

            mango.add(please);

        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        //Remove Obj WhileLoop()
     
        mango.remove("xyz");
     
     
        mango.add("string");
        mango.remove("xyz");
     
        mango.add("bear");
        mango.remove("xyz");
     
        mango.add("dove");
        mango.remove("xyz");
     
        mango.add("pine");
        mango.add("another");
     
     
    }

}

