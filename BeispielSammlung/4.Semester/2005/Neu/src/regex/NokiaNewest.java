package regex;

import java.net.*;
import java.util.regex.*;
import java.util.*;
import java.io.*;

public class NokiaNewest {
    public static void main(String[] args) throws Exception {
        // <img src="/pool/pics/phones/phone_models/phone_model_6103.gif" width="126" height="126" alt="Nokia 6103" border="0" /></a>

        StringBuffer doc = new StringBuffer();

        InputStream in = new URL("http://www.nokia.at/german/phones/phone_models/latest_20.html").openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        while((line = br.readLine()) != null) {
            doc.append(line+"\n");
        }

//        System.out.println(doc);

        // () group
        // [] character classes
        // + 1..n
        // * 0..n
        // ? 0..1
        // optional [0-9]{3,5}
        // escape'n mit \ fuer (,[,...
        // ^ ... anfang
        // $ ... ist ende
        // "." ... ist beliebiges zeichen
        // ^([^:]+):(.+)$
        // clemens:hallo
        // clemens: hallo
        Pattern p = Pattern.compile("<img src=\"([^\"]+)\" width=\"([0-9]+)\" height=\"[0-9]+\" alt=\"([^\"]+)\"",Pattern.MULTILINE);
        //Pattern p = Pattern.compile("<img src=\"([^\"]+)\"",Pattern.MULTILINE);
        Matcher m = p.matcher(doc);

        while(m.find()) {
            System.out.println("Alles: " + m.group(0));
            System.out.println("Handy: " + m.group(3));
            System.out.println();
        }
    }
}
