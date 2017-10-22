import javax.swing.*;

//Here's a panel for you to implement!  This panel should be hooked up to a ship object and should display the results of
//sending the object the toString message.

/**
 * 
 * @author Eric
 *
 */
public class CreatedPanel extends JPanel
{
	// private Ship ship;
	private JTextArea text;

	public CreatedPanel()
	{
		// Add a titled border
		setBorder(BorderFactory.createTitledBorder("Created"));
		text = new JTextArea();
		add(text);
	}

	public void setShip(Ship ship)
	{
		// this.ship = ship;
		this.text.setText(ship.toString());
	}
}
