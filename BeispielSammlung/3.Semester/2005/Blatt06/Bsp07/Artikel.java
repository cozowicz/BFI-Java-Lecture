/**
 * <b>Musterlösung</b><br>
 * Hält die Daten eines Arikels.
 */
public class Artikel {

	private int artikelnummer, preis, menge;

	/**
	 * Erzeugt einen Artikel mit Artikelnummer und Preis.
	 * @param artikelnummer Artikelnummer.
	 * @param preis Stückpreis des Artikels.
	 */
	public Artikel(int artikelnummer, int preis) {
		this.artikelnummer = artikelnummer;
		this.preis = preis;
	}

	/**
	 * Erhöht die Menge der verkauften Stück.
	 * @param menge Menge der verkauften Stück.
	 */
	public void erhoeheMenge(int menge) {
		this.menge += menge;		
	}
	
	/**
	 * @return Die Artikelnummer.
	 */
	public int getArtikelnummer() {
		return artikelnummer;
	}

	/**
	 * @return Der Umsatz, der bisher mit diesem Artikel 
	 * erwirtschaftet wurde.
	 */
	public int berechneUmsatz() {
		return menge*preis;
	}
	
}
