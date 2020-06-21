/**
 * <b>Musterlösung</b><br>
 * Berechnet den Absolutwert einer Zahl.
 */
public class Absolutwert {

	public static void main(String[] args) {
		int zahl = -17;	// Versuchen Sie auch andere Werte als -17
		int absZahl = (zahl >= 0 ? zahl : -zahl);
		System.out.println("Absolutwert von "+zahl+" ist "+absZahl+".");
	}

}
