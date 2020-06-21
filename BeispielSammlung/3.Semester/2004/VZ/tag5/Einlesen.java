package tag5;

import java.io.*;

public class Einlesen
{
  public static void main(String[] args)
  {
    try
    {
// c:\\cvs\\home\\eisber\\work\\bfi-svn\\trunk\\2004\\WS\\T3\\data\\products
      BufferedReader br = new BufferedReader(new FileReader("data/products"));
      String line;

      Product[] prods = new Product[50];
      int prodCount = 0;

      while ( (line = br.readLine()) != null)
      {
        System.out.println("Eingelesene Zeile: " + line);

        Product p = new Product();
        // product fuellen mit setImage, setPrice,...

        int pos = line.indexOf(",",0);
        // -1 wenn nicht gefunden
        String name = line.substring(0,pos);

        String priceStr = "1.42";
      // line.substring(pos1, pos2);
      //;
        try
        {
          // Integer.parseInt()
          float price = Float.parseFloat(priceStr);
        }
        catch (NumberFormatException ex1)
        {
          // ueberspringt den rest der schleife
          // und geht zum naechsten durchgang
          continue;
        }

        prods[prodCount] = p;
        prodCount++;
      }

      for (int i = 0; i < prodCount; i++)
      {
        String name = prods[i].getName();
        System.out.println("Product.Name: " + name);
      }

      br.close();
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("Datei nicht gefunden!");
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
  }
}
