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
public class ArtikelMapTest {

	/**
	 * @param args
	 * @throws  
	 */
	public static void main(String[] args){
		ArtikelMap map = new ArtikelMap();
		try {
			map.read("Artikeldaten.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(map.searchArtikel(2).getBezeichnung());
	}

}
