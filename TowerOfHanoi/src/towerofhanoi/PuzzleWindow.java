// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh (visheshfogla)

/**
 * The class sets up the front end of the game Tower of Hanoi. Everything that
 * the class does is what is displayed on the user's screen. The class makes a
 * window that also has towers and disks within them. It allows the user to see
 * how the Tower of Hanoi works. It defines the Gui for the game.
 */
package towerofhanoi;

import java.awt.Color;

import java.util.Observable;
import java.util.Observer;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * @author Vishesh (visheshfogla)
 * @version 2020-03-25
 * 
 */
public class PuzzleWindow implements Observer {

    /**
     * Declares the fields that are required by the class.
     */
    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;
    public static final int WIDTH_FACTOR = 10;
    public static final int DISK_GAP = 10;
    public static final int DISK_HEIGHT = 10;

    /**
     * The method provides small pauses within the game which allows the user to
     * observe how the game is solved exactly.
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * 
     * The method moves the disk into the appropriate tower on the GUI. The disk
     * will be seen moving because of this method. The method takes a parameter
     * that represents the position and assigns the appropriate field to the
     * local variable.
     * 
     * @param position
     */
    private void moveDisk(Position position) {
        Disk currentDisk;
        Shape currentPole = null;

        currentDisk = game.getTower(position).peek();

        // assigns the field to the local variable depending on position to be
        // left, middle or right.

        if (position == Position.LEFT) {
            currentPole = left;
        }
        else if (position == Position.MIDDLE) {
            currentPole = middle;
        }
        else if (position == Position.RIGHT) {
            currentPole = right;
        }

        // Sets the x and y coordinate for the towers and the disks.
        // Making local variables to avoid hard coding.

        int ROD_HEIGHT = 100;
        int ROD_WIDTH = 5;

        int x = currentPole.getX();
        int y = currentPole.getY() + ROD_HEIGHT - (this.game.getTower(position)
            .size() * (DISK_HEIGHT + DISK_GAP));

        currentDisk.moveTo(x - (currentDisk.getWidth() - ROD_WIDTH) / 2, y
            - (DISK_GAP));

    }


    /**
     * 
     * The constructor of the class instantiates the tower shapes by providing
     * their height and width. It takes a parameter which represents a
     * HanoiSolver object. It also makes a new Window object. The constructor
     * adds disk shapes to the towers and
     * adds both the towers and the shapes to the window. It achieves this by
     * the means of a for loop. It then adds a solve button to the south side of
     * the window.
     * 
     * @param game
     */
    public PuzzleWindow(HanoiSolver game) {

        this.game = game;
        this.game.addObserver(this);

        // instantiates the tower shapes by giving height, width, x and y
        // coordinates.
        // making local variables to avoid hard coding values.
        int ROD_X = 200;
        int ROD_Y = 100;
        int ROD_WIDTH = 5;
        int ROD_HEIGHT = 100;
        int ROD_DISTANCE = 100;

        left = new Shape(ROD_X, ROD_Y, ROD_WIDTH, ROD_HEIGHT, Color.BLUE);
        middle = new Shape(ROD_X + ROD_DISTANCE, ROD_Y, ROD_WIDTH, ROD_HEIGHT,
            Color.RED);
        right = new Shape(ROD_X + ROD_DISTANCE*2, ROD_Y, ROD_WIDTH, ROD_HEIGHT,
            Color.GREEN);

        window = new Window();

        window.addShape(this.left);
        window.addShape(this.middle);
        window.addShape(this.right);

        // Using a for loop to add disks to the window and tower.

        for (int i = 0; i < this.game.disks(); i++) {

            Disk disk = new Disk(WIDTH_FACTOR * (this.game.disks() + 1 - i)
                + ROD_WIDTH + 10);
            game.getTower(Position.RIGHT).push(disk);
            window.addShape(this.game.getTower(Position.RIGHT).peek());
            this.moveDisk(Position.RIGHT);
        }

        // Adds a solve button to the window which solves the program on being
        // clicked.

        Button solve = new Button("Solve");
        solve.onClick(this, "clickedSolve");

        window.addButton(solve, WindowSide.SOUTH);

    }


    /**
     * The method updates the window and moves the disk based on the postion
     * that is given as parameter.
     */
    @Override
    public void update(Observable o, Object arg) {

        if (arg.getClass() == Position.class) {
            Position pos = (Position)arg;
            moveDisk(pos);
            sleep();
        }

    }


    /**
     * 
     * The method solves the program when the user clicks on the button provided
     * in the parameter.
     * 
     * @param button
     *            takes a button which will solve the program when clicked on by
     *            the user.
     */
    public void clickedSolve(Button button) {
        // button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }

}
