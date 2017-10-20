/**
 * This class creates a ship object 
 * and implements Saveable.
 */
public class Ship implements Saveable 
{

		//Declare name and year fields
		private String name;
		private String year;
		
		/**
		 * This constructor creates a ship object
		 * @param name - name of the ship
		 * @param year - year the ship was built
		 */
		public Ship(String name, String year)
		{
			this.name = name;
			this.year = year;
		}

		/**
		 * Gives the name of the ship
		 * @return name
		 */
		public String getName() 
		{
			return name;
		}
		
		/**
		 * Gives the year of the ship
		 * @return name
		 */
		public String getYear() 
		{
			return year;
		}
		
		/**
		 * Sets the name of the ship
		 * @param name - ships name
		 */
		public void setName(String name)
		{
			this.name = name;
		}
		
		/**
		 * Sets the year the ship was built
		 * @param year - when the ship was built
		 */
		public void setYear(String year)
		{
			this.year = year;
		}
		
		/**
		 * Displays the ships name and year built
		 * @return name and year built
		 */
		public String toString()
		{
			String str = "<html>Ship's name: " + name + "<br> Year built: " + year + "</html>";
			return str;
		}
		
		/**
		 * Displays all information about the ship
		 * @return all object information
		 */
		public String getSaveState() 
		{
			String str = "Ship#" + name + "#" + year;
			return str;
		}
}