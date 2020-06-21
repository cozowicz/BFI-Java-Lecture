package namenverwaltung;

import java.util.*;
import java.io.*;

public class NamensVerwaltung {
    private TreeSet<String> namen =
            new TreeSet<String>(new ReverseComparator());

    public void readNamen(String file) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null) {
            namen.add(line);
        }
        br.close();
    }

    public void print() {
        for (String elem : namen) {
            System.out.println("Name: " + elem);
        }
    }

    public static void main(String[] args) throws IOException {
        NamensVerwaltung nv = new NamensVerwaltung();

        nv.readNamen("Namen.txt");
        nv.print();
    }
}

class ReverseComparator implements Comparator<String> {

    public int compare(String s1, String s2) {
        return s1.compareTo(s2)*-1;
    }
}



