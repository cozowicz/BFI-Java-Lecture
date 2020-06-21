public class GrafischeObjekteTest {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.add(new Kreis(new Punkt(10, 10), 5));
		g.add(new Punkt(20, 20));
		g.add(new Linie(new Punkt(0, 0), new Punkt(20, 20)));
		g.add(new Rechteck(new Punkt(-10, 0), new Punkt(50, 80)));
		GrafischesObjekt[] selektion = g.selektiere(new Rechteck(new Punkt(5, 5), new Punkt(15, 15)));
		System.out.println("Es wurden "+selektion.length+" Objekte selektiert.");
	}

}
