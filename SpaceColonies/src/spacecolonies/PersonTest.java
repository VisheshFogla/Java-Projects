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
public class PersonTest extends student.TestCase {
    private Person john;
    private Person doctor;
    private Person almostjohn;

    /**
     * setup
     */
    public void setUp() {
        john = new Person("John", 3, 3, 3, "LowQ Planet");
        doctor = new Person("Dr D", 15, 15, 15, "HighQ Planet");
        almostjohn = new Person("John", 3, 3, 3, "MedQ");
    }


    /**
     * test all methods.
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testAll() {
        assertEquals(john.getName(), "John");
        john.getSkills();
        assertFalse(doctor.equals(john));
        boolean x = doctor.equals(new Object());
        assertFalse(x);
        assertNotNull(john);
        assertFalse(john.equals("NotAPerson"));
        assertFalse(john.equals(doctor));
        assertTrue(john.equals(john));
        assertFalse(john.equals(almostjohn));
        assertEquals(john.toString(), "John A:3 M:3 T:3 Wants: LowQ Planet");
    }


    /**
     * tests the equals method in the person class.
     */
    public void testEquals() {

        Person p1 = new Person("Vishesh Fogla", 3, 2, 1, "Anistar");
        Person p2 = new Person("Gary Oak", 3, 3, 3, "");
        Person p3 = new Person("Vishesh Fogla", 3, 2, 1, "Anistar");
        Person p4 = new Person("Vishesh Fogla", 3, 2, 1, "Oplucid");
        Person p5 = new Person("Vishesh Fogla", 2, 1, 5, "Anistar");
        Person p6 = null;

        assertTrue(p1.equals(p1));
        assertNotNull(p1);
        assertFalse(p1.equals("red"));
        assertFalse(p1.equals(p2));
        assertTrue(p1.equals(p3));
        assertFalse(p1.equals(p4));
        assertFalse(p1.equals(p5));
        assertFalse(p1.equals(p6));

        assertEquals("Vishesh Fogla A:3 M:2 T:1 Wants: Anistar", p1.toString());
        assertEquals("No-Planet Gary Oak A:3 M:3 T:3", p2.toString());
    }
}
