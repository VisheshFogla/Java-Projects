/**
 * 
 */
package employees;

/**
 * @author Vishesh
 * @version 2019.09.01
 *
 */
public class ExternalContractor extends Employee {
    
    private double rate;
    /**
     * 
     * @param name takes name
     * @param employeeId takes employee id
     * @param hourlyRate takes rate
     */
    public ExternalContractor(String name, int employeeId, double hourlyRate)
    {
        super(name, employeeId, hourlyRate);
    }
    /**
     * 
     * @param rank takes rank
     * @return hourly rate
     */
    public double getHourlyRate(char rank)
    {
        if (rank == 'A')
        {
            rate = 38.50;
            return rate;
        }
        else if (rank == 'B')
        {
            rate = 41.75;
            return rate;
        }
        else if (rank == 'C')
        {
            rate = 45.50;
            return rate;
        }
        else
        {
            return 0;
        }
    }
    /**
     * 
     * @param hrs takes hrs
     * @param custRank takes rank
     * @return weekly pay
     */
    public double weeklyPay(int hrs, char custRank)
    {
        return this.getHourlyRate(custRank) * hrs;
    }

}
