public class CargoShip extends Ship
{
	private int cargoTonnage;

	public CargoShip(int cargoTonnage, String name, String year)
	{
		super(name, year);
		this.cargoTonnage = cargoTonnage;
	}

	public int getCargoTonnage()
	{
		return cargoTonnage;
	}

	public void setCargoTonnage(int cargoTonnage)
	{
		this.cargoTonnage = cargoTonnage;
	}

	@Override
	public String toString()
	{
		return String.format("%s\nCargo Tonnage: %d", super.toString(), cargoTonnage);
	}

	@Override
	public String getSaveState()
	{
		return String.format("%s#%d", super.getSaveState(), cargoTonnage);
	}
}
