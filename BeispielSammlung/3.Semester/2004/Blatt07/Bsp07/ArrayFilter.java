public class ArrayFilter {
	
	private int filterCount = 0;
	private FilterAlgorithmus[] filters = new FilterAlgorithmus[10];

	/**
	 * Nimm einen Filteralgorithmus in die Liste der Filteralgorithmen auf.
	 */
	public boolean register(FilterAlgorithmus filterAlgorithmus) {
		if (filterCount < filters.length) {
			filters[filterCount++] = filterAlgorithmus;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Frage alle registrierten Filter, ob das Element ausgefiltert oder behalten werden soll.
	 */
	private boolean keepElement(int element) {
		for (int i = 0; i < filterCount; i++) {
			if (!filters[i].keepElement(element)) {
				return false;
			} 
		}
		return true;
	}

	/**
	 * Generiere ein Array mit den ersten size Elementen aus dem uebergebenen Array.
	 */
	private int[] buildSubArray(int[] array, int size) {
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			result[i] = array[i];
		} 
		return result;
	}

	/**
	 * Erzeugt ein gefiltertes Array. Dazu wird zu jedem Element des uebergebenen Arrays keepElement 
	 * aufgerufen, um festzustellen, ob das Element ausgefiltert oder behalten werden soll.
	 */
	public int[] filter(int[] array) {
		int[] filteredArray = new int[array.length];
		int filteredArraySize = 0;
		for (int i = 0; i < array.length; i++) {
			if (keepElement(array[i])) {
				filteredArray[filteredArraySize++] = array[i];
			} 
		}
		return buildSubArray(filteredArray, filteredArraySize);
	}

}
