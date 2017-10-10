/**
 * Test class for PreferredCustomer class
 * @author Casey LaClair
 */
public class PrefCustomerTest 
{
	public static void main(String[] args) 
	{
		
		PreferredCustomer customer = new PreferredCustomer(200);
		customer.addPurchase(250);
		customer.addPurchase(1000);
	
		System.out.println(customer.toString() + "Discount: " + customer.getDiscount());
	}
}
