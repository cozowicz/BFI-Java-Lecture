/**
 * 
 */
package fh_vie.ac.at.Vorbereitung.Einheit3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Namensverwaltung mit natürlicher Ordnung der Elemente
 * @author Clemens Klee<br>
 * Erstellt am 16.03.2006<br>
 * Version 1.0
 */
public class Namensverwaltung{
	
	
	private TreeSet namen = new TreeSet();
	
	public void readNamen(String file) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(file));
		String name = in.readLine();
		
		while(name != null){
			namen.add(name);
			name = in.readLine();
		}
		in.close();
	}
	
	public void print(){
		Iterator it = namen.iterator();
		
		while(it.hasNext()){
			String s = (String)it.next();
			System.out.println(s);
		}
	}

}
