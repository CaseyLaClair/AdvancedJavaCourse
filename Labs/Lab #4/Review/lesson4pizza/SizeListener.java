import java.awt.event.*;

public class SizeListener implements ActionListener
{
	PizzaPanel pizzaPanel;
	OrderPanel orderPanel;
	ToppingsPanel toppingsPanel;
	public SizeListener(){}
	public void setPizzaPanel(PizzaPanel pizzaPanel)
	{
		this.pizzaPanel = pizzaPanel;
	}
	public void setOrderPanel(OrderPanel orderPanel)
	{
		this.orderPanel = orderPanel;
	}
	public void setToppingsPanel(ToppingsPanel toppingsPanel)
	{
		this.toppingsPanel = toppingsPanel;
	}
	public void actionPerformed(ActionEvent e)
	{
		pizzaPanel.updatePizzaSize();
		toppingsPanel.updateToppingPrices(pizzaPanel.getPizzaSize());
		orderPanel.updatePrice(pizzaPanel.getSizePrice(), toppingsPanel.getPrice());
	}
}