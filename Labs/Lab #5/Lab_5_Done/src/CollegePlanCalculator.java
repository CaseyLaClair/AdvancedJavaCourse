import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This program allows a user to choose multiple options 
 * for college dorms, meals, and extras.
 * @author Casey LaClair
 */

public class CollegePlanCalculator extends JFrame 
{

	//Constants for the prices for the dorms.
	private final int ALLEN_HALL = 1500;
	private final int PIKE_HALL = 1600;
	private final int FARTHING_HALL = 1200;
	private final int UNIVERSITY_SUITES = 1800;
	
	//Constants for the prices for the meal plans.
	private final int SEVEN_MEALS = 560;
	private final int FOURTEEN_MEALS = 1095;
	private final int UNLIMITED_MEALS = 1500;
	
	//parts of the menu bar.
	private static JMenuBar menuBar;
	private JMenu dorm;
	private JMenu meal;
	private JRadioButtonMenuItem allen;
	private JRadioButtonMenuItem pike;
	private JRadioButtonMenuItem farthing;
	private JRadioButtonMenuItem suites;
	private JRadioButtonMenuItem sevenMeals;
	private JRadioButtonMenuItem fourteenMeals;
	private JRadioButtonMenuItem infiniteMeals;

	//Parts of the results panel.
	private JLabel totalLabel;
	private JTextField totalField;
	private JButton findTotal;
	
	//Slider and extras.
	private ExtraServices extra;
	private AddSlider slide;
	
	//For calculations of total.
	int total;
	int dormPrice = ALLEN_HALL;
	int mealPrice = SEVEN_MEALS;
	
	/**
	 * Constructor
	 */
	public CollegePlanCalculator() 
	{
		//Set the title
		setTitle("College Plan Calculator");
		
		//Specify an action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Choose a layout:
		setLayout(new GridLayout(3,1));
		
		//Create panel objects.
		extra = new ExtraServices();
		slide = new AddSlider();
		
		//Create the results panel:
		JPanel resultsPanel=new JPanel();
		totalLabel= new JLabel("Total cost: ");
		totalField = new JTextField("$" + total,10);
		totalField.setEditable(false);
		
		findTotal = new JButton("Calculate Order");
		findTotal.addActionListener(new TotalListener());
		
		resultsPanel.add(findTotal);
		resultsPanel.add(totalLabel);
		resultsPanel.add(totalField);
		
		
		//Add everything into the window:
		buildMenuBar();
		add(extra);
		add(slide);
		add(resultsPanel);

		
		//Pack and display
		pack();
		setVisible(true);
	}
	
	/**
	 * Method for building the windows menu.
	 */
	public void buildMenuBar()
	{
		//Create menu bar object.
		menuBar = new JMenuBar();
		
		//Access each part of the menu to create.
		buildDorm();
		buildMeals();
		
		//Add to menu bar.
		menuBar.add(dorm);
		menuBar.add(meal);
		
		setJMenuBar(menuBar);
		
	}
	
	/**
	 * Method for building the dorm list on 
	 * the menu bar.
	 */
	private void buildDorm()
	{
		//Declare each menu item in the dorm menu.
		//Also adding Mnemonics.
		allen = new JRadioButtonMenuItem("Allen Hall",true);
		allen.setMnemonic(KeyEvent.VK_A);
		allen.addActionListener(new DormListener());
		
		pike = new JRadioButtonMenuItem("Pike Hall");
		pike.setMnemonic(KeyEvent.VK_P);
		pike.addActionListener(new DormListener());
		
		farthing = new JRadioButtonMenuItem("Farthing Hall");
		farthing.setMnemonic(KeyEvent.VK_F);
		farthing.addActionListener(new DormListener());
		
		suites = new JRadioButtonMenuItem("University Suites");
		suites.setMnemonic(KeyEvent.VK_S);
		suites.addActionListener(new DormListener());
		
		//Create group for buttons.
		ButtonGroup group = new ButtonGroup();
		
		//Add buttons to group.
		group.add(allen);
		group.add(pike);
		group.add(farthing);
		group.add(suites);
		
		//Create section of menu for dorms.
		dorm = new JMenu("Dorms");
		dorm.setMnemonic(KeyEvent.VK_D);
		
		//Add the dorms to the menu.
		dorm.add(allen);
		dorm.add(pike);
		dorm.add(farthing);
		dorm.add(suites);
		
	}
	
	/**
	 * Method for building the meal list on 
	 * the menu bar.
	 */
	private void buildMeals()
	{
		//Declare each menu item in the meal menu.
		//Also adding Mnemonics.
		sevenMeals = new JRadioButtonMenuItem("7 Meals/Week",true);
		sevenMeals.setMnemonic(KeyEvent.VK_7);
		sevenMeals.addActionListener(new MealListener());
		
		fourteenMeals = new JRadioButtonMenuItem("14 Meals/Week");
		fourteenMeals.setMnemonic(KeyEvent.VK_4);
		fourteenMeals.addActionListener(new MealListener());
		
		infiniteMeals = new JRadioButtonMenuItem("All you can eat!");
		infiniteMeals.setMnemonic(KeyEvent.VK_8);
		infiniteMeals.addActionListener(new MealListener());
		
		//Create group for buttons.
		ButtonGroup group = new ButtonGroup();
		
		//Add buttons to group.
		group.add(sevenMeals);
		group.add(fourteenMeals);
		group.add(infiniteMeals);
		
		//Create section of menu for meal plans.
		meal = new JMenu("Meals");
		meal.setMnemonic(KeyEvent.VK_M);
		
		//Add the meals to the menu.
		meal.add(sevenMeals);
		meal.add(fourteenMeals);
		meal.add(infiniteMeals);
		
	}
	
	/**
	 * Listener for the dorm menu.
	 */
	private class DormListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(pike.isSelected())
				dormPrice = PIKE_HALL;
			else if(farthing.isSelected())
				dormPrice = FARTHING_HALL;
			else if(suites.isSelected())
				dormPrice = UNIVERSITY_SUITES;
			else
				dormPrice = ALLEN_HALL;
		}
	}
	
	/**
	 * Listener for the meal menu.
	 */
	private class MealListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(fourteenMeals.isSelected())
				mealPrice = FOURTEEN_MEALS;
			else if(infiniteMeals.isSelected())
				mealPrice = UNLIMITED_MEALS;
			else
				mealPrice = SEVEN_MEALS;
		}
	}
	
	/**
	 * Listener for the calculate order button.
	 */
	private class TotalListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
		
			int slider = slide.getSliderValue();
			total = slider+dormPrice+mealPrice+extra.getExtras();
			
			totalField.setText("$"+Integer.toString(total));
		}
		
	}
	
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new CollegePlanCalculator();
	}
	
}