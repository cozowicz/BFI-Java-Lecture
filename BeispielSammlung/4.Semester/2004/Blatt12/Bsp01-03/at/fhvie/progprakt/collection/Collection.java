package at.fhvie.progprakt.collection;

public interface Collection {
	/**
	 * Fügt ein Element an erster Stelle in die Collection ein.
	 * @param o Das einzufügende Element.
	 */
	void addFirst(Object o);
	
	/**
	 * Hängt ein Element am Ende der Collection an.
	 * @param o Das anzuhängende Element.
	 */
	void addLast(Object o);
	
	/**
	 * Fügt ein Element an einer bestimmten Position in die Collection ein.
	 * @param index Die Position, an der das Element eingefügt werden soll. Gültig 
	 * von 0 bis size().
	 * @param o Das einzufügende Element.
	 * @throws InvalidIndexException Wird geworfen, wenn ein ungültiger Index 
	 * übergeben wurde.
	 */
	void insertAt(int index, Object o) throws InvalidIndexException;
	
	/**
	 * Löscht ein Element an einer bestimmten Position.
	 * @param index Die Position, an der das Element gelöscht werden soll. Beginnt mit 0.
	 * @throws InvalidIndexException Wird geworfen, wenn ein ungültiger Index 
	 * übergeben wurde.
	 */
	void deleteAt(int index) throws InvalidIndexException;
	
	/**
	 * Löscht alle Elemente in der Collection.
	 */
	void clean();
	
	/**
	 * Liefert das Element an einer bestimmten Position.
	 * @param index Die Position, von der das Element geliefert werden soll.
	 * @return Das Element an Position index.
	 * @throws InvalidIndexException Wird geworfen, wenn ein ungültiger Index 
	 * übergeben wurde.
	 */
	Object getAt(int index) throws InvalidIndexException;

	/**
	 * Liefert die Elementanzahl der Collection.
	 * @return
	 */
	int size();
}
