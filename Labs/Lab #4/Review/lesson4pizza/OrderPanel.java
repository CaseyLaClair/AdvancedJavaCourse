import javax.swing.*;

public class OrderPanel extends JPanel
{
	private int quantity;
	private float price;
	private JLabel quantityLabel;
	private JLabel priceLabel;
	private JButton orderButton;
	private JButton quitButton;

	public void setListener(OrderListener orderListener)
	{
		orderButton.addActionListener(orderListener);
	}

	public OrderPanel()
	{
		quantity = 1;
		price = 0;
		
		quantityLabel = new JLabel();
		priceLabel = new JLabel();
		
		updateQuantityLabel();
		updatePriceLabel();
		
		orderButton = new JButton("Add to Order");
		quitButton = new JButton("Cancel");

		quitButton.addActionListener(new QuitListener());
		
		setBorder(BorderFactory.createLoweredBevelBorder());
		
		add(quantityLabel);
		add(priceLabel);
		add(orderButton);
		add(quitButton);
	}
	public void updatePrice(float sizePrice, float toppingPrice)
	{
		this.price = sizePrice + toppingPrice;
		updatePriceLabel();
	}
	public void updateQuantityLabel()
	{
		quantityLabel.setText(String.format("Quantity: %d", quantity));
	}
	public void updatePriceLabel()
	{
		priceLabel.setText(String.format("Current Item Price: $%.2f", price));
	}
}
