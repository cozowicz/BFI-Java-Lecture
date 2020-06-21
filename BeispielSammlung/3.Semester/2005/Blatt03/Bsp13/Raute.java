/**
 * <b>Musterlösung</b><br>
 * Gibt eine aus *-Zeichen bestehende Raute aus.
 */
public class Raute {

	/**
	 * Gibt eine übergebene Anzahl von Leercheichen aus.
	 * @param anzahl Die Anzahl der auszugebenden Leerzeichen.
	 */
	static void printSpace(int anzahl) {
		for (int i = 0; i < anzahl; i++) {
			System.out.print(" ");
		}
	}

	/**
	 * Gibt eine Zeile der Raute aus.
	 * @param zeile Die auszugebende Zeilennummer.
	 * @param zeilen2 Position der Achse, um welche die Linien der Raute gespiegelt werden.
	 */
	static void printLine(int zeile, int zeilen2) {
		printSpace(zeilen2-zeile);
		System.out.print("*");
		printSpace(2*zeile-1);
		System.out.println("*");
	}

	public static void main(String[] args) {
		// Liest die Anzahl der Zeilen der Raute ein.
		System.out.print("Anzahl der Zeilen: ");
		int zeilen = In.readInt();
		int zeilen2 = zeilen/2;
		// Gibt das erste *-Zeichen aus. Sonderfall, da nur ein Stern in dieser Zeile steht.
		printSpace(zeilen2);
		System.out.println("*");
		// Gib die obere Hälfte der Raute aus.
		for (int zeile = 1; zeile < zeilen2; zeile++) {
			printLine(zeile, zeilen2);
		}
		// Gib die untere Hälfte der Raute aus.
		for (int zeile = zeilen-zeilen2-1; zeile > 0; zeile--) {
			printLine(zeile, zeilen2);
		}
		// Gibt das letzte *-Zeichen aus. Sonderfall, da nur ein Stern in dieser Zeile steht.
		printSpace(zeilen2);
		System.out.println("*");
	}
}
