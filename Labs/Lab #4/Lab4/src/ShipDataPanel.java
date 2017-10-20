import javax.swing.*;

import java.awt.*;

/**
 * The ShipDataPanel allows the user to enter the 
 * information for a kind of ship.
 *
 */
public class ShipDataPanel extends JPanel 
{

	//Declare all fields
	private ShipPanel shipPanel;
	private CruiseShipPanel cruiseShipPanel;
	private CargoShipPanel cargoShipPanel;
	private NavalShipPanel navalShipPanel;
	private ShipPanel currentPanel;
	
	/**
	 * Accessors for the data in the currently installed panel:
	 * @return ship name
	 */
	public String getShipName()
	{
		return currentPanel.getShipName();
	}
	
	/**
	 * Return year built for the ship
	 * @return year built
	 */
	public String getYearBuilt()
	{
		return currentPanel.getYearBuilt();
	}
	
	/**
	 * Check to make sure the current panel is a cruise ship panel and if so, get the max passengers out
	 * @return max passengers
	 */
	public int getMaxPassengers() 
	{
		int maxPassengers;
		if (currentPanel instanceof CruiseShipPanel)
				maxPassengers=((CruiseShipPanel)(currentPanel)).getMaxPassengers();
		else maxPassengers=-1;
		return maxPassengers;
	}
	
	/**
	 * Check to make sure the current panel is a cargo ship panel and if so, get the tonnage out
	 * @return tonnage
	 */
	public int getTonnage() 
	{
		int tonnage;
		if (currentPanel instanceof CargoShipPanel)
			tonnage=((CargoShipPanel)(currentPanel)).getTonnage();
		else tonnage=-1;
		return tonnage;
	}
	
	/**
	 * Check to make sure the current panel is a naval ship panel 
	 * and if so, get the complement out
	 * @return complement
	 */
	public int getComplement()
	{
		int complement;
		if (currentPanel instanceof NavalShipPanel)
			complement=((NavalShipPanel)(currentPanel)).getComplement();
		else complement=-1;
		return complement;
	}

	//Methods to install different panels
	public void showShipFields()
	{
		this.removeAll();
		this.add(shipPanel);
		this.setVisible(false);
		this.setVisible(true);
		currentPanel=shipPanel;
	}
	
	public void showCruiseShipFields()
	{
		this.removeAll();
		this.add(cruiseShipPanel);
		this.setVisible(false);
		this.setVisible(true);
		currentPanel=cruiseShipPanel;
	}
	
	public void showCargoShipFields()
	{
		this.removeAll();
		this.add(cargoShipPanel);
		this.setVisible(false);
		this.setVisible(true);
		currentPanel=cargoShipPanel;
	}
	
	public void showNavalShipFields()
	{
		this.removeAll();
		this.add(navalShipPanel);
		this.setVisible(false);
		this.setVisible(true);
		currentPanel=navalShipPanel;
	}
	
	/**
	 * Constructor for ShipDataPanel
	 */
	public ShipDataPanel() 
	{
		shipPanel=new ShipPanel();
		cruiseShipPanel=new CruiseShipPanel();
		cargoShipPanel=new CargoShipPanel();
		navalShipPanel=new NavalShipPanel();
		
		//Add a titled border
		setBorder(BorderFactory.createTitledBorder("Ship Data"));

		//By default, show the Ship fields:
		showShipFields();
	}
	
	/**
	 * Internal class for ShipPanel
	 */
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
			//Create a grid layout with two rows and two columns
			setLayout(new GridLayout(3,2));
			
			//Create the labels and buttons
			nameLabel=new JLabel("Name:");
			yearLabel=new JLabel("Year:");
			
			nameField=new JTextField(20);
			yearField=new JTextField(5);
			
			add(nameLabel);
			add(nameField);
			add(yearLabel);
			add(yearField);
		}
	
	}
	
	/**
	 * Internal class for CruiseShipPanel
	 */
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
			//Create a grid layout with two rows and two columns
			//setLayout(new GridLayout(3,2));
			
			//Create the labels and buttons
			maxPassLabel=new JLabel("Max passengers:");
			
			maxPassField=new JTextField(5);
			
			add(maxPassLabel);
			add(maxPassField);
		}
		
	}
	
	/**
	 * Internal class for CargoShipPanel
	 */
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
			//Create a grid layout with two rows and two columns
			//setLayout(new GridLayout(3,2));
			
			//Create the labels and buttons
			capacityLabel=new JLabel("Capacity:");
			
			capacityField=new JTextField(5);
			
			add(capacityLabel);
			add(capacityField);
		}
		
	}
	
	/**
	 * Internal class for NavalShipPanel
	 */
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
			//Create a grid layout with two rows and two columns
			setLayout(new GridLayout(3,2));
			
			//Create the labels and buttons
			complementLabel=new JLabel("Complement:");
			
			complementField=new JTextField(5);
			
			add(complementLabel);
			add(complementField);
		}
	}
	
}