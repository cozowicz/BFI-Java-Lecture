package at.fhvie.progprakt.collection;

/**
 */
public class InvalidIndexException extends Exception {

	private int index;

	public InvalidIndexException(String message, int index) {
		super(message);
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	
	
}
