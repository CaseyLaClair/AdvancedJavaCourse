import javax.swing.*;

/**
 * Creates a button panel to house action buttons.
 *
 */
public class ButtonPanel extends JPanel 
{

	//Declare buttons.
	private JButton doneButton;
	private JButton quitButton;
	
	/**
	 * Sets a listener for the done button.
	 * @param doneListener
	 */
	public void setListener(DoneListener doneListener)
	{
		doneButton.addActionListener(doneListener);
	}
	
	/**
	 * Constructor to create a button panel.
	 */
	public ButtonPanel()
	{
		//Instantiate the buttons
		doneButton=new JButton("Done");
		quitButton=new JButton("Quit");
	
		//Add them to the panel
		add(doneButton);
		add(quitButton);
	}
}