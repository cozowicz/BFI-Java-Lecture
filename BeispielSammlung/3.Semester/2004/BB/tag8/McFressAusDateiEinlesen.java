package tag8;

import java.io.*;
import tag7.*;

public class McFressAusDateiEinlesen
{
  public static void main(String[] args)
  {
    try
    {
      List l = new SimpleList();

//      BufferedReader br = new BufferedReader(new FileReader("data\\products"));
      BufferedReader br = new BufferedReader(new FileReader("data/products"));

      String line;

      while( (line = br.readLine()) != null)
      {
        System.out.println("Zeile: " + line);

        Product p = new Product();

        p.setName("BigMac");

        String bspStr = "1.23";
        float price;

        try
        {
          price = Float.parseFloat(bspStr);

          // haenge product an liste an
          l.append(p);
        }
        catch(NumberFormatException nfe)
        { }
      }

      br.close();

      // hole aus liste das erste element
      // und cast-e auf Product
      Product p1 = (Product)l.getAt(0);
      System.out.println("Erste Product: " + p1.getName());



    }
    catch (FileNotFoundException fne)
    {
      System.out.println("Datei nicht gefunden!");
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
  }
}
















