/**
 * <b>Musterlösung</b><br>
 * Eine Rechtecksklasse mit Methode zum Schneiden zweier Rechtecke. 
 */
public class Rectangle {
	
	private double x1, y1, x2, y2;
	
	public Rectangle(double x1, double y1, double x2, double y2) {
		setRectangle(x1, y1, x2, y2);
	}
	
	public void setRectangle(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	/**
	 * Stattdessen könnte auch Math.max(...) verwendet werden.
	 */
	private double max(double a, double b) {
		return a > b ? a : b;
	}
	
	/**
	 * Stattdessen könnte auch Math.min(...) verwendet werden.
	 */
	private double min(double a, double b) {
		return a < b ? a : b;
	}

	/**
	 * Schneidet das Rechteck mit dem übergebenen Rechteck und liefert das Schnittrechteck zurück.
	 * @param rect Das Rechteck, mit dem geschnitten werden soll.
	 * @return Das Schnittrechteck oder null, wenn es ein solches nicht gibt.
	 */
	public Rectangle intersect(Rectangle rect) {
		boolean noIntersection = (rect.x2 < x1 || rect.x1 > x2 || rect.y2 < y1 || rect.y1 > y2);
		if (noIntersection) {
			return null;
		} else {
			return new Rectangle(max(x1, rect.x1), max(y1, rect.y1), min(x2, rect.x2), min(y2, rect.y2));
		}
	}
	
}
