/**
 * <b>Musterlösung</b><br>
 * Alle Werte zwischen 0 und 9 eines Arrays ausgeben, die nicht
 * im Array vorkommen.
 */
public class NichtEnthalteneElemente {

	/**
	 * Erzeugt ein int-Array und befüllt die Elemente mit Zufallswerten
	 * zwischen 0 und 9.
	 * @param anzahlElemente Anzahl der Elemente des erzeugten Arrays.
	 * @return Das Array mit den Zufallswerten.
	 */
	static int[] createArray(int anzahlElemente) {
		int[] array = new int[anzahlElemente];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random()*10);
		}
		return array;
	}

	/**
	 * Suche alle Werte zwischen 0 und 9, die nicht im Array vorkommen.
	 * @param array Das zu durchsuchende Array.
	 */
	static void printElementes(int[] array) {
		// Array mit 10 Boolean-Elementen; mit false initialisiert.
		boolean[] vorkommnis = new boolean[10];
		// Setze für jeden gefundenen Wert am entsprechenden Index im
		// boolean-Array true.
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= 0 && array[i] <= 9) {
				vorkommnis[array[i]] = true;
			} 
		}
		// Gib alle Werte (Indizes) aus, die im boolschen-Array nicht auf true
		// gesetzt wurden.
		for (int i = 0; i < vorkommnis.length; i++) {
			if (!vorkommnis[i]) {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		int[] array = createArray(10);
		printElementes(array);
	}
	
}
