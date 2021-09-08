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

/**
 * @author Vishesh
 * @version 19.04.2020
 * 
 */
public class PlanetTest extends student.TestCase {
    private Planet lowQ;
    private Planet midQ;
    private Planet highQ;
    private Planet empty;
    private Planet p1;

    private Person john;
    private Person doctor;
    private Person per1;

    /**
     * setup
     */
    public void setUp() {
        lowQ = new Planet("LowQ Planet", 1, 1, 1, 100);
        midQ = new Planet("LowQ Planet", 6, 6, 6, 100);
        highQ = new Planet("HighQ Planet", 10, 10, 10, 1);

        empty = new Planet("HighQ Planet", 10, 10, 10, 1);
        john = new Person("John", 3, 3, 3, "LowQ Planet");
        doctor = new Person("Dr D", 15, 15, 15, "HighQ Planet");
        p1 = new Planet("anistar", 3, 2, 1, 10);
        per1 = new Person("Leon Oak", 5, 4, 3, "anistar");
    }


    /**
     * test all methods.
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testAll() {
        assertFalse(lowQ.equals(empty));
        assertFalse(lowQ.equals("NotAPlanet"));
        assertEquals(lowQ.getAvailability(), 100);
        assertEquals(highQ.getAvailability(), 1);
        assertTrue(lowQ.addPerson(john));
        lowQ.toString();
        assertFalse(highQ.addPerson(john));
        assertTrue(lowQ.addPerson(doctor));
        assertEquals(lowQ.compareTo(lowQ), 0);
        assertTrue(highQ.addPerson(doctor));
        assertFalse(highQ.addPerson(doctor));
        assertTrue(lowQ.equals(lowQ));
        assertFalse(lowQ.equals(midQ));
        assertFalse(lowQ.equals(highQ));
        midQ.addPerson(doctor);
        assertEquals(lowQ.compareTo(midQ), -1);
        assertEquals(midQ.compareTo(highQ), 1);
        assertFalse(lowQ.isFull());
        assertTrue(lowQ.isQualified(doctor));
    }


    /**
     * tests the getPopulation method in the planet class.
     */
    public void testGetPopulation() {
        p1.addPerson(per1);
        Person[] people = p1.getPopulation();
        assertEquals(people, p1.getPopulation());
    }


    /**
     * tests the getCapacity method in the planet class.
     */
    public void testGetCapacity() {
        assertEquals(10, p1.getCapacity());
    }


    /**
     * tests the setName method in the planet class.
     */
    public void testSetName() {
        p1.setName("geosenge");
        assertEquals("geosenge", p1.getName());
    }


    /**
     * tests the equals method in the planet class.
     */
    public void testEquals() {

        Planet p2 = new Planet("Ecuretreak", 3, 2, 1, 1);
        Planet p3 = new Planet("anistar", 5, 5, 5, 10);
        Planet p4 = new Planet("anistar", 3, 2, 1, 10);
        Planet p5 = new Planet("anistar", 3, 2, 1, 20);
        Planet p6 = null;

        assertTrue(p1.equals(p1));
        assertFalse(p1.equals(p6));
        assertFalse(p1.equals(p2));
        assertFalse(p1.equals("string"));
        assertTrue(p1.equals(p4));
        assertFalse(p1.equals(p3));
        assertFalse(p1.equals(p5));
    }


    /**
     * tests the getPopulationSize method in the planet class.
     */
    public void testGetPopulationSize() {
        p1.addPerson(per1);
        assertEquals(1, p1.getPopulationSize());
    }

}
