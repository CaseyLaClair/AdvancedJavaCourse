/**
 * This class tests the usage of inherited members 
 * of a superclass Ship.
 */
import java.util.Random;
import javax.swing.JOptionPane;

public class ShipTest 
{

	/**
	 * This method creates a ship
	 * @return a ship object
	 */
	public static Ship createShip()
	{
		Ship ship;
		String name = JOptionPane.showInputDialog("What is the name of the ship?");
		String year = JOptionPane.showInputDialog("In what year was the ship built?");
		ship = new Ship(name, year);
		return ship;
	}
	
	/**
	 * This method creates a cruise ship
	 * @return a cruise ship object
	 */
	public static Ship createCruiseShip() 
	{
		CruiseShip ship;
		String name = JOptionPane.showInputDialog("What is the name of the cruise ship?");
		String year = JOptionPane.showInputDialog("In what year was the cruise ship built?");
		int maxCapacity = Integer.parseInt(JOptionPane.showInputDialog("What is the maximum capacity of the cruise ship?"));
		ship = new CruiseShip(maxCapacity, name, year);
		return ship;
	}
	
	/**
	 * This method creates a cargo ship
	 * @return a cargo ship object
	 */
	public static Ship createCargoShip()
	{
		CargoShip ship;
		String name = JOptionPane.showInputDialog("What is the name of the cargo ship?");
		String year = JOptionPane.showInputDialog("In what year was the cargo ship built?");
		int maxTonnage = Integer.parseInt(JOptionPane.showInputDialog("What is the maximum tonnage of the cargo ship?"));
		ship = new CargoShip(maxTonnage, name, year);
		return ship;
	}
	
	/**
	 * This method creates a naval ship
	 * @return a naval ship object
	 */
	public static Ship createNavalShip()
	{
		NavalShip ship;
		String name = JOptionPane.showInputDialog("What is the name of the naval ship?");
		String year = JOptionPane.showInputDialog("In what year was the naval ship built?");
		int complement = Integer.parseInt(JOptionPane.showInputDialog("What is the complement of the naval ship?"));
		ship = new NavalShip(complement, name, year);
		return ship;
	}
	
	/**
	 * This is the main method to test the ship classes.
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		//Create an array of ships
		Ship[] ships = new Ship[5];
		Random randNums = new Random();
		
		//Cycle through random ship types and put into array
		for (int i = 0; i < ships.length; i++)
		{
			int num=randNums.nextInt(4);
			switch (num) 
			{
				case 0:
				{
					ships[i]=createShip(); 
					break;
				}
				case 1:
				{
					ships[i]=createCruiseShip();
					break;
				}
				case 2:
				{
					ships[i]=createCargoShip(); 
					break;
				}
				case 3:
				{
					ships[i]=createNavalShip(); 
					break;
				}
			}
		}
		
		//Display all ship information
		for (int i = 0; i < ships.length; i++)
		{
			System.out.println(ships[i]);
			System.out.println(ships[i].getSaveState());
		}
	}

}