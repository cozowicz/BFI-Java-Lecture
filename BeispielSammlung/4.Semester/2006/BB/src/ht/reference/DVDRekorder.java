package ht.reference;

import java.io.*;

/**
 * Referenz Implementierung Prüfung DVDRekorder
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
        int beginZeitInMinuten = neue.getBeginStunde() * 60 + neue.getBeginMinute();
        int endZeitInMinuten = neue.getEndStunde() * 60 + neue.getEndMinute();

        boolean overlap = false;
        for (int i = 0; i < index; i++) {
            Sendung a = sendungen[i];

            int a_beginZeitInMinuten = a.getBeginStunde() * 60 + a.getBeginMinute();
            int a_endZeitInMinuten = a.getEndStunde() * 60 + a.getEndMinute();

            // entweder beginZeit liegt innerhalb der sendung oder die endZeit
            if((beginZeitInMinuten >= a_beginZeitInMinuten && beginZeitInMinuten <= a_endZeitInMinuten) ||
              (endZeitInMinuten >= a_beginZeitInMinuten && endZeitInMinuten <= a_endZeitInMinuten)) {
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

    public void removeSendungen(int beginStunde, int beginMinute, int endStunde, int endMinute) {

        int beginZeitInMinuten = beginStunde * 60 + beginMinute;
        int endZeitInMinuten = endStunde * 60 + endMinute;

        for (int i = 0; i < index;) {
            Sendung a = sendungen[i];

            int a_beginZeitInMinuten = a.getBeginStunde() * 60 + a.getBeginMinute();
            int a_endZeitInMinuten = a.getEndStunde() * 60 + a.getEndMinute();

            // entweder beginZeit liegt innerhalb der sendung oder die endZeit
            if((beginZeitInMinuten >= a_beginZeitInMinuten && beginZeitInMinuten <= a_endZeitInMinuten) ||
              (endZeitInMinuten >= a_beginZeitInMinuten && endZeitInMinuten <= a_endZeitInMinuten)) {
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
        for (int i = 0; i < index; i++) {
            Sendung a = sendungen[i];
            System.out.println(a.getKanal() + "\t" + a.getTitel() + "\t" + a.getBeginStunde() + ":" + a.getBeginMinute() + "\t" + a.getDauer());
        }
    }

    public int getDauer() {
        int dauer = 0;
        for (int i = 0; i < index; i++)
            dauer += sendungen[i].getDauer();
        return dauer;
    }

    public void readSchedule(String file) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("myschedule.txt"));
        String line;
        while((line = br.readLine()) != null) {
            int pos1 = line.indexOf(" ");
            char type = line.substring(0, pos1).charAt(0);

            int pos2 = line.indexOf(" ", pos1+1);
            int beginStunde = Integer.parseInt(line.substring(pos1+1, pos2));
            pos1 = pos2;

            pos2 = line.indexOf(" ", pos1+1);
            int beginMinute = Integer.parseInt(line.substring(pos1+1, pos2));
            pos1 = pos2;

            pos2 = line.indexOf(" ", pos1+1);
            int endStunde = Integer.parseInt(line.substring(pos1+1, pos2));
            pos1 = pos2;

            pos2 = line.indexOf(" ", pos1+1);
            int endMinute = Integer.parseInt(line.substring(pos1+1, pos2));
            pos1 = pos2;

            pos2 = line.indexOf(" ", pos1+1);
            String kanal = line.substring(pos1+1, pos2);
            pos1 = pos2;

            pos2 = line.indexOf("\"", pos1+2); // +2 weil erstes " ueberspringen
            String titel = line.substring(pos1+2, pos2);
            pos1 = pos2;
//            System.out.println("Titel: '" + titel + "'");

            switch(type) {
               case 'N':
               {
                   addSendung(new Sendung(beginStunde, beginMinute, endStunde, endMinute, kanal, titel));
                   break;
               }
               case 'S':
               {
                   pos2 = line.indexOf(" ", pos1+2); // +2 " und Leerzeichen ueberspringen
                   int season = Integer.parseInt(line.substring(pos1+2, pos2));
                   pos1 = pos2;

                   int episode = Integer.parseInt(line.substring(pos1+1));

                   addSendung(new Serie(beginStunde, beginMinute, endStunde, endMinute, kanal, titel, season, episode));
                   break;
               }
               case 'F':
               {
                   String hauptdarsteller = line.substring(pos1+2);
                   pos1 = pos2;

                   addSendung(new Film(beginStunde, beginMinute, endStunde, endMinute, kanal, titel, hauptdarsteller));
                   break;
               }
            }
        }

    }
}
