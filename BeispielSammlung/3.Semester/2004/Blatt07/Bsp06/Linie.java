public class Linie extends GrafischesObjekt {

	private Punkt start;
	private Punkt ende;
	
	public Linie() {
	}
	
	public Linie(Punkt start, Punkt ende) {
		set(start, ende);
	}
	
	public void set(Punkt start, Punkt ende) {
		this.start = start.copy();
		this.ende = ende.copy();
	}

	public Punkt getStart() {
		return start.copy();
	}

	public Punkt getEnde() {
		return ende.copy();
	}

	public double berechneFlaeche() {
		return 0;
	}

	public void translate(double dx, double dy) {
		start.translate(dx, dy);
		ende.translate(dx, dy);
	}
	
	public Punkt getMittelpunkt() {
		return new Punkt((start.getX()+ende.getX())/2.0, (start.getY()+ende.getY())/2.0);
	}

			
}
