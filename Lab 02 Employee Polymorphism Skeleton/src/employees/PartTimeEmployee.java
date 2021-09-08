/**
 * 
 */
package employees;

/**
 * @author Vishesh
 * @version 2019.09.01
 */
public class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double rate;

    /**
     * 
     * @param name
     *            take name
     * @param employeeId
     *            takes id
     * @param hourlyRate
     *            takes rate
     * @param hours
     *            takes hrs
     */
    public PartTimeEmployee(
        String name,
        int employeeId,
        double hourlyRate,
        int hours) {
        super(name, employeeId, hourlyRate);

        hoursWorked = hours;
        rate = hourlyRate;

    }


    /**
     * 
     * @return hours worked
     */
    public int getHoursWorked() {
        return hoursWorked;
    }


    /**
     * weekly pay
     * 
     * @return returns double value
     */

    public double weeklyPay() {
        return hoursWorked * rate;
    }

}
