public class ElementFilter extends FilterAlgorithmus {
	
	private int[] allowedElements;
	
	public ElementFilter(int[] allowedElements) {
		this.allowedElements = allowedElements;
	}

	/**
	 * Prueft, ob das uebergebene Element in der Menge der erlaubten Elemente liegt. 
	 */
	public boolean keepElement(int element) {
		for (int i = 0; i < allowedElements.length; i++) {
			if (element == allowedElements[i]) {
				return true;
			} 
		}
		return false;
	}

}
