
public class Raum extends CheckedItem {
	
    //	 Attribute
	private Bau bau;
	private java.util.Set equipments;
	
	
	// Konstruktor
	public Raum()
	{
		super();
		equipments = new java.util.HashSet();
	}
	
	public Raum(String name)
	{
		super(name);
		equipments = new java.util.HashSet();
	}
	
	//	 Methoden
	public void check()
	{
		
	}
	
	public void addEquipment(Equipment eq)
	{
		equipments.add(eq);
		eq.setRaum(this);
	}
	
	public void removeEquipment(Equipment eq)
	{
		equipments.remove(eq);
		eq.setRaum(null);
	}
	
	public Bau getBau()
	{
		return bau;
	}
	
	public void setBau(Bau iBau)
	{
		bau = iBau;
	}
	
	public String locationString()
	{
		return bau.getName()+"::"+getName();
	}
	
	
	
}
