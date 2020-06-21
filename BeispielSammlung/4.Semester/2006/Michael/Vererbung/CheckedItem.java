
public abstract class CheckedItem {
	
	
    // Attribute
	private String name;
	
	// Konstruktor
	public CheckedItem(String name)
	{
		setName(name);
	}
	
	public CheckedItem()
	{	
		setName("---"); 
	}
	
	
	// Methoden
	public void setName(String iName)
	{
		name = iName;
	}
	
	public String getName()
	{
		return name;
	}
	
	
	public abstract void check();
	public abstract String locationString();
	
}
