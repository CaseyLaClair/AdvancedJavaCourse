/**
 * This class creates a cruise ship object 
 * and inherits from the Ship class.
 *
 */
public class CruiseShip extends Ship 
{
	
	//Declare all needed fields
	private int maxPassengers;
	
	/**
	 * This constructor creates a cruise ship object
	 * @param maxPassengers - number of people the ship can hold
	 * @param name - name of the ship
	 * @param year - year the ship was built
	 */
	public CruiseShip(int maxPassengers, String name, String year)
	{
		super(name,year);
		this.maxPassengers = maxPassengers;
	}
	
	/**
	 * Gives the max passengers of the ship
	 * @return maxPassengers
	 */
	public int getMaxPassengers() 
	{
		return maxPassengers;
	}
	
	/**
	 * Sets the max passengers of the ship
	 * @param maxPassengers - number of people the ship can hold
	 */
	public void setMaxPassengers(int maxPassengers)
	{
		this.maxPassengers = maxPassengers;
	}
	
	/**
	 * Displays the cruise ships name and max passengers
	 * @return name and maxPassengers
	 */
	public String toString() 
	{
		String str = "<html>Ship's name: " + this.getName() + "<br>Max passengers: " + maxPassengers + "</html>";
		return str;
	}
	
	/**
	 * Displays all information about the cruise ship
	 * @return all object information
	 */
	public String getSaveState() 
	{
		String str = "CruiseShip#" + this.getName() + "#" + this.getYear() + "#" + maxPassengers;
		return str;
	}

}