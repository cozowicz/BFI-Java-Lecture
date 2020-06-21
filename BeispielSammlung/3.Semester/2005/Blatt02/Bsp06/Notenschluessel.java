/**
 * <b>Musterlösung</b><br>
 * Bestimmt die Note (1 bis 5) aus einem eingegebenen Prozentwert. 
 */
public class Notenschluessel {

	public static void main(String[] args) {
		System.out.print("Prozent: ");
		float prozent = In.readFloat();
		int note;
		if (prozent >= 88) {
			note = 1;
		} else if (prozent >= 75) {
			note = 2;
		} else if (prozent >= 63) {
			note = 3;
		} else if (prozent >= 50) {
			note = 4;
		} else {
			note = 5;
		}
		System.out.println("Note: "+note);
	}

}
