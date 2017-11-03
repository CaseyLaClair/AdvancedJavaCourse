import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Creates the order panel
 * @author Casey LaClair
 */
public class OrderPanel extends JPanel
{
	//Init object references
	private OrderOptionsPanel optionsPanel;
	private OrderPricePanel pricePanel;
	
	/**
	 * Constructor
	 */
	public OrderPanel() 
	{
		//Set layout
		setLayout(new GridLayout(1, 2));
		
		//Declare objects for panel
		optionsPanel = new OrderOptionsPanel();
		pricePanel = new OrderPricePanel();
		
		//Add components to panel
		add(optionsPanel);
		add(pricePanel);
	}
}
