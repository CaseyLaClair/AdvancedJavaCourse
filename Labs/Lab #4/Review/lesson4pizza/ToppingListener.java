import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToppingListener implements ActionListener
{
	PizzaPanel pizzaPanel;
	ToppingsPanel toppingsPanel;
	OrderPanel orderPanel;
	public ToppingListener(){}
	
	public void setPizzaPanel(PizzaPanel pizzaPanel)
	{
		this.pizzaPanel = pizzaPanel;
	}
	public void setToppingsPanel(ToppingsPanel toppingsPanel)
	{
		this.toppingsPanel = toppingsPanel;
	}
	public void setOrderPanel(OrderPanel orderPanel)
	{
		this.orderPanel = orderPanel;
	}
	public void actionPerformed(ActionEvent e)
	{
		pizzaPanel.updatePizzaSize();
		toppingsPanel.updateToppingPrices(pizzaPanel.getPizzaSize());
		orderPanel.updatePrice(pizzaPanel.getSizePrice(), toppingsPanel.getPrice());
	}
}
