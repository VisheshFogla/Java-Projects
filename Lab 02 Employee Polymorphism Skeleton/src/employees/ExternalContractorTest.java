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
public class ExternalContractorTest extends TestCase {
    
    private ExternalContractor obj;

    /**
     * sets up the test cases
     */
    public void setUp()
    {
        obj = new ExternalContractor("john", 1234, 45 );

        
    }
    /**
     * tests the given method
     */
    public void testGetHourlyRate()
    {
        assertEquals(obj.getHourlyRate('A'), 38.50, 0.1);
    }
    /**
     * tests the given method
     */
    public void testGetHourlyRate1()
    {
        assertEquals(obj.getHourlyRate('B'), 41.75, 0.1);
    }
    /**
     * tests the given method
     */
    public void testGetHourlyRate2()
    {
        assertEquals(obj.getHourlyRate('C'), 45.50, 0.1);
    }
    /**
     * tests the given method
     */
    public void testGetHourlyRate3()
    {
        assertEquals(obj.getHourlyRate('D'), 0, 0.1);
    }
    /**
     * tests the given method
     */
    public void testWeeklyPay()
    {
        assertEquals(obj.weeklyPay(20, 'A'), 770, 0.1);
    }

}
