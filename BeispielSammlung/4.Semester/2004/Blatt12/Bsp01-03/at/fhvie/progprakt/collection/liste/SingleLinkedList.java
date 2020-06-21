package at.fhvie.progprakt.collection.liste;

import at.fhvie.progprakt.collection.Collection;
import at.fhvie.progprakt.collection.InvalidIndexException;

public class SingleLinkedList implements Collection {

	private SingleLinkedListNode head = null;
	private SingleLinkedListNode tail = null;
	private int size = 0;

	public void addFirst(Object o) {
		head = new SingleLinkedListNode(o, head);
		if (tail == null) {
			tail = head;
		}
		size++;
	}

	public void addLast(Object o) {
		// TODO addLast
	}

	public void insertAt(int index, Object o) throws InvalidIndexException {
		if (index < 0 || index > size) {
			throw new InvalidIndexException("Ungültiger Index: "+index, index);
		} else {
			if (index == 0) {
				addFirst(o);
			} else if (index == size) {
				addLast(o);
			} else {
				SingleLinkedListNode p = head;
				for (int i = 1; i < index; i++) {
					p = p.next;
				}
				p.next = new SingleLinkedListNode(o, p.next);
				size++;
			}
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
