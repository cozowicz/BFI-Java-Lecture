package ht.reference.calendar;

import java.io.*;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

/**
 * Um GregorianCalendar und split() verbesserte DVDRekorder Implementierung
 *
 * @author Markus Cozowicz
 * @version 1.0
 */
public class DVDRekorder {
    private int maximalAuzeichnungsKapazitaetInMinuten;
    private Sendung[] sendungen = new Sendung[15];
    int index = 0;

    public DVDRekorder(int maximalAuzeichnungsKapazitaetInMinuten) {
        this.maximalAuzeichnungsKapazitaetInMinuten = maximalAuzeichnungsKapazitaetInMinuten;
    }

    // DVDRekorder meinRekorder = new DVDRekorder(2000);
    //
    // Sendung s = new Sendung(0,0,0,30,"Kabel 1","Kit");
    // meinRekorder.addSendung(s);
    public void addSendung(Sendung neue) {
        GregorianCalendar begin = neue.getBegin();
        GregorianCalendar end = neue.getEnd();

        boolean overlap = false;
        for (int i = 0; i < index; i++) {
            Sendung a = sendungen[i];

            GregorianCalendar a_begin = a.getBegin();
            GregorianCalendar a_end = a.getEnd();

            // entweder beginZeit liegt innerhalb der sendung oder die endZeit
            if((a_begin.before(begin) && begin.before(a_end)) ||
               (a_begin.before(end) && end.before(a_end))) {
               overlap = true;
               break;
            }
        }

        if(overlap == false &&  // keine ueberschneidung
           getDauer() + neue.getDauer() < maximalAuzeichnungsKapazitaetInMinuten && // noch genug frei am rekorder?
           index < sendungen.length ) { // array gross genug
            sendungen[index] = neue;
            index++;
        }
    }

    public void removeSendungen(GregorianCalendar begin, GregorianCalendar end) {

        for (int i = 0; i < index;) {
            Sendung a = sendungen[i];

            GregorianCalendar a_begin = a.getBegin();
            GregorianCalendar a_end = a.getEnd();

            // entweder beginZeit liegt innerhalb der sendung oder die endZeit
            if((a_begin.before(begin) && begin.before(a_end)) ||
               (a_begin.before(end) && end.before(a_end))) {

                // remove
                for (int j = i; j < index-1; j++) {
                    sendungen[j] = sendungen[j+1];
                }
                index--;
            }
            else // wichtig i++ darf nur erhoeht werden, wenn die sendung nicht geloescht wurde!!!
                i++;
        }
    }

    public void printSchedule() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        for (int i = 0; i < index; i++) {
            Sendung a = sendungen[i];
            System.out.println(a.getKanal() + "\t" + a.getTitel() + "\t" + sdf.format(a.getBegin().getTime()) + " - " +
                               sdf.format(a.getEnd().getTime())  + "\t" + a.getDauer());
        }
    }

    public int getDauer() {
        int dauer = 0;
        for (int i = 0; i < index; i++)
            dauer += sendungen[i].getDauer();
        return dauer;
    }

    public void readSchedule(String file) throws Exception {
        // F 14.5.2005 20:15 22:30 PRO7 "Spiderman" "Brad Pitt"
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        BufferedReader br = new BufferedReader(new FileReader("myschedule.txt"));
        String line;
        while((line = br.readLine()) != null) {
            int pos = line.indexOf("\"");
            String rest = line.substring(pos+1); // cut off "
            line = line.substring(0, pos);

            String[] fields = line.split(" ");

            // wichtig: die objekte muessen innerhalb der schleife erzeugt werden,
            // sonst haben alle sendungen die gleichen zeiten.
            GregorianCalendar begin = new GregorianCalendar();
            GregorianCalendar end = new GregorianCalendar();

            begin.setTime(sdf.parse(fields[1] + " " + fields[2])); // 14.5.2005 20:15
            end.setTime(sdf.parse(fields[1] + " " + fields[3]));   // 14.5.2005 22:30
            String kanal = fields[4];

            switch(fields[0].charAt(0)) {
               case 'N':
               {
                   String titel = rest.substring(0, rest.length()-1); // cut off last "
                   addSendung(new Sendung(begin, end, kanal, titel));
                   break;
               }
               case 'S':
               {
                   // S 2.1.2005 10:00 11:30 RTL "Gute Zeiten, Schlechte Zeiten" 1 5
                   int pos2 = rest.indexOf("\"");
                   String titel = rest.substring(0,pos2-1); // cut off \"
                   rest = rest.substring(pos2+2); // cut off \" and leerzeichen
                   fields = rest.split(" ");

                   int season = Integer.parseInt(fields[0]);
                   int episode = Integer.parseInt(fields[1]);

                   addSendung(new Serie(begin, end, kanal, titel, season, episode));
                   break;
               }
               case 'F':
               {
                   // F 14.5.2005 20:15 22:30 PRO7 "Spiderman" "Brad Pitt"
                   fields = rest.split("\"");
                   // "Spiderman", " ", "Brad Pitt"
                   String titel = fields[0];
                   String hauptdarsteller = fields[2];

                   addSendung(new Film(begin, end, kanal, titel, hauptdarsteller));
                   break;
               }
            }
        }

    }
}
