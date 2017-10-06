
public class CruiseShip extends Ship {
	
	private int maxPassengers;
	
	public CruiseShip(int maxPassengers, String name, String year){
		super(name,year);
		this.maxPassengers=maxPassengers;
	}
	
	public int getMaxPassengers() {
		return maxPassengers;
	}
	
	public void setMaxPassengers(int maxPassengers){
		this.maxPassengers=maxPassengers;
	}
	
	public String toString() {
		String str="Ship's name: "+this.getName()+"\nMax passengers: "+maxPassengers;
		return str;
	}

}