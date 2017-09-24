
public class ParkingMeter {
	
	private int minutesPurchased;		//the number of minutes purchased on the meter
	
	/* CONSTRUCTORS */
	/**
	 * Constructor that takes a value for the one field of the object.
	 * @param minutesPurchased -- value to store in minutesPurchased
	 */
	public ParkingMeter(int minutesPurchased){
		this.minutesPurchased=minutesPurchased;
	}
	
	
	/* ACCESSORS */
	
	/**
	 * Accessor: getTimePurchased -- returns the value in minutesPurchased
	 */
	public int getTimePurchased() {
		return minutesPurchased;
	}

	// returns a string representing the state of an object
	public String toString()
	{
		String str = "Minutes Purchased: " + minutesPurchased;
		// Return string
		return str;
	}
}
