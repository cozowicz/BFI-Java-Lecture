/**
 * <b>Musterlösung</b><br>
 * Gehaltsberechnung: Manager
 */
public class Manager extends Angestellter {

	private float praemie;
	
	public Manager(float monatsgehalt, float praemie) {
		super(monatsgehalt);
		this.praemie = praemie;
	}

	public float berechneJahresgehalt() {
		return super.berechneJahresgehalt()+praemie;
	}

}
