/**
 * 
 */
package fh_vie.ac.at.Vorbereitung.Einheit3;
import java.util.*;
import java.io.*;
/**
 * HashMap in der Artikel zu Artikelnummern gemappt werden.
 * @author Clemens Klee<br>
 * Erstellt am 16.03.2006<br>
 * Version 1.0
 */
public class ArtikelMap {
	private HashMap<Integer,Artikel> artikel;
	
	public ArtikelMap (){
		artikel = new HashMap<Integer,Artikel>();
	}
	
	public void read(String file) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = in.readLine();
		
		while(line != null){
			String[] data = line.split(" ");
			int artnr = Integer.parseInt(data[0]);
			Artikel a = new Artikel(artnr,data[1]);
			artikel.put(artnr,a);
			line = in.readLine();
		}
		in.close();
	}
	
	public Artikel searchArtikel(int artikelnr){
		if(!artikel.containsKey(artikelnr)){
			return null;
		}
		else{
			return artikel.get(artikelnr);
		}
	}
}
