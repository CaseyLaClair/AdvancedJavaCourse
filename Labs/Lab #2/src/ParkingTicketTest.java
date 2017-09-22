import java.util.Scanner;


/**
 * This class tests the functionality of previous classes.
 * @author Casey LaClair
 *
 */


public class ParkingTicketTest 
{

	public static void main(String[] args) 
	{
		int input;
		ParkedCar.Make make = null;
		String model;
		String color;
		String licensePlate;
		int minutesParked;
		String officerName;
		String badgeNumber;
		int minutesPurchased;
		String yesOrNo;
		
		Scanner kb = new Scanner(System.in);
		
		do
		{
			do 
			{
				System.out.println("Choose Car Make:\n1 for FORD, 2 for LAMBO, 3 for TESLA:");
				input = kb.nextInt();
				
				switch(input) 
				{
					case 1 :
						make = ParkedCar.Make.FORD;
						break;
					case 2 : 
						make = ParkedCar.Make.LAMBO;
						break;
					case 3 : 
						make = ParkedCar.Make.TESLA;
						break;
					default : 
						System.out.println("Invalid choice, try again");
						break;
				}
				
			}while(input != 1 && input != 2 && input != 3);
			
			System.out.println("Enter Car Model: ");
			model = kb.nextLine();
			
			System.out.println("Enter Car Color: ");
			color = kb.nextLine();
			
			System.out.println("Enter License Plate #: ");
			licensePlate = kb.nextLine();
			
			System.out.println("Enter Minutes Parked: ");
			minutesParked = kb.nextInt();
					
			System.out.println("Enter Officers Name: ");
			officerName = kb.nextLine();
			
			System.out.println("Enter Officers Badge #: ");
			badgeNumber = kb.nextLine();
			
			System.out.println("Enter Minutes Purchased: ");
			minutesPurchased = kb.nextInt();
			
			ParkedCar car = new ParkedCar(make, model, color, licensePlate, minutesParked);
			PoliceOfficer officer = new PoliceOfficer(officerName, badgeNumber);
			ParkingMeter meter = new ParkingMeter(minutesPurchased);
		
			if (officer.expiredCheck(meter, car)) 
			{
				ParkingTicket ticket = officer.issueTicket(meter, car);
				System.out.println(ticket.getFine());
				System.out.println(ticket.getNumTickets() + "\n");
				System.out.println(ticket.toString());		
			}
			
			System.out.println("Want to add another ticket? Y/N");
			yesOrNo = kb.nextLine();
			
		}while(yesOrNo.equalsIgnoreCase("Y"));

		kb.close();
	}

}