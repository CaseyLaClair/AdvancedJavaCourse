/**
 * This program will set employee values using Employee class.
 * @author Casey LaClair
 *
 */


public class EmployeeTest {

	public static void main(String[] args)
	{
		//Using all args constructor for each employee to input data.
		Employee employee1 = new Employee("Susan Meyers", 47889, "Accounting", "Vice President", 85.00, 40.0);
		Employee employee2 = new Employee("Mark Jones", 39119, "IT", "Programmer", 50.00, 60.0);
		Employee employee3 = new Employee("Joy Rogers", 81774, "Manufacturing", "Engineer", 45.00, 37.5);
		
		//Display employee1 information
		System.out.println("Employee 1 name: " + employee1.getName());
		System.out.println("Employee 1 id: " + employee1.getIdNumber());
		System.out.println("Employee 1 department: " + employee1.getDepartment());
		System.out.println("Employee 1 position: " + employee1.getPosition());
		System.out.printf("Employee 1 gross pay: $%,.2f \n\n", employee1.grossPay());
		
		//Display employee2 information
		System.out.println("Employee 2 name: " + employee2.getName());
		System.out.println("Employee 2 id: " + employee2.getIdNumber());
		System.out.println("Employee 2 department: " + employee2.getDepartment());
		System.out.println("Employee 2 position: " + employee2.getPosition());
		System.out.printf("Employee 2 gross pay: $%,.2f \n\n", employee2.grossPay());
		
		//Display employee3 information
		System.out.println("Employee 3 name: " + employee3.getName());
		System.out.println("Employee 3 id: " + employee3.getIdNumber());
		System.out.println("Employee 3 department: " + employee3.getDepartment());
		System.out.println("Employee 3 position: " + employee3.getPosition());
		System.out.printf("Employee 3 gross pay: $%,.2f \n\n", employee3.grossPay());
	}
}
