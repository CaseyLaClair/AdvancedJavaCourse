import javax.swing.*;
import java.awt.*;

/**
 * This class acts as a template only for the labels
 * above the topping options.
 * @author Casey LaClair
 */
public class SpecificToppingLabel extends JPanel
{
	//Declare all labels
	private JLabel topping;
	private JLabel none;
	private JLabel full;
	private JLabel half1;
	private JLabel half2;
	private JLabel premium;
	
	/**
	 * Constructor for the topping labels
	 */
	public SpecificToppingLabel() 
	{
		//Set grid layouts
		setLayout(new GridLayout(1,6));
		
		//Initialize labels
		topping = new JLabel("Topping   ");
		none = new JLabel("None");
		full = new JLabel("Full");
		half1 = new JLabel("1st Half");
		half2 = new JLabel("2nd Half");
		premium = new JLabel("Double");
		
		//Add all components to panel
		add(topping);
		add(none);
		add(full);
		add(half1);
		add(half2);
		add(premium);
	}
}
