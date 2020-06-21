package artikelverwaltung;

import java.util.*;

public class Artikel implements Comparable<Artikel> {
    private int id;
    private String name;

    public Artikel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int compareTo(Artikel a) {
        if(id == a.id)
            return 0;
        else if(id < a.id)
            return -1;
        else
            return 1;
    }

    public String getBezeichnung() {
        return name;
    }
}
