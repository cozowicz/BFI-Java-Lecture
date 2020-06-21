/**
 * <b>Musterlösung</b><br>
 * Berechnet Pi mit einer gegebenen Genauigkeit Epsilon.
 */
public class Pi {

	public static void main(String[] args) {
		System.out.print("Genauigkeit Epsilon: ");
		double epsilon = In.readDouble()/4.0;
		double pi4 = 0.0;
		double pi4Last = 0.0;
		double nenner = 1.0;
		double signum = 1.0;
		do {
			pi4Last = pi4;
			pi4 += signum*(1.0/nenner);
			nenner += 2;
			signum = -signum;
			// Math.abs(..) = Absolut Wert
		} while (Math.abs(pi4-pi4Last) > epsilon); 
		System.out.println("Pi: "+(pi4*4.0));
	}
	
}
