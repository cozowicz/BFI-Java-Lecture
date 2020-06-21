package tag7;

public interface List
{
    /**
     * Haengt ein neues Object am ende an
     *
     * @param obj Object das am ende angehaengt wird
     */
    public void append(Object obj);

  // Alle methoden in Interfaces sind automatisch "public"

  /**
   * Entfernt object aus der liste
   *
   * @param index position an der es entfernt wird
   * @return Object des entfernt wurde bzw. null wenn nicht gefunden
   */
  Object removeAt(int index);

  /**
   * liefert element an stelle index
   */
  Object getAt(int index);

  /**
   * @return Liefert die laenge der liste
   */
  public int getLength();
}
