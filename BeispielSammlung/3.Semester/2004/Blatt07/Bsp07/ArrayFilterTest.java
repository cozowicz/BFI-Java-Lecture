/**
 * Klasse zum Testen des ArrayFilters.
 */
public class ArrayFilterTest {

	public static void main(String[] args) {
		ArrayFilter arrayFilter = new ArrayFilter();
		arrayFilter.register(new MinFilter(10));
		arrayFilter.register(new MaxFilter(50));
		int[] erlaubteElemente = { 1, 10, 20, 30, 40, 50, 60 }; 
		arrayFilter.register(new ElementFilter(erlaubteElemente));
		int[] testArray1 = { 1, 10, -15, 20, 13, 17, 60, 50 };
		int[] filteredTestArray1 = arrayFilter.filter(testArray1);
		// filteredTestArray1 sollte sein: { 10, 20, 50 }
		for (int i = 0; i < filteredTestArray1.length; i++) System.out.print(filteredTestArray1[i]+", "); 
	}

}
