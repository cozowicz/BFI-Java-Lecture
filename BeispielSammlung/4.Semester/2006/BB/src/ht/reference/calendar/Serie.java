package ht.reference.calendar;

import java.util.GregorianCalendar;

/**
 * Referenz Implementierung Prüfung DVDRekorder
 *
 * @author Markus Cozowicz
 * @version 1.0
 */
public class Serie extends Sendung {
    private int episode;
    private int season;

    public Serie(GregorianCalendar begin, GregorianCalendar end, String kanal, String titel, int episode, int season) {
         super(begin, end, kanal, titel);
         this.episode = episode;
         this.season = season;
    }
}
