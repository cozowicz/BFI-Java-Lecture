/**
 * <b>Musterlösung</b><br>
 * Stellt einen Punkt im kartesischen Koordinatensystem dar. 
 */
public class Point {

	private double x, y;
	
	/**
	 * Konstruktor. Der Punkt zeigt auf die Koordinate (0,0).
	 */
	public Point() {
	}
	
	/**
	 * Konstruktor. Der Punkt zeigt auf die Koordinate (x,y).
	 * @param x X-Koordinate des Punktes.
	 * @param y Y-Koordinate des Punktes.
	 */
	public Point(double x, double y) {
		setLocation(x, y);
	}

	/**
	 * Setzt den Punkt auf die Koordinate (x,y).
	 * @param x X-Koordinate des Punktes.
	 * @param y Y-Koordinate des Punktes.
	 */
	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Verschiebt den Punkt um dx in x-Richtung und dy in y-Richtung.
	 * @param dx Verschiebung in X-Richtung.
	 * @param dy Verschiebung in Y-Richtung.
	 */
	public void move(double dx, double dy) {
		x += dx;
		y += dy;
	}
	
	/**
	 * @return Die X-Koordinate des Punktes.
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return Die Y-Koordinate des Punktes.
	 */
	public double getY() {
		return y;
	}

}
