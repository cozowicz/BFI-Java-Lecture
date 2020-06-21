public class SingleLinkedList {

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

	public boolean contains(Object o) {
		return contains(o, head);
	}
	
	private boolean contains(Object o, SingleLinkedListNode node) {
		if (node != null) {
			if (node.value.equals(o)) {
				return true;
			} else {
				return contains(o, node.next);
			}
		} else {
			return false;
		}
		/* Alternative Implementierung
		 * return node != null && (node.value.equals(o) || contains(o, node.next));
		 */
	}
	
	// TODO Die restlichen Methoden der Liste sind hier nicht ausimplementiert.


}
