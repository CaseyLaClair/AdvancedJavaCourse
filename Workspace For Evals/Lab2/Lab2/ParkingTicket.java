
public class ParkingTicket {

	private ParkedCar car;			    //the car receiving the ticket
	private PoliceOfficer officer;	    //the officer issuing the ticket
	private double fine;			    //the fine being charged
	private static int numTicket = 0;   //number of tickets 
	
	/* CONSTRUCTORS*/
	public ParkingTicket(ParkingMeter meter, ParkedCar car, PoliceOfficer officer){
		//local variables for use in fine calculation:
		int paidTime, parkedTime, overTime,overTimeHours,overTimeMinutes;
		
		//Calculate how long the car has been parked without paying:
		paidTime=meter.getTimePurchased();
		parkedTime=car.getMinutesParked();
		overTime=parkedTime-paidTime;
		
		//Calculate the fine (assuming a ticket is issued only if the car has been parked for too long):
		overTimeHours = overTime/60;		//divide by 60 minutes/hour to get hours
		overTimeMinutes=overTime%60;		//get the number of minutes over
		if (overTimeMinutes>0) {
			overTimeHours++;
		}
		overTimeHours -= 1;					//subtract off the first hour, $25
		fine=25;
		
		if (overTimeHours>0) {
			fine += 10*overTimeHours;
		}
		
		//set car field:
		this.car= new ParkedCar(car);
		
		//set officer field:
		this.officer = new PoliceOfficer(officer);
	}
	
	
	/* ACCESSORS */
	
	/**
	 * Accessor: getFine -- returns the value in fine
	 */
	public double getFine() {
		return fine;
	}
	
	/**
	 * Accessor: getOfficerName -- returns the value returned by PoliceOfficer.getName()
	 */
	public String getOfficerName() {
		return officer.getName();
	}
	
	/**
	 * Accessor: getOfficerBadge -- returns the value returned by PoliceOfficer.getBadgeNum()
	 */
	public String getOfficerBadge() {
		return officer.getBadgeNum();
	}
	
	/**
	 * Accessor: getMake -- returns the value returned by ParkedCar.getMake()
	 */
	public String getMake() {
		return car.getMake();
	}
	
	/**
	 * Accessor: getModel -- returns the value returned by ParkedCar.getModel()
	 */
	public String getModel() {
		return car.getModel();
	}
	
	/**
	 * Accessor: getPlate -- returns the value returned by ParkedCar.getPlate()
	 */
	public String getPlate() {
		return car.getPlate();
	}
	
	/**
	 *  
	 * @return numTickets
	 */
	public int getNumTicketsCount() 
	{  
		numTicket++;
		return numTicket;
	}
	// returns a string representing the state of an object
	public String toString()
	{
		String str = "Car: " + car + "\nOfficer Name: " + officer + "\nFine: " + fine +
				"\nNumber of Tickets: " + getNumTicketsCount();
		// Return string
		return str;
	}
}
