package fh_vie.ac.at.Vorbereitung.Einheit3;

import java.io.IOException;

public class Artikeltest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Artikelverwaltung a = new Artikelverwaltung(new ArtikelDown());
		try {
			a.readArtikel("Artikeldaten.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		a.print();
	}

}
