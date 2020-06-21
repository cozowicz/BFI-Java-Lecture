package org.eisber.mobile;

import javax.microedition.lcdui.*;

public class MainForm extends List implements CommandListener
{
//  private Command storeCmd;
//  private Command listCmd;

  public MainForm()
  {
    super("Record Management",List.IMPLICIT);

    // Set up this Displayable to listen to command events
    setCommandListener(this);
    // add the Exit command
    addCommand(new Command("Exit", Command.EXIT, 1));

    append("Snake", null);
    append("Store",null);
    append("List",null);

    // have it under "more"
    // Command.SCREEN ... Custom action
    // 1 ... priority
    /*
    storeCmd = new Command("Store",Command.SCREEN,1);
    list.addCommand(storeCmd);
    listCmd = new Command("List",Command.SCREEN,1);
    list.addCommand(listCmd);
     */
  }

  public void commandAction(Command command, Displayable displayable)
  {
    if(command == List.SELECT_COMMAND)
    {
      switch(getSelectedIndex())
      {
        case 0: // Snake
          Snake snake = new Snake();
          MainMIDlet.getDisplay().setCurrent(snake);
          snake.start();
          break;
        case 1: // Store
          MainMIDlet.getDisplay().setCurrent(new Store());
          break;
        case 2: // List
          MainMIDlet.getDisplay().setCurrent(new ListRecords());
          break;
      }
    }
    else
    {
      switch (command.getCommandType())
      {
        case Command.EXIT:

          // stop the MIDlet
          MainMIDlet.quitApp();
          break;
        case Command.SCREEN:
          /*
                  if(command == storeCmd)
                  {

                  }
                  else if(command == listCmd)
                  {

                  }
                  break;
           */
      }
    }
  }

}
