/**
 * <b>Musterlösung</b><br>
 * Implementiert ein Wörterbuch.
 */
public class Dictionary {

	private Translation[] translations = new Translation[1000];
	private int anzahl = 0;

	public boolean insert(String wortSprache1, String wortSprache2) {
		// ist im Wörterbuch noch Platz?
		if (anzahl < translations.length) {
			String uebersetzung = lookup(wortSprache1);
			if (uebersetzung == null) {
				translations[anzahl++] = new Translation(wortSprache1, wortSprache2);
				return true;
			}
		}
		return false;
	}
	
	public void remove(String wortSprache1) {
		int i = 0;
		boolean found = false;
		while (i < anzahl && !found) {
			Translation t = translations[i++];
			if (t.getWortSprache1().equals(wortSprache1)) {
				translations[i-1] = null;
				found = true;
			}
		}
		if (found) {
			while (i < anzahl) {
				translations[i-1] = translations[i++];					
			}
			anzahl--;
			translations[anzahl] = null;
		}
	}
	
	public String lookup(String wortSprache1) {
		for (int i = 0; i < anzahl; i++) {
			Translation t = translations[i];
			if (t.getWortSprache1().equals(wortSprache1)) {
				return t.getWortSprache2();
			}
		}
		return null;
	}
	
}
