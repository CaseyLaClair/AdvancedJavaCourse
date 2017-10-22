import javax.swing.*;

import java.awt.*;

/**
 * The ShipDataPanel allows the user to enter the information for a kind of
 * ship.
 * 
 * @author Maggie also Eric
 *
 */
public class ShipDataPanel extends JPanel
{

	private ShipPanel shipPanel;
	private CruiseShipPanel cruiseShipPanel;
	private CargoShipPanel cargoShipPanel;
	private NavalShipPanel navalShipPanel;
	private ShipPanel currentPanel;

	// Accessors for the data in the currently installed panel:
	public String getShipName()
	{
		return currentPanel.getShipName();
	}

	public String getYearBuilt()
	{
		return currentPanel.getYearBuilt();
	}

	// Check to make sure the current panel is a cruise ship panel and if so, get
	// the max passengers out
	public int getMaxPassengers()
	{
		int maxPassengers;
		if (currentPanel instanceof CruiseShipPanel)
			try
			{
				maxPassengers = ((CruiseShipPanel) (currentPanel)).getMaxPassengers();
			} catch (NumberFormatException e)
			{
				return -1;
			}
		else
			maxPassengers = -1;
		return maxPassengers;
	}

	// check to make sure the current panel is a cargo ship panel and if so, get the
	// tonnage out
	public int getTonnage()
	{
		int tonnage;
		if (currentPanel instanceof CargoShipPanel)
			try
			{
				tonnage = ((CargoShipPanel) (currentPanel)).getTonnage();
			} catch (NumberFormatException e)
			{
				return -1;
			}
		else
			tonnage = -1;
		return tonnage;
	}

	// check to make sure the current panel is a naval ship panel and if so, get the
	// complement out
	public int getComplement()
	{
		int complement;
		if (currentPanel instanceof NavalShipPanel)
			try
			{
				complement = ((NavalShipPanel) (currentPanel)).getComplement();
			} catch (NumberFormatException e)
			{
				return -1;
			}
		else
			complement = -1;
		return complement;
	}

	// Methods to install different panels:
	public void showShipFields()
	{
		this.removeAll();
		this.add(shipPanel);
		this.setVisible(false);
		this.setVisible(true);
		currentPanel = shipPanel;
	}

	public void showCruiseShipFields()
	{
		this.removeAll();
		this.add(cruiseShipPanel);
		this.setVisible(false);
		this.setVisible(true);
		currentPanel = cruiseShipPanel;
	}

	public void showCargoShipFields()
	{
		this.removeAll();
		this.add(cargoShipPanel);
		this.setVisible(false);
		this.setVisible(true);
		currentPanel = cargoShipPanel;
	}

	public void showNavalShipFields()
	{
		this.removeAll();
		this.add(navalShipPanel);
		this.setVisible(false);
		this.setVisible(true);
		currentPanel = navalShipPanel;
	}

	// Constructor:
	public ShipDataPanel()
	{
		shipPanel = new ShipPanel();
		cruiseShipPanel = new CruiseShipPanel();
		cargoShipPanel = new CargoShipPanel();
		navalShipPanel = new NavalShipPanel();

		// Add a titled border
		setBorder(BorderFactory.createTitledBorder("Ship Data"));

		// By default, show the Ship fields:
		showShipFields();
	}

	// Internal classes:
	private class ShipPanel extends JPanel
	{
		private JLabel nameLabel;
		private JLabel yearLabel;
		private JTextField nameField;
		private JTextField yearField;

		public String getShipName()
		{
			return nameField.getText();
		}

		public String getYearBuilt()
		{
			return yearField.getText();
		}

		private ShipPanel()
		{
			// Create a grid layout with two rows and two columns
			setLayout(new GridLayout(3, 2));

			// Create the labels and buttons
			nameLabel = new JLabel("Name:");
			yearLabel = new JLabel("Year:");

			nameField = new JTextField(20);
			yearField = new JTextField(5);

			add(nameLabel);
			add(nameField);
			add(yearLabel);
			add(yearField);
		}

	}

	private class CruiseShipPanel extends ShipPanel
	{

		private JLabel maxPassLabel;
		private JTextField maxPassField;

		public int getMaxPassengers()
		{
			return Integer.parseInt(maxPassField.getText());
		}

		private CruiseShipPanel()
		{
			// Create a grid layout with two rows and two columns
			// setLayout(new GridLayout(3,2));

			// Create the labels and buttons
			maxPassLabel = new JLabel("Max passengers:");

			maxPassField = new JTextField(5);

			add(maxPassLabel);
			add(maxPassField);
		}

	}

	private class CargoShipPanel extends ShipPanel
	{

		private JLabel capacityLabel;
		private JTextField capacityField;

		public int getTonnage()
		{
			return Integer.parseInt(capacityField.getText());
		}

		private CargoShipPanel()
		{
			// Create a grid layout with two rows and two columns
			// setLayout(new GridLayout(3,2));

			// Create the labels and buttons
			capacityLabel = new JLabel("Capacity:");

			capacityField = new JTextField(5);

			add(capacityLabel);
			add(capacityField);
		}

	}

	private class NavalShipPanel extends ShipPanel
	{
		private JLabel complementLabel;
		private JTextField complementField;

		public int getComplement()
		{
			return Integer.parseInt(complementField.getText());
		}

		private NavalShipPanel()
		{
			// Create a grid layout with two rows and two columns
			setLayout(new GridLayout(3, 2));

			// Create the labels and buttons
			complementLabel = new JLabel("Complement:");

			complementField = new JTextField(5);

			add(complementLabel);
			add(complementField);
		}
	}

}
