/**
 * <b>Musterl�sung</b><br>
 * Nat�rliche Person.
 */
public class NatuerlichePerson extends Person {

	private String vorname;
	private String nachname;
	
	public NatuerlichePerson(String vorname, String nachname, String adresse) {
		super(adresse);
		this.vorname = vorname;
		this.nachname = nachname;
	}
	
	public String getName() {
		return vorname+" "+nachname;
	}

}
