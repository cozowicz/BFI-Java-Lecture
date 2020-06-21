
public abstract class Equipment extends CheckedItem {
	
    //	Attribute
	private Raum raum;
	
	// Konstruktor
	public Equipment()
	{
		super();
	}
	
	public Equipment(String name)
	{
		super(name);
	}
	
	
	//	Methoden
	public void setRaum(Raum iRaum)
	{
		raum = iRaum;
	}
	
	public Raum getRaum()
	{
		return raum;
	}
	
	public void check()
	{
		
	}
	
	public String locationString()
	{
		return getRaum().getBau().getName()+ "::"+getRaum().getName()+"::"+getName();
	}
	
}
