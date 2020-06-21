package org.eisber.mobile;

import javax.microedition.lcdui.*;
import javax.microedition.rms.*;

public class Store extends Form implements CommandListener
{
  private TextField field;

  public Store()
  {
    super("Store New Entry");

    // Set up this Displayable to listen to command events
    setCommandListener(this);

    field = new TextField("Kilometer","",10,TextField.ANY);
    append(field);

    // add the Exit command
    addCommand(new Command("Ok", Command.OK, 1));
    addCommand(new Command("Back", Command.BACK, 1));
  }

  public void commandAction(Command command, Displayable displayable)
  {
    switch(command.getCommandType())
    {
        case Command.OK:
      // could be done more clever?!
          byte[] data = field.getString().getBytes();

          try
          {
            MainMIDlet.getStore().addRecord(data, 0, data.length);
          }
          catch (RecordStoreNotOpenException ex)
          {
            ex.printStackTrace();
          }
          catch (RecordStoreException ex)
          {
            ex.printStackTrace();
          }
          // fall thru
        case Command.BACK:
          MainMIDlet.getDisplay().setCurrent(new MainForm());
          break;
    }

  }

}
