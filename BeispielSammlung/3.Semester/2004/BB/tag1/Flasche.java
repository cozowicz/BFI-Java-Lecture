package tag1;

// Einzeliges Kommentar
/* Mehrzeiliges
   Kommentar
 */

// Klassen Definition
public class Flasche
{
  // member variablen
  private int menge;
  private int kapazitat;

  // methoden
  // Konstruktor
  // new Flasche(10,10)
  public Flasche(int menge, int b)
  {
    // wegen namenskonflikt
    this.menge = menge;
    kapazitat = b;
  }

  // function voll() as boolean
  public boolean voll()
  {
    // != ... ungleich
    // <
    // >
    // && ... and
    // || ... or
    // ! ... not (   !(menge == kapazitaet) )
    // S.39 im buch
    if(menge == kapazitat)
      return true;
    else
    {
      // wenn mehr als eine zeile
      return false;
    }
  }

  public boolean leer()
  {
    // selber machen
    return false;
  }
}
