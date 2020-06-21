package org.eisber.mobile;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Font;

public class Snake extends Canvas implements Runnable
{
  private static final long WAIT_TIME = 50;
  //                                     RRGGBB
  // red - green - blue in hex
  private static final int COLOR_BACKGROUND = 0x00FFFFFF;
  private static final int COLOR_FOREGROUND = 0x00000000;
  private static final Font font = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD | Font.STYLE_ITALIC, Font.SIZE_SMALL);

  private long frameTime;
  private long frameStarted;
  private long fpsStartTime;
  private boolean finished;

  private int lastGameAction;
  private int x;
  private int y;

  int fps;
  int lastFps;
  private StringBuffer fpsStringBuffer = new StringBuffer("0000");
  private char[] messageChars;
  private int messageLength;

  public synchronized void start()
  {
    fps = lastFps = 0;
    // same as new String("fps: ").toCharArray()
    messageChars = "fps: 0000".toCharArray();
    messageLength = messageChars.length - 4;

    lastGameAction = RIGHT;
    x = getWidth() / 2;
    y = getHeight() / 2;

    fpsStartTime = frameStarted = System.currentTimeMillis();
    finished = false;
    Thread animationThread = new Thread(this);
    animationThread.start();
  }

  /**
   * paint
   *
   * @param graphics Graphics
   * @todo Implement this javax.microedition.lcdui.Displayable method
   */
  public void paint(Graphics g)
  {
    // hintergrund loeschen
    g.setColor(COLOR_BACKGROUND);
    g.fillRect(0, 0, getWidth(), getHeight());

    g.setColor(COLOR_FOREGROUND);
    g.setFont(font);

    // schlechte performance
    // g.drawString(frameTime + " ms per frame", 0, 0, Graphics.TOP | Graphics.LEFT);

    fpsStringBuffer.delete(0,fpsStringBuffer.length());
    fpsStringBuffer.append(lastFps);
    fpsStringBuffer.getChars(0,fpsStringBuffer.length(),messageChars,messageLength);

    g.drawChars(messageChars,0,messageLength + fpsStringBuffer.length(),0,0, Graphics.TOP | Graphics.LEFT);
    g.fillRect(x, y, 2, 2);
  }

  public void run()
  {
    Thread currentThread = Thread.currentThread();
    try
    {
      while (!finished)
      {
        frameTime = System.currentTimeMillis() - frameStarted;
        frameStarted = System.currentTimeMillis();

        /*
                 do work calculations
         */

        switch (lastGameAction)
        {
          case KEY_NUM4:
          case LEFT:
            if (x > 0)
              x--;
            break;
          case KEY_NUM2:
          case UP:
            if (y > 0)
              y--;
            break;
          case KEY_NUM6:
          case RIGHT:
            if (x < getWidth())
              x++;
            break;
          case KEY_NUM8:
          case DOWN:
            if (y < getHeight())
              y++;
            break;
        }

        repaint();
        synchronized (this)
        {
          wait(WAIT_TIME);
        }

        if(System.currentTimeMillis() - fpsStartTime > 1000) // second
        {
          lastFps = fps;
          fps = 0;
          fpsStartTime = System.currentTimeMillis();
        }
        else
          fps++;
      }
    }
    catch (InterruptedException ie)
    {
      System.out.println("interrupted");
    }
  }

  public synchronized void keyReleased(int keyCode)
  {
    lastGameAction = getGameAction(keyCode);
  }

}
