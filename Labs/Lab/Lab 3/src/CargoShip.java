
public class CargoShip extends Ship {

	private int cargoTonnage;
	
	public CargoShip(int cargoTonnage, String name, String year){
		super(name,year);
		this.cargoTonnage=cargoTonnage;
	}
	
	public int getCargoTonnage() {
		return cargoTonnage;
	}
	
	public void setCargoTonnage(int cargoTonnage){
		this.cargoTonnage=cargoTonnage;
	}
	
	public String toString() {
		String str="Ship's name: "+this.getName()+"\nCargo capacity: "+cargoTonnage;
		return str;
	}
}