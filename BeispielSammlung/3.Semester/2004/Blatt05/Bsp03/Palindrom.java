/**
 * <b>Musterlösung</b><br>
 * Ermittelt, ob ein Satz ein Palindrom ist. Palindrome sind Wörter oder Sätze
 * die vor- und rückwärts gelesen identisch sind. 
 */
public class Palindrom {

	/**
	 * Prüft, ob der übergebene Satz ein Palindrom ist.
	 * @param satz Ein Satz.
	 * @return True, wenn der Satz ein Palindrom ist; ansonsten false.  
	 */
	static boolean isPalindrom(String satz) {
		// Der erste Index beginnt am Beginn des Satzes, ...
		int startIndex = 0;
		// der zweite Index am Ende des Satzes.
		int endIndex = satz.length()-1;
		// Solange noch nicht alle Zeichen überprüft wurden...
		while (startIndex < endIndex) {
			char c1 = satz.charAt(startIndex);
			char c2 = satz.charAt(endIndex);
			if (Character.isLetter(c1)) {
				if (Character.isLetter(c2)) {
					// handelt es sich an beiden Stellen um Buchstaben, dann
					// sollen die Buchstaben case insensitive verglichen werden
					if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
						return false;
					} else {
						// die Buchstaben sind gleich -> erhöhe den Startindex 
						startIndex++; 
					}
				}
				// Wenn c1 ein Buchstabe ist, dann muss der Endindex auf jeden
				// Fall erniedigt werden. 
				endIndex--;
			} else {
				// Zeichen die keine Buchstaben sind werden überlesen
				startIndex++;
				if (!Character.isLetter(c2)) {
					// Zeichen die keine Buchstaben sind werden überlesen
					endIndex--;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.print("Satz: ");
		String satz = In.readLine();
		if (isPalindrom(satz)) {
			System.out.println("... ist ein Palindrom.");
		} else {
			System.out.println("... ist kein Palindrom.");
		}
	}
	
}
