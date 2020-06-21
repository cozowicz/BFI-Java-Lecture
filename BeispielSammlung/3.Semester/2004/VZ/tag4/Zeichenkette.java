package tag4;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2004</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Zeichenkette
{
  private String kette;

  public Zeichenkette(String s)
  {
    kette=s;
  }

  public void print()
  {
    System.out.println(kette);
  }

// Mit der Klasse theoretisch besprochen
  public int suche(String s)
  {
    int last = kette.length()-s.length();

    for (int i=0; i<=last; i++)
    {
      if (kette.charAt(i)==s.charAt(0))
      {
        int j=1;
        while (j < s.length() && kette.charAt(i+j)==s.charAt(j))
          j++;
        if (j==s.length())
          return i;
      }
    }
    return -1;
  }

// Noch nicht mit der Klasse gemacht
  public int suche2(String s)
  {

    int k=1;
    while (k<s.length()-1 && s.charAt(k)!='*')
      k++;

    if (k<s.length()-1)
    {
      String s1=s.substring(0,k);
      String s2=s.substring(k+1);
      System.out.println("s1="+s1+" s2="+s2);
      int pos1=suche2(s1);
      int pos2=suche2(s2);
      if (pos1!=-1 && pos1<=pos2+s1.length())
        return pos1;
      else
        return -1;
    }
    else
    {
      int last = kette.length() - s.length();

      for (int i = 0; i <= last; i++)
      {
        if (kette.charAt(i) == s.charAt(0))
        {
          int j = 1;
          while (j < s.length() && kette.charAt(i + j) == s.charAt(j))
            j++;
          if (j == s.length())
            return i;
        }
      }
      return -1;
    }
  }


  public static void main(String[] args)
  {
    Zeichenkette zk = new Zeichenkette("Das ist ein Test!");
    zk.print();
    System.out.println("String 'ein' found at position: "+zk.suche2("ein"));
    System.out.println("String 'EIN' found at position: "+zk.suche2("EIN"));
    System.out.println("String 'ist*Test' found at position: "+zk.suche("ist*Test"));
    System.out.println("String 'ist*Test' found at position: "+zk.suche2("ist*Test"));
    System.out.println("String 'i*st' found at position: "+zk.suche2("i*st"));
  }
}
