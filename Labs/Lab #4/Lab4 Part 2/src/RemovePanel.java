import javax.swing.*;
import java.awt.*;

/**
 * Class to create panel for what to remove from the pizza.
 * @author Casey LaClair
 */
public class RemovePanel extends JPanel
{
	//Declare options.
	private JCheckBox noCheese;
	private JCheckBox noSauce;
	
	/**
	 * Constructor for the panel.
	 */
	public RemovePanel() 
	{
		//Set grid layout
		setLayout(new GridLayout(1,1));
		
		//Initialize the checkboxes
		noCheese = new JCheckBox("No Cheese");
		noSauce = new JCheckBox("No Sauce");
		setBorder(BorderFactory.createTitledBorder("Remove..."));
		
		//Add all components to the panel.
		add(noCheese);
		add(noSauce);
	}
}
