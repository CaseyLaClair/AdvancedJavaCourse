import java.awt.event.*;
import javax.swing.JOptionPane;

public class OrderListener implements ActionListener
{


	public OrderListener()
	{

	}

	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(null, "Your pizza has been ordered!");
	}

}
