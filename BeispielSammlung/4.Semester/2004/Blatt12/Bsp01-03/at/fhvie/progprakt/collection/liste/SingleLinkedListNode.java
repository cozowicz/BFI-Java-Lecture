package at.fhvie.progprakt.collection.liste;

class SingleLinkedListNode {

	SingleLinkedListNode next;
	Object value;
	
	public SingleLinkedListNode(Object value, SingleLinkedListNode next) {
		this.value = value;
		this.next = next;
	}

}
