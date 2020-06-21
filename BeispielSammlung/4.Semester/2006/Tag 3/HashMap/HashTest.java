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
public class HashTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMapDemo hm = new HashMapDemo();
		try {
			hm.read("Kunden.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		hm.test();
	}

}
