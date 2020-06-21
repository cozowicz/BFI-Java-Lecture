public class Punkt extends GrafischesObjekt {

	private double x;
	private double y;

	public Punkt() {
		setLocation(0, 0);
	}

	public Punkt(double x, double y) {
		setLocation(x, y);
	}

	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double berechneFlaeche() {
		return 0;
	}

	public void translate(double dx, double dy) {
		x += dx;
		y += dy;
	}

	public Punkt copy() {
		return new Punkt(x, y);
	}

	public Punkt getMittelpunkt() {
		return this;
	}

}
