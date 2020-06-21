/**
 * <b>Musterlösung</b><br>
 * Beispielverwendung der Klassen. 
 */
public class RunUnternehmen {

	public static void main(String[] args) {
		Unternehmen unternehmen = new Unternehmen(100);
		Mitarbeiter m1 = new Arbeiter("Maximilian", "Muster", "1234010160", 50000);
		unternehmen.mitarbeiterAnstellen(m1);
		Mitarbeiter m2 = new Manager("Susanne", "Schuster", "9876311265", 70000, 15000);
		unternehmen.mitarbeiterAnstellen(m2);
		unternehmen.gehaltstabelle(0.9f, "Bsp02/gehaltstabelle.txt");
	}
	
}
