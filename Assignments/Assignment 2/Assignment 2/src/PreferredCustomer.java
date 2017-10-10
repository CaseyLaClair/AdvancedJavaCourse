/**
 * This class extends the Person class and
 * is used to create preferred customer objects.
 * @author Casey LaClair
 */
public class PreferredCustomer extends Person 
{

	//Data type wasn't specified, so used
	//double to mimic real life situations.
	private double purchases;
	
	/**
	 * No-arg constructor
	 */
	public PreferredCustomer() 
	{
		purchases = 0.0;
	}
	
	/**
	 * Constructor to instantiate all fields
	 * @param purchases
	 */
	public PreferredCustomer(double purchases) 
	{
		this.purchases = purchases;
	}
	
	/**
	 * Copy constructor
	 * @param toCopy
	 */
	public PreferredCustomer(PreferredCustomer toCopy) 
	{
		
		//Copy each field of the object
		purchases = toCopy.purchases;
	}
	
	/**
	 * Get amount of preferred customer purchases
	 * @return purchases
	 */
	public double getPurchases() 
	{
		return purchases;
	}
	
	/**
	 * Add a purchase to the preferred customer account
	 * @param purchase
	 */
	public void addPurchase(double purchase) 
	{
		purchases += purchase;
	}
	
	/**
	 * This method calculates a preferred customers
	 * discount based off combined past purchases
	 * @return discount
	 */
	public double getDiscount() 
	{
		
		//Declare all vars, set 
		//all discount amounts
		double discount = 0.0;
		double purchases = getPurchases();
		double dis1 = 2000;
		double dis2 = 1500;
		double dis3 = 1000;
		double dis4 = 500;
		
		if (purchases >= dis1) 
			discount = 0.1;
		else if(purchases < dis1 && purchases >= dis2)
			discount = 0.07;
		else if(purchases < dis2 && purchases >= dis3)
			discount = 0.06;
		else if(purchases < dis3 && purchases >= dis4)
			discount = 0.05;
		
		
		return discount;
	}
	
	/**
	 * toString to display all preferred customer info
	 */
	public String toString() 
	{
		
		String values = String.format("Customer Purchases: $%.2f\n", purchases);
		
		return values;
	}
}
