package Bsp04;

import MoessenboeckIO.*;

/**
 * <b>Musterlösung</b><br>
 * List eine Liste von Namen aus einer Datei, formatiert diese um
 * und schreibt die umformatierten Namen wieder in eine Datei.
 */
public class NamenFormatieren {

	public static void main(String[] args) {
		// Öffne die Quelldatei mit Namen
		In.open("Bsp04/namen.dat");
		if (In.done()) {
			// Erzeuge die Zieldatei der formatierten Namen
			Out.open("Bsp04/namen_formatiert.dat");
			if (Out.done()) {
				// Solange Eingabedaten vorhanden sind -> Konvertiere eine Namenszeile
				while (In.done()) {
					convertNameLine();
				}
				// Dateien schließen
				Out.close();
				In.close();
				System.out.println("Namen erfolgreich umformatiert.");
			} else {
				System.out.println("Datei Bsp04/namen_formatiert.dat konnte nicht erstellt werden.");
				In.close();
			}
		} else {
			System.out.println("Datei Bsp04/namen.dat konnte nicht geöffnet werden.");
		}
	}

	/**
	 * Liest eine Zeile mit einem Namen aus der Quelldatei und schreibt den formatierten Namen
	 * in die Ausgabedatei
	 */
	static void convertNameLine() {
		// einen Namen einlesen
		String vorname = In.readWord();
		String vorname2 = In.readWord();
		String nachname = In.readLine().trim();
		// erzeuge eine Ausgabezeile nur dann, wenn die Namen korrekt eingelesen werden konnten
		if (In.done()) {
			// Prüfe, ob der Name einen zweiten Vornamen besitzt
			if (nachname.equals("")) {
				nachname = vorname2;
				vorname2 = null;
			}
			Out.print(nachname+", "+vorname);
			if (vorname2 != null) {
				// Optionale Ausgabe des zweiten Vornamen
				Out.print(" "+vorname2.charAt(0)+".");
			}
			Out.println();
		}
	}

}
