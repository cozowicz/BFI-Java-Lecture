public class Rechteck extends GrafischesObjekt {

	private Punkt linksOben;
	private Punkt rechtsUnten;
	
	public Rechteck() {
	}
	
	public Rechteck(Punkt linksOben, Punkt rechtsUnten) {
		set(linksOben, rechtsUnten);
	}
	
	public void set(Punkt linksOben, Punkt rechtsUnten) {
		this.linksOben = linksOben.copy();
		this.rechtsUnten = rechtsUnten.copy();
	}

	public Punkt getLinksOben() {
		return linksOben.copy();
	}

	public Punkt getRechtsUnten() {
		return rechtsUnten.copy();
	}

	public double getBreite() {
		return rechtsUnten.getX()-linksOben.getX(); 
	}
	
	public double getHoehe() {
		return rechtsUnten.getY()-linksOben.getY();
	}

	public double berechneFlaeche() {
		return getBreite()*getHoehe();
	}

	public void translate(double dx, double dy) {
		linksOben.translate(dx, dy);
		rechtsUnten.translate(dx, dy);
	}
	
	public Punkt getMittelpunkt() {
		return new Punkt((linksOben.getX()+rechtsUnten.getX())/2.0, 
		                 (linksOben.getY()+rechtsUnten.getY())/2.0);
	}
	
	public boolean contains(Punkt punkt) {
		double x = punkt.getX();
		double y = punkt.getY();
		return x >= linksOben.getX() && x <= rechtsUnten.getX() && 
		       y >= linksOben.getY() && y <= rechtsUnten.getY();
	}
	
}
