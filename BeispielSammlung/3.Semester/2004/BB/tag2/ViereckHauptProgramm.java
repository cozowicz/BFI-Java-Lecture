package tag2;

public class ViereckHauptProgramm {
/* Punke werden so gelegt:

   x4,y4               x3,y3

   x1,y1               x2,y2

 Und in der Reihenfolge:
 x1,y1, x2, y2, x3, y3, x4, y4

 eingelesen.

*/
public static void main(String[] args) {
    Viereck d = new Viereck(2,1,4,1,6,5,4,5);
    d = new Viereck(1,1,2,1,2,2,1,2);
    if (d.isQuadrat() == true) {
      System.out.println("Quadrat!");
    }
    if (d.isRechteck() == true) {
      System.out.println("Rechteck!");
    }
    if (d.isRaute() == true) {
      System.out.println("Raute!");
    }
    d = new Viereck(2,1,4,1,6,5,4,5);
    if (d.isParallelogramm() == true) {
      System.out.println("Parallelogramm!");
    }
  }
}
