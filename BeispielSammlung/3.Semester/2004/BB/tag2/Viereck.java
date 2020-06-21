// package namen klein
package tag2;

public class Viereck
{

  int x1, x2, x3, x4;
  int y1, y2, y3, y4;

  public Viereck(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4)
  {
    this.x1 = x1;
    this.x2 = x2;
    this.x3 = x3;
    this.x4 = x4;
    this.y1 = y1;
    this.y2 = y2;
    this.y3 = y3;
    this.y4 = y4;
  }

  public boolean isQuadrat()
  {
    if ( ( (x2 - x1) == (x3 - x4)) &&
        ( (y4 - y1) == (y3 - y2)) &&
        ( (y4 - y1) == (x2 - x1)))
    {
      return true;
    }
    else
      return false;
  }

  public boolean isRechteck()
  {
    if ( ( (x2 - x1) == (x3 - x4)) &&
        ( (y4 - y1) == (y3 - y2)) &&
        ( (y4 - y1) != (x2 - x1)) &&
        (x1 == x4) &&
        (x2 == x3) &&
        (y1 == y2) &&
        (y4 == y3))
    {
      return true;
    }
    else
      return false;
  }

  public boolean isRaute()
  {
    if ( ((x2 - x1) == (x3 - x4)) &&
         ((y4 - y1) == (y3 - y2)) &&
         ((y4 - y1) != (x2 - x1)) &&
         (((y3 - y2) * (y3 - y1) + (x3 - x2) * (x3 - x2)) ==
         ((x2 - x1) * (x2 - x1))))
    {
      return true;
    }
    else
      return false;
  }

  public boolean isParallelogramm()
  {
    if ( ((x2 - x1) == (x3 - x4)) &&
         ((y4 - y1) == (y3 - y2)))
    {
      return true;
    }
    else
      return false;
  }

}
