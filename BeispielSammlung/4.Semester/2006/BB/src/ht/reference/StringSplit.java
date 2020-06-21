package ht.reference;

import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.*;

public class StringSplit {

    public static void main(String[] args) {

        String s = "N 9 10 11 00 ORF1 \"Zeit im Bild\"";

        int pos = s.indexOf("\"");
        String title = s.substring(pos);
        s = s.substring(0, pos);

        String[] arr = s.split(" ");

        System.out.println("Type: " + arr[0]);
        System.out.println("Zeit: " + arr[1] + ":" + arr[2]);

        Date d = new Date(); // Aktuelle Zeit

        GregorianCalendar g = new GregorianCalendar();
        g.add(GregorianCalendar.DATE, -7);
        int hour = g.get(GregorianCalendar.HOUR);
        // get()

        GregorianCalendar g2 = new GregorianCalendar();

        if(g.before(g2)) {
            System.out.println("g ist vor g2");
        }


        String eingabe = "N 9:10 11:00 ORF1";
        String[] felder = eingabe.split(" ");

        // Sendung s = new Sendung(0,0,0,30,"Kabel 1","Kit");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        try {
            Date d1 = sdf.parse(felder[1]);

            g.setTime(d1);

            g.setTime(sdf.parse(felder[1]));
        } catch (ParseException ex) {
        }

        GregorianCalendar greg = new GregorianCalendar();
        long m1 = greg.getTimeInMillis();









    }
}
