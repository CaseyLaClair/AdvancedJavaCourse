public class Ship implements Saveable
{
	private String name;
	private String year;

	Ship(String name, String year)
	{
		this.name = name;
		this.year = year;
	}

	public String getName()
	{
		return name;
	}

	public String getYear()
	{
		return year;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setYear(String year)
	{
		this.year = year;
	}

	@Override
	public String toString()
	{
		return String.format("Name: %s\nYear: %s", name, year);
	}

	public String getSaveState()
	{
		return String.format("%s#%s#%s", this.getClass().getSimpleName(), name, year);
	}
}
