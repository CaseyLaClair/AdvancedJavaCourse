public class CruiseShip extends Ship
{
	private int maxPassengers;

	CruiseShip(int maxPassengers, String name, String year)
	{
		super(name, year);
		this.maxPassengers = maxPassengers;
	}

	public int getMaxPassengers()
	{
		return maxPassengers;
	}

	public void setMaxPassengers(int maxPassengers)
	{
		this.maxPassengers = maxPassengers;
	}

	@Override
	public String toString()
	{
		return String.format("%s\nMax Passengers: %d", super.toString(), maxPassengers);
	}

	@Override
	public String getSaveState()
	{
		return String.format("%s#%d", super.getSaveState(), maxPassengers);
	}
}
