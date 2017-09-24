import java.util.Scanner;
public class ParkingTicketSimulatorTest {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) 
	{
		//Create scanner
		Scanner scan = new Scanner(System.in);
		
		// to hold 'y' or 'n'
		char con;
		
		// Declare variables to be used for object values
		String done, make, model, color, plate, name, badge;
		int minutesParked, purchasedMins;
		
		
			

			// loop for user input
		do {
				// Prompt for car make
				System.out.print("What is the make of the car? ");
				make = scan.nextLine();
				// Prompt for car model
				System.out.print("What is the model of the car? ");
				model = scan.nextLine();
				// Prompt for color
				System.out.print("What is the color of the car? ");
				color = scan.nextLine();
				// Prompt for plate number
				System.out.print("What is the car's plate number? ");
				plate = scan.nextLine();
				// Prompt for minutes parked
				System.out.print("How many minutes has the car been parked? ");
				minutesParked = scan.nextInt();
				// Prompt for minutes purchased
				System.out.print("How many minutes were purchased? ");
				purchasedMins = scan.nextInt();
				scan.nextLine();
				// Prompt for officer name
				System.out.print("Officer name? ");
				name = scan.nextLine();
				// Prompt for officer badge number
				System.out.print("Officer badge number? ");
				badge = scan.nextLine();
			
				//Create objects
				ParkingMeter meter = new ParkingMeter(purchasedMins);
				ParkedCar car = new ParkedCar(make,model, color, plate, minutesParked);
				PoliceOfficer officer = new PoliceOfficer(name, badge);
		
				if (officer.determineExpiration(meter, car)) 
				{
					ParkingTicket ticket = officer.issueTicket(meter, car);
					System.out.println(ticket.getFine());
					System.out.println(ticket.getNumTicketsCount());
				}
				
				// ask user if they are done
				System.out.print("Do you want to continue? ");
				done = scan.nextLine();
				con = done.charAt(0);
			} while(con == 'Y' || con == 'y');
		
	}

}
