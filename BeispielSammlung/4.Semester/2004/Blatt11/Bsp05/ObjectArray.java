public class ObjectArray {

	private Object[] array;
	private int size;

	public ObjectArray(int capacity) {
		array = new Object[capacity];
		size = 0;
	}

	public void insert(int index, Object element) throws InvalidIndexException, OverflowException {
		if (index < 0 || index > size) {
			throw new InvalidIndexException("Der Index "+index+
				" liegt ausserhalb des erlaubten Bereichs!", index);
		} else if (size == array.length) {
			throw new OverflowException("Die Kapazität des Arrays wurde erreicht!");
		} else {
			for (int i = size; i > index; i--) {
				array[i] = array[i-1];
			}
			array[index] = element;
			size++;
		}
	}
}
