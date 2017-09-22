
/**
 * This class creates and stores information regarding to
 * a police officer.
 * @author Casey LaClair
 *
 */


public class PoliceOfficer 
{
	
	private String name;			//police officer's name
	private String badgeNumber;		//police officer's badge number


	
	/**
	 * Constructor takes in name and badge number of police officer.
	 * @param name -- name of the police officer
	 * @param badgeNumber -- badge number of the police officer
	 */
	
	public PoliceOfficer(String name, String badgeNumber)
	{
		this.name = name;
		this.badgeNumber = badgeNumber;
	}
	
	/**
	 * This constructor creates a copy of a PoliceOfficer object.
	 * @param officer -- the police officer object to copy
	 */
	
	public PoliceOfficer(PoliceOfficer officer)
	{
		this.name = officer.getName();
		this.badgeNumber = officer.getBadgeNumber();
	}

	/**
	 * This method returns the name of a police officer.
	 */
	
	public String getName() 
	{
		return name;
	}
	
	/**
	 * This method returns the badge number of a police officer.
	 */
	
	public String getBadgeNumber() 
	{
		return badgeNumber;
	}
	

	/**
	 * This method determines whether a car has been parked longer
	 * than the amount of time they have purchased.
	 * @param meter -- a ParkingMeter object
	 * @param car -- a ParkedCar object
	 * @return true if the parked car exceeds the amount of time purchased, otherwise false
	 */
	
	public boolean expiredCheck(ParkingMeter meter, ParkedCar car)
	{
		if (car.getMinutesParked() > meter.getMinutesPurchased())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Issue a parking ticket to car
	 * @param meter -- the ParkingMeter object
	 * @param car -- the ParkedCar object
	 * @return -- a ticket object 
	 */
	
	public ParkingTicket issueTicket(ParkingMeter meter, ParkedCar car)
	{
		ParkingTicket ticket = new ParkingTicket(meter, car, this);
		
		return ticket;
	}
	
	/**
	 * This method overrides the default toString method and displays 
	 * the officers name and badge number.
	 */
	
	public String toString()
	{
		String values = String.format("%s\nBadge Number: %s\n", name, badgeNumber);
		return values;
	}
	
	/**
	 * This method overrides the equals method to compare
	 * the officer objects name and badge numbers. 
	 * @param officer object
	 * @return true or false status of equality
	 */
	
	public boolean equals(PoliceOfficer officer)
	{
		boolean status = false;
		
		if (this.name == officer.getName() && this.badgeNumber == officer.getBadgeNumber())
			status = true;
		
		return status;
	}
	
}