package Bsp06;

import MoessenboeckIO.*;

/**
 * <b>Musterlösung</b><br>
 * Komprimiet und dekomprimiert einen Text nach der Lauflängencodierung.
 */
public class Lauflaengencodierung {

	/**
	 * Komprimerit eine Zeichenfolge nach der Lauflängencodierung.
	 * @param s Die zu komprimiertende Zeichenfolge.
	 * @return Die komprimierte Zeichenfolge.
	 */
	static String komprimieren(String s) {
		StringBuffer encodedString = new StringBuffer();
		int i = 0;
		while (i < s.length()) {
			int start = i;
			char c = s.charAt(i++);
			while (i < s.length() && c == s.charAt(i)) {
				i++;
			}
			int wiederholungen = i-start;
			encodedString.append(c);
			if (wiederholungen > 2) {
				encodedString.append(wiederholungen);
			} else {
				if (wiederholungen == 2) encodedString.append(c);
			}
		}
		return encodedString.toString();
	}

	/**
	 * Dekomprimiert eine mit Lauflängencodierung komprimierte Zeichenfolge.
	 * @param s Die komprimierte Zeichenfolge.
	 * @return Die dekomprimierte Zeichenfolge.
	 */
	static String dekomprimieren(String s) {
		StringBuffer decodedString = new StringBuffer();
		int i = 0;
		while (i < s.length()-1) {
			char c = s.charAt(i++);
			char c1 = s.charAt(i);
			int wiederholungen;
			if (c1 == c) {
				wiederholungen = 2;
				i++;
			} else {
				if (Character.isDigit(s.charAt(i))) {
					wiederholungen = 0;
					do {
						wiederholungen = wiederholungen*10+s.charAt(i++)-'0';
					} while (i < s.length() && Character.isDigit(s.charAt(i)));
				} else {
					wiederholungen = 1;
				}
			}
			for (; wiederholungen > 0; wiederholungen--) {
				decodedString.append(c);
			}
		}
		if (i < s.length()) {
			decodedString.append(s.charAt(s.length()-1));
		}
		return decodedString.toString();
	}

	public static void main(String[] args) {
		System.out.print("Zeichenfolge:  ");
		String s = In.readLine();
		String komprimiert = komprimieren(s);
		System.out.println("komprimiert:   "+komprimiert);
		System.out.println("dekomprimiert: "+dekomprimieren(komprimiert));
	}
}
