package artikelverwaltung;

import java.io.*;
import java.util.*;


public class Zwischentest {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Artikel> stammdaten = new HashMap<Integer,Artikel>();

        BufferedReader in = new BufferedReader(new FileReader("Artikeldaten.txt"));
        String line = in.readLine();
        while (line != null) {
            String[] artikeldaten = new String[2];
            artikeldaten = line.split(" ");

            int nr = Integer.parseInt(artikeldaten[0]);
            Artikel a = new Artikel(nr, artikeldaten[1]);
            stammdaten.put(nr, a);
            line = in.readLine();
        }
        in.close();

        TreeSet<Integer> filter = new TreeSet<Integer>();
        in = new BufferedReader(new FileReader("filter.txt"));
        line = in.readLine();
        while (line != null) {
            filter.add(Integer.parseInt(line));
        }
        in.close();

        for (Integer nr : filter) {
           Artikel a = stammdaten.get(nr);
           System.out.println(a.getBezeichnung());
        }
    }
}
