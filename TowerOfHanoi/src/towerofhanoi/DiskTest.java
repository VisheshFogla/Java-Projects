// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh (visheshfogla)

/**
 * The class tests the methods in the Disk class. It checks if the methods
 * covers all condition
 */
package towerofhanoi;

import student.TestCase;

/**
 * @author Vishesh (visheshfogla)
 * @version 2020-03-25
 *
 */
public class DiskTest extends TestCase {

    /**
     * defines disks fields that are used for testing
     */
    private Disk disk1;
    private Disk disk2;
    private Disk disk3;
    private Disk disk4;
    private Disk disk5;

    /**
     * The setUp method initializes the disk fields by providing parameters to
     * each one of them.
     * It also defines a null disk that is used for testing purposes.
     */
    public void setUp() {
        disk1 = new Disk(34);
        disk2 = new Disk(34);
        disk3 = null;
        disk4 = new Disk(45);
        disk5 = new Disk(23);
    }


    /**
     * The method tests the compareTo method which compares the width of two
     * disks.
     */
    public void testCompareTo() {

        // tests the case where an exception is thrown when the parameterized
        // disk is null.
        try {
            disk1.compareTo(disk3);
        }
        catch (IllegalArgumentException e) {

            // catches an IllegalArgumentException when the disk provided in the
            // parameter is null.
        }

        // tests if the width is smaller.
        assertEquals(1, disk1.compareTo(disk5));
        // tests if the width is larger.
        assertEquals(-1, disk1.compareTo(disk4));
        // tests if the width is equal.
        assertEquals(0, disk1.compareTo(disk2));

    }


    /**
     * The method tests the toString method and checks if the correct String
     * output is obtained when toString method is called. The toString method
     * should correctly return the width of the disk as a string.
     */
    public void testToString() {
        assertEquals("23", disk5.toString());
    }


    /**
     * The method tests the equals method and checks if the equals method
     * returns the correct boolean value depending on different cases.
     */
    public void testEquals() {

        // Defines a string variable that is used for testing.
        String test = "hello";

        // tests if the boolean value is false when the parameterized disk is
        // null.
        assertFalse(disk1.equals(disk3));

        // tests if the boolean value is true when the parameterized disk is the
        // same disk as the disk on which the method is called.
        assertTrue(disk1.equals(disk1));

        // tests if the boolean value is false when the classes of the two
        // object being compared are different.
        assertFalse(disk1.equals(test));

        // tests if the boolean value is true when the two objects have the same
        // width.
        assertTrue(disk1.equals(disk2));

        // tests if the boolean value if false when the two objects have
        // different width.
        assertFalse(disk1.equals(disk4));
    }

}
