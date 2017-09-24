
public class ParkedCar {
	
	private String make;			//the make of the car
	private String model;			//the model of the car
	private String color;			//the color of the car
	private String plate;			//the license plate of the car
	private int minutesParked;		//the number of minutes the car has been parked
	
	/* CONSTRUCTORS*/
	/**
	 * Constructor for ParkedCar that takes values for all of the fields
	 * @param make -- value to store in the make field
	 * @param model -- value to store in the model field
	 * @param color -- value to store in the color field
	 * @param plate -- value to store in the plate field
	 * @param minutesParked -- value to store in the minutesParked field
	 */
	public ParkedCar(String make, String model, String color, String plate, int minutesParked){
		this.make = make;
		this.model = model;
		this.color = color;
		this.plate = plate;
		this.minutesParked = minutesParked;
	}
	
	/**
	 * Copy constructor for ParkedCar that copies values in the fields of the ParkedCar object passed.
	 * @param car -- a ParkedCar object to copy into this object.
	 */
	public ParkedCar(ParkedCar car) {
		this.make = car.getMake();
		this.model = car.getModel();
		this.color = car.getColor();
		this.plate = car.getPlate();
		this.minutesParked = car.getMinutesParked();
	}
	
	
	/* ACCESSORS */
	
	/**
	 * Accessor: getMake -- returns the value in make
	 */
	public String getMake() {
		return make;
	}
	
	/**
	 * Accessor: getModel -- returns the value in model
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * Accessor: getColor -- returns the value in color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Accessor: getPlate -- returns the value in plate
	 */
	public String getPlate() {
		return plate;
	}
	
	/**
	 * Accessor: getMinutesParked -- returns the value in minutesParked
	 */
	public int getMinutesParked() {
		return minutesParked;
	}
	
	// returns a string representing the state of an object
		public String toString()
		{
			String str = "Make: " + make + "\nModel: " + model + "\nColor: " + color +
					"\nPlate: " + plate + "\nMinutes Parked: " + minutesParked;
			// Return string
			return str;
		}

	
}
