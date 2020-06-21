package tag5;

public class Matrix
{
  private int[][] m;

  public Matrix(int[][] m)
  {
    this.m = m;
  }

  public Matrix addition(Matrix mat)
  {
    // m
    // mat.m
    // m.length ... anzahl zeilen
    // m[0].length ... anzahl splaten
    int[][] erg = new int[m.length][m[0].length];

    for (int i = 0; i<m.length; i++)
    {
      for (int j=0; j<m[0].length;j++)
      {
        erg[i][j]=m[i][j]+mat.m[i][j];
      }
    }

    // erg[zeile 1][spalte 2]
    // erg[0][1]

    return new Matrix(erg);
  }




  public void print()
  {
    for (int i = 0; i < m.length; i++)
    {
      for (int j = 0; j < m[0].length; j++)
      {
        System.out.print(m[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args)
  {

    int[][] z1={ {1,2},{3,4} };

    Matrix m7=new Matrix(z1);

    Matrix m1 = new Matrix(new int[][]{
                           {3,2},
                           {5,7},
                           {1,2}});
    Matrix m2 = new Matrix(new int[][]{
                           {1,2},
                           {3,4},
                           {0,9}});

    Matrix m3;
    m3 = m1.addition(m2);
    m3.print();
  }
}
