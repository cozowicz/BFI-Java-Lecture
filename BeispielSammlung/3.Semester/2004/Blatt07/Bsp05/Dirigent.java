public class Dirigent {

	private Musikant[] orchester = new Musikant[100];
	private int anzahlMusikanten = 0;
	
	/**
	 * Nimmt einen Musikanten ins Orchester auf.
	 * @param musikant Der aufzunehmende Musikant.
	 * @return true, wenn der Musikant aufgenommen wurde; ansonsten false.
	 */
	public boolean nimmInsOrchesterAuf(Musikant musikant) {
		if (anzahlMusikanten < orchester.length) {
			orchester[anzahlMusikanten++] = musikant;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Fordert die Musikanten des Orchesters anzahl oft auf ihren Beitrag
	 * für das Zufalls-Musikstück zu spielen.
	 * @param anzahl Anzahl der Aufforderungen an die Musikanten etwas
	 * zu spielen. 
	 */
	public void spiele(int anzahl) {
		// Spiele nur, wenn Musikanten im Orchester sind
		if (anzahlMusikanten > 0) {
			while (anzahl > 0) {
				int musikantIndex = (int) (anzahlMusikanten*Math.random());
				orchester[musikantIndex].spiele();
				anzahl--;
			}
		}
	}

}
