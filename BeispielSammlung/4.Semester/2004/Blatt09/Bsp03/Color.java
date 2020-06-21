/**
 * Ein Farbwert aufgeteilt in Rot- Gr�n- und Blauanteil. Jeder Farbanteil
 * darf einen Wert zwischen 0 und 255 besitzen, wobei 0 bedeutet, da� der
 * Farbanteil in der Farbe nicht vorkommt; 255 hingegen bedeutet, da� der
 * Farbanteil maximal vorkommt. Einige Beispiele sollen dies verdeutlichen:
 * 
 * Farbmischung:				Ergebnisfarbe:
 * -------------------------------------------
 * Rot=0, Gr�n=0, Blau=0		Schwarz   
 * Rot=255, Gr�n=255, Blau=255	Wei�
 * Rot=255, Gr�n=0, Blau=0		Rot
 * Rot=220, Gr�n=0, Blau=200	Violett   
 */
public class Color {

	private int red, green, blue;
	
	public Color(int red, int green, int blue) {
		this.red = red % 256;
		this.green = green % 256;
		this.blue = blue % 256;
	}
	
	public int getRed() {
		return red;
	}

	public int getGreen() {
		return green;
	}

	public int getBlue() {
		return blue;
	}
	
}
