package tag7;

public class SimpleList implements List
{
  // nested klassen
  class Element
  {
    public Object data;
    public Element next;
  }

  private Element start;

  public void append(Object obj)
  {
    if(start == null)
    {
      start = new Element();
      start.next = null;
      start.data = obj;
    }
    else
    {
      Element h = start;

      while(h.next != null)
        h = h.next;

      Element e = new Element();
      // Dot Notation
      e.data = obj;
      e.next = null;

      h.next = e;
    }
  }

  public Object getAt(int index)
  {
    // liste leer
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

      /*
      for(int i = 0; h.next != null && i < index; i++)
        h = h.next;
      */
      return h.data;
    }
  }

  public int getLength()
  {
    return 0;
  }

  public Object removeAt(int index)
  {
    return null;
  }


  public static void main(String[] args)
  {
    List l = new SimpleList();

    l.append("Markus");
    l.append("Cozowicz");

    String s0 = (String)l.getAt(0);
    String s1 = (String)l.getAt(1);

    System.out.println("Element an Stelle 0: " + s0);
    System.out.println("Element an Stelle 1: " + s1);
  }

}
