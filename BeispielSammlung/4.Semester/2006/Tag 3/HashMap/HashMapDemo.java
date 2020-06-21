/**
 * 
 */
package fh_vie.ac.at.Vorbereitung.Einheit3;

import java.util.*;
import java.io.*;
/**
 * @author Clemens Klee<br>
 * Erstellt am 16.03.2006<br>
 * Version 1.0
 */
public class HashMapDemo {
	private HashMap kunden;
	
	public HashMapDemo(){
		kunden = new HashMap(100);
	}
	
	public void read(String file) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = in.readLine();
		
		while(line != null){
			String[] data = line.split(" ");
			kunden.put(Integer.parseInt(data[0]),data[1]);
			line = in.readLine();
		}
		in.close();
	}
	
	public void test(){
		System.out.println("Auswertung über Map.Entry:");
		Set set = kunden.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()){
			Map.Entry e = (Map.Entry)it.next();
			System.out.println("KundenNr: "+e.getKey()+", Name: "+e.getValue());
		}
		
		System.out.println("Auswertung über keySet():");
		it = kunden.keySet().iterator();
		
		while(it.hasNext()){
			int knr = (Integer)it.next();
			String name = (String)kunden.get(knr);
			System.out.println("KundenNr: "+knr+", Name: "+name);
		}
		
		System.out.println("Auswertung über values():");
		it = kunden.values().iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("Auswertungen mit contains...");
		System.out.println("Gibt es den Schlüsselwert 1? "+kunden.containsKey(1));
		System.out.println("Gibt es den Schlüsselwert 5? "+kunden.containsKey(5));
		
		System.out.println("Gibt es den Wert Huber? "+kunden.containsValue("Huber"));
		System.out.println("Gibt es den Wert Klee? "+kunden.containsValue("Klee"));
	}
	
}
