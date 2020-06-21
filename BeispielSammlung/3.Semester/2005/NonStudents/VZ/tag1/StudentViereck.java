// $Id$
package tag1;

public class StudentViereck {

  private int x1;
  private int y1;
  private int x2;
  private int y2;
  private int x3;
  private int y3;
  private int x4;
  private int y4;


// Die vier Ecken werden eingegeben: links unten, gegen Uhrzeigersinn

  public StudentViereck(int x1,int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
    this.x1=x1;
    this.y1=y1;
    this.x2=x2;
    this.y2=y2;
    this.x3=x3;
    this.y3=y3;
    this.x4=x4;
    this.y4=y4;

    }

    double getkante(int welche)
    {
      int punkt1x;
      int punkt1y;
      int punkt2x;
      int punkt2y;

      switch(welche)
      {
        case 1:
          punkt1x=x1;
          punkt1y=y1;
          punkt2x=x2;
          punkt2y=y2;
          break;
        case 2:
          punkt1x=x2;
          punkt1y=y2;
          punkt2x=x3;
          punkt2y=y3;
          break;
        case 3:
          punkt1x=x3;
          punkt1y=y3;
          punkt2x=x4;
          punkt2y=y4;
          break;
        default:
          punkt1x=x4;
          punkt1y=y4;
          punkt2x=x1;
          punkt2y=y1;
          break;
      }
      int xdiff;
      int ydiff;
      xdiff=punkt1x-punkt2x;
      ydiff=punkt1y-punkt2y;

      return(Math.sqrt(xdiff*xdiff+ydiff*ydiff));

    }

    double umfang()
    {
      return getkante(1)+getkante(2)+getkante(3)+getkante(4);
    }

    boolean isTrapez() // Trapez: obere und untere Kante auf einer Linie
    {
      if((y1==y2)&&(y3==y4)) return true;
      else return false;
    }

    boolean isRaute() // Raute: alle 4 Längen gleich
    {
      if((getkante(1)==getkante(2))&&(getkante(3)==getkante(4))&&(getkante(1)==getkante(4))) return true;
      else return false;
    }

    boolean isRechteck()
    {
      if((x1==x4)&&(x2==x3)&&(y1==y2)&&(y3==y4)) return true;
        else return false;
    }
    boolean isQuadrat()
    {
      if(this.isRechteck() && this.isRaute()) return true;
      else return false;
    }

    boolean isParalellogramm() // Seiten 1,3 und 2,4 sind gleich lang
    {
      if( (getkante(1)==getkante(3))&&(getkante(2)==getkante(4)) ) return true;
      else return false;

    }

    boolean isDeltoid()
    {
      if( (getkante(1)==getkante(2)) && (getkante(3)==getkante(4)) )
      {
        return true;
      }
      else
      {
        if( (getkante(2)==getkante(3)) && (getkante(1)==getkante(4)) )
        {
          return true;
        }
        else
        {
          return false;
        }
      }

    }

  public static void main(String[] args) {
    StudentViereck viereck1 = new StudentViereck(1,0,2,2,1,3,0,2);

    System.out.println("Umfang:"+viereck1.umfang());

    if (viereck1.isRaute())
      System.out.println("Raute");
    else
    {
      System.out.println("Nicht Raute");
      if (viereck1.isRechteck())
        System.out.println("Rechteck");
      else
        System.out.println("Nicht Rechteck");
      if (viereck1.isQuadrat())
        System.out.println("Quadrat");
      else
        System.out.println("Nicht Quadrat");
      if (viereck1.isTrapez())
        System.out.println("Trapez");
      else
        System.out.println("Nicht Trapez");
      if (viereck1.isParalellogramm())
        System.out.println("Paralellogramm");
      else
        System.out.println("Nicht Paralellogramm");
      if (viereck1.isDeltoid())
        System.out.println("Deltoid");
      else
        System.out.println("Nicht Deltoid");
    }
  }

}
