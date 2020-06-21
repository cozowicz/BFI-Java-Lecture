package listen;

import java.util.Locale;
import java.text.ParseException;

import java.text.SimpleDateFormat;

public class Liste {

    private class Element {
        public Object value;
        public Element next;
    }

    private Element head;

    public void add(Object obj) {
        if(head == null) {
            head = new Element();
            head.value = obj;
        }
        else {
            Element h = head;
            while(h.next != null)
                h=h.next;

            h.next = new Element();
            h.next.value = obj;
        }
    }

    public Object get(int index) {
        Element h = head;

        for (int i = 0; i < index && h != null; i++, h=h.next); // <<<< ;
        // { }

        if(h != null)
            return h.value;
        else
            return null;
    }


    public int size() {
        return 0;
    }

    public boolean remove(Object obj) {
        // 1. leer
        if(head == null)
            return false;

        // 2. erstes
        if(head.value == obj) {
            head = head.next;
            return true;
        }

        // 3. mitte
        Element h = head;
        Element prev = null;
        while(h != null && h.value != obj) {
            prev = h;
            h = h.next;
        }
        if(h == null) // nicht gefunden
            return false;

        // umhaengen
        prev.next = h.next;
        return true;
    }


    public void insert(int pos, Object obj) {

        if(pos == 0) {
            Element h = new Element();
            h.value = obj;
            h.next = head;
            head = h;
        }
        else {

            if(head == null) {
                head = new Element();
                head.value = obj;
            }
            else {
                int i = 0;
                Element h = head;
                while (h.next != null && i < pos - 1) {
                    h = h.next;
                    i++;
                }
                Element neu = new Element();
                neu.value = obj;

                neu.next = h.next;
                h.next = neu;
            }
        }
    }


    void swap(int index1, int index2)
    {
        // list empty or same index
        if(head == null || index1 == index2)
            return;


        // make sure index1 < index2
        if(index1 > index2) {
            int h = index1;
            index1 = index2;
            index2 = h;
        }

        if(index1 == 0)
        {
            // first elem needs to be swapped
            Element h, prev;
            h = prev = head;

            // search element at index1 and index1-1 (same as remove())
            for(int i=0;i<index2 && h.next != null;i++) {
                prev = h;
                h = h.next;
            }

            prev.next = head;

            // swap head.next/h.next
            Element tmp = head.next;
            head.next = h.next;
            h.next = tmp;

            head = h;
        }
        else
        {
            // general case
            Element h1, prev1, h2, prev2;

            h1 = h2 = prev1 = prev2 = head;

            // search element at index1 and index1-1 (same as remove())
            for(int i=0;i<index1 && h1.next != null;i++) {
                prev1 = h1;
                h1 = h1.next;
            }

            // search element at index2 and index2-1 (same as remove())
            // plain copy&paste from before, just replace h1 with h2, and prev1 with prev2
            for(int i=0;i<index2 && h2.next != null;i++) {
                prev2 = h2;
                h2 = h2.next;
            }


            if(h1 == prev2) {
                // e.g. swap(1,2)
                // A     -> B     -> C
                // prev1    h1       h2
                //          prev2

                prev1.next = h2;
                h1.next = h2.next;
                h2.next = h1;
            }
            else {
                // e.g. swap(1, 4);
                // A     -> B  -> C  -> D     -> E
                // prev1    h1          prev2    h2

                // vertausche h1.next/h2.next
                Element tmp = h1.next;
                h1.next = h2.next;
                h2.next = tmp;

                // make sure the elements before h1 and h2 point to the correct element
                prev1.next = h2;
                prev2.next = h1;
            }
        }
        System.out.println("swap("+index1+","+index2+"): " + this);
    }


    public String toString() {
        if(head == null)
            return "[]";

        String str = "[";
        Element h = head;
        while(h!=null) {
            str += h.value + ", ";
            h=h.next;
        }
        return str.substring(0,str.length()-2) + "]";
    }

    public void remove(int index1, int index2) {

        Element h2 = head;
        for (int i = 0; i < index2; i++) {
            h2 = h2.next;
        }

        if(index1 == 0) {
            head = h2.next;
        }
        else {
            Element prev1 = head;
            Element h1 = head;
            for (int i = 0; i < index1; i++) {
                prev1 = h1;
                h1 = h1.next;
            }

            prev1.next = h2.next;
        }

    }






    // Object removeAt(int index)
    // void insertFront(Object obj)
    // int indexOf(Object obj)

    public static void main(String[] args) {

        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        try {
          System.out.println("date: " + simpledateformat.parse("2100-06-27").getTime());
        }
        catch (ParseException ex) {
        }
        byte foo = (byte)0xF0;

        System.out.println("foo: " + foo);
        System.out.println("foo: " + (foo & 0xFF));

        if(false) {
        Liste liste = new Liste();

        liste.add("Markus");
        liste.add("Tom");
        liste.add("Kartin");
        liste.add("Rudi");

        System.out.println("           "+liste);

        liste.swap(0,0);
        liste.swap(1,2);
        liste.swap(1,3);
        liste.swap(0,2);
        liste.swap(0,4);
        liste.swap(6,7);
        }

//        Object obj = liste.get(0);
//        String s = (String)obj;
//
////        Integer a = (Integer)obj;
////        int ai = a.intValue();
//
//        System.out.println("Liste(0): " + s);
    }











}
