
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
	
}