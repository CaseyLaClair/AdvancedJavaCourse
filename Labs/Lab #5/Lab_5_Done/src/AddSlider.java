import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates a slider panel.
 * @author Casey LaClair
 */
public class AddSlider extends JPanel
{
	//Declare all needed fields.
	private JSlider slider;
	private JLabel charge;
	private JTextField displayValue;
	private final int MIN = 100;
	private final int MAX = 1000;
	private final int INIT = 100;
	private final int MAJOR_TICK = 250;
	private final int MINOR_TICK = 50;
	private int currentValue = 0;
	
	/**
	 * Constructor
	 */
	public AddSlider() 
	{
		//Set layout and border.
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Charge Account"));
		
		//Set display for the slider.
		charge = new JLabel("Choose charge amount:");
		displayValue = new JTextField("$0");
		displayValue.setEditable(false);
		
		//Create slider.
		slider = new JSlider(JSlider.HORIZONTAL,MIN,MAX,INIT);
		slider.setMajorTickSpacing(MAJOR_TICK);
		slider.setMinorTickSpacing(MINOR_TICK);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(new SliderListener());
		
		//Add parts of the slider panel to the layout.
		add(charge, BorderLayout.NORTH);
		add(slider, BorderLayout.CENTER);
		add(displayValue, BorderLayout.SOUTH);
	}
	
	/**
	 * Accessor method for the slider value.
	 * @return Slider value.
	 */
	public int getSliderValue()
	{
		return currentValue;
	}
	
	/**
	 * Listener for the slider.
	 */
	private class SliderListener implements ChangeListener
	{
		@Override
		public void stateChanged(ChangeEvent e) 
		{
			currentValue = slider.getValue();
			
			displayValue.setText("$"+Integer.toString(currentValue));
		}
	}
}
