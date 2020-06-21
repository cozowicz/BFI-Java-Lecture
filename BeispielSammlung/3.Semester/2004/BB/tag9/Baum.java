package tag9;

public class Baum
{
  class Element
  {
    public int data;

    public Element left;
    public Element right;
  }

  private Element root;


  void add(int zahl)
  {
    if(root == null) // baum ist leer
    {
      root = new Element();
      root.data = zahl;
    }
    else
    {
      Element h = root;

      while(true)
      {
        if (h.data > zahl)
        {
          if (h.left == null)
          {
            h.left = new Element();
            h.data = zahl;
            return;
          }
          else
            h = h.left;
        }
        else
        {
          if (h.right == null)
          {
            h.right = new Element();
            h.data = zahl;
            return;
          }
          else
            h = h.right;
        }
      }
    }
  }

  boolean suchen(int zahl)
  {
    if(root == null) // baum ist leer
    {
      return false;
    }
    else
    {
      Element h = root;

      while(true)
      {
        if (h.data == zahl)
          return true;

        if (h.data > zahl)
        {
          if (h.left == null)
            return false;
          else
            h = h.left;
        }
        else
        {
          if (h.right == null)
            return false;
          else
            h = h.right;
        }
      }
    }
  }
}
