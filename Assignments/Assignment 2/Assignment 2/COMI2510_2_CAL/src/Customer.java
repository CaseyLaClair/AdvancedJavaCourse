/**
 * This class extends the Person class and
 * is used to create customer objects.
 * @author Casey LaClair
 */
public class Customer extends Person 
{

	//Declare all fields
	private int customerNum;
	private boolean mailingList;
	
	/**
	 * No-arg constructor for customer
	 */
	public Customer() 
	{
		customerNum = 0;
		mailingList = false;
	}
	
	/**
	 * Constructor to instantiate all fields
	 * @param customerNum
	 * @param mailingList
	 */
	public Customer(int customerNum, boolean mailingList) 
	{
		this.customerNum = customerNum;
		this.mailingList = mailingList;
	}
	
	/**
	 * Copy constructor
	 * @param toCopy
	 */
	public Customer(Customer toCopy) 
	{
		
		//Copy each field of the object
		customerNum = toCopy.customerNum;
		mailingList = toCopy.mailingList;
	}
	
	/**
	 * Set customer number
	 * @param customerNum
	 */
	public void setCustomerNum(int customerNum) 
	{
		this.customerNum = customerNum;
	}
	
	/**
	 * Set mailing list value
	 * @param mailingList
	 */
	public void setMailingList(boolean mailingList) 
	{
		this.mailingList = mailingList;
	}
	
	/**
	 * Get customer number
	 * @return customerNum
	 */
	public int getCustomerNum() 
	{
		return customerNum;
	}
	
	/**
	 * Get the mailing list value for customer
	 * @return mailingList
	 */
	public boolean getMailingList() 
	{
		return mailingList;
	}
	
	/**
	 * Display customer number and true/false for mailing list
	 */
	public String toString() 
	{
			
		String values = String.format("Customer Number: %d\n Mailing List: %b\n", customerNum, mailingList);
		
		return values;
	}
}
