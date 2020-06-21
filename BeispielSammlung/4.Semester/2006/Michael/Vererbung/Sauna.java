
public class Sauna extends LimitierterRaum {
    
	// Attribute
	private float temperatur;
	private float max_temperatur;
	
	// Konstruktor 
	public Sauna()
	{
		super();
	}
	
	public Sauna(String name)
	{
		super(name);
	}
	
	// Methoden
	public float getTemp()
	{
		return temperatur;
	}
	
	public void setTemp(float t)
	{
		temperatur = t;
	}
	
	public float getMaxTemp()
	{
		return max_temperatur;
	}
	
	public void setMaxTemp(float t)
	{
		max_temperatur = t;
	}

}
