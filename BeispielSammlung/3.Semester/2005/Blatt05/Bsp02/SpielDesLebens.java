package Bsp02;

import MoessenboeckIO.*;

/**
 * <b>Musterlösung</b><br>
 * Spiel des Lebens.
 */
public class SpielDesLebens {

	public static void main(String[] args) {
		boolean[][] welt = readWorld();
		printWorld(welt);
		while (continueProgram()) {
			welt = nextGeneration(welt);
			printWorld(welt);
		}
	}

	/**
	 * Liest eine Zeile von Tastatur und ermittelt, ob das
	 * Programm fortgesetzt weden soll oder nicht.
	 * @return false, wenn quit eingegeben wurde; ansonsten
	 * true.
	 */
	public static boolean continueProgram() {
		System.out.print("<enter> um fortzusetzen; quit<enter> um zu beenden: ");
		String input = In.readLine();
		return !input.equalsIgnoreCase("quit");
	}

	/**
	 * Liest die Dimension und die Spielwelt-Matrix von
	 * Datei ein.
	 * @return Die Spielwelt-Matrix.
	 */
	private static boolean[][] readWorld() {
		In.open("Bsp01/input.dat");
		if (In.done()) {
			int dimension = In.readInt();
			boolean[][] welt = new boolean[dimension][dimension];
			for (int i = 0; i < dimension && In.done(); i++) {
				for (int j = 0; j < dimension && In.done(); j++) {
					char c = In.read();
					while (c != '0' && c != '1' && In.done()) {
						c = In.read();
					}
					welt[i][j] = (c == '1');
				}
			}
			if (!In.done()) {
				System.out.println("Fehler beim Lesen der Datei 'Bsp01/input.dat'.");
				return null;
			}
			In.close();
			return welt;
		} else {
			System.out.println("Datei 'Bsp01/input.dat' nicht gefunden.");
			return null;
		}
	}

	/**
	 * Gibt die übergebene Spielwelt-Matrix aus.
	 * @param welt Die auszugebene Spielwelt-Matrix.
	 */
	private static void printWorld(boolean[][] welt) {
		for (int i = 0; i < welt.length; i++) {
			for (int j = 0; j < welt[i].length; j++) {
				if (welt[i][j]) {
					System.out.print("X");
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}

	/**
	 * Berechnet die nächste Generation ausgehend von einer
	 * übergebenen Spielwelt. Die übergebene Spielwelt wird
	 * dabei nicht verändert.
	 * @param welt Die Spielwelt, von der aus die nächste
	 * Generation an Zellen berechnet werden soll.
	 * @return Eine Spielwelt mit der neuen Generation an
	 * Zellen.
	 */
	private static boolean[][] nextGeneration(boolean[][] welt) {
		boolean[][] entwickelteWelt = new boolean[welt.length][];
		// Durchwandere alle Zellen der Spielwelt-Matrix
		for (int i = 0; i < welt.length; i++) {
			entwickelteWelt[i] = new boolean[welt[i].length];
			for (int j = 0; j < welt[i].length; j++) {
				int neighbours = countNeighbours(welt, i, j);
				// Lebt die Zelle?
				if (welt[i][j]) {
					// ja, dann bestimme ob die Zelle am Leben bleibt.
					entwickelteWelt[i][j] = (neighbours == 2 || neighbours == 3);
				} else {
					// nein, dann bestimme ob die Zelle zum Leben erwacht.
					entwickelteWelt[i][j] = (neighbours == 3);
				}
			}
		}
		return entwickelteWelt;
	}

	/**
	 * Die relativen Positionen der Nachbarzellen:
	 * links-oben,links, links-unten, oben, unten,
	 * rechts-oben, rechts und rechts-unten
	 */
	private static final int[][] neighbourFields = { {-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1} };

	/**
	 * Zählt die Anzahl lebender Nachbarzellen zu einer
	 * gegebenen Zellposition in der Spielweltmatrix.
	 * @param welt Die Spielwelt-Matrix.
	 * @param zeile Zeilenposition der Zelle, deren
	 * lebenden Nachbarzellen gezählt werden sollen.
	 * @param spalte Spaltenposition der Zelle, deren
	 * lebenden Nachbarzellen gezählt werden sollen.
	 * @return Die Anzahl an lebenen Nachbarzellen.
	 */
	private static int countNeighbours(boolean[][] welt, int zeile, int spalte) {
		int neighbours = 0;
		// Gehe durch alle im Array neighbourFields definierten
		// Nachbarzellen und zähle die Anzahl der lebenen
		// Nachbarn.
		for (int i = 0; i < neighbourFields.length; i++) {
			neighbours += getFieldValue(welt, zeile+neighbourFields[i][0], spalte+neighbourFields[i][1]);
		}
		return neighbours;
	}

	/**
	 * Ermittelt, ob eine bestimmte Zelle auf der
	 * Spielwelt-Matrix lebt oder nicht. Dabei dürfen
	 * auch Zeilen-/Spaltenpositionen die größer gleich
	 * der Matrixdimension bzw. kleiner 0 sind übergeben
	 * werden.
	 * @param welt Die Spielwelt-Matrix.
	 * @param zeile Zeilenposition der Zelle.
	 * @param spalte Spaltenposition der Zelle.
	 * @return 1, wenn die Zelle lebt; 0, wenn die
	 * Zelle tot ist.
	 */
	private static int getFieldValue(boolean[][] welt, int zeile, int spalte) {
		int z = (zeile+welt.length)%welt.length;
		int s = (spalte+welt[z].length)%welt[z].length;
		return welt[z][s] ? 1 : 0;
	}

}
