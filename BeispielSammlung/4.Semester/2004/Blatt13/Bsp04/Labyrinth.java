public class Labyrinth {

	private int startPosZeile = 0;
	private int startPosSpalte = 0;
	private int breite = 0;
	private int hoehe = 0;
	private char[][] labyrinth;

	public void readLabyrinth(String datei) {
		In.open(datei);
		if (In.done()) {
			breite = In.readInt();
			hoehe = In.readInt();
			labyrinth = new char[hoehe][breite];
			for (int zeile = 0; zeile < hoehe; zeile++) {
				In.readLine();
				for (int spalte = 0; spalte < breite; spalte++) {
					labyrinth[zeile][spalte] = In.read();
					if (labyrinth[zeile][spalte] == 'S') {
						startPosZeile = zeile;
						startPosSpalte = spalte;
					}
				}
			}
			In.close();
		} else {
			System.out.println("Datei "+datei+" nicht gefunden.");
			labyrinth = null;
		}
	}

	public void printLabyrinth() {
		if (labyrinth != null) {
			for (int zeile = 0; zeile < labyrinth.length; zeile++) {
				for (int spalte = 0; spalte < labyrinth[zeile].length; spalte++) {
					System.out.print(labyrinth[zeile][spalte]);
				}
				System.out.println();
			}
		}
	}
	
	public boolean findPath() {
		if (labyrinth != null) {
			boolean canExit = findPath(startPosZeile, startPosSpalte);
			// Der Startpunkt wurde durch ein '.'-Zeichen überschrieben, 'S' wiederherstellen
			labyrinth[startPosZeile][startPosSpalte] = 'S';
			return canExit;
		} else {
			return false;
		}
	}
	
	private boolean findPath(int zeile, int spalte) {
		if (zeile < 0 || zeile >= hoehe || spalte < 0 || spalte >= breite) {
			// Wir sind ausserhalb des Labyrinths, ein Weg wurde gefunden!
			return true;
		}
		if (labyrinth[zeile][spalte] == ' ' || labyrinth[zeile][spalte] == 'S') {
			labyrinth[zeile][spalte] = '.';
			boolean canExit = findPath(zeile+1, spalte) || // unten 
				   			  findPath(zeile, spalte+1) || // rechts
				              findPath(zeile-1, spalte) || // oben 
				              findPath(zeile, spalte-1);   // links
			if (!canExit) {
				labyrinth[zeile][spalte] = '-';
			}
			return canExit;
		}
		return false;
	}

	public static void main(String[] args) {
		Labyrinth l = new Labyrinth();
		l.readLabyrinth("Bsp04/labyrinth.dat");
		if (l.findPath()) {
			System.out.println("Weg aus dem Labyrinth gefunden!");
		} else {
			System.out.println("Es gibt keinen Weg aus dem Labyrinth!");
		}
		System.out.println();
		l.printLabyrinth();
	}
}
