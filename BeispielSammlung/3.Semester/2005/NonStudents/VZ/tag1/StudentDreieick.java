// $Id$
package tag1;

/**
 * <p>Überschrift: </p>
 * <p>Beschreibung: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Organisation: </p>
 * @author unbekannt
 * @version 1.0
 */

public class StudentDreieick { //neue Klasse
  // member variablen
  private int a;
  private int b;
  private int c;

  //constructor, selber Name wie Klasse
  public StudentDreieick(int p_a, int p_b, int p_c) {
    //parameter werden membervariablen zugewiesen
    this.a = p_a;
    this.b = p_b;
    this.c = p_c;
  }

  int getUmfang() { //Methode
    return a + b + c;
    //nach return ist function aus
  }

  boolean istgleichschenkelig() { // == Vergleich
    // != ungleich
    // && und
    // || oder
    // = Zuweisung
    if (a == b || b == c || c == a)
      return true;
    else
      return false;
  }

  boolean istgleichsseitig() {
    if (a == b && b == c)
      return true;
    else
      return false;
  }

  boolean istrechtwinkelig() {
    if ( (a * a + b * b) == (c * c) || (b * b + c * c) == (a * a) ||
        (c * c + a * a) == (b * b))
      return true;
    else
      return false;
  }

  //Hauptprogramm
  public static void main(String[] args) {
    //Typ    Variablenname
    StudentDreieick dreieick = new StudentDreieick(3, 3, 3);

    int ergebnis = dreieick.getUmfang();
    System.out.println("Umfang des Dreiecks: " + ergebnis);

    boolean gleichschenkelig = dreieick.istgleichschenkelig();
    boolean gleichseitig = dreieick.istgleichsseitig();
    boolean rechtwinkelig = dreieick.istrechtwinkelig();

    if (gleichschenkelig == true)
      System.out.println("Das Dreieck ist gleichschenkelig ");

    if (gleichseitig == true)
      System.out.println("Das Dreieck ist gleichseitig");

    if (rechtwinkelig == true)
      System.out.println("Das Dreieck ist rechtwinkelig");
  }
  }
