/**
 * 
 */
package game;

import java.awt.Color;
import CS2114.*;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * 
 * @author Vishesh visheshfogla
 * @version 02/26/2020.
 */
public class WhackAShape {

    private SimpleBagInterface<Shape> bag;
    private Window window;
    private TestableRandom generator;

    /**
     * The method builds a shape depending on the input string.
     * 
     * @param input
     *            takes an input to build its shape.
     * @return returns the shape that has been created.
     */
    private Shape buildShape(String input) {
            generator = new TestableRandom();
        int size = generator.nextInt(100);

        size = size + 100;

        int x = generator.nextInt(window.getGraphPanelWidth() - size);
        int y = generator.nextInt(window.getGraphPanelHeight() - size);

        Shape currentShape = null;

        if (input.contains("blue")) {
            if (input.contains("circle")) {
                currentShape = new CircleShape(x, y, size, Color.BLUE);
            }
            else if (input.contains("square")) {
                currentShape = new SquareShape(x, y, size, Color.BLUE);
            }
        }
        else if (input.contains("red")) {
            if (input.contains("circle")) {
                currentShape = new CircleShape(x, y, size, Color.RED);
            }
            else if (input.contains("square")) {
                currentShape = new SquareShape(x, y, size, Color.RED);
            }
        }
        else {
            throw new IllegalArgumentException();
        }
        currentShape.onClick(this, "clickedShape");

        return currentShape;
    }


    /**
     * The method alters the shape once it has been clicked.
     * 
     * @param input
     *            The shape to be removed from the window.
     */
    public void clickedShape(Shape input) {
        window.removeShape(input);
        bag.remove(input);

        Shape nextShape = bag.pick();
        if (nextShape == null) {
            TextShape display = new TextShape(0, 0, "You Win!", Color.BLACK);
            display.setX((window.getGraphPanelWidth() / 2) - (display.getWidth()
                / 2));
            display.setY((window.getGraphPanelHeight() / 2) - (display
                .getHeight() / 2));
            window.addShape(display);
        }
        else {
            window.addShape(nextShape);
        }

    }


    /**
     * The method returns the window
     * 
     * @return the window object of the Window class.
     */
    public Window getWindow() {
        return window;
    }


    /**
     * @return the bag in which items are stored.
     */
    public SimpleBagInterface<Shape> getBag() {
        return bag;
    }


    /**
     * Defines the constructor of WhackAShape class.
     */
    public WhackAShape() {
        bag = new SimpleArrayBag<>();
        window = new Window();

        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");

        window.addButton(quitButton, WindowSide.SOUTH);

        String[] store = new String[] { "red circle", "blue circle",
            "red square", "blue square" };

        generator = new TestableRandom();
        int index = generator.nextInt(6);

        index = index + 7;

        for (int i = 0; i < index; i++) {
            int n = generator.nextInt(4);
            Shape create = buildShape(store[n]);
            bag.add(create);
        }

        window.addShape(bag.pick());
    }


    /**
     * Exits from the window after clicking on the button.
     * 
     * @param quit
     *            exits from the given window.
     */
    public void clickedQuit(Button quit) {
        System.exit(0);
    }


    /**
     * Defines the constructor for the class that takes an array of strings as
     * input.
     * 
     * @param str
     *            input for determining which shapes should appear in the game.
     */
    public WhackAShape(String[] str) {
        bag = new SimpleArrayBag<>();
        window = new Window();

        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");

        window.addButton(quitButton, WindowSide.SOUTH);

        Shape toAdd = null;

        for (int i = 0; i < str.length; i++) {
            try {
                toAdd = buildShape(str[i]);
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            bag.add(toAdd);
        }

        window.addShape(bag.pick());
    }

}
