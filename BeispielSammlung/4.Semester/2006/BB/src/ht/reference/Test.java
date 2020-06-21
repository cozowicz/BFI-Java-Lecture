package ht.reference;

/**
 * Referenz Implementierung Prüfung DVDRekorder
 *
 * @author Markus Cozowicz
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) throws Exception {
//        DVDRekorder d = new DVDRekorder(100);
//        DVDRekorder d = new DVDRekorder(200);

        Sendung[] arr = new Sendung[5];
        arr[0] = new Sendung(10,0,13,0,"ORF 2","Olympia");

        Sendung kit = new Sendung(0,0,0,30,"Kabel 1", "Kit");
        arr[2] = kit;

        DVDRekorder d = new DVDRekorder(300);

        d.readSchedule("myschedule.txt");
        d.printSchedule();
    }
}
