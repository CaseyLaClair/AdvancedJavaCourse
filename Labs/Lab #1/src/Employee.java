
public class Employee {

	private String name;
	private int idNumber;
	private String department;
	private String position;
	
	public Employee(String name, int idNumber, String department, String position)
	{
		name = this.name;
		idNumber = this.idNumber;
		department = this.department;
		position = this.position;
		
	}
	
	public Employee(String name, int idNumber)
	{
		name = this.name;
		idNumber = this.idNumber;
		department = "";
		position = "";
		
	}
	
	public Employee()
	{
		name = "";
		idNumber = 0;
		department = "";
		position = "";
		
	}
	
	public void setName(String name)
	{
		name = this.name;
	}
	
	public void setIdNumber(int idNumber)
	{
		idNumber = this.idNumber;
	}
	
	public void setDepartment(String department)
	{
		department = this.department;
	}
	
	public void setPosition(String position)
	{
		position = this.position;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getIdNumber()
	{
		return idNumber;
	}
	
	public String getDepartment()
	{
		return department;
	}
	
	public String getPosition()
	{
		return position;
	}
}
