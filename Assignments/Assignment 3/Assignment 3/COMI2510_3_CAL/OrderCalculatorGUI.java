import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The OrderCalculatorGUI class creates the GUI for the Brandi's Bagel House
 * application.
 */

public class OrderCalculatorGUI extends JFrame 
{
	private GreetingPanel banner; //Greeting panel
	private OrderPanel orderPanel; //Holds options and price panel
	private JPanel buttonPanel; // To hold the buttons
	private JButton calcButton; // To calculate the cost
	private JButton exitButton; // To exit the application
	private final double TAX_RATE = 0.06; // Sales tax rate

	/**
	 * Constructor
	 */
	public OrderCalculatorGUI() 
	{
		// Display a title.
		setTitle("Order Calculator");

		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a BorderLayout manager.
		setLayout(new BorderLayout());

		// Create the custom panels.
		banner = new GreetingPanel();
		orderPanel = new OrderPanel();

		// Create the button panel.
		buildButtonPanel();

		// Add the components to the content pane.
		add(banner, BorderLayout.NORTH);
		// add(bagels, BorderLayout.WEST);
		add(orderPanel, BorderLayout.CENTER);
		// add(coffee, BorderLayout.EAST);
		add(buttonPanel, BorderLayout.SOUTH);

		// Pack the contents of the window and display it.
		pack();
		setVisible(true);
	}

	/**
	 * The buildButtonPanel method builds the button panel.
	 */
	private void buildButtonPanel() 
	{
		// Create a panel for the buttons.
		buttonPanel = new JPanel();

		// Create the buttons.
		calcButton = new JButton("Calculate");
		exitButton = new JButton("Exit");

		// Register the action listeners.
		calcButton.addActionListener(new CalcButtonListener());
		exitButton.addActionListener(new ExitButtonListener());

		// Add the buttons to the button panel.
		buttonPanel.add(calcButton);
		buttonPanel.add(exitButton);
	}

	/**
	 * Private inner class that handles the event when the user clicks the Calculate
	 * button.
	 */
	private static class CalcButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			double subTotal, tax, total;

			//Set values based off static members of OrderPricePanel
			subTotal = OrderPricePanel.sub;
			tax = OrderPricePanel.taxes;
			total = OrderPricePanel.totalCost;

			// Display the charges.
			JOptionPane.showMessageDialog(null,
					String.format("Subtotal: $%,.2f\n" + "Tax: $%,.2f\n" + "Total: $%,.2f", subTotal, tax, total));
		}
	}

	/**
	 * Private inner class that handles the event when the user clicks the Exit
	 * button.
	 */
	private class ExitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);
		}
	}

	/**
	 * main method
	 */
	public static void main(String[] args) {
		new OrderCalculatorGUI();
	}
}
