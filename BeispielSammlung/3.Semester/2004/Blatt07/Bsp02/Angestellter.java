/**
 * <b>Musterlösung</b><br>
 * Gehaltsberechnung: Angestellter
 */
public class Angestellter {

	private float monatsgehalt;
	
	public Angestellter(float monatsgehalt) {
		this.monatsgehalt = monatsgehalt;
	}
	
	public float berechneJahresgehalt() {
		return 14*monatsgehalt;
	}

}
