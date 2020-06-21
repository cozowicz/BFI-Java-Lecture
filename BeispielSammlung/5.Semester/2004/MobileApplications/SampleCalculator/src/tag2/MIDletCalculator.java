package tag2;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MIDletCalculator extends MIDlet
{
  static MIDletCalculator instance;
  Eingabe displayable = new Eingabe();
  public MIDletCalculator()
  {
    instance = this;
  }

  public void startApp()
  {
    // Display.getDisplay(MIDletCalculator.instance)
    Display.getDisplay(this).setCurrent(displayable);
  }

  public void pauseApp()
  {
  }

  public void destroyApp(boolean unconditional)
  {
  }

  public static void quitApp()
  {
    instance.destroyApp(true);
    instance.notifyDestroyed();
    instance = null;
  }

}
