/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh Fogla (visheshfogla)

/**
 * 
 */
package spacecolonies;

import java.io.File;


import java.io.FileNotFoundException;
import java.util.Scanner;
import bsh.ParseException;


/**
 * @author Vishesh
 * @version 19.04.2020
 * 
 */
public class ColonyReader {
    private Planet[] planets;
    private ArrayQueue<Person> queue;


    /**
     * constructor. Reads in the two file names, passes the 1st to readQueue,
     * the 2nd to readPlanet, then creates a new SpaceWindow with those
     * queue/planets
     * 
     * @param applicantFileName
     *            applicant file
     * @param planetFileName
     *            planet file
     * @throws SpaceColonyDataException
     *             if the skills were wrong
     * @throws ParseException
     *             if planets were wrong
     * @throws FileNotFoundException
     *             if file wasn't found
     */
    public ColonyReader(String applicantFileName, String planetFileName)
        throws SpaceColonyDataException,
        ParseException,
        FileNotFoundException {
        planets = new Planet[ColonyCalculator.NUM_PLANETS + 1];
        queue = readQueueFile(applicantFileName);
        planets = readPlanetFile(planetFileName);
        // Instantiate a new SpaceWindow with the recently filled colony as its
        // parameter.
        @SuppressWarnings("unused")
        SpaceWindow sw = new SpaceWindow(new ColonyCalculator(queue, planets));
    }


    /**
     * read planet file, and store it inside a returned array.
     * Example line:
     * Planet1, 5, 2, 2, 10
     * 
     * @param fileName
     *            the file
     * @return
     *         the planet array
     * @throws ParseException
     *             if there aren't 5 comma separated values
     * @throws SpaceColonyDataException
     *             if skills are not between 1 and 5
     * @throws FileNotFoundException
     *             if file wasn't found
     */
    private Planet[] readPlanetFile(String fileName)
        throws ParseException,
        SpaceColonyDataException,
        FileNotFoundException {
        Planet[] temp = new Planet[ColonyCalculator.NUM_PLANETS + 1];
        Scanner file = new Scanner(new File(fileName));
        for (int i = 1; i < ColonyCalculator.NUM_PLANETS + 1; i++) {

            if (file.hasNextLine()) {
                String[] planets = file.nextLine().split(", *");

                if (planets.length != 5) {
                    file.close();
                    System.out.println("ParseException");
                    throw (new ParseException(
                        "Error: There are not 5 comma separated values on the line, rather, there were "
                            + planets.length));
                }

                if (!isInSkillRange(Integer.valueOf(planets[1]), Integer
                    .valueOf(planets[2]), Integer.valueOf(planets[3]))) {
                    file.close();
                    System.out.println("SCDE");
                    throw (new SpaceColonyDataException(
                        "Error: For planet, skill wasn't between 1 and 5"));
                }
                temp[i] = new Planet(planets[0], Integer.valueOf(planets[1]),
                    Integer.valueOf(planets[2]), Integer.valueOf(planets[3]),
                    Integer.valueOf(planets[4]));
                if (file.hasNextLine()) {
                    file.nextLine();
                }
            }
        }
        if (planets.length < 3) {
            file.close();
            System.out.println("SCDE");
            throw (new SpaceColonyDataException(
                "Error: Planet length invalid."));
        }
        file.close();
        /*
         * for (Planet i: temp) {
         * System.out.println(i);
         * }
         */
        return temp;
    }


    /**
     * Store data in input, and store that in the returned arrayqueue.
     * Example: Bob Marley, 5, 3, 1, Planet1.
     * 
     * @param fileName
     *            input
     * @return
     *         the arrayqueue of people
     * @throws SpaceColonyDataException
     *             if skill isn't between 1 and 5
     * @throws FileNotFoundException
     *             if file wasn't found
     * @throws ParseException
     *             when there are too few skills
     */
    private ArrayQueue<Person> readQueueFile(String fileName)
        throws SpaceColonyDataException,
        FileNotFoundException,
        ParseException {
        Scanner file = new Scanner(new File(fileName));
        ArrayQueue<Person> temp = new ArrayQueue<Person>();
        while (file.hasNextLine()) {
            String[] skills;
            skills = file.nextLine().split(", *");
            for (int i = 0; i < skills.length; i++) {
                if (skills[i] == null || skills[i].equals("")) {
                    file.close();
                    throw (new ParseException(
                        "Error: There weren't three skills given for person"));
                }
            }
            if (!isInSkillRange(Integer.valueOf(skills[1]), Integer.valueOf(
                skills[2]), Integer.valueOf(skills[3]))) {
                file.close();
                System.out.println("SCDE");
                throw (new SpaceColonyDataException(
                    "Error: For person, skill wasn't between 1 and 5"));
            }
            try {
                temp.enqueue(new Person(skills[0], Integer.valueOf(skills[1]),
                    Integer.valueOf(skills[2]), Integer.valueOf(skills[3]),
                    skills[4]));
            }
            catch (ArrayIndexOutOfBoundsException e) {
                temp.enqueue(new Person(skills[0], Integer.valueOf(skills[1]),
                    Integer.valueOf(skills[2]), Integer.valueOf(skills[3]),
                    ""));
            }
        }
        file.close();
        return temp;
    }


    /**
     * see if skills were in range
     * 
     * @param num1
     *            first number
     * @param num2
     *            2nd number
     * @param num3
     *            3rd number
     * @return
     *         whether or not all of the integers it is passed (num1, num2, and
     *         num3) are between the minimum and maximum possible values for a
     *         skill.
     */
    public boolean isInSkillRange(int num1, int num2, int num3) {
        return (num1 >= 1 && num1 <= 5 && num2 >= 1 && num2 <= 5 && num3 >= 1
            && num3 <= 5);
    }


    /**
     * get planet array
     * 
     * @return
     *         the planets
     */
    public Planet[] getPlanets() {
        return planets;
    }


    /**
     * get the ArrayQueue
     * 
     * @return
     *         the queue
     */
    public ArrayQueue<Person> getQueue() {
        return queue;
    }
}