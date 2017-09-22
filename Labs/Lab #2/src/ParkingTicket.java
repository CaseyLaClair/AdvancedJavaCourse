
/*
 * Casey LaClair
 * 
 */

public class ParkingTicket 
{

	private ParkedCar car;				//the car getting a ticket
	private PoliceOfficer officer;		//the officer giving the ticket
	private double fine;				//the fine of the ticket
	private static int numTickets = 0;  //how many tickets have been issued.
	
	
	public ParkingTicket(ParkingMeter meter, ParkedCar car, PoliceOfficer officer)
	{
		
		int timePurchased, timeParked, timeOver, hoursOver, minutesOver;
		
		//Calculate how long the car has been parked
		timePurchased = meter.getMinutesPurchased();
		timeParked = car.getMinutesParked();
		timeOver = timeParked - timePurchased;
		
		//Calculate the fine (assuming a ticket is issued only if the car has been parked for too long):
		hoursOver = timeOver/60;		//divide by 60 minutes/hour to get hours
		minutesOver = timeOver%60;		//get the number of minutes over
		if (minutesOver > 0) 
		{
			hoursOver++;
		}
		
		hoursOver -= 1;					//subtract off the first hour, $25
		fine=25;
		
		if (hoursOver>0) {
			fine += 10*hoursOver;
		}
		
		//set car field:
		this.car= new ParkedCar(car);
		
		//set officer field:
		this.officer = new PoliceOfficer(officer);
		
		//update the number of tickets issued.
		updateNumTickets();
	}
	

	
	/**
	 * This method returns the fine amount
	 * @return fine issued
	 */
	
	public double getFine() 
	{
		return fine;
	}
	
	/**
	 * This method returns the officer's name using officer.getName()
	 * @return officer's name
	 */
	
	public String getOfficerName() 
	{
		return officer.getName();
	}
	
	/**
	 * This method returns the officer's badge number using officer.getBadgeNumber()
	 * @return officer's badge number
	 */
	
	public String getOfficerBadge() 
	{
		return officer.getBadgeNumber();
	}
	
	/**
	 * This method returns the cars make using car.getmake()
	 * @return cars make
	 */
	
	public ParkedCar.Make getMake() 
	{
		return car.getMake();
	}
	
	/**
	 * This method returns the cars model using car.getModel()
	 * @return cars model
	 */
	
	public String getModel() 
	{
		return car.getModel();
	}
	
	/**
	 * This method returns the cars license plate using car.getLicensePlate()
	 * @return cars license plate
	 */
	
	public String getLicensePlate() 
	{
		return car.getLicensePlate();
	}
	
	/**
	 * This method updates the number of tickets issued.
	 */
	
	public static void updateNumTickets()
	{
		numTickets++;
	}
	
	/**
	 * This method returns the number of tickets that have been issued.
	 * @return number of tickets issued
	 */
	public int getNumTickets()
	{
		return numTickets;
	}
	
	/**
	 * This toString overrides the default and displays all information 
	 * regarding a the car info, officer info, and fine for a parking ticket.
	 */
	public String toString()
	{
		String values = String.format("Car Information:\n%s\nOfficer: %s\nFine: %.2f\n", car.toString(), officer.toString(), fine);
		return values;
	}
	
	/**
	 * This method overrides the equals method to compare 
	 * the parking tickets car objects, officer objects, and
	 * fines.
	 * @param ticket object to compare
	 * @return true or false status of equality
	 */
	
	public boolean equals(ParkingTicket ticket)
	{
		boolean status = false;
		
		if (this.car.equals(ticket.car) && this.officer.equals(ticket.officer)
				&& this.fine == ticket.getFine()) 
		{
			status = true;
		}
		
		return status;
	}
	
}