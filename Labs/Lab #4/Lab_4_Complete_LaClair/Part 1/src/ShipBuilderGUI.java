import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Creates a window to allow the creation of ships.
 *
 */
public class ShipBuilderGUI extends JFrame
{

	/**
	 * Constructor for the GUI.
	 */
	public ShipBuilderGUI()
	{
		//Set the title bar
		setTitle("Ship Builder");
				
		//Specify an action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Add a GridLayout manager to the content pane
		setLayout(new GridLayout(2,2));
		
		//Create the four different panels and three listeners
		ShipDataPanel shipDataPanel=new ShipDataPanel();
		ShipButtonListener shipButtonListener=new ShipButtonListener(shipDataPanel);
		ShipTypePanel shipTypePanel=new ShipTypePanel(shipButtonListener);
		
		//Create additional panels
		CreatedPanel createdPanel=new CreatedPanel();
		ButtonPanel buttonPanel=new ButtonPanel();
		DoneListener doneListener=new DoneListener(shipTypePanel,shipDataPanel,createdPanel);
		buttonPanel.setListener(doneListener);
		
		//Add the panels to the frame
		add(shipTypePanel);
		add(shipDataPanel);
		add(createdPanel);
		add(buttonPanel);
		
		//Display this window
		pack();
		setVisible(true);
	}
	
	/**
	 * This will create all of the panels and listeners 
	 * and acquaint what needs to be acquainted.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new ShipBuilderGUI();
	}

}