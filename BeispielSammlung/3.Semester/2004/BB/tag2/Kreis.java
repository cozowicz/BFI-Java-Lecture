package tag2;

public class Kreis
{
  private int x;
  private int y;
  private int r;

  public Kreis(int x, int y, int r)
  {
    this.x = x;
    this.y = y;
    this.r = r;
  }

  public boolean imKreis(int x, int y)
  {
    int dx = Math.abs(this.x - x);
    int dy = Math.abs(this.y - y);

    if(dx * dx + dy * dy < r * r)
      return true;
    else
      return false;
  }

  public static void main(String[] args)
  {
    int x = 3;
    Kreis kreis = new Kreis(x,0,4);
    System.out.println("ImKreis: " + kreis.imKreis(1,1));
  }
}






