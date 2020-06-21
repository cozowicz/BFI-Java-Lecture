package neu;

import java.util.*;

public class ArrayListBsp {

    public static void main(String[] args) {

        // generics
        ArrayList<String> strList = new ArrayList<String>();

        strList.add("Hallo");

        String s = strList.get(0);

        // auto-unboxing
        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(2);
        int abc = intList.get(0);

    }
}
