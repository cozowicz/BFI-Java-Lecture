/**
 * <b>Musterlösung</b><br>
 * Artikelverwaltung.
 */
public class Artikelverwaltung {

	public static void main(String[] args) {
		In.open("Bsp07/artikel.dat");
		if (In.done()) {
			Artikel article = readArtikel();
			while (article != null) {
				writeArtikel(article);
				article = readArtikel();
			}
			In.close();
		} else {
			System.out.println("Datei Bsp07/artikel.dat nicht gefunden!");
		}
	}
	
	/**
	 * Liest die Daten eines Artikels aus der Datei und liefert diese 
	 * in einem Artikelobjekt zurück.
	 * @return Ein Artikelobjekt mit den Daten eines Artikels aus der Datei.
	 */
	public static Artikel readArtikel() {
		int artikelnummer = In.readInt();
		int preis = In.readInt();
		Artikel artikel = new Artikel(artikelnummer, preis);
		int menge = In.readInt();
		while (menge != 0) {
			artikel.erhoeheMenge(menge);
			menge = In.readInt();
		}
		if (In.done()) {
			return artikel;
		} else {
			return null;
		}
	}

	/**
	 * Gibt Artikelnummer und Umsatz eines Artikels aus.
	 * @param artikel Der Artikel, zu dem Artkelnummer und Umsatz
	 * ausgegeben werden sollen. 
	 */
	public static void writeArtikel(Artikel artikel) {
		System.out.println(artikel.getArtikelnummer()+"\t"+artikel.berechneUmsatz());
	}
}
