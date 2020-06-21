public class Main {

	public static void main(String[] args) throws Exception {
		try {
			ObjectArray array = new ObjectArray(5);
			array.insert(0, "Element 1");
			array.insert(1, "Element 2");
			array.insert(0, "Element 0");
			array.insert(3, "Element 3");
			array.insert(1, "Element X");
			// OverflowException
			array.insert(1, "Element Y");
		} catch (InvalidIndexException ex) {
			ex.printStackTrace();
		} catch (OverflowException ex) {
			ex.printStackTrace();
		}
		
		try {
			ObjectArray array = new ObjectArray(3);
			array.insert(0, "Element 1");
			// InvalidIndexException
			array.insert(2, "Element X");
		} catch (InvalidIndexException ex) {
			ex.printStackTrace();
			System.out.println("ex.getIndex() = "+ex.getIndex());
		} catch (OverflowException ex) {
			ex.printStackTrace();
		}
	}
	
}
