/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh Fogla (visheshfogla)

package spacecolonies;

import CS2114.*;

import java.awt.Color;


/**
 * @author Vishesh
 * @version 19.04.2020
 * 
 */
public class SpaceWindow {
    private Window window;
    private TextShape personInfo;
    private TextShape planet1;
    private TextShape planet2;
    private TextShape planet3;
    private ColonyCalculator colonyCalculator;
    private Button accept;
    private Button reject;
    int circles = ColonyCalculator.NUM_PLANETS; // three different circles
    public static final int QUEUE_STARTX = 50; // The horizontal position which
                                               // starts your queue

    public static final int QUEUE_STARTY = 100; // The vertical position which
                                                // starts your queue

    public static final int CIRCLE_SIZE = 50; // To use to size each Person
                                              // circles
    public static final int SQUARE_SIZE = 100;

    public static final int PLANET_STARTX = 100;
    public static final int PLANET_STARTY = 275;


    /**
     * constructor. Creates buttons and shapes.
     * 
     * @param cc
     *            the colony calculator.
     * @throws SpaceColonyDataException
     *             if cc was null
     */
    public SpaceWindow(ColonyCalculator cc) throws SpaceColonyDataException {
        colonyCalculator = cc;
        if (colonyCalculator == null) {
            throw new SpaceColonyDataException(
                "Error: colonyCalculator was null!");
        }
        window = new Window("Space Colony Placement");
        accept = new Button("ACCEPT");
        reject = new Button("REJECT");
        accept.onClick(this, "clickedAccept");
        reject.onClick(this, "clickedReject");
        window.addButton(accept, WindowSide.SOUTH);
        window.addButton(reject, WindowSide.SOUTH);
        if (cc.getQueue().isEmpty()) {
            personInfo = new TextShape(QUEUE_STARTX, QUEUE_STARTY - CIRCLE_SIZE,
                "");
        }
        else {
            personInfo = new TextShape(QUEUE_STARTX, QUEUE_STARTY - CIRCLE_SIZE,
                cc.getQueue().getFront().toString());
        }
        Planet p1 = cc.planetByNumber(1);
        Planet p2 = cc.planetByNumber(2);
        Planet p3 = cc.planetByNumber(3);

        planet1 = new TextShape(PLANET_STARTX, PLANET_STARTY, p1.getName()
            + ", 0/10");
        System.out.println("P1 string was: " + p1.getSkills().toString());
        if (p2 != null) {
            planet2 = new TextShape(PLANET_STARTX + SQUARE_SIZE * 3 / 2,
                PLANET_STARTY, p2.getName() + ", 0/10");
        }
        if (p3 != null) {
            planet3 = new TextShape(PLANET_STARTX + SQUARE_SIZE * 3,
                PLANET_STARTY, p3.getName() + ", 0/10");
        }

        window.addShape(planet1);
        window.addShape(planet2);
        window.addShape(planet3);
        window.addShape(personInfo);
        updateGUI();
    }


