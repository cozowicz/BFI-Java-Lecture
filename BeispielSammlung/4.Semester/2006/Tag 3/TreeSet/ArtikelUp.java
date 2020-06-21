/**
 * 
 */
package fh_vie.ac.at.Vorbereitung.Einheit3;
import java.util.*;
/**
 * Comparator um Artikel nach der Artikelnummer aufsteigend zu sortieren.
 * @author Clemens Klee<br>
 * Erstellt am 16.03.2006<br>
 * Version 1.0
 */
public class ArtikelUp implements Comparator{
	public int compare(Object o1, Object o2) {
		Artikel a = (Artikel)o1;
		Artikel b = (Artikel)o2;
		
		if(a.getArtnr()>b.getArtnr())
			return 1;
		if(a.getArtnr()<b.getArtnr())
			return -1;
		else
			return 0;
	}
}
