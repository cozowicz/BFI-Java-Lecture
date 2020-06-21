/**
 * <b>Musterlösung</b><br>
 * Rechnet eine in Sekunden eingelesene Zahl in Stunden, Minuten und Sekunden um.
 */
public class Zeitrechnung {
	
	public static void main(String[] args) {
		System.out.print("Sekundenanzahl: ");
		long wert = In.readLong();
		long sekunden = wert % 60;
		long minuten = (wert % 3600) / 60;
		long stunden = wert / 3600;
		System.out.println("ergibt: "+stunden+"h "+minuten+"m "+sekunden+"s");
	}

}
