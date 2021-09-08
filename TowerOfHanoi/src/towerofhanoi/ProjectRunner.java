// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh (visheshfogla)

/**
 * The class is used to run the game Tower of Hanoi and display the frontend of
 * the game to the user.
 */
package towerofhanoi;

/**
 * @author Vishesh (visheshfogla)
 * @version 2020-03-25
 *
 */
public class ProjectRunner {

    /**
     * The method calls the constructor for PuzzleWindow and HanoiSolver classes
     * to initiate the front end and the back end of the program. It takes
     * string arguments as parameter which allow the user to input the number of
     * disks they want. The Tower of Hanoi will then begin with the number of
     * disks that hey have entered. However they can enter only one number every
     * time the game starts. The default value of number of disks has also been
     * declared in case the user does not enter any number.
     * 
     * @param args
     *            takes a number from the user in the form of string which is
     *            then parsed as integer and assigned to be the number of disks.
     */
    public static void main(String[] args) {
        int disks = 3;

        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }

        System.out.println("game started");
        HanoiSolver game = new HanoiSolver(disks);
        @SuppressWarnings("unused")
        PuzzleWindow toh = new PuzzleWindow(game);
    }

}
