/**
 * This class creates a naval ship object 
 * and inherits from the Ship class.
 * @author Casey LaClair
 *
 */
public class NavalShip extends Ship 
{
	
	//Declare fields
	private int complement;

	/**
	 * This constructor creates a naval ship object
	 * @param complement - number of people on the ship
	 * @param name - name of the ship
	 * @param year - year the ship was built
	 */
	public NavalShip(int complement, String name, String year)
	{
		super(name,year);
		this.complement = complement;
	}
	
	/**
	 * Gives the complement of the ship
	 * @return complement
	 */
	public int getComplement() 
	{
		return complement;
	}
	
	/**
	 * Sets the complement of the ship
	 * @param complement - number of people on the ship
	 */
	public void setComplement(int complement)
	{
		this.complement = complement;
	}
	
	/**
	 * Displays the naval ships name and complement
	 * @return name and complement
	 */
	public String toString() 
	{
		String str = "<html>Ship's name: " + this.getName() + "<br>Ship complement: " + complement + "</html>";
		return str;
	}
	
	/**
	 * Displays all information about the naval ship
	 * @return all object information
	 */
	public String getSaveState() 
	{
		String str = "NavalShip#" + this.getName() + "#" + this.getYear() + "#" + complement;
		return str;
	}
}
