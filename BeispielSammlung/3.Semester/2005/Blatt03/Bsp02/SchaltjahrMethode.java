/**
 * <b>Musterlösung</b><br>
 * Beispielprogramm zur Demonstration von Methoden in Java. Das Beispiel
 * zeigt eine Methode zur Bestimmung eines Schaltjahrs.
 * 
 * @author Martin Trummer
 */
public class SchaltjahrMethode {

	/**
	 * Bestimmt, ob das übergebene Jahr ein Schaltjahr ist.
	 * @param jahr Das zu prüfende Jahr.
	 * @return <code>true</code>, wenn das übergebene Jahr ein Schaltjahr ist;
	 * ansonsten <code>false</code>.
	 */
	public static boolean istSchaltjahr(int jahr) {
		return (jahr % 400 == 0) || (jahr % 4 == 0 && jahr % 100 != 0);
	}

	/**
	 * Startmethode des Schaltjahrprogramms.
	 * @param args Kommandozeilenargumente, die dem Programm mitgegeben
	 * werden.
	 */
	public static void main(String[] args) {
		System.out.print("Jahr: ");
		int jahr = In.readInt();
		if (istSchaltjahr(jahr)) {
			System.out.println(jahr+" ist ein Schaltjahr.");
		} else {
			System.out.println(jahr+" ist kein Schaltjahr.");
		}
	}


}
