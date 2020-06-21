package org.eisber.mobile;

import java.util.*;
import java.io.*;

/**
 * Hier werden die Daten aus der Text Datei in ein format umgewandelt,
 * das in J2ME leicht eingelesen werden kann.
 *
 * @author Markus Cozowicz (eisber@eisber.net)
 * @version $Revision$
 */
public class WriteDataFile
{
  public static void main(String[] args) throws Exception
  {
    ArrayList list = new ArrayList();

    // read complete file
    BufferedReader br = new BufferedReader(new FileReader("data/products.txt"));
    String line;
    while( (line = br.readLine()) != null)
    {
      list.add(line);
    }
    br.close();

    // write compressed file
    DataOutputStream out = new DataOutputStream(new FileOutputStream("data/products.bin"));

    // write number of records
    out.writeInt(list.size());

    // loop over data
    Iterator iter = list.iterator();
    while (iter.hasNext())
    {
      String l = (String) iter.next();
      // BigMac,big_mac,2.75,Burger
      String[] fields = l.split(",");

      out.writeUTF(fields[0]); // Bezeichnung
      out.writeUTF(fields[1]); // Image name
      float f = Float.parseFloat(fields[2]);
      out.writeInt((int)f); // preis, kein float support of mobile plattform
      out.writeUTF(fields[3]); // Gruppe
    }
    out.close();

  }
}
