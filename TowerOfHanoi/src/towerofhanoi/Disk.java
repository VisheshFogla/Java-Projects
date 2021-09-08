// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh (visheshfogla)

/**
 * The class represents a disk. The class forms a disk and defines different
 * functions for it.
 * The class defines a constructor and three methods for the disk which is later
 * used in the project.
 */
package towerofhanoi;

import CS2114.Shape;
import student.TestableRandom;
import java.awt.Color;

/**
 * @author Vishesh (visheshfogla)
 * @version 2020-03-25
 *
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * 
     * Represents the constructor of the Disk class. The constructor takes the
     * width parameter and also calls the constructor of the super class. The
     * super constructor takes four parameters which include the width and
     * height of the disk. The disk is also given a random color which is
     * randomly determined by generating three random numbers.
     * 
     * @param width
     *            takes the width of the disk which would would be assigned to
     *            the disk. This width would determine whether the disk is
     *            eligible to have a valid push or not in the tower class.
     */
    public Disk(int width) {

        // Calls the constructor of the super class.
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);

        TestableRandom generator = new TestableRandom();
        // Generates three random numbers for deciding color.
        int first = generator.nextInt(256);

        int second = generator.nextInt(256);

        int third = generator.nextInt(256);

        Color rang = new Color(first, second, third);

        this.setBackgroundColor(rang);
    }


    /**
     * 
     * The method compares the disk taken as parameter to the disk on which the
     * method is called on. The method throws exception when the disk taken is
     * null. It returns a positive value if the width of the parameterized disk
     * is less than the disk on which the method is called on. It returns a
     * negative value if the width is larger. If the width of the two disks is
     * the same then the method returns 0. Therefore, the method returns an
     * integer value.
     * 
     */
    @Override
    public int compareTo(Disk o) {

        if (o == null) {
            throw new IllegalArgumentException();
        }
        else if (o.getWidth() < this.getWidth()) {
            return 1;
        }
        else if (o.getWidth() > this.getWidth()) {
            return -1;
        }

        return 0;
    }


    /**
     * The method prints the width of the disk on which the method is called on.
     * The method returns the width of the disk in the form of string value.
     * 
     * @return the width of the disk as a string.
     */
    public String toString() {
        int wid = this.getWidth();

        return "" + wid + "";
    }


    /**
     * 
     * The method checks if the object taken as a parameter is equal to the
     * object on which the method is called on. The method returns the correct
     * boolean value based on different conditions. The method checks that the
     * width of the disk taken as a parameter is equal to the width of the disk
     * on which the disk is called on. If it is equal then the method returns
     * true. If the width is not equal then the method returns false. If the
     * object to be compared is the same as the object then the method return
     * true. If the object taken is null then the method returns false. If the
     * classes of the two objects are different then the method returns false.
     * 
     * @param other
     *            takes an object to be compared to the object on which the
     *            method is called on.
     * 
     * @return boolean value depending on whether the two objects are equal or
     *         not. In this case if the width of the two disks is equal then it
     *         would return true.
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass().equals(other.getClass())) {
            Disk different = (Disk)other;
            if (this.getWidth() == different.getWidth()) {
                return true;
            }
        }
        return false;
    }
}
