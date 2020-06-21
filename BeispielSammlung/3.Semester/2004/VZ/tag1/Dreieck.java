// $Id$
package tag1;

/**
 * Generelle Information bzgl. Klassen/Objekten kann auf Buch S. 143 gefunden werden
 *
 * @author Markus Cozowicz
 * @version 1.1
 */
public class Dreieck
{
  // Member variablen
  private int a;
  private int b;
  private int c;

  // Constructor
  public Dreieck(int p_a, int p_b, int p_c)
  {
    this.a = p_a;
    this.b = p_b;
    this.c = p_c;
  }


  public int getUmfang()
  {
    return a + b + c;

    // in visual basic
    // getUmfang = a + b + c
    // b = 3

    /* java equivalent:

    int erg = a + b + c;
    b = 3;
    return erg;
    */
  }

  boolean isGleichschenklig()
  {
    // == ... vergleich
    // != ... ungleich
    // =  ... zuweisung
    // || ... oder
    // && ... und
    // bei nur einer zeile kann { } weggelassen werden
    // Buch S.42
    if(a == b || b == c || a == c)
      return true;
    else
    {
      return false;
    }
  }

  /* Hauptprogram */
  public static void main(String[] args)
  {
    Dreieck dreieck =

      new Dreieck(1,2,3);

    dreieck = new Dreieck(5,5,6);

    int ergebnis = dreieck.getUmfang();
    System.out.println("Umfang vom Dreieck: " +  ergebnis);

    boolean gleich = dreieck.isGleichschenklig();
    System.out.println("Ist das dreieck gleichschenklig: " + gleich);

//    dreieck.isRechtWinklig();
//    dreieck.isGleichtseitig();
    int zahl1 = 3, zahl2 = 5;
    int max;

    if(zahl1 > zahl2)
    {
      int kat1;
      max = zahl1;
    }
    else
      max = zahl2;

  }
}
