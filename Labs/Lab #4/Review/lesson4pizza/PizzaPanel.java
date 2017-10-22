import javax.swing.*;
import java.awt.*;

//PIZZA
//PANEL
public class PizzaPanel extends JPanel
{
	SizePanel sizePanel;
	RemovePanel removePanel;
	InstructionsPanel instructionsPanel;
	
	public PizzaPanel(SizeListener sizeListener)
	{
		sizePanel = new SizePanel(sizeListener);
		removePanel = new RemovePanel();
		instructionsPanel = new InstructionsPanel();
				
		
		setLayout(new GridLayout(3, 1));
		setBorder(BorderFactory.createLoweredBevelBorder());
		
		add(sizePanel);
		add(removePanel);
		add(instructionsPanel);
	}
	
	public Size getPizzaSize()
	{
		return sizePanel.getPizzaSize();
	}
	public float getSizePrice()
	{
		return sizePanel.getPizzaPrice();
	}
	public void updatePizzaSize()
	{
		sizePanel.updatePizzaSize();
	}
	
	private class SizePanel extends JPanel
	{
		private static final float LARGEPRICE = 11.99f;
		private static final float XLARGEPRICE = 13.99f;
		private static final float SMALLPRICE = 7.99f;
		
		//Never ask a pizza its size
		private Size pizzaSize;
		
		private JLabel label;
		
		private JRadioButton large;
		private JRadioButton xlarge;
		private JRadioButton small;
		private ButtonGroup sizeGroup;
		
		public SizePanel(SizeListener sizeListener)
		{
			large = new JRadioButton("Large - $11.99 + $1.50 / reg topping + $2.00 / prem topping");
			xlarge = new JRadioButton("X-Large - $13.99 + $1.50 / reg topping + $2.00 / prem topping");
			small = new JRadioButton("Small - $7.99 + $1.00 / reg topping + $1.50 / prem topping");
			
			large.addActionListener(sizeListener);
			xlarge.addActionListener(sizeListener);
			small.addActionListener(sizeListener);
			
			large.setSelected(true);
			
			label = new JLabel("Size");
			
			sizeGroup = new ButtonGroup();
			
			sizeGroup.add(large);
			sizeGroup.add(xlarge);
			sizeGroup.add(small);
			
			setLayout(new GridLayout(4, 1));
			
			add(label);
			add(large);
			add(xlarge);
			add(small);			
		}
		
		public void updatePizzaSize()
		{
			
			if(large.isSelected())
			{
				pizzaSize = Size.LARGE;
			}
			else if(xlarge.isSelected())
			{
				pizzaSize = Size.XLARGE;
			}
			else if(small.isSelected())
			{
				pizzaSize = Size.SMALL;
			}
			else
				System.out.println("UHHHH");
			
		}
		//what did I just tell you?
		public Size getPizzaSize()
		{
			return pizzaSize;
		}
		
		public float getSizePrice()
		{
			switch(pizzaSize)
			{
			case LARGE:
				return LARGEPRICE;
			case XLARGE:
				return XLARGEPRICE;
			case SMALL:
				return SMALLPRICE;
			default:
				return -1;
			}
		}
		public float getPizzaPrice()
		{
			switch(pizzaSize)
			{
			case LARGE:
				return LARGEPRICE;
			case XLARGE:
				return XLARGEPRICE;
			case SMALL:
				return SMALLPRICE;
			//shouldn't ever execute
			//but java is unhappy without
			//the default case
			default:
				return -1f;
			}
		}
	}
	private class RemovePanel extends JPanel
	{
		JLabel label;
		JCheckBox removeCheese;
		JCheckBox removeSauce;
		JPanel subPanel;
		
		public RemovePanel()
		{
			label = new JLabel("Remove...");
			removeCheese = new JCheckBox("No Cheese");
			removeSauce = new JCheckBox("No Sauce");
			subPanel = new JPanel();
			
			setLayout(new GridLayout(2,1));
			add(label);
			subPanel.add(removeCheese);
			subPanel.add(removeSauce);
			add(subPanel);
		}
	}
	private class InstructionsPanel extends JPanel
	{
		JLabel label;
		JCheckBox[] buttons;
		JPanel subPanel;
		
		public InstructionsPanel()
		{
			label = new JLabel("Cooking Instructions");
			subPanel = new JPanel();
			buttons = new JCheckBox[]
			{
					new JCheckBox("Cook Lite"),
					new JCheckBox("Well Done"),
					new JCheckBox("Extra Sauce"),
					new JCheckBox("Light Cheese"),
					new JCheckBox("Light Sauce"),
			};
			setLayout(new GridLayout(2,1));
			add(label);	
			subPanel.setLayout(new GridLayout(buttons.length / 2 + 1, 2));
			for(int i = 0; i < buttons.length; i++)
			{
				subPanel.add(buttons[i]);
			}
			add(subPanel);
		}
	}
}