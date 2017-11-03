import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * Creates the coffee and shots panel
 * @author Casey LaClair
 */
public class CoffeeAndShots extends JPanel
{
	private JPanel coffeeAndShots;
	
	//Coffee constants and variables
	private final double NO_COFFEE = 0.0;
	private final double REGULAR_COFFEE = 1.25;
	private final double DECAF_COFFEE = 1.25;
	private final double CAPPUCCINO = 2.00;
	private final double RED_EYE = 1.50;
	private final double SHOT = 0.5;

	//Coffee combo box variables
	private JPanel coffeePanel;
	private JLabel coffee;
	private String[] coffees = {"No Coffee", "Regular", "Decaf", "Cappuccino", "Red-Eye"};
	private JComboBox coffeeBox;
		
	//Number of shots variables
	private JPanel shotsPanel;
	private JLabel shotsLabel;
	private JSlider slider;
	private int currentValue;
		
	/**
	 * Constructor
	 */
	public CoffeeAndShots()
	{
		//Init panel
		coffeeAndShots = new JPanel();
		
		//Set layout
		setLayout(new GridLayout(4,1));
		
		//Create labels and combo box
		coffee = new JLabel("Coffee:");
		coffeeBox = new JComboBox(coffees);
		
		//Create shots for label
		shotsLabel = new JLabel("Number of shots:");
		
		//Create specs for slider
		slider = new JSlider(JSlider.HORIZONTAL,0,5,0);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(new SliderListener());
		
		//Add components to panel
		add(coffee);
		add(coffeeBox);
		
		//Set action listener for coffee combo box
		coffeeBox.addActionListener(new ComboBoxListener());
	}
	
	/**
	 * Get the value of coffee selected and
	 * display slider for shots if Red-Eye
	 * is selected.
	 * @return value of coffee
	 */
	public double getValueOfCoffee()
	{
		double value = 0.0;
		int index = coffeeBox.getSelectedIndex();
		
		//Display slider if red-eye selected
		if (index == 4)
		{
			add(shotsLabel);
			add(slider);
		}
		else
		{
			remove(shotsLabel);
			remove(slider);
		}
		
		//Determine value of coffee chosen
		switch (index) 
		{
			case 1: value = REGULAR_COFFEE;
			break;
			case 2: value = DECAF_COFFEE;
			break;
			case 3: value = CAPPUCCINO;
			break;
			case 4: value = RED_EYE;
			break;
			default: value = NO_COFFEE;
			break;
		}
		return value;
	}
	
	/**
	 * Get value of shots based on slider.
	 * @return value of shots for coffee
	 */
	public double getValueOfShots()
	{
		currentValue = slider.getValue();
		
		double price = (double) (currentValue*SHOT);
		
		return price;
	}
	
	/**
	 * Private inner class for combo box listener
	 * @author Casey LaClair
	 */
	private class ComboBoxListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Format the quantity to avoid long decimals.
			DecimalFormat dc = new DecimalFormat("0.00");
			String cPrice = dc.format(getValueOfCoffee());
			
			//Create labels for values
			String coffeePrice = new String(coffeeBox.getSelectedItem()+" $"+String.valueOf(cPrice));
			
			//Set new text for price panel
			OrderPricePanel.setTextCoffee(coffeePrice);
			OrderPricePanel.addCoffeeToSub(getValueOfCoffee());
			OrderPricePanel.setTotals();
		}
	}
	
	/**
	 * Private inner class for slider listener
	 * @author Casey LaClair
	 */
	private class SliderListener implements ChangeListener
	{
		@Override
		public void stateChanged(ChangeEvent e) 
		{
			//Format the quantity to avoid long decimals.
			DecimalFormat dc = new DecimalFormat("0.00");
			String sPrice = dc.format(getValueOfShots());
			
			//Create labels for values
			String shot = new String("(Includes "+slider.getValue()+" shots)"+" $"+String.valueOf(sPrice));
			
			//Set new text for price panel
			OrderPricePanel.setTextShots(shot);
			OrderPricePanel.addShotsToSub(getValueOfShots());
			OrderPricePanel.setTotals();
		}
	}
}

