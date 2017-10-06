import java.util.Random;
import javax.swing.JOptionPane;

public class ShipTest {

	public static Ship createShip(){
		Ship ship;
		String name=JOptionPane.showInputDialog("What is the name of the ship?");
		String year=JOptionPane.showInputDialog("In what year was the ship built?");
		ship=new Ship(name,year);
		return ship;
	}
	
	public static Ship createCruiseShip() {
		CruiseShip ship;
		String name=JOptionPane.showInputDialog("What is the name of the cruise ship?");
		String year=JOptionPane.showInputDialog("In what year was the cruise ship built?");
		int maxCapacity=Integer.parseInt(JOptionPane.showInputDialog("What is the maximum capacity of the cruise ship?"));
		ship = new CruiseShip(maxCapacity,name,year);
		return ship;
	}
	
	public static Ship createCargoShip(){
		CargoShip ship;
		String name=JOptionPane.showInputDialog("What is the name of the cargo ship?");
		String year=JOptionPane.showInputDialog("In what year was the cargo ship built?");
		int maxTonnage=Integer.parseInt(JOptionPane.showInputDialog("What is the maximum tonnage of the cargo ship?"));
		ship = new CargoShip(maxTonnage,name,year);
		return ship;
	}
	
	public static void main(String[] args) {
		Ship[] ships= new Ship[5];
		Random randNums=new Random();
		
		for (int i=0; i<ships.length; i++){
			int num=randNums.nextInt(3);
			switch (num) {
				case 0:
				{ships[i]=createShip(); break;
				}
				case 1:
				{ships[i]=createCruiseShip(); break;
				}
				case 2:
				{ships[i]=createCargoShip(); break;
				}
			}
		}
		
		for (int i=0; i<ships.length; i++){
			System.out.println(ships[i].toString());
		}
	}

}