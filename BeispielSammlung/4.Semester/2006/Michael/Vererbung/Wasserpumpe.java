
public class Wasserpumpe extends Stromverbraucher {
	
	//	Attribute
	private float act_durchfluss;
	private float soll_durchfluss;

	// Konstruktor
	public Wasserpumpe()
	{
		super();
	}
	
	public Wasserpumpe(String name)
	{
		super(name);
	}
	
	// Methoden
	public void setActDurchfluss(float fluss)
	{
		act_durchfluss = fluss;
	}
	
	public float getActDurchfluss()
	{
		return act_durchfluss;
	}
	
	public void setSollDurchfluss(float fluss)
	{
		soll_durchfluss = fluss;
	}
	
	public float getSollDurchfluss()
	{
		return soll_durchfluss;
	}
}
