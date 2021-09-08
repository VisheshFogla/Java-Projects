/**
 * 
 */
package employees;
import student.TestCase;

/**
 * @author Vishesh
 * @version 2019.09.01
 */
public class EmployeeTest extends TestCase {
    
    public Employee em;
    private Employee happy;
    private Employee sad;
    private Employee sadness;
    private Employee sadder;
    private PartTimeEmployee saddest;
    private Employee nob;
    /**
     * sets up the test cases
     */
    public void setUp()
    {
        em = new Employee("mark", 1234, 45);
        happy = new Employee("mark", 1234, 56); 
        sad = new Employee("point", 2314, 45);
        sadness = new Employee("mark", 2134, 45);
        sadder = new Employee("jon", 1234, 45);
        saddest = new PartTimeEmployee("jack", 2453, 35, 26);
        nob = null;
    }
    /**
     * tests the given method
     */
    public void testGetName()
    {        
        assertEquals(em.getName(), "mark");
    }
    /**
     * tests the given method
     */
    public void testGetEmployeeId()
    {        
        assertEquals(em.getEmployeeId(), 1234);
    }
    /**
     * tests the given method
     */
    public void testGetHourlyRate()
    {
        assertEquals(em.getHourlyRate(), 45, 0.1);
    }
    /**
     * tests the given method
     */
    public void testWeeklyPay()
    {
        assertEquals(em.weeklyPay(), 1800, 0.1);
    }
    /**
     * tests the given method
     */
    public void testEquals1()
    {
        assertTrue(em.equals(happy));
    }
    /**
     * tests the given method
     */
    public void testEquals2()
    {
        assertTrue(em.equals(em));
    }
    /**
     * tests the given method
     */
    public void testEquals4()
    {
        assertFalse(em.equals(sadder));
    }
    /**
     * tests the given method
     */
    public void testEquals5()
    {
        assertFalse(em.equals(sad));
    }
    /**
     * tests the given method
     */
    public void testEquals6()
    {
        assertFalse(em.equals(sadness));
    }
    /**
     * tests the given method
     */
    public void testEquals7()
    {
        assertFalse(em.equals(saddest));
    }
    /**
     * tests the given method.
     */
    public void testEquals8()
    {
        assertFalse(em.equals(nob));
    }
    

}
