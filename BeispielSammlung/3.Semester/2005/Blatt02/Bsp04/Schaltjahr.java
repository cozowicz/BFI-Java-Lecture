/**
 * <b>Musterlösung</b><br>
 * Bestimmt, ob ein eingegebenes Jahr ein Schaltjahr ist.
 */
public class Schaltjahr {

	public static void main(String[] args) {
		System.out.print("Jahr: ");
		int jahr = In.readInt();
		if ((jahr % 400 == 0) || (jahr % 4 == 0 && jahr % 100 != 0)) {
			System.out.println(jahr+" ist ein Schaltjahr.");
		} else {
			System.out.println(jahr+" ist kein Schaltjahr.");
		}
	}

}
