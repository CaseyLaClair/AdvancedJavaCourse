import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class to create and display order options panel
 * @author Casey LaClair
 */
public class OrderOptionsPanel extends JPanel
{
	//Create new object references for panel
	private BagelAndToppingPanel bagelAndTopping;
	private CoffeeAndShots coffeeAndShots;
	
	/**
	 * Constructor for options panel
	 */
	public OrderOptionsPanel() 
	{
		//Set layout
		setLayout(new GridLayout(2, 1));
		
		//Set border title
		setBorder(BorderFactory.createTitledBorder("Order"));

		//Create new objects for panel
		bagelAndTopping = new BagelAndToppingPanel();
		coffeeAndShots = new CoffeeAndShots();
		
		//Add components to panel
		add(bagelAndTopping);
		add(coffeeAndShots);
	}
}
