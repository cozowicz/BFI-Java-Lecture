public class Kreis extends GrafischesObjekt {

	private Punkt mittelpunkt;
	private double radius;

	public Kreis() {
	}
	
	public Kreis(Punkt mittelpunkt, double radius) {
		set(mittelpunkt, radius);
	}

	public void set(Punkt mittelpunkt, double radius) {
		this.mittelpunkt = mittelpunkt.copy();
		this.radius = radius;
	}
	
	public Punkt getMittelpunkt() {
		return mittelpunkt.copy();
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double berechneFlaeche() {
		return radius*radius*Math.PI;
	}

	public void translate(double dx, double dy) {
		mittelpunkt.translate(dx, dy);
	}
	
}
