package org.eisber.mobile;

import javax.microedition.lcdui.*;
import java.io.*;

/**
 * Hier werden die Daten, welche vorher mit dem Generate Project
 * erzeugt worden sind, eingelesen.
 *
 * @author Markus Cozowicz (eisber@eisber.net)
 * @version $Revision$
 */
public class LoadPreStoredData extends List implements CommandListener
{
  private Product[] products;

  public LoadPreStoredData()
  {
    super("Data...", List.IMPLICIT);

    try
    {
      // der / (slash) ist sehr wichtig
      InputStream in = getClass().getResourceAsStream("/products.bin");
      if (in == null)
      {
        System.out.println("Could not find products");
        return;
      }

      DataInputStream dis = new DataInputStream(in);

      // wichtig! ohne anzahl ist nicht klar wie oft eingelesen werden
      // soll.
      int numberOfEntries = dis.readInt();
      products = new Product[numberOfEntries];

      System.out.println("reading " + numberOfEntries);
      for (int i = 0; i < numberOfEntries; i++)
      {
        // wir erzeugen uns objekte
        // damit wir angenehm damit arbeiten koennen
        Product prod = new Product();

        prod.setName(dis.readUTF());
        prod.setImage(dis.readUTF());
        prod.setPrice(dis.readInt());
        prod.setGroup(dis.readUTF());

        products[i] = prod;

//        System.out.println("product name: " + prod.getName());
        append(prod.getName(),null);
      }
    }
    catch (Throwable ex)
    {
      ex.printStackTrace();
    }

    System.out.println("done");
    // Set up this Displayable to listen to command events
    setCommandListener(this);
    // add the Exit command
    addCommand(new Command("Exit", Command.EXIT, 1));
  }

  public void commandAction(Command command, Displayable displayable)
  {
    /** @todo Add command handling code */
    if (command.getCommandType() == Command.EXIT)
    {
      // stop the MIDlet
      // PreStoredDataMidlet.quitApp();
    }
  }

}
