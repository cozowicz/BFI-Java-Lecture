
public abstract class Stromverbraucher extends Equipment {
	
	// Attribute
	private float stromaufnahme;
	private boolean is_operating;
	
	// Konstruktor
	public Stromverbraucher()
	{
		super();
	}
	 
	 public Stromverbraucher(String name)
	{
		super(name);
	}
	
	// Methoden
	public void setStromaufnahme(float strom)
	{
		stromaufnahme = strom;
	}
	
	public float getStromaufnahme()
	{
		return stromaufnahme;
	}
	
	public boolean getOperationStatus()
	{
		return is_operating;
	}
	
	public void setOperationStatus(boolean status)
	{
		is_operating = status;
	}
	
}
