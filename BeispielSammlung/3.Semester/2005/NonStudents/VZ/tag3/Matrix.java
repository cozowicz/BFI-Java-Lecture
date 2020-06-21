package tag3;

public class Matrix
{
  private int[][] zahlen;

  public Matrix(int[][] z)
  {
    zahlen = z;
  }

  public Matrix addition(Matrix m)
  {
    int[][] erg = new int[zahlen.length][zahlen[0].length];
    for (int i = 0; i < zahlen.length; i++)
    {
      for (int j = 0; j < zahlen[i].length; j++)
      {
        // mit "m." kann auf member variablen von Matrix m
        // zugegriffen werdne
        erg[i][j] = zahlen[i][j] + m.zahlen[i][j];
      }
    }

    return new Matrix(erg);
  }

  // multiplikation
  // transpose

public Matrix multiplikation(Matrix m)
  {
    int [][] erg=new int [zahlen.length][m.zahlen[0].length];

    for (int i=0; i<zahlen.length; i++)
    {
      for (int j=0; j<m.zahlen[0].length; j++)
      {
        int sum=0;
        for (int k=0; k<m.zahlen.length; k++)
        {
          sum=sum+zahlen[i][k]*m.zahlen[k][j];
          erg[i][j]=sum;
        }
      }
    }
    return new Matrix(erg);
  }

  public void print()
  {
    for (int i = 0; i < zahlen.length; i++)
    {
      for (int j = 0; j < zahlen[i].length; j++)
      {
        System.out.print(zahlen[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args)
  {
    /**
     * 1 2 3
     * 4 5 6
     */
    int[][] z1 = { {1,2,3}, {4,5,6} };
    /**
     * 7 8 9
     * 2 4 6
     */
    int[][] z2 = { {7,8,9}, {2,4,6} };
    /**
     * 1 2
     * 3 4
     * 5 6
     */
    int [][] z4 = { {1,2}, {3,4}, {5,6}};

    Matrix m1 = new Matrix(z1);
    Matrix m2 = new Matrix(z2);

    Matrix m3 = m1.addition(m2);

    Matrix m4 = new Matrix(z4);
    Matrix m5 = m4.multiplikation(m1);

    System.out.println("m1");
    m1.print();
    System.out.println("m2");
    m2.print();
    System.out.println("m1+m2");
    m3.print();
    System.out.println("m4");
    m4.print();
    System.out.println("m4 x m1");
    m5.print();
  }
}



    /*
Inserted by Janki

Anhand dieses Beispiels habe ich versucht das objektorientierte
     Denken zu verstärken!

War nur als Beispiel und nicht als ausführbaren code gedacht.

int punktX=1;
int punktY=2;

bewege (richtungX, richtungY)
{
  punktX=punktX+richtungX;
  punktY=punktY+richtungY;
}

public Class Punkt
{
    public Punkt(int initX, int initY)
    {
       x=initX;
       y=initY;
    }

    private int x;
    private int y;

    void bewege(int richtungX, int richtungY)
    {
       x=x+richtungX;
       y=y+richtungY;
    }

    void print()
    {
      System.out.println("X-Koordinate="+x+" Y-Koordinate="+y);
    }


}


   Punkt p1=new Punkt(3,7);
   p1.print();
   p1.bewege(10,-3);
   p1.print();

   Punkt p2=new Punkt(11,-5);
   p2.bewege(1,2);

   Punkt p3=new Punkt();

   */
