/**
 * <b>Musterlösung</b><br>
 * Beispiel Gehaltstabelle 
 */
public class Unternehmen {

	private Mitarbeiter[] mitarbeiter;
	private int anzahlMitarbeiter;
	
	public Unternehmen(int maxAnzahlMitarbeiter) {
		mitarbeiter = new Mitarbeiter[maxAnzahlMitarbeiter];
		anzahlMitarbeiter = 0;
	}
	
	public boolean mitarbeiterAnstellen(Mitarbeiter ma) {
		if (anzahlMitarbeiter < mitarbeiter.length) {
			mitarbeiter[anzahlMitarbeiter++] = ma;
			return true;
		} else {
			return false;
		}
	}
	
	public void gehaltstabelle(float unternehmenserfolg, String dateiname) {
		Out.open(dateiname);
		if (Out.done()) {
			for (int i = 0; i < anzahlMitarbeiter && Out.done(); i++) {
				Out.print(mitarbeiter[i].getName());
				Out.print("\t");
				Out.print(mitarbeiter[i].getSvnr());
				Out.print("\t");
				Out.println(mitarbeiter[i].berechneGehalt(unternehmenserfolg));
			}
			Out.close();
		}
	}
	
}
