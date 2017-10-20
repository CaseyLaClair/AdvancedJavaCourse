import javax.swing.*;
import java.awt.*;

/**
 * The ShipTypePanel allows the user to choose a Ship. 
 * When the user chooses a type of ship, the ShipDataPanel will update.
 *
 */
public class ShipTypePanel extends JPanel
{
	
	public static final String SHIP="Ship";
	public static final String CRUISE_SHIP="Cruise Ship";
	public static final String CARGO_SHIP="Cargo Ship";
	public static final String NAVAL_SHIP="Naval Ship";
	
	private JRadioButton shipButton;
	private JRadioButton cruiseShipButton;
	private JRadioButton cargoShipButton;
	private JRadioButton navalShipButton;
	private ButtonGroup shipsButtonGroup;
	
	public ShipTypePanel(ShipButtonListener shipButtonListener)
	{
		//Create a GridLayout manager with four rows and one column
		setLayout(new GridLayout(4,1));
		
		//Create the buttons
		shipButton=new JRadioButton(SHIP,true);
		cruiseShipButton= new JRadioButton(CRUISE_SHIP);
		cargoShipButton= new JRadioButton(CARGO_SHIP);
		navalShipButton=new JRadioButton(NAVAL_SHIP);
		
		//Add the buttons to a radio button group
		shipsButtonGroup=new ButtonGroup();
		shipsButtonGroup.add(shipButton);
		shipsButtonGroup.add(cruiseShipButton);
		shipsButtonGroup.add(cargoShipButton);
		shipsButtonGroup.add(navalShipButton);
		
		//Add action listeners to the radio buttons
		shipButton.addActionListener(shipButtonListener);
		cruiseShipButton.addActionListener(shipButtonListener);
		cargoShipButton.addActionListener(shipButtonListener);
		navalShipButton.addActionListener(shipButtonListener);
		
		//Add a titled border
		setBorder(BorderFactory.createTitledBorder("Ship Type"));
		
		//Add the components to this panel
		add(shipButton);
		add(cruiseShipButton);
		add(cargoShipButton);
		add(navalShipButton);
	}
	
	public String getCurrentShipType()
	{
		//note that there is a way to get an Enumeration of the buttons for iteration
		//we won't do that here
		if (shipButton.isSelected())
			return shipButton.getActionCommand();
		else if (cruiseShipButton.isSelected())
			return cruiseShipButton.getActionCommand();
		else if (cargoShipButton.isSelected())
			return cargoShipButton.getActionCommand();
		else if (navalShipButton.isSelected())
			return navalShipButton.getActionCommand();
		else return "Error: no ship type is selected";
	}
}