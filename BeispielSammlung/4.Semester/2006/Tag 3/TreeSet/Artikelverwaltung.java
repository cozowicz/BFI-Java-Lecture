/**
 * 
 */
package fh_vie.ac.at.Vorbereitung.Einheit3;
import java.util.*;
import java.io.*;

/**
 * TreeSet mit Elementen die Comparable implementieren
 * bzw. mit Comparator.
 * @author Clemens Klee<br>
 * Erstellt am 16.03.2006<br>
 * Version 1.0
 */
public class Artikelverwaltung {
	private TreeSet<Artikel> artikel; 
	
	public Artikelverwaltung(){
		artikel = new TreeSet<Artikel>();
	}
	public Artikelverwaltung(Comparator c){
		artikel = new TreeSet<Artikel>(c);
	}
	
	public void readArtikel(String file) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = in.readLine();
		while(line != null){
			String[] artikeldaten = new String[2];
			artikeldaten = line.split(" ");
			
			Artikel a = new Artikel(Integer.parseInt(artikeldaten[0]),artikeldaten[1]);
			artikel.add(a);
			line = in.readLine();
		}
		in.close();
	}
	
	public void print(){
		Iterator it = artikel.iterator();
		while(it.hasNext()){
			Artikel a = (Artikel)it.next();
			System.out.println(a.getArtnr()+" "+a.getBezeichnung());
		}
	}
}
