// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh (visheshfogla)

/**
 * The class tests the methods in the HanoiSolver class.
 */
package towerofhanoi;

import student.TestCase;

/**
 * @author Vishesh (visheshfogla)
 * @version 2020-03-25
 * 
 */
public class HanoiSolverTest extends TestCase {

    /**
     * Declares the fields for testing the methods. This includes HanoiSolver,
     * Tower and disk objects.
     */
    private HanoiSolver hs1;
    private HanoiSolver hs2;
    private Tower left;
    private Tower middle;
    private Tower right;
    private Disk disk3;

    /**
     * The method initializes the fields of the class by providing the parameter
     * wherever necessary.
     */
    public void setUp() {
        hs1 = new HanoiSolver(3);
        hs2 = new HanoiSolver(0); 

        left = hs1.getTower(Position.LEFT);
        middle = hs1.getTower(Position.MIDDLE);
        right = hs1.getTower(Position.RIGHT);

        Disk disk1 = new Disk(30);
        Disk disk2 = new Disk(20);
        disk3 = new Disk(10);

        hs1.getTower(Position.RIGHT).push(disk1);
        hs1.getTower(Position.RIGHT).push(disk2);
        hs1.getTower(Position.RIGHT).push(disk3);
        hs1.getTower(Position.DEFAULT);

        hs2.getTower(Position.RIGHT).push(disk1);

    }


    /**
     * The method tests the disk method. It checks whether the number of disks
     * in the HanoiSolver is correct or not.
     */
    public void testDisks() {
        assertEquals(3, hs1.disks());
    }


    /**
     * The method tests the getTower method and checks if the appropriate tower
     * is returned when different positions have been entered.
     */
    public void testGetTower() {
        assertEquals(left, hs1.getTower(Position.LEFT));
        assertEquals(middle, hs1.getTower(Position.MIDDLE));
        assertEquals(right, hs1.getTower(Position.RIGHT));

    }


    /**
     * The method tests the toString method. It checks whether the correct
     * string output for the object in the three towers in the proper order is
     * obtained.
     */
    public void testToString() {
        hs1.getTower(Position.MIDDLE).push(disk3);
        hs1.getTower(Position.LEFT).push(disk3);
        assertEquals("[10][10][10, 20, 30]", hs1.toString());
    }


    /**
     * The method tests the solve method and checks whether the disks have been
     * moved from the right tower to the left one. It ensures that the logic of
     * the program is working accurately.
     */
    public void testSolve() {
        hs1.solve();
        assertEquals(3, hs1.getTower(Position.LEFT).size());

        hs2.solve();
        assertEquals(0, hs2.getTower(Position.LEFT).size());
    }

}
