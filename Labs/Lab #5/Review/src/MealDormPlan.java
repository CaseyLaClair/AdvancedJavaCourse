/**
 * @author Andrew Norfolk
 * COMI-2510-600
 * 10/27/2017
 */

// Libraries
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

/**
 * The primary JFrame extension class
 */
public class MealDormPlan extends JFrame {
    // Constants for the window's dimensions
    private final int WINDOW_WIDTH = 600;
    private final int WINDOW_HEIGHT = 150;

    // Constants for dormitory pricing
    private final int ALLEN_HALL = 1500;
    private final int PIKE_HALL = 1600;
    private final int FARTHING_HALL = 1200;
    private final int UNIVERSITY_SUITES = 1800;

    // Constants for meal plan pricing
    private final int SEVEN_MEALS = 560;
    private final int FOURTEEN_MEALS = 1095;
    private final int UNLIMITED_MEALS = 1500;

    // Constants for extra service pricing
    private final int LAUNDRY_SERVICE = 500;
    private final int PIZZA_DELIVERY_SERVICE = 14000;

    // GUI object declarations here
    private JMenuBar menuBar;

    private JMenu mealChoice;
    private JMenu dormChoice;
    private JMenu extraServices;

    private JSlider chargeAccount;

    private JRadioButtonMenuItem allenItem;
    private JRadioButtonMenuItem pikeItem;
    private JRadioButtonMenuItem farthingItem;
    private JRadioButtonMenuItem universitySuitesItem;

    private JRadioButtonMenuItem sevenMealsItem;
    private JRadioButtonMenuItem fourteenMealsItem;
    private JRadioButtonMenuItem unlimitedMealsItem;

    private JCheckBoxMenuItem laundryService;
    private JCheckBoxMenuItem pizzaDelivery;

    private JLabel totalChargesLabel;

    // Initializing each charge value to zero so we don't run into any null pointer exceptions
    private int totalChargesDorm = 0;
    private int totalChargesMeal = 0;
    private int totalChargesExtraServices = 0;
    private int totalChargesChargeAccount = 0;
    private int totalChargesFinal = 0;

    private JPanel chargesPanel;

    /**
     * No-arg constructor to create the root JPanel
     */
    private MealDormPlan() {
        // Arbitrarily setting the window dimensions
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Meal & Dorm Plan");
        setLayout(new GridLayout(2, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        chargesPanel = new JPanel();

        totalChargesLabel = new JLabel();
        totalChargesLabel.setText("Total Cost: $0");
        chargesPanel.add(totalChargesLabel);

        buildSlider();
        buildMenuBar();

        add(chargesPanel);

        setVisible(true);
    }

    /**
     * Method to set the slider's properties and add it to the root JPanel
     */
    private void buildSlider() {
        chargeAccount = new JSlider(JSlider.HORIZONTAL, 100, 1000, 500);
        chargeAccount.setMajorTickSpacing(50);
        chargeAccount.setPaintTicks(true);
        chargeAccount.setPaintLabels(true);
        chargeAccount.setSnapToTicks(true);
        chargeAccount.addChangeListener(new ChargeAccountListener());
        add(chargeAccount);
    }

    /**
     * Method to build the main menu bar including adding menus
     */
    private void buildMenuBar() {
        menuBar = new JMenuBar();
        buildDormMenu();
        buildMealMenu();
        buildExtraServicesMenu();

        menuBar.add(dormChoice);
        menuBar.add(mealChoice);
        menuBar.add(extraServices);

        // Sets the window's JMenuBar
        setJMenuBar(menuBar);
    }

    /**
     * Method to build the extra services menu and add the respective services
     */
    private void buildExtraServicesMenu() {
        extraServices = new JMenu("Extra Services");
        laundryService = new JCheckBoxMenuItem("Laundry Service");
        laundryService.setMnemonic(KeyEvent.VK_L);
        laundryService.addActionListener(new ExtraServicesListener());

        pizzaDelivery = new JCheckBoxMenuItem("Pizza Delivery Service");
        pizzaDelivery.setMnemonic(KeyEvent.VK_P);
        pizzaDelivery.addActionListener(new ExtraServicesListener());

        extraServices.add(laundryService);
        extraServices.add(pizzaDelivery);

    }

    /**
     * Method to build the dorm menu and add the respective dorms
     */
    private void buildDormMenu() {
        dormChoice = new JMenu("Dormitory");

        // ALLEN HALL
        allenItem = new JRadioButtonMenuItem("Allen Hall");
        allenItem.setMnemonic(KeyEvent.VK_A);
        allenItem.addActionListener(new DormListener());

        // PIKE HALL
        pikeItem = new JRadioButtonMenuItem("Pike Hall");
        pikeItem.setMnemonic(KeyEvent.VK_P);
        pikeItem.addActionListener(new DormListener());

        // FARTHING HALL
        farthingItem = new JRadioButtonMenuItem("Farthing Hall");
        farthingItem.setMnemonic(KeyEvent.VK_F);
        farthingItem.addActionListener(new DormListener());

        // UNIVERSITY SUITES
        universitySuitesItem = new JRadioButtonMenuItem("University Suites");
        universitySuitesItem.setMnemonic(KeyEvent.VK_U);
        universitySuitesItem.addActionListener(new DormListener());

        // Setting the button group so only one radio option can be selected at a time
        ButtonGroup dormGroup = new ButtonGroup();
        dormGroup.add(allenItem);
        dormGroup.add(pikeItem);
        dormGroup.add(farthingItem);
        dormGroup.add(universitySuitesItem);

        dormChoice.add(allenItem);
        dormChoice.add(pikeItem);
        dormChoice.add(farthingItem);
        dormChoice.add(universitySuitesItem);
    }

    /**
     * Method to build the meal menu
     */
    private void buildMealMenu() {
        mealChoice = new JMenu("Meal Plan");

        // SEVEN MEALS A WEEK
        sevenMealsItem = new JRadioButtonMenuItem("Seven Meals a Week");
        sevenMealsItem.setMnemonic(KeyEvent.VK_S);
        sevenMealsItem.addActionListener(new MealListener());

        // FOURTEEN MEALS A WEEK
        fourteenMealsItem = new JRadioButtonMenuItem("Fourteen Meals a Week");
        fourteenMealsItem.setMnemonic(KeyEvent.VK_F);
        fourteenMealsItem.addActionListener(new MealListener());

        // UNLIMITED MEALS A WEEK
        unlimitedMealsItem = new JRadioButtonMenuItem("Unlimited Meals a Week");
        unlimitedMealsItem.setMnemonic(KeyEvent.VK_U);
        unlimitedMealsItem.addActionListener(new MealListener());

        // Creates a button group so only one option can be selected at a time
        ButtonGroup mealGroup = new ButtonGroup();
        mealGroup.add(sevenMealsItem);
        mealGroup.add(fourteenMealsItem);
        mealGroup.add(unlimitedMealsItem);

        mealChoice.add(sevenMealsItem);
        mealChoice.add(fourteenMealsItem);
        mealChoice.add(unlimitedMealsItem);
    }

    /**
     * ActionListener class for the dorm selection menu
     */
    private class DormListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (allenItem.isSelected()) {
                totalChargesDorm = ALLEN_HALL;
            }
            else if (pikeItem.isSelected()) {
                totalChargesDorm = PIKE_HALL;
            }
            else if (farthingItem.isSelected()) {
                totalChargesDorm = FARTHING_HALL;
            }
            else {
                totalChargesDorm = UNIVERSITY_SUITES;
            }
            // Calculates all of the total charges and updates the label accordingly
            totalChargesFinal = totalChargesDorm + totalChargesMeal + totalChargesChargeAccount +
                    totalChargesExtraServices;
            totalChargesLabel.setText("Total Price: $" + Integer.toString(totalChargesFinal));
        }
    }

