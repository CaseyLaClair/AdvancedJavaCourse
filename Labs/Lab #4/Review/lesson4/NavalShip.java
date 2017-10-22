public class NavalShip extends Ship
{
	private int compliment;

	public NavalShip(int compliment, String name, String year)
	{
		super(name, year);
		this.compliment = compliment;
	}

	public int getCompliment()
	{
		return compliment;
	}

	public void setCompliment(int compliment)
	{
		this.compliment = compliment;
	}

	@Override
	public String toString()
	{
		return String.format("%s\nCompliment: %d", super.toString(), compliment);
	}

	@Override
	public String getSaveState()
	{
		return String.format("%s#%d", super.getSaveState(), compliment);
	}
}
