/**
 * The Employee class is used to hold information for individual employees.
 * @author Casey LaClair
 *
 */


public class Employee {

	private String name;		//employee name
	private int idNumber;		//employee ID 
	private String department;  //employees department he/she works in
	private String position;    //employee position
	
	/**
	 * This constructor sets name, idNumber, department, and position.
	 * @param name
	 * @param idNumber
	 * @param department
	 * @param position
	 */
	
	public Employee(String name, int idNumber, String department, String position)
	{
		name = this.name;
		idNumber = this.idNumber;
		department = this.department;
		position = this.position;
		
	}
	
	
	/**
	 * This constructor sets name and idNumber,
	 * while setting department and position to "".
	 * @param name
	 * @param idNumber
	 */
	
	public Employee(String name, int idNumber)
	{
		name = this.name;
		idNumber = this.idNumber;
		department = "";
		position = "";
		
	}
	
	
	/**
	 * This constructor takes no parameters and sets defaults for all employee values.
	 * "" for Strings and 0 for int.
	 */
	
	public Employee()
	{
		name = "";
		idNumber = 0;
		department = "";
		position = "";
		
	}
	
	
	/**
	 * This method sets the employees name from value given.
	 * @param name
	 */
	
	public void setName(String name)
	{
		name = this.name;
	}
	
	
	/**
	 * This method sets the employees idNumber from value given.
	 * @param idNumber
	 */
	
	public void setIdNumber(int idNumber)
	{
		idNumber = this.idNumber;
	}
	
	
	/**
	 * This method sets the employees department from value given.
	 * @param department
	 */
	
	public void setDepartment(String department)
	{
		department = this.department;
	}
	
	
	/**
	 * This method sets the employees position from value given.
	 * @param position
	 */
	
	public void setPosition(String position)
	{
		position = this.position;
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
}
