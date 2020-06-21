package tag2;

import javax.microedition.lcdui.*;

public class Eingabe extends Form implements CommandListener
{
  TextField zahl1;
  TextField zahl2;

  public Eingabe()
  {
    super("Zahlen Eingeben");

    // Set up this Displayable to listen to command events
    setCommandListener(this);
    // add the Exit command
    addCommand(new Command("Exit", Command.EXIT, 1));
    addCommand(new Command("Addieren", Command.OK, 1));

    // (String label, String text, int maxSize, int constraints)
    zahl1 = new TextField("Zahl 1:", "", 4, TextField.NUMERIC);
    append(zahl1);
    zahl2 = new TextField("Zahl 2:", "", 4, TextField.NUMERIC);
    append(zahl2);
  }

  public void commandAction(Command command, Displayable displayable)
  {
    /** @todo Add command handling code */
    if (command.getCommandType() == Command.EXIT)
    {
      // stop the MIDlet
      MIDletCalculator.quitApp();
    }
    else if(command.getCommandType() == Command.OK)
    {
      int z1 = Integer.parseInt(zahl1.getString());
      int z2 = Integer.parseInt(zahl2.getString());

      // z1+z2
      Display.getDisplay(MIDletCalculator.instance)
          .setCurrent(new Ausgabe(z1, z2));
    }
  }

}







