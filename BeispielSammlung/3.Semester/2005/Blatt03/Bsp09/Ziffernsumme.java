
/**
 * @author Clemens Klee<br>
 * Erstellt am 25.10.2005<br>
 * Version 1.0
 */
public class Ziffernsumme {
	
	/**
	 * Errechnet die Ziffernsumme einer ganzen Zahl.
	 * @param zahl Die Zahl deren Ziffernsumme errechnet werden soll.
	 * @return Die Ziffernsumme der Zahl.
	 */
	static int ziffernsumme(int zahl){
		int neueZahl = 0;
		while(zahl!=0){
			//addiere zu neueZahl die letzte Stelle der übergebenen
			//Zahl hinzu (Modulo mit 10)
			neueZahl = neueZahl + zahl % 10;

			//verschiebe die übergebene Zahl um eine Stelle nach rechts
			zahl = zahl/10;
		}
		return neueZahl;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("Zahl: ");
		int x = In.readInt();
		System.out.println("Ziffernsumme: " + ziffernsumme(x));
	}

}
