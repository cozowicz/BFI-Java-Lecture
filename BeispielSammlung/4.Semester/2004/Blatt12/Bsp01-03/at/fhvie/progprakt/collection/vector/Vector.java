package at.fhvie.progprakt.collection.vector;

import at.fhvie.progprakt.collection.Collection;
import at.fhvie.progprakt.collection.InvalidIndexException;

public class Vector implements Collection {
	
	private Object[] array;
	private int size;
	
	public Vector(int initialCapacity) {
		array = new Object[initialCapacity];
		size = 0;
	}

	public void addFirst(Object o) {
		// TODO addFirst
	}

	public void addLast(Object o) {
		// TODO addLast
	}

	/**
	 * Vergrößert das Array um den Faktor 2. Fügt dabei einen Nullwert an 
	 * der Stelle index ein.
	 * @param index Der Index, an dem eine Leerwert eingefügt werden soll.
	 */
	private void resize(int index) {
		Object[] newArray = new Object[Math.max(1, array.length*2)];
		for (int i = 0; i < index; i++) {
			newArray[i] = array[i];
		}
		for (int i = index; i < array.length; i++) {
			newArray[i+1] = array[i];
		}
		array = newArray;
	}

	public void insertAt(int index, Object o) throws InvalidIndexException {
		if (index < 0 || index > size) {
			throw new InvalidIndexException("Ungültiger Index: "+index, index);
		} else {
			if (size == array.length) {
				resize(index);
			} else {
				for (int i = size; i > index; i--) {
					array[i] = array[i-1];
				}
			}
			array[index] = o;
			size++;
		}
	}

	public void deleteAt(int index) throws InvalidIndexException {
		// TODO deleteAt
	}

	public void clean() {
		// TODO clean
	}

	public Object getAt(int index) throws InvalidIndexException {
		// TODO getAt
		return null;
	}

	public int size() {
		return size;
	}

}
