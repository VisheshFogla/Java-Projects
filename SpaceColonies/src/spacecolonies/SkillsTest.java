// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh Fogla (visheshfogla)

/**
 * tests the method in the skils class.
 */
package spacecolonies;

import student.TestCase;

/**
 * @author Vishesh
 * @version 19.04.2020
 *
 * 
 */
public class SkillsTest extends TestCase {

    private Skills set1;
    private Skills set2;
    private Skills set3;
    private Skills set4;
    private Skills set5;
    private Skills set6;

    /**
     * sets up the method for testing.
     */
    public void setUp() {
        set1 = new Skills(4, 2, 3);
        set2 = new Skills(5, 5, 5);
        set3 = new Skills(3, 4, 3);
        set4 = new Skills(3, 1, 4);
        set5 = new Skills(4, 2, 3);
        set6 = new Skills(4, 2, 0);

    }


    /**
     * tests the getAgriculture method in the skills class.
     */
    public void testGetAgriculture() {

        assertEquals(4, set1.getAgriculture());
    }


    /**
     * tests the getMedicine method in the skills class.
     */
    public void testGetMedicine() {
        assertEquals(2, set1.getMedicine());
    }


    /**
     * tests the getTechnology method in the skills class.
     */
    public void testGetTechnology() {
        assertEquals(3, set1.getTechnology());
    }


    /**
     * tests the IsBelow method in the skills class.
     */
    public void testIsBelow() {
        assertTrue(set1.isBelow(set2));
        assertFalse(set2.isBelow(set1));
        assertFalse(set3.isBelow(set1));
        assertFalse(set4.isBelow(set1));
    }


    /**
     * tests the Equals method in the skills class.
     */
    public void testEquals() {

        Skills set7 = null;

        assertTrue(set1.equals(set1));
        assertFalse(set1 == (null));
        assertFalse(set1.equals("invalid"));
        assertTrue(set1.equals(set5));
        assertFalse(set1.equals(set2));
        assertFalse(set1.equals(set4));
        assertFalse(set3.equals(set4));
        assertFalse(set1.equals(set6));
        assertFalse(set1.equals(set7));

    }


    /**
     * tests the toString method in the skills class.
     */
    public void testToString() {
        assertEquals("A:4 M:2 T:3", set1.toString());
    }
}
