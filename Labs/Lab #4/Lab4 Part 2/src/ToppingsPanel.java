import javax.swing.*;
import java.awt.*;

/**
 * This class creates a panel for the toppings to be put. 
 * It is meant to house the SpecificToppingLabel object and all
 * SpecificTopingButtons objects that are created.
 * @author Casey LaClair
 */
public class ToppingsPanel extends JPanel {

	//Declare all fields.
	private SpecificToppingLabel toppingLabel;
	private SpecificToppingButtons group1;
	private SpecificToppingButtons group2;
	private JLabel g1Name;
	private JLabel g2Name;
	
	/**
	 * Constructor for the topics panel
	 */
	public ToppingsPanel()
	{		
		//Set grid layout
		setLayout(new GridLayout(3,2));
		
		setBorder(BorderFactory.createTitledBorder("Toppings"));
		
		//Create group names to be passed later
		//during the topping object creation.
		g1Name = new JLabel("Bacon");
		g2Name = new JLabel("Pineapple");
		
		//Create the labels for each part of the topping group.
		toppingLabel = new SpecificToppingLabel();
		
		//Create the topping objects
		group1 = new SpecificToppingButtons(g1Name);
		group2 = new SpecificToppingButtons(g2Name);
		 
		//Add all components to the panel
		add(toppingLabel);
		add(group1);
		add(group2);
	}
	
	/**
	 * Calculates the total cost of all toppings added.
	 * @param pizza - price based on size.
	 * @return total topping price.
	 */
	public double getToppingsTotal(double pizza) 
	{	
		double total = 0.0;
	
		total = group1.getToppingCost(pizza) +
				group2.getToppingCost(pizza);
		
		return total;
	}
}
