/**
 * <b>Musterlösung</b><br>
 * Kehrt die Reihenfolge der Ziffern einer Zahl um. Aus beispielsweise
 * 517 wird 715. Aus 100 wird 001 was als 1 dargestellt wird.
 */
public class ZiffernUmkehren {

	/**
	 * Kehrt die Reihenfolge der Ziffern der übergebenen Zahl um.
	 * @param zahl Die Zahl deren Ziffernreihenfolge umgekehrt werden soll. 
	 * @return Die umgekehrte Zahl.
	 */
	static int ziffernUmkehren(int zahl) {
		int neueZahl = 0;
		while (zahl != 0) {
			// Schiebe die Ziffern der neuen Zahl um eine Stelle nach links
			// (Multiplikation mit 10) und addiere sie mit der Einerstelle
			// der ursprünglichen Zahl  
			neueZahl = neueZahl*10+zahl%10;
			// Schiebe die Ziffern der ursprünglichen Zahl um eine Stelle nach
			// rechts (Division durch 10)
			zahl /= 10;
		}
		return neueZahl;
	}

	public static void main(String[] args) {
		System.out.print("Zahl: ");
		int zahl = In.readInt();
		System.out.println("-> "+ziffernUmkehren(zahl));
	}
}
