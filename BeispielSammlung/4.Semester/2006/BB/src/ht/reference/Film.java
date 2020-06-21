package ht.reference;

/**
 * Referenz Implementierung Prüfung DVDRekorder
 *
 * @author Markus Cozowicz
 * @version 1.0
 */
public class Film extends Sendung {
    private String hauptdarsteller;

    public Film(int beginStunde, int beginMinute, int endStunde, int endMinute, String kanal, String titel, String hauptdarsteller) {
        super(beginStunde, beginMinute, endStunde, endMinute, kanal, titel);
        this.hauptdarsteller = hauptdarsteller;
    }
}
