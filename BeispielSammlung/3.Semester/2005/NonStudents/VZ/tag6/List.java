package tag6;

public interface List
{
    /**
     * Fuegt das Object am ende ein
     */
    public void append(Object o);

  // public ist automatisch
  void insert(Object o, int index);

  int length();

  Object getAt(int index);

  Object removeAt(int index);

  // "A", "B", "C"
  // o ... "B"
  // indexOf("B") ... 1
  int indexOf(Object o);

  // "A", "B", "A", "C"
  // indexOf("A",1) ... 2
  int indexOf(Object o, int index);//suchen
}
