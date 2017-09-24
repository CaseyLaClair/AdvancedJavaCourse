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
		//Declare variables to be used to create objects.
		int input, minutesParked, minutesPurchased;
		String model, color, licensePlate, officerName, badgeNumber, yesOrNo;
		ParkedCar.Make make = null;
		
		//Create scanner to read input
		Scanner kb = new Scanner(System.in);
		
		//Do loop to go through each entry to determine if parking ticket is needed.
		do
		{
			//Do loop to choose between the available makes of a car
			//and repeat through in case of invalid inputs.
			do 
			{
				//Choose between car makes.
				System.out.println("Choose Car Make:\n1 for FORD, 2 for LAMBO, 3 for TESLA:");
				input = kb.nextInt();
				
				//Switch to assign make variable based off int entry.
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
				
			//Continue loop if valid entry not accepted	
			}while(input != 1 && input != 2 && input != 3);
			
			//Consume next line.
			kb.nextLine();
			
			//Enter car model.
			System.out.println("Enter Car Model: ");
			model = kb.nextLine();
			
			//Enter car color.
			System.out.println("Enter Car Color: ");
			color = kb.nextLine();
			
			//Enter license plate
			System.out.println("Enter License Plate #: ");
			licensePlate = kb.nextLine();
			
			//Entry for minutes car was parked.
			System.out.println("Enter Minutes Parked: ");
			minutesParked = kb.nextInt();
			
			//Consume next line.
			kb.nextLine();
			
			//Enter officers name.
			System.out.println("Enter Officers Name: ");
			officerName = kb.nextLine();
			
			//Enter officers badge number..
			System.out.println("Enter Officers Badge #: ");
			badgeNumber = kb.nextLine();
			
			//Enter minutes purchased for car parked.
			System.out.println("Enter Minutes Purchased: \n");
			minutesPurchased = kb.nextInt();
			
			//Consume next line.
			kb.nextLine();
			
			//Create objects from data entered by user.
			ParkedCar car = new ParkedCar(make, model, color, licensePlate, minutesParked);
			PoliceOfficer officer = new PoliceOfficer(officerName, badgeNumber);
			ParkingMeter meter = new ParkingMeter(minutesPurchased);
		
			//Check if car has gone over purchased time.
			if (officer.expiredCheck(meter, car)) 
			{
				ParkingTicket ticket = officer.issueTicket(meter, car);
				System.out.println(ticket.toString());
				System.out.println("Number of Tickets: " + ticket.getNumTickets() + "\n");
			}
			
			//Request if user wants to evaluate another vehicle.
			System.out.println("Want to add another ticket? Y/N");
			yesOrNo = kb.nextLine();
			
		//Check if user enter Y for yes, else end.	
		}while(yesOrNo.equalsIgnoreCase("Y"));
		
		//Close scanner.
		kb.close();
	}

}