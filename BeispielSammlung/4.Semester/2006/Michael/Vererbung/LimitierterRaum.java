
public abstract class LimitierterRaum extends Raum {
	
    //	Attribute
	private int max_persons;
	private int act_persons;
	
	
	// Konstruktor
	public LimitierterRaum()
	{
		super();
	}
	
	public LimitierterRaum(String name)
	{
		super(name); 
	}
	
    //	Methoden
	public void enterPerson()
	{
		act_persons++;
	}
	
	public void leavePerson()
	{
		act_persons--;
	}
	
	public void setMax(int max)
	{
		max_persons = max;
	}
	
	public int getMax()
	{
		return max_persons;
	}
	
	public void setAct(int act)
	{
		act_persons = act;
	}
	
	public int getAct()
	{
		return act_persons;
	}

}
