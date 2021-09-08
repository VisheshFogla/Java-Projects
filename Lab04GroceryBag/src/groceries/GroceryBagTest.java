package groceries;

import student.TestCase;

/**
 * @author Vishesh
 * @version 02.14.2020
 */
public class GroceryBagTest extends TestCase {
    /*
     * Instantiates the fields of the class
     * that are used for testing different methods.
     */
    private GroceryBag bag1;
    private GroceryBag bag2;
    private GroceryBag bag3;
    private GroceryBag bag6;
    private String bag7;
    private GroceryBag bag8;
    private GroceryBag bag9;
    private GroceryBag bag10;
    private GroceryBag bag11;
    private GroceryBag bag12;

    /**
     * Sets up each test method.
     */
    public void setUp() {
        bag1 = new GroceryBag();
        bag1.add("apples");
        bag1.add("chips");
        bag1.add("yogurt");
        bag1.add("chicken");
        bag1.add("pasta");

        bag2 = new GroceryBag();
        bag2.add("pizza");
        bag2.add("broccoli");
        bag2.add("pasta");
        bag2.add("pasta");
        bag2.add("apples");

        bag3 = new GroceryBag();
        bag3.add("apples");
        bag3.add("chicken");
        bag3.add("chicken");
        bag3.add("pasta");
        bag3.add("pizza");
        bag3.add("soda");
        bag3.add("yoghurt");
        bag3.add("wheat");

        GroceryBag bag4 = new GroceryBag();
        bag4.add("chicken");
        bag4.add("chicken");
        bag4.add("pasta");
        bag4.add("pasta");
        bag4.add("yoghurt");

        bag6 = null;

        bag7 = "Hello!";

        bag8 = new GroceryBag();
        bag8.add("pizza");
        bag8.add("broccoli");

        bag9 = new GroceryBag();
        bag9.add(null);
        bag9.add(null);
        bag9.add("pizza");

        bag10 = new GroceryBag();
        bag10.add(null);
        bag10.add(null);
        bag9.add("pizza");

        bag11 = new GroceryBag();
        bag11.add("apples");
        bag11.add("chips");
        bag11.add("yogurt");
        bag11.add("chicken");
        bag11.add("pasta");

        bag12 = new GroceryBag();
        bag12.add(null);
        bag12.add(null);
        bag12.add(null);

    }

    /**
     * tests the intersection method and
     * checks if there are an intersection of elements
     * in a new bag.
     */
    public void testIntersection() {
        GroceryBag bag5 = bag1.intersection(bag2);

        assertTrue(bag5.contains("pasta"));
        assertTrue(bag5.contains("apples"));
    }


    /**
     * tests the equals method and checks if the
     * two bags given are equal.
     */
    public void testEquals1() {
        assertFalse(bag1.equals(bag2));
    }


    /**
     * tests the equals method and checks if the
     * bag is the same bag.
     */
    public void testEquals2() {
        assertTrue(bag1.equals(bag1));
    }


    /**
     * tests the equals method and checks if the
     * bag is null
     */
    public void testEquals3() {
        assertFalse(bag1.equals(bag6));
    }


    /**
     * tests the equals method and checks if the
     * bag is of a different class
     */
    public void testEquals4() {
        assertFalse(bag1.equals(bag7));
    }


    /**
     * tests the equals method and checks if the
     * size of one bag is the same as other.
     */
    public void testEquals5() {
        assertFalse(bag1.equals(bag3));
    }


    /**
     * tests the equals method and checks if the
     * the bags are equal.
     */
    public void testEquals6() {
        assertFalse(bag2.equals(bag8));
    }


    /**
     * tests the equals method
     */
    public void testEquals7() {
        assertFalse(bag9.equals(bag10));
    }


    /**
     * tests the equals method
     */
    public void testEquals8() {
        assertTrue(bag1.equals(bag11));
    }


    /**
     * tests the equals method.
     */
    public void testEquals9() {
        assertFalse(bag12.equals(bag10));
    }

}
