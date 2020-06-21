/**
 * <b>Musterlösung</b><br>
 * Invertiert ein Array.
 */
public class ArrayInvertieren {

	/**
	 * Dreht die Reihenfolge der Elemente des übergebenen Arrays um.
	 * @param array Das zu invertierende Array.
	 */
	static void invert(int[] array) {
		// Tausche erstes mit letztem Element, zweites mit vorletzem, ...
		int endindex = array.length-1;
		for (int i = 0; i < array.length/2; i++) {
			int temp = array[i];
			array[i] = array[endindex-i];
			array[endindex-i] = temp;
		}
	}

	/**
	 * Main-Methode mit Testfällen.
	 */
	public static void main(String[] args) {
		// Testfall 1: Array mit gerader Anzahl an Elementen
		int[] array1 = { 1, 2, 3, 4, 5, 6 };
		invert(array1);
		
		// Testfall 2: Array mit ungerader Anzahl an Elementen
		int[] array2 = { 1, 2, 3, 4, 5, 6, 7 };
		invert(array2);

		// Testfall 3: Leeres Array
		int[] array3 = {};
		invert(array3);

		// Testfall 4: Array mit einem Element
		int[] array4 = { 5 };
		invert(array4);
	}
	
}
