
/*
 * Casey LaClair
 * 
 */

public class ParkingTicket 
{

	private ParkedCar car;			//the car getting a ticket
	private PoliceOfficer officer;	//the officer giving the ticket
	private double fine;			//the fine of the ticket
	
	
	public ParkingTicket(ParkingMeter meter, ParkedCar car, PoliceOfficer officer)
	{
		
		int timePurchased, timeParked, timeOver, hoursOver, minutesOver;
		
		//Calculate how long the car has been parked
		timePurchased  = meter.getMinutesPurchased();
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
	
	public String getMake() 
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
	
}