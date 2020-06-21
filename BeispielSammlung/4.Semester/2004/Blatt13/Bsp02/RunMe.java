
public class RunMe {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.addFirst("E3");
		list.addFirst("E2");
		list.addFirst("E1");
		System.out.println("contains(E2) = "+list.contains("E2"));
		System.out.println("contains(E4) = "+list.contains("E4"));
	}
}
