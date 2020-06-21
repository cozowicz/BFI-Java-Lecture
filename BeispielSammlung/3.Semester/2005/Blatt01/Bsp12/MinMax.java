/**
 * <b>Musterlösung</b><br>
 * Berechnet Minimum und Maximum von drei Zahlen.
 */
public class MinMax {

	public static void main(String[] args) {
		int zahl1 = 3;
		int zahl2 = 7;
		int zahl3 = -4;
		int max12 = (zahl1 > zahl2 ? zahl1 : zahl2);
		int max123 = (max12 > zahl3 ? max12 : zahl3);
		System.out.println("Maximum von "+zahl1+", "+zahl2+" und "+zahl3+" ist "+max123+".");
		int min12 = (zahl1 > zahl2 ? zahl2 : zahl1);
		int min123 = (zahl3 > min12 ? min12 : zahl3);
		System.out.println("Minimum von "+zahl1+", "+zahl2+" und "+zahl3+" ist "+min123+".");
	}

}
