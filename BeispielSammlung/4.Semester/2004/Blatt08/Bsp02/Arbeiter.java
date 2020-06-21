/**
 * <b>Musterlösung</b><br>
 * Beispiel Gehaltstabelle 
 */
public class Arbeiter extends Mitarbeiter {
	
	public Arbeiter(String vorname, String nachname, String svnr, float gehalt) {
		super(vorname, nachname, svnr, gehalt);
	}

	public float berechneGehalt(float unternehmenserfolg) {
		return getGehalt();
	}

}