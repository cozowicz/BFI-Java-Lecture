package at.fhvie.progprakt.collection;

public interface Collection {
	/**
	 * F�gt ein Element an erster Stelle in die Collection ein.
	 * @param o Das einzuf�gende Element.
	 */
	void addFirst(Object o);
	
	/**
	 * H�ngt ein Element am Ende der Collection an.
	 * @param o Das anzuh�ngende Element.
	 */
	void addLast(Object o);
	
	/**
	 * F�gt ein Element an einer bestimmten Position in die Collection ein.
	 * @param index Die Position, an der das Element eingef�gt werden soll. G�ltig 
	 * von 0 bis size().
	 * @param o Das einzuf�gende Element.
	 * @throws InvalidIndexException Wird geworfen, wenn ein ung�ltiger Index 
	 * �bergeben wurde.
	 */
	void insertAt(int index, Object o) throws InvalidIndexException;
	
	/**
	 * L�scht ein Element an einer bestimmten Position.
	 * @param index Die Position, an der das Element gel�scht werden soll. Beginnt mit 0.
	 * @throws InvalidIndexException Wird geworfen, wenn ein ung�ltiger Index 
	 * �bergeben wurde.
	 */
	void deleteAt(int index) throws InvalidIndexException;
	
	/**
	 * L�scht alle Elemente in der Collection.
	 */
	void clean();
	
	/**
	 * Liefert das Element an einer bestimmten Position.
	 * @param index Die Position, von der das Element geliefert werden soll.
	 * @return Das Element an Position index.
	 * @throws InvalidIndexException Wird geworfen, wenn ein ung�ltiger Index 
	 * �bergeben wurde.
	 */
	Object getAt(int index) throws InvalidIndexException;

	/**
	 * Liefert die Elementanzahl der Collection.
	 * @return
	 */
	int size();
}
