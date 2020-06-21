package org.eisber.mobile;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class PreStoredDataMidlet extends MIDlet
{
  static PreStoredDataMidlet instance;
  LoadPreStoredData displayable = new LoadPreStoredData();
  public PreStoredDataMidlet()
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
