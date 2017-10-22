import javax.swing.*;

/**
 * The ButtonPanel class holds the done and quit buttons. The quit button does
 * not have a listener and therefore doesn't "do" anything, but the done button
 * has a listener -- doneListener.
 * 
 * @author Maggie also Eric
 *
 */

public class ButtonPanel extends JPanel
{

	private JButton doneButton;
	private JButton quitButton;

	// Set the listener for the button.
	public void setListener(DoneListener doneListener)
	{
		doneButton.addActionListener(doneListener);
	}

	// Create the buttons and install them in the panel.
	public ButtonPanel()
	{
		// Instantiate the buttons
		doneButton = new JButton("Done");
		quitButton = new JButton("Quit");

		// We don't need a whole function for this
		// No one is going to want to change the quit listener
		quitButton.addActionListener(new QuitListener());

		// Add them to the panel
		add(doneButton);
		add(quitButton);
	}
}
