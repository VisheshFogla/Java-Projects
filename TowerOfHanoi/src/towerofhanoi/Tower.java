// Virginia Tech Honor Code Pledge:]
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh (visheshfogla)

/**
 * The class defines the tower in which the disks will be pushed in. It also
 * defines some methods that would be performed on tower objects.
 */
package towerofhanoi;

/**
 * @author Vishesh (visheshfogla)
 * @version 2020-03-25
 * 
 */
public class Tower extends LinkedStack<Disk> {

    /**
     * Declares the field that would be used in the class. The field is a
     * position field.
     */
    private Position position;

    /**
     * 
     * Defines the constructor of the tower class that calls the constructor of
     * the super class and takes position as a parameter. This position is then
     * assigned to the field that has been declared already.
     * 
     * @param position
     *            takes a position that would determine the position of the
     *            tower.
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }


    /**
     * 
     * The method returns the position of the Tower on which the method is
     * called on.
     * 
     * @return position of the tower on which the method is called on.
     */
    public Position position() {
        return this.position;
    }


    /**
     * The method pushes a disk into the tower on which the method is called on.
     * It evaluates if the push is a valid push and then determines whether it
     * should perform the action of pushing or not. If it is a valid push, we
     * call super.push(), and provide the disk. If this is an invalid push, we
     * will throw an IllegalStateException or if the disk passed in is null we
     * should throw an IllegalArgumentException.
     */
    @Override
    public void push(Disk disk) {

        if (disk == null) {
            System.out.println("Exception thrown null");

            throw new IllegalArgumentException();
        }
        else if (!isEmpty() && (this.peek().compareTo(disk)) != 1) {
            System.out.println("Exception thrown");

            throw new IllegalStateException();
        }

        super.push(disk);

    }

}
