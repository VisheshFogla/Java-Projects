/**
 * 
 */
package game;

/**
 * @author Vishesh visheshfogla
 * @version 02/26/2020.
 */
public class ProjectRunner {

    /**
     * The main method responsible for the program to run.
     * 
     * @param args
     *            takes string arguments as input.
     */
    public static void main(String[] args) {
        WhackAShape was;

        if (args.length > 0) {
            was = new WhackAShape(args);
        }
        else {
            was = new WhackAShape();
        }
    }

}
