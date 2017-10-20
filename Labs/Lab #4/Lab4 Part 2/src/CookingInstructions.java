import javax.swing.*;
import java.awt.*;

/**
 * Class to create cooking instructions panel
 * @author Casey LaClair
 */
public class CookingInstructions extends JPanel {

	//Declare vars
	private JCheckBox cookLite;
	private JCheckBox extraSauce;
	private JCheckBox lightCheese;
	private JCheckBox lightSauce;
	
	/**
	 * Constructor for the panel
	 */
	public CookingInstructions()
	{
		//Set grid layout
		setLayout(new GridLayout(2,2));
		
		//Declare all checkboxes for options
		cookLite = new JCheckBox("Cook Lite");
		extraSauce = new JCheckBox("Extra Sauce");
		lightCheese = new JCheckBox("Light Cheese");
		lightSauce = new JCheckBox("Light Sauce");
		setBorder(BorderFactory.createTitledBorder("Cooking Instructions"));
		
		//Add all components to panel
		add(cookLite);
		add(extraSauce);
		add(lightCheese);
		add(lightSauce);
	}
}