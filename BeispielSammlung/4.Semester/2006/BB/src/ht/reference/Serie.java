package ht.reference;

/**
 * Referenz Implementierung Prüfung DVDRekorder
 *
 * @author Markus Cozowicz
 * @version 1.0
 */
public class Serie extends Sendung {
    private int episode;
    private int season;

    public Serie(int beginStunde, int beginMinute, int endStunde, int endMinute, String kanal, String titel, int episode, int season) {
         super(beginStunde, beginMinute, endStunde, endMinute, kanal, titel);
         this.episode = episode;
         this.season = season;
    }
}
