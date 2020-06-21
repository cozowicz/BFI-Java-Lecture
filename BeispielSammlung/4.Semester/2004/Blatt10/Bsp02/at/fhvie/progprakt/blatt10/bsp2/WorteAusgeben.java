package at.fhvie.progprakt.blatt10.bsp2;

import java.util.StringTokenizer;
import In;

public class WorteAusgeben {

	public static void main(String[] args) {
		System.out.print("Text eingeben: ");
		String line = In.readLine();
		StringTokenizer st = new StringTokenizer(line, " \t\n\r\f.,:;!?");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
	
}
