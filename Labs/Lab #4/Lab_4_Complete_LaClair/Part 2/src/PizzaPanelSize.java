import javax.swing.*;
import java.awt.*;

/**
 * Class to create a panel to choose the pizzas size.
 * @author Casey LaClair
 */
public class PizzaPanelSize extends JPanel 
{
	//Declare final prices based on pizza size.
	public final double LARGE_PIZZA = 11.99;
	public final double X_LARGE_PIZZA = 13.99;
	public final double SMALL_PIZZA = 7.99;
	
	//Create buttons for the different sizes.
	private JRadioButton large;
	private JRadioButton xLarge;
	private JRadioButton small;
	private ButtonGroup sizeGroup;
	
	/**
	 * Constructor to create pizza size panel.
	 */
	public PizzaPanelSize()
	{
		//Set grid layout
		setLayout(new GridLayout(3,1));
		
		//Displays for the radio buttons.
		large = new JRadioButton("Large - $11.99 + $1.50 / reg topping + $2.00 / prem topping", true);
		xLarge = new JRadioButton("X-Large - $13.99 + $1.50 / reg topping + $2.00 / prem topping", true);
		small = new JRadioButton("Small - $7.99 + $1.00 / reg topping + $1.50 / prem topping", true);
		sizeGroup = new ButtonGroup();
		
		//Add radio buttons to radio group.
		sizeGroup.add(large);
		sizeGroup.add(xLarge);
		sizeGroup.add(small);
		setBorder(BorderFactory.createTitledBorder("Remove..."));
		
		//Add all components to panel.
		add(large);
		add(xLarge);
		add(small);
	}
	
	/**
	 * Gets the price based on the pizza chosen.
	 * @return Price for the size of the pizza.
	 */
	public double getPizzaSize() 
	{
		double price = 0.0;
		
		if (large.isSelected())
			price = LARGE_PIZZA;
		else if (xLarge.isSelected())
			price = X_LARGE_PIZZA;
		else
			price = SMALL_PIZZA;
		
		return price;
	}
}