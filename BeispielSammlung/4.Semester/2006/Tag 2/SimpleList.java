package fh_vie.ac.at.Vorbereitung.Einheit2;

public class SimpleList
{
  // nested klassen
  class Element
  {
    private Object data;
    private Element next;
  }

  private Element start;
  private int size = 0;
  
  public void append(Object data)
  {
    if(start == null)
    {
      start = new Element();
      start.next = null;
      start.data = data;
      size++;
    }
    else
    {
      Element h = start;

      while(h.next != null)
        h = h.next;

      Element e = new Element();
      // Dot Notation
      e.data = data;
      e.next = null;

      h.next = e;
      size++;
    }
  }

  public Object getAt(int index) throws EmptyListException,InvalidIndexException
  {
    if(index > size){
    	throw new InvalidIndexException("Index außerhalb der Grenzen",index);
    }
	// liste leer
    else if(start == null)
    {
      throw new EmptyListException("Liste ist leer!");
    }
    else
    {
      Element h = start;

      while(h.next != null && index > 1)
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
    return size;
  }

  public void removeAt(int index) throws EmptyListException,InvalidIndexException
  {
	if(index > getLength())
		throw new InvalidIndexException("Index nicht vorhanden",index);
	
	if(size == 0)
		throw new EmptyListException("Liste ist leer");
	
    Element h = start;
    Element e;
    int i = 1;
    while(h.next != null && i < index-1){
    	h = h.next;
    	i++;
    }
    
    e = h.next;
    while(e.next != null && index > 1){
    	e = e.next;
    	index--;
    }
    
    h.next = e;
    size--;
  }

  public void print(){
	  Element h = start;
	  int i = 1;
	  while(i<=size){
		  System.out.println(h.data);
		  h = h.next;
		  i++;  
	  }
  }
  
  public static void main(String[] args)
  {
    SimpleList l = new SimpleList();
    
    l.append(1);
    l.append(3);
    l.append(5);
    l.append(7);
    int i = 0;
    int j = 0;
    System.out.println(l.getLength());
    try{
    i = (Integer)l.getAt(1);
    j = (Integer)l.getAt(3);
    
    System.out.println("Element an Stelle 1: " + i);
    System.out.println("Element an Stelle 3: " + j);
        
    l.removeAt(3);
    
    i = (Integer)l.getAt(1);
    j = (Integer)l.getAt(3);
    }
    catch (InvalidIndexException iex){
    	System.out.println(iex.getMessage() +" "+ iex.getIndex());
    	System.exit(0);
    }
    catch (EmptyListException elex){
    	System.out.println(elex.getMessage());
    }
    
    
    System.out.println(l.getLength());
    System.out.println("Element an Stelle 1: " + i);
    System.out.println("Element an Stelle 3: " + j);
    l.print();
  }

}