    /**
     * updates the circles to match the queue and squares to match their
     * capacity, or, displays "Good work" upon completion.
     */
    public void updateGUI() {
        if (colonyCalculator.getQueue().isEmpty()) {
            window.removeAllShapes();
            window.removeButton(accept, WindowSide.SOUTH);
            window.removeButton(reject, WindowSide.SOUTH);
            TextShape done = new TextShape(window.getWidth() / 3, window
                .getHeight() / 3, "All applicants processed! Good work!");
            window.addShape(done);
        }
        else {
            window.removeAllShapes();
            // update PersonInfo.
            personInfo.remove();
            personInfo = new TextShape(QUEUE_STARTX, QUEUE_STARTY - CIRCLE_SIZE
                * 3 / 2, colonyCalculator.getQueue().getFront().toString());
            Planet p1 = colonyCalculator.planetByNumber(1);
            Planet p2 = colonyCalculator.planetByNumber(2);
            Planet p3 = colonyCalculator.planetByNumber(3);
            // update the planets

            planet1.setText(p1.getName() + ", " + p1.getPopulationSize() + "/"
                + p1.getCapacity());
            TextShape perma1 = new TextShape(PLANET_STARTX, PLANET_STARTY + 15,
                p1.getSkills().toString());
            if (p2 != null) {
                planet2.setText(p2.getName() + ", " + p2.getPopulationSize()
                    + "/" + p2.getCapacity());
                TextShape perma2 = new TextShape(PLANET_STARTX + SQUARE_SIZE * 3
                    / 2, PLANET_STARTY + 15, p2.getSkills().toString());

                window.addShape(perma2);
            }
            if (p3 != null) {
                planet3.setText(p3.getName() + ", " + p3.getPopulationSize()
                    + "/" + p3.getCapacity());

                TextShape perma3 = new TextShape(PLANET_STARTX + SQUARE_SIZE
                    * 3, PLANET_STARTY + 15, p3.getSkills().toString());
                window.addShape(perma3);
            }
            window.addShape(planet1);
            window.addShape(planet2);
            window.addShape(planet3);
            window.addShape(perma1);
            window.addShape(personInfo);
            // create planet squares.
            for (int i = 1; i < ColonyCalculator.NUM_PLANETS + 1; i++) {
                Shape planetshape = new Shape(PLANET_STARTX + SQUARE_SIZE * 3
                    / 2 * (i - 1), PLANET_STARTY - SQUARE_SIZE, SQUARE_SIZE,
                    SQUARE_SIZE);

                Shape fillShape = planetshape;
                Planet curr = colonyCalculator.planetByNumber(i);
                if (curr != null) {
                    int newSS = SQUARE_SIZE * curr.getAvailability() / curr
                        .getCapacity();
                    fillShape = new Shape(PLANET_STARTX + SQUARE_SIZE * 3 / 2
                        * (i - 1), PLANET_STARTY - SQUARE_SIZE, SQUARE_SIZE, newSS);
                    window.moveToFront(fillShape);
                }

                planetshape.setForegroundColor(Color.BLACK);
                fillShape.setForegroundColor(Color.BLACK);
                switch (i) {
                    case 1:
                        planetshape.setBackgroundColor(Color.YELLOW);
                        fillShape.setBackgroundColor(Color.ORANGE);
                        break;
                    case 2:
                        planetshape.setBackgroundColor(Color.CYAN);
                        fillShape.setBackgroundColor(Color.BLUE);
                        break;
                    case 3:
                        planetshape.setBackgroundColor(Color.MAGENTA);
                        fillShape.setBackgroundColor(Color.RED);
                        break;
                }
                window.addShape(planetshape);
                window.addShape(fillShape);
                window.moveToBack(planetshape);
            }
            // add the circles to match the color of the planet
            ArrayQueue<Person> temp = null;
            if (!colonyCalculator.getQueue().isEmpty()) {
                temp = colonyCalculator.getQueue();
            }
            // System.out.println("Temp's size was " + temp.getSize());
            Object[] copy = temp.toArray();
            for (int i = 0; i < temp.getSize(); i++) {
                CircleShape shape = new CircleShape(QUEUE_STARTX + CIRCLE_SIZE
                    * i, QUEUE_STARTY, CIRCLE_SIZE);
                // see which planet (color) they were meant to go to
                String plan = ((Person)copy[i]).getPlanetName();
                int personPlanet = colonyCalculator.getPlanetIndex(plan);
                // System.out.println("Person at " + i + " had preference "+
                // personPlanet);
                shape.setBackgroundColor(Color.BLACK);
                switch (personPlanet) {
                    case 1:
                        shape.setForegroundColor(Color.YELLOW);
                        break;
                    case 2:
                        shape.setForegroundColor(Color.CYAN);
                        break;
                    case 3:
                        shape.setForegroundColor(Color.MAGENTA);
                        break;

                }
                window.addShape(shape);
            }
        }
    }


    /**
     * execute accept and update GUI to match that, if it wasn't accepted,
     * disable the button instead
     * 
     * @param button
     *            the button.
     */
    public void clickedAccept(Button button) {
        boolean accepted = colonyCalculator.accept();
        if (accepted == true) {
            updateGUI();
        }
        else {
            button.disable();
        }
    }


    /**
     * execute reject and update GUI to match that, also enabling accept in case
     * of disable
     * 
     * @param button
     *            the button.
     */
    public void clickedReject(Button button) {
        colonyCalculator.reject();
        updateGUI();
        accept.enable();
    }
}
