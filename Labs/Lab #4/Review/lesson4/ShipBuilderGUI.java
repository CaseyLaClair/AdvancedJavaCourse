import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Here's the program! Create panels and listeners and introduce 'em to each
 * other. Pack 'em up and show them to the user.
 * 
 * @author Maggie
 *
 */
public class ShipBuilderGUI extends JFrame
{

	public ShipBuilderGUI()
	{
		// set the title bar
		setTitle("Ship Builder");

		// specify an action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add a GridLayout manager to the content pane
		setLayout(new GridLayout(2, 2));

		// create the four different panels and three listeners
		ShipDataPanel shipDataPanel = new ShipDataPanel();
		ShipButtonListener shipButtonListener = new ShipButtonListener(shipDataPanel);
		ShipTypePanel shipTypePanel = new ShipTypePanel(shipButtonListener);

		CreatedPanel createdPanel = new CreatedPanel();
		ButtonPanel buttonPanel = new ButtonPanel();
		DoneListener doneListener = new DoneListener(shipTypePanel, shipDataPanel, createdPanel);
		buttonPanel.setListener(doneListener);

		// add the panels
		add(shipTypePanel);
		add(shipDataPanel);
		add(createdPanel);
		add(buttonPanel);

		// display this window
		pack();
		setVisible(true);
	}

	// This will create all of the panels and listeners and acquaint what needs to
	// be acquainted.

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new ShipBuilderGUI();
	}

}
