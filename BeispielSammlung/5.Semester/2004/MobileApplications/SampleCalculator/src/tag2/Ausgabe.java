package tag2;

import javax.microedition.lcdui.*;

public class Ausgabe extends Form implements CommandListener
{
  public Ausgabe(int z1, int z2)
  {
    super("Ergebnis Addition");

    // 3 + 4 =10
    append("" + z1 + " + " + z2 + " = " + (z1 + z2));

    // Set up this Displayable to listen to command events
    setCommandListener(this);
    // add the Exit command
    addCommand(new Command("Exit", Command.EXIT, 1));
  }

  public void commandAction(Command command, Displayable displayable)
  {
    /** @todo Add command handling code */
  }

}
