package ht.reference.calendar;


public class Test {
    public static void main(String[] args) throws Exception {

        DVDRekorder d = new DVDRekorder(300);

        d.readSchedule("myschedule.txt");
        d.printSchedule();
    }
}
