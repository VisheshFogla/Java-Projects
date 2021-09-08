// Virginia Tech Honor Code Pledge:]
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh (visheshfogla)

/**
 * The class tests the methods defined in the tower class.
 */
package towerofhanoi;

import student.TestCase;

/**
 * @author Vishesh (visheshfogla)
 * @version 2020-03-25
 * 
 */
public class TowerTest extends TestCase {

    /**
     * Declares fields that would be used in testing. This consists of Tower and
     * Disks objects.
     */
    private Tower t1;
    private Tower t2;
    private Tower t3;
    private Disk disk1;
    private Disk disk2;
    private Disk disk3;

    /**
     * The method initializes the fields and provides appropriate parameters
     * that each initialization requires.
     */
    public void setUp() {
        t1 = new Tower(Position.LEFT);
        t2 = new Tower(Position.RIGHT);
        t3 = new Tower(Position.MIDDLE);
        disk1 = new Disk(10);
        disk2 = new Disk(20);
        disk3 = null;
        t3.push(disk1);
    }


    /**
     * The method tests the Position method and checks if the position returned
     * by the method is correct.
     */
    public void testPosition() {
        assertEquals(Position.LEFT, t1.position());
    }


    /**
     * The method tests the push method. It checks if a valid push has taken
     * place and the disk has been correctly inserted into the tower. It throws
     * exceptions where necessary and covers all cases.
     */
    public void testPush() {
        t1.push(disk2);
        assertEquals(1, t1.size());

        t2.push(disk2);
        t2.push(disk1);
        assertEquals(2, t2.size());

        // throws exception when disk is null.
        try {
            t1.push(disk3);
        }
        catch (IllegalArgumentException e) {

            // catches an exception when an invalid push is called.

        }

        // throws exception when the disk is larger than the disk on which it is
        // being pushed.
        try {
            t3.push(disk2);
        }
        catch (IllegalStateException e) {
            
         // catches an exception when an invalid push is called.
        }
    }

}
