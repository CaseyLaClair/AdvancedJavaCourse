import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * Class that creates the bagel and topping panel
 * to be held in the order panel.
 * @author Casey LaClair
 */
public class BagelAndToppingPanel extends JPanel
{
	private JPanel bagelAndTopping;
	
	//Bagel constants and variables
	private final double NO_BAGEL = 0.0;
	private final double WHITE_BAGEL = 1.25;
	private final double WHEAT_BAGEL = 1.50;
	private final double SESAME_BAGEL = 1.50;

	//Variables for the bagel combo box.
	private JLabel bagel;
	private String[] bagels = {"No Bagel", "White Bagel", "Wheat Bagel", "Sesame Bagel"};
    private JComboBox bagelBox;
    
    //Topping constants and variables
    private final double NO_TOPPING = 0.0;
    private final double CREAM_CHEESE = 0.50;
    private final double BUTTER = 0.25;
    private final double PEACH_JELLY = 0.75;
    private final double BLUEBERRY_JAM = 0.75;

    //Variables for the topping combo box.
	private JLabel topping;
	private String[] toppings = {"No Topping", "Cream Cheese", "Butter", "Peach Jelly", "Blueberry Jam"};
	private JComboBox toppingBox;
	
	/**
	 * Constructor for bagel and topping panel
	 */
	public BagelAndToppingPanel()
	{
		//Init bagel and topping panel
		bagelAndTopping = new JPanel();
		
		//Set layout
		setLayout(new GridLayout(4, 1));
		
		//Assign labels
		bagel = new JLabel("Bagel:");
	    bagelBox = new JComboBox(bagels);
	    topping = new JLabel("Topping:");
		toppingBox = new JComboBox(toppings);

		//Add components to panel
	    add(bagel);
	    add(bagelBox);
		
	    //Create action listener for bagel and topping combo boxes
		bagelBox.addActionListener(new ComboBoxListener());
		toppingBox.addActionListener(new ComboBoxListener());
	}
	
	/**
	 * Method to return value of bagel and also add topping
	 * components to panel if a bagel is chosen.
	 * @return value of bagel chosen
	 */
	public double getValueOfBagel()
	{
		//Init values
		double value = 0.0;
		int index = bagelBox.getSelectedIndex();
		
		//Display topping options if bagel is chosen
		if (index != 0)
		{
			add(topping);
			add(toppingBox);
		}
		else
		{
			remove(topping);
			remove(toppingBox);
		}
		
		//Determine value of bagel
		switch (index) 
		{
			case 1: value = WHITE_BAGEL;
			break;
			case 2: value = WHEAT_BAGEL;
			break;
			case 3: value = SESAME_BAGEL;
			break;
			default: value = NO_BAGEL;
			break;
		}
		return value;
	}
	
	/**
	 * Get the value of the topping selected
	 * @return topping value
	 */
	public double getValueOfTopping()
	{
		double value = 0.0;
		int index = toppingBox.getSelectedIndex();
	
		//Determine value of topping
		switch (index) 
		{
			case 1: value = CREAM_CHEESE;
			break;
			case 2: value = BUTTER;
			break;
			case 3: value = PEACH_JELLY;
			break;
			case 4: value = BLUEBERRY_JAM;
			break;
			default: value = NO_TOPPING;
			break;
		}
		return value;
	}
	
	/**
	 * Private inner class for a combo box listener.
	 * @author Casey LaClair
	 */
	private class ComboBoxListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			//Format the quantity to avoid long decimals.
			DecimalFormat dc = new DecimalFormat("0.00");
			String bPrice = dc.format(getValueOfBagel());
			String tPrice = dc.format(getValueOfTopping());
			
			//Create labels for values
			String bagelPrice = new String(bagelBox.getSelectedItem()+" $"+String.valueOf(bPrice));
			String toppingPrice = new String(toppingBox.getSelectedItem()+" $"+String.valueOf(tPrice));
			
			//Set bagel text on price panel
			OrderPricePanel.setTextBagel(bagelPrice);
			OrderPricePanel.setTextTopping(toppingPrice);
			
			//Set values on price panel
			OrderPricePanel.addBagelAndToppingToSub(getValueOfBagel()+getValueOfTopping());
			OrderPricePanel.setTotals();
		}
	}
}
