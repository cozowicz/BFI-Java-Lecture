package tag6;

public class SimpleList implements List
{
  // Klasse nur innerhalb von SimpleList verfuegbar
  class Element
  {
    public Object data;
    public Element next;
  }

  private Element start;

  public void append(Object o)
  {
    if(start == null)
    {
      start = new Element();
      // dot notation
      start.data = o;
      start.next = null;
    }
    else
    {
      Element h = start;
      while(h.next != null)
        h = h.next;

      Element e = new Element();
      e.data = o;
      e.next = null;
      h.next= e;
    }
  }

  public Object getAt(int index)
  {
    if(start == null)
    {
      return null;
    }
    else
    {
      Element h = start;
      while(h.next != null && index > 0)
      {
        h = h.next;
        index--;
      }

      return h.data;
    }
  }

  public void insert(Object o, int index)
  {
  }

  public int length()
  {
    return 0;
  }

  public Object removeAt(int index)
  {
    return null;
  }

  public int indexOf(Object obj)
  {
    return indexOf(obj, 0);
  }

  public int indexOf(Object obj, int index)
  {
    if(start == null)
      return -1;
    else
    {
      // gehe bis index
      int count = 0;

      Element h = start;
      while(h.next != null && count < index)
      {
        h = h.next;
        count++;
      }
      // jetzt suchen!

      while(h != null && !h.data.equals(o))
      {
        h = h.next;
        count++;
      }
      if(h == null)
        return -1;
      else
        return count;
    }
  }

  public static void main(String[] args)
  {
    List list = new SimpleList();

    list.append("FishMac");
    list.append("Cheese Burger");

    // cast
    String s0 = (String)list.getAt(0);
    String s1 = (String)list.getAt(1);

    System.out.println("Element mit index 0: " + s0);
    System.out.println("Element mit index 1: " + s1);
  }
}
