import java.awt.event.*;

/**
 * The ShipButtonListener listens for radio button clicks selecting different ships in the ship type panel.
 * @author Maggie
 *
 */
public class ShipButtonListener implements ActionListener {

	private ShipDataPanel shipDataPanel;
	
	/**
	 * Constructor.
	 * @param shipDataPanel  This is the panel that will change contents based on a click.
	 */
	public ShipButtonListener(ShipDataPanel shipDataPanel){
		this.shipDataPanel=shipDataPanel;
	}
	
	/**
	 * Depending on which radio button was clicked, have the ship data panel set up to collect
	 * different information.
	 */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand() == ShipTypePanel.SHIP) 
			shipDataPanel.showShipFields();
		else if (e.getActionCommand() == ShipTypePanel.CRUISE_SHIP)
			shipDataPanel.showCruiseShipFields();
		else if (e.getActionCommand() == ShipTypePanel.CARGO_SHIP)
			shipDataPanel.showCargoShipFields();
		else if (e.getActionCommand() == ShipTypePanel.NAVAL_SHIP)
			shipDataPanel.showNavalShipFields();
		
	}
	
	

}