
public class Bau extends CheckedItem {
	
	// Attribute
	private java.util.Set rooms;
	
	
	// Konstruktor
	public Bau()
	{
		super();
		rooms = new java.util.HashSet();
	}
	
	public Bau(String name)
	{
		super(name);
		rooms = new java.util.HashSet();
	}
	
	
	// Methoden
	public void addRoom(Raum raum)
	{
		rooms.add(raum);
		raum.setBau(this);
	}
	
	public void removeRomm(Raum iRaum)
	{
		rooms.remove(iRaum);
		iRaum.setBau(null);
	}
	
	public void check()
	{
		
	}
	
	public String locationString()
	{
		return getName();
	}
	
	public float gesamtVerbrauch()
	{
		return 0;
	}
	
}