    /**
     * ActionListener class for the meal plan selection menu
     */
    private class MealListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (sevenMealsItem.isSelected()) {
                totalChargesMeal = SEVEN_MEALS;
            }
            else if (fourteenMealsItem.isSelected()) {
                totalChargesMeal = FOURTEEN_MEALS;
            }
            else {
                totalChargesMeal = UNLIMITED_MEALS;
            }

            // Calculates all of the total charges and updates the label accordingly
            totalChargesFinal = totalChargesDorm + totalChargesMeal + totalChargesChargeAccount +
                    totalChargesExtraServices;
            totalChargesLabel.setText("Total Price: $" + Integer.toString(totalChargesFinal));
        }
    }

    /**
     * ActionListener class for the extra services selection menu
     */
    private class ExtraServicesListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	
        	int tempLaundry = 0;
        	int tempPizza = 0;
        	
            if (laundryService.isSelected()) {
                tempLaundry += LAUNDRY_SERVICE;
            }

            if (pizzaDelivery.isSelected()) {
                tempPizza += PIZZA_DELIVERY_SERVICE;
            }
            
            totalChargesExtraServices = tempLaundry + tempPizza;
            
            // Calculates all of the total charges and updates the label accordingly
            totalChargesFinal = totalChargesDorm + totalChargesMeal + totalChargesChargeAccount +
                    totalChargesExtraServices;
            totalChargesLabel.setText("Total Price: $" + Integer.toString(totalChargesFinal));
        }
    }

    /**
     * ChangeListener class for the charge account slider
     */
    private class ChargeAccountListener implements ChangeListener {
        public void stateChanged(ChangeEvent e){
            // Gets the value of the slider and sets the charges accordingly
            totalChargesChargeAccount = chargeAccount.getValue();

            // Calculates all of the total charges and updates the label accordingly
            totalChargesFinal = totalChargesDorm + totalChargesMeal + totalChargesChargeAccount +
                    totalChargesExtraServices;
            totalChargesLabel.setText("Total Price: $" + Integer.toString(totalChargesFinal));
        }
    }

    /**
     * Main method, calls MealDormPlan() to run the program
     * @param args
     */
    public static void main(String[] args) {
        new MealDormPlan();
    }
}