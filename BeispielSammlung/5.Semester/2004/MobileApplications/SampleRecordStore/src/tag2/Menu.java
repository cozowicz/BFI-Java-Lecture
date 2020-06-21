package tag2;

import javax.microedition.lcdui.*;

public class Menu extends List implements CommandListener
{
  public Menu()
  {
    super("Overview", List.IMPLICIT);

    // Set up this Displayable to listen to command events
    setCommandListener(this);
    // add the Exit command
    addCommand(new Command("Exit", Command.EXIT, 1));

    append("Add",null);
    append("List",null);
  }

  public void commandAction(Command command, Displayable displayable)
  {
    /** @todo Add command handling code */
    if (command.getCommandType() == Command.EXIT)
    {
      // stop the MIDlet
      MIDletRecordStore.quitApp();
    }
    else if(command == List.SELECT_COMMAND)
    {
      switch(getSelectedIndex())
      {
        case 0: // Add
          break;

        case 1: // List
          break;
      }
    }
  }

}
