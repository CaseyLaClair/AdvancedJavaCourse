import java.awt.event.*;

/**
 * Acts as a listener for the 
 * Done Button in the Ship builder GUI.
 *
 */
public class DoneListener implements ActionListener 
{

	//Declare types of panels
	private ShipTypePanel shipTypePanel;
	private ShipDataPanel shipDataPanel;
	private CreatedPanel createdPanel;

	/**
	 * Create listener for when all information is listed
	 * @param shipTypePanel
	 * @param shipDataPanel
	 * @param createdPanel
	 */
	public DoneListener(ShipTypePanel shipTypePanel, ShipDataPanel shipDataPanel, CreatedPanel createdPanel)
	{
		this.shipTypePanel=shipTypePanel;
		this.shipDataPanel=shipDataPanel;
		this.createdPanel=createdPanel;
	}

	/**
	 * Determine type of ShipDataPanel to display and 
	 * information to display about the ship.
	 */
	public void actionPerformed(ActionEvent e)
	{
		String shipType=shipTypePanel.getCurrentShipType();
		Ship ship;
		if (shipType==ShipTypePanel.SHIP)
			ship=createShip();
		else if (shipType==ShipTypePanel.CRUISE_SHIP)
			ship=createCruiseShip();
		else if (shipType==ShipTypePanel.CARGO_SHIP)
			ship=createCargoShip();
		else if (shipType==ShipTypePanel.NAVAL_SHIP)
			ship=createNavalShip();
		else
			ship=new Ship("Error","Error");
		
		createdPanel.displayShip(ship);

	}

	/**
	 * Create a ship.  Get the data from the ShipDataPanel.
	 * @return a Ship
	 */
	private Ship createShip() 
	{
		Ship ship;
		String shipName=shipDataPanel.getShipName();
		String shipYearBuilt=shipDataPanel.getYearBuilt();
		
		if ((!shipName.equals("")) && (!shipYearBuilt.equals("")))
		{
			ship=new Ship(shipName,shipYearBuilt);
			return ship;
		}
		else
		{
			ship = new Ship("Empty Name","Empty Year Built");
			return ship;
		}
	}

	/**
	 * Create a cruise ship.  Get the data from the ShipDataPanel.
	 * @return a CruiseShip
	 */
	private Ship createCruiseShip()
	{
		CruiseShip ship;
		String shipName=shipDataPanel.getShipName();
		String shipYearBuilt=shipDataPanel.getYearBuilt();
		int maxPassengers=shipDataPanel.getMaxPassengers();
		ship=new CruiseShip(maxPassengers,shipName,shipYearBuilt);
		return ship;
	}

	/**
	 * Create a cargo ship.  Get the data from the ShipDataPanel.
	 * @return a CargoShip
	 */
	private Ship createCargoShip()
	{
		CargoShip ship;
		String shipName=shipDataPanel.getShipName();
		String shipYearBuilt=shipDataPanel.getYearBuilt();
		int tonnage=shipDataPanel.getTonnage();
		ship=new CargoShip(tonnage,shipName,shipYearBuilt);
		return ship;
	}

	/**
	 * Create a naval ship.  Get the data from the ShipDataPanel.
	 * @return a NavalShip
	 */
	private Ship createNavalShip()
	{
		NavalShip ship;
		String shipName=shipDataPanel.getShipName();
		String shipYearBuilt=shipDataPanel.getYearBuilt();
		int complement=shipDataPanel.getComplement();
		ship=new NavalShip(complement,shipName,shipYearBuilt);
		return ship;
	}
}