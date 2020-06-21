/**
 * <b>Musterl�sung</b><br>
 * H�lt die Daten eines Arikels.
 */
public class Artikel {

	private int artikelnummer, preis, menge;

	/**
	 * Erzeugt einen Artikel mit Artikelnummer und Preis.
	 * @param artikelnummer Artikelnummer.
	 * @param preis St�ckpreis des Artikels.
	 */
	public Artikel(int artikelnummer, int preis) {
		this.artikelnummer = artikelnummer;
		this.preis = preis;
	}

	/**
	 * Erh�ht die Menge der verkauften St�ck.
	 * @param menge Menge der verkauften St�ck.
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
