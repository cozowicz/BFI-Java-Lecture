package util;

import java.util.*;

public class UtilTest {
    public static void main(String[] args) {

        ArrayList list1 = new ArrayList();
        list1.add("Markus");
        // String             Object
        // Type Casting (Typ)
           String s = (String)list1.get(0);

        // Generics ab 1.5 (c++ templates)
        ArrayList<String> list2 = new ArrayList<String>();
        // void add(String s)
        list2.add("Tom");

        // String get(int index)
        String s2 = list2.get(0);

        TreeSet zahlen1 = new TreeSet();
        zahlen1.add(new Integer(5));
        Integer a1 = (Integer)zahlen1.first();
        int z1 = a1.intValue();

        // Auto-unboxing
        TreeSet<Integer> zahlen2 = new TreeSet<Integer>();
        zahlen2.add(6);
        int z2 = zahlen2.first();


        Map<Integer, String> namen = new HashMap<Integer,String>();

        // 5 -> "Markus"
        namen.put(5, "Markus");
        namen.put(3, "Tom");
        namen.put(5, "Klaus");

        s = namen.get(5);

        System.out.println("Namen: " + s);

        // Elemnt Type variableNamen : Liste
        for (String n : namen.values()) {
            System.out.println("Name: " + n);
        }
    }





}
