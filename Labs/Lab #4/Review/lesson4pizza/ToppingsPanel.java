import javax.swing.*;
import java.awt.*;

public class ToppingsPanel extends JPanel
{
	private float regToppingPrice;
	private float premToppingPrice;
	private Topping[] meatToppings;
	private Topping[] nonMeatToppings;
	
	private JPanel meatPanel;
	private JPanel nonMeatPanel;
	
	private float price;
	
	public ToppingsPanel(ToppingListener toppingListener)
	{
		meatToppings = new Topping[]
		{
				new Topping("Bacon", toppingListener, true),
				new Topping("Capicola", toppingListener),
				new Topping("Beef", toppingListener, true),
				new Topping("Pepperoni", toppingListener),
				new Topping("Meatball", toppingListener, true),
				new Topping("Sausage", toppingListener),
				new Topping("Chicken", toppingListener, true),
				new Topping("Linguica", toppingListener),
		};
		nonMeatToppings = new Topping[]
		{
				new Topping("Extra Cheese", toppingListener),
				new Topping("Feta Cheese", toppingListener),
				new Topping("Broccoli", toppingListener),
				new Topping("Green Peppers", toppingListener),
				new Topping("Mushrooms", toppingListener),
				new Topping("Olives", toppingListener),
				new Topping("Onion", toppingListener),
				new Topping("Pinapple", toppingListener),
				new Topping("Tomatoes", toppingListener),
				new Topping("Garlic", toppingListener),
				new Topping("Tomato Chunks", toppingListener),
				new Topping("Banana Peppers", toppingListener),
		};
		
		regToppingPrice = 0;
		premToppingPrice = 0;
		price = 0;
		
		setLayout(new GridLayout(1, 2, 0, 50));
		
		setBorder(BorderFactory.createLoweredBevelBorder());
		
		meatPanel = new JPanel();
		
		int minlistsize = meatToppings.length < nonMeatToppings.length ? meatToppings.length : nonMeatToppings.length;
		meatPanel.setLayout(new GridLayout(0, 1));

		meatPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Meat"));
		nonMeatPanel = new JPanel();
		nonMeatPanel.setLayout(new GridLayout(0, 1));
		nonMeatPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Non-Meat"));
		
		for(int i = 0; i < meatToppings.length; i++)
		{
			meatPanel.add(meatToppings[i]);
		}
		for(int i = 0; i < nonMeatToppings.length; i++)
		{
			nonMeatPanel.add(nonMeatToppings[i]);
		}
		add(meatPanel);
		add(nonMeatPanel);
	}
	public void updateToppingPrices(Size size)
	{
		if(size == Size.LARGE)
		{
			regToppingPrice = 1.50f;
			premToppingPrice = 2.00f;
		}
		else if(size == Size.XLARGE)
		{
			regToppingPrice = 1.50f;
			premToppingPrice = 2.00f;
		}
		else if(size == Size.SMALL)
		{
			regToppingPrice = 1.00f;
			premToppingPrice = 1.50f;
		}
		calculatePrice(size);
	}
	private void calculatePrice(Size size)
	{
		price = 0;
		Topping t;
		float tp;
		for(int i = 0; i < meatToppings.length; i++)
		{
			t = meatToppings[i];
			if(!t.isOnPizza())
			{
				continue;
			}
			tp = t.isPremium ? premToppingPrice: regToppingPrice;
			tp = t.isDouble() ? tp * 2 : tp;
			price += tp;
		}
		for(int i = 0; i < nonMeatToppings.length; i++)
		{
			t = nonMeatToppings[i];
			if(!t.isOnPizza())
			{
				continue;
			}
			tp = t.isPremium() ? premToppingPrice: regToppingPrice;
			tp = t.isDouble() ? tp * 2 : tp;
			price += tp;
		}
	}
	public float getPrice()
	{
		return price;
	}
	
	private class Topping extends JPanel
	{
		private JLabel name;
		private boolean isPremium;
		
		private ButtonGroup buttonGroup;
		private JRadioButton noneButton;
		private JRadioButton fullButton;
		private JRadioButton firstHalfButton;
		private JRadioButton secondHalfButton;
		private JCheckBox doubleButton;
		
		public Topping(String name, ToppingListener toppingListener)
		{
			this.name = new JLabel(name);
			this.isPremium = false;
			
			noneButton = new JRadioButton("None");
			fullButton = new JRadioButton("Full");
			firstHalfButton = new JRadioButton("1st Half");
			secondHalfButton = new JRadioButton("2nd Half");
			doubleButton = new JCheckBox("Double");
			
			noneButton.addActionListener(toppingListener);
			fullButton.addActionListener(toppingListener);
			firstHalfButton.addActionListener(toppingListener);
			secondHalfButton.addActionListener(toppingListener);
			doubleButton.addActionListener(toppingListener);
			
			buttonGroup = new ButtonGroup();
			buttonGroup.add(noneButton);
			buttonGroup.add(fullButton);
			buttonGroup.add(firstHalfButton);
			buttonGroup.add(secondHalfButton);
			
			noneButton.setSelected(true);
			
			setBorder(BorderFactory.createLoweredBevelBorder());
			
			add(this.name);
			add(noneButton);
			add(fullButton);
			add(firstHalfButton);
			add(secondHalfButton);
			add(doubleButton);
		}
		public Topping(String name, ToppingListener toppingListener, boolean isPremium)
		{
			this(name, toppingListener);
			this.isPremium = isPremium;
		}
		public boolean isOnPizza()
		{
			return !noneButton.isSelected();
		}
		public boolean isDouble()
		{
			return doubleButton.isSelected();
		}
		public boolean isPremium()
		{
			return this.isPremium;
		}
	}
}
