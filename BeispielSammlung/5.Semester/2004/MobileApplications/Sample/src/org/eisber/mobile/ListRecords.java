package org.eisber.mobile;

import javax.microedition.lcdui.*;
import javax.microedition.rms.*;
import java.util.*;

public class ListRecords extends List implements CommandListener
{
  public ListRecords()
  {
    super("All Records", List.IMPLICIT);

    // Set up this Displayable to listen to command events
    setCommandListener(this);

    try
    {
      RecordEnumeration recordEnum = MainMIDlet.getStore().enumerateRecords(null, null, false);
      while (recordEnum.hasNextElement())
      {
        byte[] data = recordEnum.nextRecord();

        append(new String(data),null);
      }
    }
    catch (InvalidRecordIDException ex)
    {
      ex.printStackTrace();
    }
    catch (RecordStoreNotOpenException ex)
    {
      ex.printStackTrace();
    }
    catch (RecordStoreException ex)
    {
      ex.printStackTrace();
    }

    // add the Back command
    addCommand(new Command("Back", Command.BACK, 1));
  }

  public void commandAction(Command command, Displayable displayable)
  {
    MainMIDlet.getDisplay().setCurrent(new MainForm());
  }

}
