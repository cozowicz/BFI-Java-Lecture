/**
 * 
 */
package fh_vie.ac.at.Vorbereitung.Einheit3;

import java.util.ArrayList;

/**
 * @author Clemens Klee<br>
 * Erstellt am 16.03.2006<br>
 * Version 1.0
 */
public class ArrayListBsp {
	public static void main(String[] args){
		ArrayList list = new ArrayList();
		
		list.add("Clemens");
		
		String s = (String)list.get(0);
		//Generics: festlegen, welche Sachen in der Liste sind
		ArrayList<String> stringList = new ArrayList<String>();
		
		stringList.add("Klee");
		//Cast unnötig
		String s1 = stringList.get(0);
		
		//AutoUnboxing: brauch nicht mehr über Wrapper
		//Klassen auf primitive Datentypen casten
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(2);
		int abc = intList.get(0);
	}
}
