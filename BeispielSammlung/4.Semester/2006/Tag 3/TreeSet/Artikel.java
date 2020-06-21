/**
 * 
 */
package fh_vie.ac.at.Vorbereitung.Einheit3;

import java.util.Comparator;

/**
 * Klasse zum Demonstrieren von Comparable
 * @author Clemens Klee<br>
 * Erstellt am 16.03.2006<br>
 * Version 1.0
 */
public class Artikel {//implements Comparable{
	private int artnr;
	private String bezeichnung;
	
	public Artikel(int nr, String bezeichnung){
		this.artnr =nr;
		this.bezeichnung=bezeichnung;
	}

//	public int compareTo(Object other) {
//		Artikel a = (Artikel)other;
//		//aufsteigend nach Artikelnummern sortieren
//		if(a.artnr > this.artnr)
//			return -1;
//		else if(a.artnr < this.artnr)
//			return 1;
//		else
//			return 0;
//	}

	/**
	 * @return Returns the artnr.
	 */
	public int getArtnr() {
		return artnr;
	}

	/**
	 * @param artnr The artnr to set.
	 */
	public void setArtnr(int artnr) {
		this.artnr = artnr;
	}

	/**
	 * @return Returns the bezeichnung.
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}

	/**
	 * @param bezeichnung The bezeichnung to set.
	 */
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	
}
