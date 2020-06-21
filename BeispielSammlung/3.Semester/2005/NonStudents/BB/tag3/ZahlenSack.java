package tag3;

public class ZahlenSack
{
  private int[] zahlen;

  public ZahlenSack(int[] pz)
  {
    pz = null;
    zahlen = pz;
  }

  public int summe()
  {
    int sum = 0;
    // for i = 0 to zahlen.length step 1
    // i++
    // i = i + 1
    for (int i = 0; i < zahlen.length; i++)
    {
      // sum += zahlen[i];
      sum = sum + zahlen[i];
    }
    return sum;
  }

  public int min()
  {
    int kleinstes = zahlen[0];

    for (int i = 1; i < zahlen.length; i++)
    {
      if(zahlen[i] < kleinstes)
        kleinstes = zahlen[i];
    }

    return kleinstes;
  }

  public int max()
  {
    int groesstes = zahlen[0];
    for (int i = 1; i < zahlen.length; i++)
    {
      if(zahlen[i] > groesstes)
        groesstes = zahlen[i];
    }

    return groesstes;
  }

  public int zweitKleinstes()
  {
    if(zahlen.length == 0)
      return 0;

    if(zahlen.length == 1)
      return zahlen[0];

    int min1 = zahlen[0];
    int min2 = zahlen[1];

    for (int i = 2; i < zahlen.length; i++)
    {
      if(zahlen[i] < min1)
      {
        min2 = min1;
        min1 = zahlen[i];
      }
      else if(zahlen[i] < min2)
        min2 = zahlen[i];
    }

    return min2;
  }

  public int indexOf(int element)
  {
    for (int i = 0; i < zahlen.length; i++)
    {
      if(zahlen[i] == element)
        return i;
    }
    return -1;
  }

  public void print()
  {
    for (int i = 0; i < zahlen.length; i++)
    {
      System.out.print(zahlen[i] + " ");
    }
    System.out.println();
  }


  public static void main(String[] args)
  {
    // nur beispiel
    int[] bsp = new int[3];
    bsp[0] = 1;

    int[] z = {6,7,2,8};
    ZahlenSack zs = new ZahlenSack(z);

    System.out.println("Summe: " + zs.summe());
  }
}









