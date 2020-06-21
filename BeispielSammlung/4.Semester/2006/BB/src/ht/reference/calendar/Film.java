package ht.reference.calendar;

import java.util.GregorianCalendar;

/**
 * Referenz Implementierung Prüfung DVDRekorder
 *
 * @author Markus Cozowicz
 * @version 1.0
 */
public class Film extends Sendung {
    private String hauptdarsteller;

    public Film(GregorianCalendar begin, GregorianCalendar end, String kanal, String titel, String hauptdarsteller) {
        super(begin, end, kanal, titel);
        this.hauptdarsteller = hauptdarsteller;
    }
}
