import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * This class creates the GUI for ordering 
 * pizza and calculates the total of all added.
 * @author Casey LaClair
 */
public class OrderCalculatorGUI extends JFrame
{
	//Declare all variables.
	private PizzaPanelSize pizzaPanelSize;
	private RemovePanel removePanel;
	private CookingInstructions cookingInstructions;
	private ToppingsPanel toppingsPanel;
	private JPanel buttonPanel;
	private JLabel quantityLabel;
	private JLabel quantity;
	private int quantityCount;
	private JLabel currentPriceLabel;
	private JLabel currentPrice;
	private double currentPriceTotal;
	private JButton addToOrder;
	private JButton cancel;
	
	/**
	 * Constructor for the GUI.
	 */
	public OrderCalculatorGUI()
	{
		//Set Title fir the window
		setTitle("Pizza Order");
		
		//Set grid layout 
		setLayout(new GridLayout(5,1));
		
		//Default operation when the program is closed.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create needed panel objects.
		pizzaPanelSize = new PizzaPanelSize();
		removePanel = new RemovePanel();
		cookingInstructions = new CookingInstructions();
		toppingsPanel = new ToppingsPanel();
		buildButtonPanel();
		
		//Add all objects to the frame
		add(pizzaPanelSize);
		add(removePanel);
		add(cookingInstructions);
		add(toppingsPanel);
		add(buttonPanel);
		
		//Display the window.
		pack();
		setVisible(true);
	}
	
	/**
	 * Method used to create the button panel.
	 */
	private void buildButtonPanel()
	{
		buttonPanel = new JPanel();
		
		//Take the current quantity ordered and display.
		quantityLabel = new JLabel("Quantity");
		quantity = new JLabel(String.valueOf(quantityCount));
		
		//Take the current price and display.
		currentPriceLabel = new JLabel("Current Price");
		currentPrice = new JLabel(String.valueOf(currentPriceTotal));
		
		//Create buttons.
		addToOrder = new JButton("Add To Order");
		cancel = new JButton("Cancel");
		
		//Create button listeners
		addToOrder.addActionListener(new OrderButtonListener());
		cancel.addActionListener(new CancelButtonListener());
		
		//Add all components to the panel
		buttonPanel.add(quantityLabel);
		buttonPanel.add(quantity);
		buttonPanel.add(currentPriceLabel);
		buttonPanel.add(currentPrice);
		buttonPanel.add(addToOrder);
		buttonPanel.add(cancel);
	}
	
	/**
	 * Method to update the quantity and price areas 
	 * after an order is added.
	 */
	public void displayUpdate() 
	{
		//Clear panel
		buttonPanel.removeAll();
		
		//Format the quantity to avoid long decimals.
		DecimalFormat dc = new DecimalFormat("0.00");
		String temp = dc.format(currentPriceTotal);
		
		//Create labels for values
		quantity = new JLabel(String.valueOf(quantityCount));
		currentPrice = new JLabel("$"+String.valueOf(temp));
		
		//Add all components back to panel.
		buttonPanel.add(quantityLabel);
		buttonPanel.add(quantity);
		buttonPanel.add(currentPriceLabel);
		buttonPanel.add(currentPrice);
		buttonPanel.add(addToOrder);
		buttonPanel.add(cancel);
		
		//Reset panel visibility
		buttonPanel.setVisible(false);
		buttonPanel.setVisible(true);
	}

	
	
	
	/**
	 * Private inner class to handle addToOrder button click
	 * @author Casey LaClair
	 */
	private class OrderButtonListener implements ActionListener
	{
		/**
		 * Override the actionPerformed from ActionListener
		 */
		public void actionPerformed(ActionEvent e)
		{
			//Declare vars
			double pizzaPrice, toppingsPrice, total;
			
			//Get values of pizza size and topping prices.
			pizzaPrice = pizzaPanelSize.getPizzaSize();
			toppingsPrice = toppingsPanel.getToppingsTotal(pizzaPrice);
			
			//Add all values.
			total = pizzaPrice + toppingsPrice;
			
			//Increment quantity.
			setQuantityCount();
			
			//All total to current price.
			setCurrentPriceTotal(total);
			
			//Update the information displayed.
			displayUpdate();
		}
	}
	
	/**
	 * Inner class to act as cancel button listener
	 * @author Casey LaClair
	 */
	private class CancelButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Exit on cancel instead of clear.
			System.exit(0);
		}
	}
	
	/**
	 * Increment the quantity of pizzas ordered.
	 */
	public void setQuantityCount()
	{
		this.quantityCount++;
	}
	
	/**
	 * Add to the current price.
	 * @param currentPriceTotal
	 */
	public void setCurrentPriceTotal(double currentPriceTotal)
	{
		this.currentPriceTotal += currentPriceTotal;
	}
	
	
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args)
	{
		new OrderCalculatorGUI();
	}

}
