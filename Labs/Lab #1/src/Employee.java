/**
 * The Employee class is used to hold information for individual employees.
 * @author Casey LaClair
 *
 */


public class Employee {

	private String name;	    	//employee name
	private int idNumber;		    //employee ID 
	private String department;  	//employees department he/she works in
	private String position;    	//employee position
	private double payRate;     	//employee pay rate
	private double hoursPerWeek; 	//employee hours per week worked
	private double grossPay;		//employee calculated gross pay
	
	/**
	 * This constructor sets name, idNumber, department, position, payRate, and hoursPerWeek.
	 * @param name
	 * @param idNumber
	 * @param department
	 * @param position
	 * @param payRate
	 * @param hoursPerWeek
	 */
	
	public Employee(String name, int idNumber, String department, String position, double payRate, double hoursPerWeek)
	{
		this.name = name;
		this.idNumber = idNumber;
		this.department = department;
		this.position = position;
		this.payRate = payRate;
		this.hoursPerWeek = hoursPerWeek;
		
	}
	
	
	/**
	 * This constructor sets name and idNumber, while setting department and position to "", 
	 * and payRate and hoursPerWeek to 0.0.
	 * @param name
	 * @param idNumber
	 */
	
	public Employee(String name, int idNumber)
	{
		this.name = name;
		this.idNumber = idNumber;
		department = "";
		position = "";
		payRate = 0.0;
		hoursPerWeek = 0.0;
		
	}
	
	
	/**
	 * This constructor takes no parameters and sets defaults for all employee values.
	 * "" for Strings, 0 for int, and 0.0 for doubles.
	 */
	
	public Employee()
	{
		name = "";
		idNumber = 0;
		department = "";
		position = "";
		payRate = 0.0;
		hoursPerWeek = 0.0;
		
	}
	
	
	/**
	 * This method sets the employees name from value given.
	 * @param name
	 */
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	
	/**
	 * This method sets the employees idNumber from value given.
	 * @param idNumber
	 */
	
	public void setIdNumber(int idNumber)
	{
		this.idNumber = idNumber;
	}
	
	
	/**
	 * This method sets the employees department from value given.
	 * @param department
	 */
	
	public void setDepartment(String department)
	{
		this.department = department;
	}
	
	
	/**
	 * This method sets the employees position from value given.
	 * @param position
	 */
	
	public void setPosition(String position)
	{
		this.position = position;
	}
	
	
	/**
	 * This method sets the employees pay rate from value given.
	 * @param payRate
	 */
	
	public void setPayRate(double payRate)
	{
		this.payRate = payRate;
	}
	
	
	/**
	 * This method sets how many hours per week the employee works.
	 * @param hoursPerWeek
	 */
	
	public void setHoursPerWeek(double hoursPerWeek)
	{
		this.hoursPerWeek = hoursPerWeek;
	}
	
	
	/**
	 * This method gets the name from a employee.
	 * @return name of employee
	 */
	
	public String getName()
	{
		return name;
	}
	
	
	/**
	 * This method gets the idNumber from a employee.
	 * @return idNumber for employee
	 */
	
	public int getIdNumber()
	{
		return idNumber;
	}
	
	
	/**
	 * This method gets the department an employee works in.
	 * @return employees department
	 */
	
	public String getDepartment()
	{
		return department;
	}
	
	
	/**
	 * This method returns the employees position.
	 * @return employees position
	 */
	
	public String getPosition()
	{
		return position;
	}
	
	
	/**
	 * This method returns the employees pay rate.
	 * @return employees pay rate
	 */
	
	public double getPayRate()
	{
		return payRate;
	}
	
	
	/**
	 * This method returns the employees hours worked for the week.
	 * @return employees hours worked per week
	 */
	
	public double getHoursPerWeek()
	{
		return hoursPerWeek;
	}
	
	
	/**
	 * This method calculates the gross pay of an employee 
	 * based off their pay rate and hours worked per week.
	 * @return gross pay of employee
	 */
	
	public double grossPay()
	{
		grossPay = payRate * hoursPerWeek;
		return grossPay;
	}
}
