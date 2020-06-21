package at.fhvie.progprakt.listetest;

import at.fhvie.progprakt.collection.Collection;
import at.fhvie.progprakt.collection.InvalidIndexException;
import at.fhvie.progprakt.collection.liste.SingleLinkedList;

public class ListeTest {

	public static void main(String[] args) {
		Collection list = new SingleLinkedList();
		try {
			list.insertAt(0, "E1");
			list.insertAt(1, "E3");
			list.insertAt(0, "E0");
			list.insertAt(2, "E2");
		} catch (InvalidIndexException ex) {
			ex.printStackTrace();
		}
	}
	
}
