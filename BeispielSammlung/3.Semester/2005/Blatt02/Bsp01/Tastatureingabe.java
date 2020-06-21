/**
 * <b>Musterlösung</b><br>
 * Liest zwei Zahlen von Tastatur und addiert diese.
 */
public class Tastatureingabe {

	public static void main(String[] args) {
		System.out.print("Zahl1: ");
		int zahl1 = In.readInt();
		System.out.print("Zahl2: ");
		int zahl2 = In.readInt();
		System.out.print("Summe: ");
		System.out.println(zahl1+zahl2);
	}
	
}
