
/**
 * This class tests the functionality of previous classes.
 * @author Casey LaClair
 *
 */


public class ParkingTicketTest 
{

	public static void main(String[] args) 
	{
		
		ParkingMeter meter = new ParkingMeter(120);
		ParkedCar car = new ParkedCar("Ford", "Focus", "White", "BATMAN1", 121);
		PoliceOfficer officer = new PoliceOfficer("Hutch","299792458");
		
		if (officer.expiredCheck(meter, car)) 
		{
			ParkingTicket ticket = officer.issueTicket(meter, car);
			System.out.println(ticket.getFine());
		}

	}

}