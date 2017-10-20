import java.awt.GridLayout;

import javax.swing.*;

/**
 * Creates a panel to display ship information.
 *
 */
public class CreatedPanel extends JPanel 
{
	
	//Label message to display
	private JLabel message;
	
	/**
	 * Constructor for to create a panel to display
	 * ship information.
	 */
	public CreatedPanel()
	{
		
		//Set border and Layout 
		setBorder(BorderFactory.createTitledBorder("Ship Information"));
		setLayout(new GridLayout(1,1));
			
	}
	
	/**
	 * Display ship information
	 * @param ship
	 */
	public void displayShip(Ship ship) 
	{
		
		//Remove all information in panel
		//and then replace with updated information.
		this.removeAll();
		message = new JLabel(ship.toString());
		this.add(message);
		this.setVisible(false);
		this.setVisible(true);
		
	}
}