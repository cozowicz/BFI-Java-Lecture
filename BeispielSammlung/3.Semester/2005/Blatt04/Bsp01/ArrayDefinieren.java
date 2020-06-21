/**
 * <b>Musterl�sung</b><br>
 * Erzeugt ein Array mit eingebbar vielen Elementen und initialisiert
 * dieses absteigend.
 */
public class ArrayDefinieren {

	public static void main(String[] args) {
		System.out.print("Elementanzahl: ");
		int elementAnzahl = In.readInt();
		if (elementAnzahl >= 0) {
			int[] array = new int[elementAnzahl];
			// Pr�fen Sie das Ergebnis mit den Debugger, indem Sie auf die
			// n�chste Zeile einen Breakpoint setzen und das Programm im
			// Debug-Modus starten.
			for (int i = 0; i < array.length; i++) {
				array[i] = array.length-i;
			}
		} else {
			System.out.println("Elementanzahl mu� eine positive Zahl oder Null sein.");
		}
	}

}
