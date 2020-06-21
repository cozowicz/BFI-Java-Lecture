package tag2;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MIDletRecordStore extends MIDlet
{
  static MIDletRecordStore instance;
  Menu displayable = new Menu();
  public MIDletRecordStore()
  {
    instance = this;
  }

  public void startApp()
  {
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
