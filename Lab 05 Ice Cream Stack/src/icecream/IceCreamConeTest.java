/**
 * 
 */
package icecream;

import student.TestCase;

/**
 * @author Vishesh
 * @version 02/21/2020
 */
public class IceCreamConeTest extends TestCase {

    private IceCreamCone cone1;
    private IceCreamCone cone2;
    private IceCreamCone cone3;
    private IceCreamCone cone4;
    private String cone;

    /**
     * sets up instance fields
     */
    public void setUp() {
        cone1 = new IceCreamCone();
        cone2 = new IceCreamCone();
        cone3 = new IceCreamCone();
        cone = "vanilla";
        cone4 = null;
    }


    /**
     * tests add method.
     */
    public void testAddSoop() {
        cone1.addScoop("vanilla");
        assertTrue(cone1.contains("vanilla"));
    }


    /**
     * tests eat scoop method.
     */
    public void testEatScoop() {
        cone1.addScoop("chocolate");
        assertEquals("chocolate", cone1.eatScoop());
    }


    /**
     * tests num scoops method.
     */
    public void testNumScoops() {
        cone1.addScoop("strawberry");
        cone1.addScoop("butterscotch");
        assertEquals(2, cone1.numScoops());
    }


    /**
     * tests contains method.
     */
    public void testContains1() {
        cone1.addScoop("strawberry");
        assertTrue(cone1.contains("strawberry"));
    }


    /**
     * tests empty cone method.
     */
    public void testEmptyCone() {
        assertTrue(cone3.emptyCone());
    }


    /**
     * tests current scoop method.
     */
    public void testCurrentScoop() {
        cone1.addScoop("flavor");
        assertEquals("flavor", cone1.currentScoop());
    }


    /**
     * tests equals method.
     */
    public void testEquals1() {
        cone1.addScoop("strawberry");

        cone2 = cone1;
        assertTrue(cone1.equals(cone2));
    }


    /**
     * tests equals method.
     */
    public void testEquals2() {
        assertFalse(cone1.equals(cone4));
    }


    /**
     * tests equals method.
     */
    public void testEquals3() {
        cone1.addScoop("strawberry");

        assertFalse(cone1.equals(cone));
    }


    /**
     * tests equals method.
     */
    public void testEquals4() {
        cone1.addScoop("vanilla");
        cone2.addScoop("vanilla");
        assertTrue(cone1.equals(cone2));
    }


    /**
     * tests equals method.
     */
    public void testEquals5() {
        cone1.addScoop("strawberry");
        cone2.addScoop("vanilla");

        assertFalse(cone1.equals(cone2));
    }


    /**
     * tests the toString method.
     */
    public void testToString() {
        cone1.addScoop("vanilla");
        assertEquals("[vanilla]", cone1.toString());
    }
    /**
     * tests the contains method for second condition.
     */
    public void testContains2()
    {
        cone1.addScoop("vanilla");
        assertFalse(cone1.contains("strawberry"));
    }

}
