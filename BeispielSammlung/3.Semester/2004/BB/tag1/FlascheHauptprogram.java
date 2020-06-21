package tag1;

public class FlascheHauptprogram
{
  // hier faengt das program an!
  public static void main(String[] args)
  {
    Flasche f = new Flasche(10,10);
    boolean ruckgabewert = f.voll();
    System.out.println("voll: " + ruckgabewert);

    f = new Flasche(0,10);
    System.out.println("voll: " + f.voll());
  }
}
