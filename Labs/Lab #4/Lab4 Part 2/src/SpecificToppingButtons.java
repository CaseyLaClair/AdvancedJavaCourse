import javax.swing.*;
import java.awt.*;

/**
 * Class to create a specific row for a single topping.
 * @author Casey LaClair 
 */
public class SpecificToppingButtons extends JPanel
{
	//Declare all fields for toppings
	private JLabel topping;
	private JRadioButton none;
	private JRadioButton full;
	private JRadioButton half1;
	private JRadioButton half2;
	private ButtonGroup bg;
	private JCheckBox premium;
	
	/**
	 * Constructor for creating a specific topping.
	 * @param topping - the toppings name.
	 */
	public SpecificToppingButtons(JLabel topping) 
	{
		//Set grid layout
		setLayout(new GridLayout(1,6));
		
		//Initialize all parts of the topping group.
		this.topping = topping;
		none = new JRadioButton("", true);
		full = new JRadioButton();
		half1 = new JRadioButton();
		half2 = new JRadioButton();
		premium = new JCheckBox();
		bg = new ButtonGroup();
		
		//Add all button options to the button group
		bg.add(none);
		bg.add(full);
		bg.add(half1);
		bg.add(half2);
		
		//Add all components to panel.
		add(this.topping);
		add(none);
		add(full);
		add(half1);
		add(half2);
		add(premium);
	}
	
	/**
	 * This method takes into consideration the size of the pizza
	 * when determining the price of the toppings included.
	 * @param pizza price based on size
	 * @return price based on size and toppings selected.
	 */
	public double getToppingCost(double pizza)
	{
		//Declare and initialize var to return.
		double total = 0.0;
		
		//If the pizza is a small, determine cast of toppings.
		if (pizza < 8.0) 
		{
			if (none.isSelected())
				total = 0.0;
			else if (!none.isSelected() && premium.isSelected())
				total = 1.5;
			else
				total = 1.0;
		}
		
		//If the pizza isn't a small, choose the topping price for
		//large or XL.
		else 
		{
			if (none.isSelected())
				total = 0.0;
			else if (!none.isSelected() && premium.isSelected())
				total = 2.0;
			else
				total = 1.5;
		}
		return total;
	}
}
