import javax.swing.*;
import java.awt.*;

/*
 * This is only the beginning of this doomed program
 * do not look further
 * (it's a horrible mess, I'm so sorry)
 */
public class PizzaGUI extends JFrame
{
	PizzaPanel pizzaPanel;
	ToppingsPanel toppingsPanel;
	OrderPanel orderPanel;
	public PizzaGUI()
	{
		SizeListener sizeListener = new SizeListener();
		ToppingListener toppingListener = new ToppingListener();
		pizzaPanel = new PizzaPanel(sizeListener);
		
		toppingsPanel = new ToppingsPanel(toppingListener);
		orderPanel = new OrderPanel();
		orderPanel.setListener(new OrderListener());
		
		sizeListener.setPizzaPanel(pizzaPanel);
		sizeListener.setOrderPanel(orderPanel);
		sizeListener.setToppingsPanel(toppingsPanel);
		
		toppingListener.setPizzaPanel(pizzaPanel);
		toppingListener.setToppingsPanel(toppingsPanel);
		toppingListener.setOrderPanel(orderPanel);
		
		setTitle("Papa Gino's(tm) Nothing Compares(R)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 1));
		
		add(pizzaPanel);
		add(toppingsPanel);
		add(orderPanel);
		
		pack();
		setVisible(true);
		
	}
	public static void main(String[] args)
	{
		new PizzaGUI();
	}
}
