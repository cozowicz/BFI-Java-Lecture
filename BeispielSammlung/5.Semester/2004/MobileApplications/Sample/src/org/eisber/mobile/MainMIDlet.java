package org.eisber.mobile;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.*;

public class MainMIDlet extends MIDlet
{
  static MainMIDlet instance;

  private RecordStore store;

  public MainMIDlet()
  {
    instance = this;
  }

  public void startApp()
  {
    // initial form
    Display.getDisplay(this).setCurrent(new MainForm());

    try
    {
      store = RecordStore.openRecordStore("MyStore", true);
    }
    catch (RecordStoreException ex)
    {
      // todo display nice error msg
      ex.printStackTrace();
    }
  }

  public void pauseApp()
  {
  }

  public void destroyApp(boolean unconditional)
  {
    try
    {
      if (store != null)
      {
        store.closeRecordStore();
      }
    }
    catch (RecordStoreNotOpenException ex)
    {
      ex.printStackTrace();
    }
    catch (RecordStoreException ex)
    {
      ex.printStackTrace();
    }
  }

  public static void quitApp()
  {
    instance.destroyApp(true);
    instance.notifyDestroyed();
    instance = null;
  }

  public static Display getDisplay()
  {
    return Display.getDisplay(instance);
  }

  public static RecordStore getStore()
  {
    return instance.store;
  }

}
