
public class PoliceOfficer {
	
	private String name;			//the police officer's name
	private String badgeNum;		//the police officer's badge number

	/* CONSTRUCTORS*/
	
	/**
	 * Constructor that takes values as parameters for all fields of the object.
	 * @param name -- the value to be assigned into name field
	 * @param badgeNum -- the value to be assigned into the badgeNum field
	 */
	public PoliceOfficer(String name, String badgeNum){
		this.name=name;
		this.badgeNum=badgeNum;
	}
	
	/**
	 * Copy constructor that takes a PoliceOfficer object as a parameter and copies the fields to this.
	 * @param officer -- PoliceOfficer object to be copied to this.
	 */
	public PoliceOfficer(PoliceOfficer officer){
		this.name=officer.getName();
		this.badgeNum=officer.getBadgeNum();
	}
	
	/* ACCESSORS */
	/**
	 * Accessor: getName -- returns the value stored in name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Accessor: getBadgeNum -- returns the value stored in badgeNum
	 */
	public String getBadgeNum() {
		return badgeNum;
	}
	
	
	/* MUTATORS */
	
	/* OTHER METHODS */
	/**
	 * determineExpiration
	 * Determine whether the car parked at the meter (both passed) is illgally parked.
	 * @param meter -- a ParkingMeter
	 * @param car -- a ParkedCar
	 * @return true if the car has been parked longer than time purchased on the meter
	 */
	public boolean determineExpiration(ParkingMeter meter, ParkedCar car){
		if (car.getMinutesParked()-meter.getTimePurchased() > 0 ){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * issueTicket
	 * Create a ticket for the car and meter passed
	 * @param meter -- the ParkingMeter illegaly parked at
	 * @param car -- the illegally parked car
	 * @return -- a ticket object referencing the passed meter and car
	 */
	public ParkingTicket issueTicket(ParkingMeter meter, ParkedCar car){
		ParkingTicket ticket;
		
		ticket=new ParkingTicket(meter, car, this);
		return ticket;
	}
	// returns a string representing the state of an object
	public String toString()
	{
		String str = "Name: " + name + "\nBadge Number: " + badgeNum;
		// Return string
		return str;
	}
}
