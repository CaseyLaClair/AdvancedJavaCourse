import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * Order price panel
 * @author Casey LaClair
 */
public class OrderPricePanel extends JPanel
{
	//I know statics aren't usually the most liked
	//but to avoid jumbling code all into one class or
	//daisy chaining getter methods, I made static to 
	//ease my pain.
	public static JLabel bagels;
	public static JLabel toppings;
	public static JLabel coffee;
	public static JLabel shots;
	private JLabel empty;
	public static JLabel subTotal;
	public static JLabel tax;
	public static JLabel total;
	public static double sub;
	public static double taxes;
	public static double totalCost;
	public static double bagelAndTopping;
	public static double coffeeCost;
	public static double shotsCost;
	private final static double TAX_RATE = 0.06;
	
	
	/**
	 * Constructor
	 */
	OrderPricePanel()
	{
		//Set layout
		setLayout(new GridLayout(16,1));
		
		//Set labels
		bagels = new JLabel("No Bagel $0.00");
		toppings = new JLabel("No Topping $0.00");
		coffee = new JLabel("No Coffee $0.00");
		shots = new JLabel("(Includes 0 shots) $0.00");
		empty = new JLabel();
		subTotal = new JLabel();
		tax = new JLabel();
		total = new JLabel();
		
		//Add components to panel
		add(bagels);
		add(toppings);
		add(coffee);
		add(shots);
		add(empty);
		add(subTotal);
		add(tax);
		add(total);
	}
	
	//Methods to add prices to subtotal
	public static void addBagelAndToppingToSub(double d)
	{
		bagelAndTopping = d;
	}
	
	public static void addCoffeeToSub(double d)
	{
		coffeeCost = d;
	}
	
	public static void addShotsToSub(double d)
	{
		shotsCost = d;
	}
	
	/**
	 * Set totals method to display in the 
	 * price panel.
	 */
	public static void setTotals()
	{
		//Formatting decimals
		DecimalFormat dc = new DecimalFormat("0.00");
		
		//Calculate sub, taxes, and total
		sub = bagelAndTopping+coffeeCost+shotsCost;
		taxes = sub*TAX_RATE;
		totalCost = sub+taxes;
		String subPrice = dc.format(sub);
		String taxPrice = dc.format(taxes);
		String totalPrice = dc.format(totalCost);
		
		//Reset all labeled values in price panel
		subTotal.removeAll();
		String subTemp = new String("SubTotal: $" + String.valueOf(subPrice));
		subTotal.setText(subTemp);
		
		tax.removeAll();
		String taxTemp = new String("Tax: $" + String.valueOf(taxPrice));
		tax.setText(taxTemp);
			
		total.removeAll();
		String totTemp = new String("Total: $" + String.valueOf(totalPrice));
		total.setText(totTemp);
	}
	
	/**
	 * Method to set text for bagels in price panel
	 * @param s - String
	 */
	public static void setTextBagel(String s)
	{
		//Clear panel
		bagels.removeAll();
		bagels.setText(s);
		
	}
	
	/**
	 * Method to set text for toppin in price panel
	 * @param s - String
	 */
	public static void setTextTopping(String s)
	{
		//Clear panel
		toppings.removeAll();
		toppings.setText(s);
		
	}
	
	/**
	 * Method to set text for coffee in price panel
	 * @param s - String
	 */
	public static void setTextCoffee(String s)
	{
		//Clear panel
		coffee.removeAll();
		coffee.setText(s);
		
	}
	
	/**
	 * Method to set text for shots in price panel
	 * @param s - String
	 */
	public static void setTextShots(String s)
	{
		//Clear panel
		shots.removeAll();
		shots.setText(s);
		
	}
}
