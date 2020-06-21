package ht.reference.calendar;

import java.util.GregorianCalendar;


/**
 * @author Markus Cozowicz
 * Version 1.0
 */
public class Sendung {
    private GregorianCalendar begin;
    private GregorianCalendar end;
    private String kanal;
    private String titel;

    public Sendung(GregorianCalendar begin, GregorianCalendar end, String kanal, String titel) {
        this.begin = begin;
        this.end = end;
        this.kanal = kanal;
        this.titel = titel;
    }

    public String getKanal() {
        return kanal;
    }

    public String getTitel() {
        return titel;
    }

    public GregorianCalendar getEnd() {
        return end;
    }

    public GregorianCalendar getBegin() {
        return begin;
    }

    public long getDauer() {
        return (end.getTimeInMillis() - begin.getTimeInMillis()) / 1000 / 60;
    }
}





