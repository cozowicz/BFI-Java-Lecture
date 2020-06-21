package Bsp02;

import MoessenboeckIO.*;
/**
 * <b>Musterlösung</b><br>
 * Gibt alle Wörter eines Satzes einzeln aus.
 */
public class WoerterIdentifizieren {

	public static void main(String[] args) {
		System.out.print("Satz: ");
		String satz = In.readLine();
		boolean inWort = false;
		for (int i = 0; i < satz.length(); i++) {
			char c = satz.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				// Buchstabe eines Wortes
				inWort = true;
				System.out.print(c);
			} else {
				// kein Buchstabe => Leerzeichen, Satzzeichen, ...
				if (inWort) {
					System.out.println();
					inWort = false;
				}
			}
		}
	}

}
