import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Class that creates a extra services panel.
 * @author Casey LaClair
 */
public class ExtraServices extends JPanel
{
	//Constants for extra services.
	private final int PARKING = 25;
	private final int SOUND_PROOF = 50;
	private final int KING = 750;
	private final int SECURE = 300;
	
	private JLabel parking;
	private JLabel soundProof;
	private JLabel kingCrown;
	private JLabel security;
	private JCheckBox park;
	private JCheckBox sound;
	private JCheckBox king;
	private JCheckBox secure;
	
	/**
	 * Constructor
	 */
	public ExtraServices()
	{
		//Set layout and border.
		setLayout(new GridLayout(2, 4));
		setBorder(BorderFactory.createTitledBorder("Extra Services"));
		
		//Create labels for extra services.
		parking = new JLabel("Parking: $25");
		soundProof = new JLabel("Sound Proof Room: $50");
		kingCrown = new JLabel("Useless Crown: $750");
		security = new JLabel("High Tech Room Security: $300");
		
		//Create check boxes for extra services.
		park = new JCheckBox();
		sound = new JCheckBox();
		king = new JCheckBox();
		secure = new JCheckBox();
		
		//Add all components to the panel.
		add(parking);
		add(soundProof);
		add(kingCrown);
		add(security);
		add(park);
		add(sound);
		add(king);
		add(secure);
		
	}
	
	/**
	 * Accessor for the value of all extras.
	 * @return value of extra services
	 */
	public int getExtras()
	{
		int total = 0;
		
		if(park.isSelected())
			total += PARKING;
		if(sound.isSelected())
			total += SOUND_PROOF;
		if(king.isSelected())
			total += KING;
		if(secure.isSelected())
			total += SECURE;
		return total;
	}
}
