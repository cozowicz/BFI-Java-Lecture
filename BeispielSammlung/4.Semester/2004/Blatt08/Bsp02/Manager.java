/**
 * <b>Musterlösung</b><br>
 * Beispiel Gehaltstabelle 
 */
public class Manager extends Mitarbeiter {
	
	private float praemienanteilGehalt;

	public Manager(String vorname, String nachname, String svnr, 
				   float fixanteilGehalt, float praemienanteilGehalt) {
		super(vorname, nachname, svnr, fixanteilGehalt);
		this.praemienanteilGehalt = praemienanteilGehalt;
	}

	public float berechneGehalt(float unternehmenserfolg) {
		return getGehalt()+unternehmenserfolg*praemienanteilGehalt;
	}
	
}