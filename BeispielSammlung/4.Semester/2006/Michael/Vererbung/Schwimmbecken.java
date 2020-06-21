
public class Schwimmbecken extends Equipment {
	
    // Attribute
	private float wasserguete;

	// Konstruktor
	public Schwimmbecken()
	{
		super();
	}
	
	public Schwimmbecken(String name)
	{
		super(name);
	}
	
	// Methoden
	public void setWasserguete(float guete)
	{
		wasserguete = guete;
	}
	
	public float getWasserguete()
	{
		return wasserguete;
	}

}
