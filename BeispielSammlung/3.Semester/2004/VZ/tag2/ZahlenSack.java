package tag2;

public class ZahlenSack
{
  private int[] zahlen;

  // public ZahlenSack(int[] zahlen)
  public ZahlenSack(int[] pz)
  {
    // this.zahlen = zahlen;
    zahlen = pz;
  }

  public int summe()
  {
    int sum = 0;
    for (int i = 0; i < zahlen.length; i++)
       sum = sum + zahlen[i];
    return sum;
  }

  public int min()
  {
    if(zahlen.length == 0)
      return 0;

    int m = zahlen[0];
    for (int i = 1; i < zahlen.length; i++)
    {
      if(m > zahlen[i])
        m = zahlen[i];

    }
    return m;
  }

  public double durchschnitt()
  {
    double s = summe();
    return s / zahlen.length;
  }

  // zweitKleinstes

  // bubbleSort

  // binSearch

  public void sort()
  {
    boolean keinTausch;
    do
    {
      keinTausch = true;
      for (int i = 0; i < zahlen.length - 1; i++)
      {
        if (zahlen[i]>zahlen[i+1])
        {
          int h=zahlen[i];
          zahlen[i]=zahlen[i+1];
          zahlen[i+1]=h;
          keinTausch = false;
        }
      }
    }
    while (!keinTausch);
  }

  public void print()
  {
    for (int i=0; i<zahlen.length; i++)
    {
      System.out.print(zahlen[i]+" ");
    }
    System.out.println();
  }

  //  binSearch
  public int finde(int x)
  {
    int low=0;
    int high=zahlen.length-1;

    while (low<=high)
    {
      int m=(low+high)/2;

      if (zahlen[m]==x)
        return m;

      else if (x>zahlen[m])
        low=m+1;

      else
        high=m-1;
    }
    return -1;
  }

  public static void main(String[] args)
  {
    int[] z = {5,13,1,2,3,4,1};

    ZahlenSack zs =
      // erzeugt neues object
      // ruft constructor
      new ZahlenSack( z ) ;
    System.out.println("zs=");
    zs.print();
    System.out.println("Sortieren ...");
    zs.sort();
    System.out.println("zs=");
    zs.print();
    System.out.println("Summe: " + zs.summe());
    System.out.println("Zahl 4 ist an Position: "+zs.finde(4));
    System.out.println("Zahl 7 ist an Position: "+zs.finde(7));
  }
}
