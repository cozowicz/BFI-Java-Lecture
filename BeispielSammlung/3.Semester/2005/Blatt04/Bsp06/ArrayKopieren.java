/**
 * <b>Musterlösung</b><br>
 * Kopieren eines zweidimensionalen float-Arrays.
 */
public class ArrayKopieren {

	/**
	 * Kopiert ein zweidimensionales float-Array. Berücksichtigt beim
	 * Kopieren null-Werte.
	 * @param quelle Das zu kopierende Array.
	 * @return Das kopierte Array.
	 */
	static float[][] copyArray(float[][] quelle) {
		// Absturz bei Übergabe von null vermeiden
		if (quelle != null) {
			float[][] ziel = new float[quelle.length][];
			// Kopieren der einzelnen Zeilen des Arrays
			for (int i = 0; i < quelle.length; i++) {
				// Ist die Zeile null?
				if (quelle[i] != null) {
					// nein, dann kopiere die Zeile
					ziel[i] = new float[quelle[i].length];
					for (int j = 0; j < quelle[i].length; j++) {
						ziel[i][j] = quelle[i][j];
					}
				} else {
					// ja, dann übernimm den Wert null in das Zielarray
					ziel[i] = null;
				}
			}
			return ziel;
		} else {
			// Bei Übergabe von null wird null zurückgegeben
			return null;
		}
	}

	/**
	 * Main-Methode mit Testfällen.
	 */
	public static void main(String[] args) {
		// Testfall 1: Normales Array
		float[][] array1 = { {1.5f, 2, 3}, {9, 5.2f}, {1, 7, 10.89f, 30}, {4} };
		float[][] kopieVonArray1 = copyArray(array1);

		// Testfall 2: Array mit leerem Array
		float[][] array2 = { {1.5f, 2, 3}, {}, {1, 7, 10.89f, 30}, {} };
		float[][] kopieVonArray2 = copyArray(array1);

		// Testfall 3: Array mit null-Wert
		float[][] array3 = { null, {1, 7, 10.89f, 30}, null };
		float[][] kopieVonArray3 = copyArray(array1);
		
		// Testfall 4: null-Wert
		float[][] array4 = null;
		float[][] kopieVonArray4 = copyArray(array1);
	}

}
