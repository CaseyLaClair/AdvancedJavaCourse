
/**
 * This class holds the values for how many 
 * minutes have been purchased for the car
 * to be parked.
 * @author Casey LaClair
 */

public class ParkingMeter 
{
	
	private int minutesPurchased;		//the number of minutes purchased
	
	
	/**
	 * Constructor that takes a value for minutes purchased
	 * @param minutesPurchased -- value for minutes purchased on the parking meter
	 */
	
	public ParkingMeter(int minutesPurchased)
	{
		this.minutesPurchased = minutesPurchased;
	}
	
	
	
	/**
	 * This method returns the minutes purchased.
	 * @return minutes purchased.
	 */
	
	public int getMinutesPurchased() 
	{
		return minutesPurchased;
	}
	
	/**
	 * This method overrides the default toString() method and displays 
	 * the minutes purchased for a car.
	 */
	
	public String toString()
	{
		String values = String.format("Minutes Purchased: %d", minutesPurchased);
		return values;
	}
	
	/**
	 * This method overrides the equals method to compare
	 * minutes purchased between two ticket objects.
	 * @param meter object
	 * @return true or false status of equality
	 */
	
	public boolean equals(ParkingMeter meter)
	{
		boolean status = false;
		
		if (this.minutesPurchased == meter.getMinutesPurchased())
			status = true;
		
		
		return status;
	}
}