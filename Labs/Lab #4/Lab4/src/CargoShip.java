/**
 * This class creates a cargo ship object 
 * and inherits from the Ship class.
 */
public class CargoShip extends Ship
{

	//Declare needed fields
	private int cargoTonnage;
	
	/**
	 * This constructor creates a cargo ship object
	 * @param cargoTonnage - how much cargo
	 * @param name - name of cargo ship
	 * @param year - year ship was built
	 */
	public CargoShip(int cargoTonnage, String name, String year)
	{
		super(name,year);
		this.cargoTonnage = cargoTonnage;
	}
	
	/**
	 * This method gets the ships cargo in tons
	 * @return cargoTonnage
	 */
	public int getCargoTonnage() 
	{
		return cargoTonnage;
	}
	
	/**
	 * This method gets the cargo ships tonnage
	 * @param cargoTonnage
	 */
	public void setCargoTonnage(int cargoTonnage)
	{
		this.cargoTonnage = cargoTonnage;
	}
	
	/**
	 * Displays the cargo ships name and cargo tonnage
	 * @return name and cargoTonnage
	 */
	public String toString() 
	{
		String str = "<html>Ship's name: " + this.getName() + "<br>Cargo capacity: " + cargoTonnage + "</html>";
		return str;
	}
	
	/**
	 * Displays all information about the cargo ship
	 * @return all object information
	 */
	public String getSaveState() 
	{
		String str = "CargoShip#" + this.getName() + "#" + this.getYear() + "#" + cargoTonnage;
		return str;
	}
}