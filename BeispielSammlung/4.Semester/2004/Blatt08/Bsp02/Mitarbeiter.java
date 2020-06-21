/**
 * <b>Musterlösung</b><br>
 * Beispiel Gehaltstabelle 
 */
public abstract class Mitarbeiter {

	private float gehalt;
	private String vorname;
	private String nachname;
	private String svnr;

	public Mitarbeiter(String vorname, String nachname, String svnr, float gehalt) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.svnr = svnr;
		this.gehalt = gehalt;
	}

	public String getName() {
		return vorname+" "+nachname;
	}

	public String getSvnr() {
		return svnr;
	}

	protected float getGehalt() {
		return gehalt;
	}

	public abstract float berechneGehalt(float unternehmenserfolg);

}
