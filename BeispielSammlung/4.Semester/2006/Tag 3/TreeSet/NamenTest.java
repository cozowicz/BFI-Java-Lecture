/**
 * 
 */
package fh_vie.ac.at.Vorbereitung.Einheit3;

import java.io.IOException;

/**
 * @author Clemens Klee<br>
 * Erstellt am 16.03.2006<br>
 * Version 1.0
 */
public class NamenTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Namensverwaltung namen = new Namensverwaltung();
		try {
			namen.readNamen("Namen.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		namen.print();
	}

}
