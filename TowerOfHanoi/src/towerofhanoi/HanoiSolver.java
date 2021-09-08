// Virginia Tech Honor Code Pledge:

//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh (visheshfogla)

/**
 * The class defines the actual logic for the working of Tower of Hanoi. It also
 * defines the three towers for the project. The class also extends Observable. 
 */
package towerofhanoi;

import java.util.Observable;

/**
 * @author Vishesh (visheshfogla)
 * @version 2020-03-25
 * 
 */
public class HanoiSolver extends Observable {

    /**
     * Declares four fields that are used in the class. The left, right and
     * middle towers are declared and an integer value for taking the number of
     * disks is also declared.
     */
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    /**
     * 
     * The constructor for the class takes a parameter which determines the
     * number of disks for the starting tower. It also initializes the left,
     * middle and right tower by providing the appropriate parameters.
     * 
     * @param number
     *            determines the number of disks at the start of the game.
     */
    public HanoiSolver(int number) {
        numDisks = number;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }


    /**
     * 
     * The method returns the number of disks that the game Tower of Hanoi
     * contains.
     * 
     * @return number of disks at the start of the game.
     */
    public int disks() {
        return numDisks;
    }


    /**
     * 
     * The method takes a position as a parameter and returns a tower at that
     * positionIt is implemented through a switch case.
     * 
     * @param pos
     *            position that determines which tower is to be returned.
     * @return the appropriate tower based on the position given as a parameter.
     */
    public Tower getTower(Position pos) {

        switch (pos) {
            case LEFT: {
                return left;
            }
            case MIDDLE: {
                return middle;
            }
            case RIGHT: {
                return right;
            }
            default: {
                return left;
            }
        }
    }


    /**
     * The method returns a string output that provides all objects in the three
     * towers as a string in order.
     * 
     * @return string value of the objects in the three towers.
     */
    public String toString() {
        StringBuilder total = new StringBuilder();

        total.append(left.toString());
        total.append(middle.toString());
        total.append(right.toString());

        return total.toString();
    }


    /**
     * The method pops the disk from one tower and pushes the disk into another
     * tower. Both the towers are taken as parameters.
     * 
     * @param source
     *            the tower where the disk is to be pop from.
     * @param destination
     *            the tower the disk is to be pushed.
     */
    private void move(Tower source, Tower destination) {
        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * 
     * The method moves the disk from the start tower to the end tower to solve
     * the Tower of Hanoi. It defines the main logic of the program and
     * implements it with the help of recursion.
     * 
     * @param currentDisks
     *            the number of disks that are pushed into the towers before
     *            solving the game.
     * @param startPole
     *            the tower from where the diskd have to be pop or moved.
     * @param tempPole
     *            The intermediate tower where the disks will be placed for
     *            movement.
     * @param endPole
     *            The tower the disk has to be finally moved to.
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {

        // The base condition when there is only one disk to be moved.
        if (currentDisks == 1) {
            this.move(startPole, endPole); 
        }
        else if (currentDisks > 1) {

            // recursion when there are more than one disk to be moved.

            this.solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            this.solveTowers(1, startPole, tempPole, endPole);
            this.solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * The method calls the solveTowers method with appropriate parameters. The
     * number of disks are provided and the right, middle and left towers are
     * provided as the start, temp and the en towers respectively.
     */
    public void solve() {
        solveTowers(numDisks, right, middle, left);
    }

}
