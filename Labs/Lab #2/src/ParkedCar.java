
/**
 * This class is used to create a car object and store the values
 * of make, model, color, license plate, and the minutes the car
 * has been parked. 
 * @author Casey LaClair
 */


public class ParkedCar 
{
	
	private String make;			//make of the car
	private String model;			//model of the car
	private String color;			//color of the car
	private String licensePlate;	//license plate for the car
	private int minutesParked;		//how long the car has been parked
	
	
	/**
	 * Constructor for ParkedCar that fills in all fields.
	 * @param make -- value for the make field
	 * @param model -- value for the model field
	 * @param color -- value for the color field
	 * @param plate -- value for the license plate field
	 * @param minutesParked -- minutes the car has been parked
	 */
	
	public ParkedCar(String make, String model, String color, String licensePlate, int minutesParked)
	{
		this.make = make;
		this.model = model;
		this.color = color;
		this.licensePlate = licensePlate;
		this.minutesParked = minutesParked;
	}
	
	/**
	 * This constructor copies all fields of a ParkedCar object.
	 * @param car -- a parked car object to copy
	 */
	
	public ParkedCar(ParkedCar car)
	{
		this.make = car.getMake();
		this.model = car.getModel();
		this.color = car.getColor();
		this.licensePlate = car.getLicensePlate();
		this.minutesParked = car.getMinutesParked();
	}
	
	
	
	/**
	 * This method returns the make of the car.
	 * @return make of the car
	 */
	
	public String getMake() 
	{
		return make;
	}
	
	/**
	 * This method returns the model of the car.
	 * @return car model
	 */
	
	public String getModel() 
	{
		return model;
	}
	
	/**
	 * This method returns the color of the car.
	 * @return car color
	 */
	
	public String getColor() 
	{
		return color;
	}

	/**
	 * This method returns the license plate of the car.
	 * @return license plate number
	 */
	
	public String getLicensePlate() 
	{
		return licensePlate;
	}
	
	/**
	 * This method returns the minutes the car has been parked.
	 * @return minutes parked
	 */
	
	public int getMinutesParked() 
	{
		return minutesParked;
	}
	
	/**
	 * This method overrides the toString method and displays the car's 
	 * make, model, color, license plate, and minutes parked.
	 */
	
	public String toString()
	{
		String values = String.format("Make: %s\nModel: %s\nColor: %s\nPlate#: %s\nMinutes Parked: %d\n", make, model, color, licensePlate, minutesParked);
		return values;
	}
	
	/**
	 * This method overrides the equals method to compare
	 * two car objects make, model, color, license plate,
	 * and minutes parked.
	 * @param car object
	 * @return true or false status of equality
	 */
	
	public boolean equals(ParkedCar car)
	{
		boolean status = false;
		
		if (this.make == car.getMake() && this.model == car.getModel() &&
				this.color == car.getColor() && this.licensePlate == car.getLicensePlate() &&
				this.minutesParked == car.getMinutesParked())
		{
			status = true;
		}
		
		return status;
	}

}