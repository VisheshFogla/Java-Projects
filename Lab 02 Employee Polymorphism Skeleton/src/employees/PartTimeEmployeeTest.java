/**
 * 
 */
package employees;
import student.TestCase;

/**
 * @author Vishesh
 * @version 2019.09.01
 *
 */
public class PartTimeEmployeeTest extends TestCase {
    
    private PartTimeEmployee em;

    /**
     * sets up the test cases
     */
    public void setUp()
    {
        em = new PartTimeEmployee("mark", 1234, 45, 20);

    }
    /**
     * tests the given method
     */
    public void testGetHoursWorked()
    {
        assertEquals(em.getHoursWorked(), 20);
    }
    /**
     * tests the given method
     */
    public void testWeeklyPay()
    {
        assertEquals(em.weeklyPay(), 900, 0.1);
    }

}
