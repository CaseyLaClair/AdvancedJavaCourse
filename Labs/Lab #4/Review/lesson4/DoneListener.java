import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 * The DoneListener is listening for the Done button being pressed. Once that
 * happens, the DoneListener will determine what kind of ship is selected from
 * the ShipTypePanel, get the data for the ship from the ShipDataPanel, and
 * create a ship object. Unimplemented: send this ship object to the
 * CreatedPanel.
 * 
 * @author Maggie also Eric
 *
 */
public class DoneListener implements ActionListener
{

	private ShipTypePanel shipTypePanel;
	private ShipDataPanel shipDataPanel;
	private CreatedPanel createdPanel;

	public DoneListener(ShipTypePanel shipTypePanel, ShipDataPanel shipDataPanel, CreatedPanel createdPanel)
	{
		this.shipTypePanel = shipTypePanel;
		this.shipDataPanel = shipDataPanel;
		this.createdPanel = createdPanel;
	}

	// The user has clicked the Done button. Figure out what kind of ship the user
	// is creating by getting that information
	// from the shipTypePanel. Then get the necessary information from the
	// shipDataPanel and create a ship object. Pass that
	// reference to the createdPanel so it can display the information.
	public void actionPerformed(ActionEvent e)
	{
		String shipType = shipTypePanel.getCurrentShipType();
		Ship ship;
		if (shipType == ShipTypePanel.SHIP)
			ship = createShip();
		else if (shipType == ShipTypePanel.CRUISE_SHIP)
			ship = createCruiseShip();
		else if (shipType == ShipTypePanel.CARGO_SHIP)
			ship = createCargoShip();
		else if (shipType == ShipTypePanel.NAVAL_SHIP)
			ship = createNavalShip();
		else
			ship = new Ship("Error", "Error");
		if (ship == null)
		{
			JOptionPane.showMessageDialog(null, "One or more required fields is blank or invalid.");
		} else
		{
			createdPanel.setShip(ship);
			System.out.println(ship);
		}
	}

	// Create a ship. Get the data from the ShipDataPanel.
	private Ship createShip()
	{
		Ship ship;
		String shipName = shipDataPanel.getShipName();
		String shipYearBuilt = shipDataPanel.getYearBuilt();
		if ((!shipName.equals("")) && (!shipYearBuilt.equals("")))
		{
			ship = new Ship(shipName, shipYearBuilt);
			return ship;
		} else
		{
			return null;
		}
	}

	// Create a cruise ship. Get the data from the ShipDataPanel.
	private Ship createCruiseShip()
	{
		CruiseShip ship;
		String shipName = shipDataPanel.getShipName();
		String shipYearBuilt = shipDataPanel.getYearBuilt();
		int maxPassengers = shipDataPanel.getMaxPassengers();
		// Uhh checking for maxPassengers to not be empty is kinda weird
		if ((shipName.equals("")) || (shipYearBuilt.equals("")) || !(maxPassengers >= 0))
		{
			return null;
		}
		ship = new CruiseShip(maxPassengers, shipName, shipYearBuilt);
		return ship;
	}

	// Create a cargo ship. Get the data from the ShipDataPanel.
	private Ship createCargoShip()
	{
		CargoShip ship;
		String shipName = shipDataPanel.getShipName();
		String shipYearBuilt = shipDataPanel.getYearBuilt();
		int tonnage = shipDataPanel.getTonnage();
		// see above comment
		if ((shipName.equals("")) || (shipYearBuilt.equals("")) || !(tonnage >= 0))
		{
			return null;
		}
		ship = new CargoShip(tonnage, shipName, shipYearBuilt);
		return ship;
	}

	// Create a naval ship. Get the data from the ShipDataPanel.
	private Ship createNavalShip()
	{
		NavalShip ship;
		String shipName = shipDataPanel.getShipName();
		String shipYearBuilt = shipDataPanel.getYearBuilt();
		int complement = shipDataPanel.getComplement();
		if ((shipName.equals("")) || (shipYearBuilt.equals("")) || !(complement >= 0))
		{
			return null;
		}
		ship = new NavalShip(complement, shipName, shipYearBuilt);
		return ship;
	}
}
