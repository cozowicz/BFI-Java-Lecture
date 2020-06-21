import java.util.ArrayList;
import java.util.LinkedList;

public class PerformanceTest {

	public static void main(String[] args) {
		int length = 30000;
		ArrayList arrayList = new ArrayList();
		LinkedList linkedList = new LinkedList();

		// ---- ADD ----

		// Messung ArrayList add(0, x)
		long start = System.currentTimeMillis();
		for (int i = 0; i < length; i++) {
			arrayList.add(0, new Double(Math.random()*1000));
		}
		long end = System.currentTimeMillis();
		System.out.println("ArrayList mit "+length+" add(0, x)-Calls: "+(end-start)+"ms");
		
		// Messung LinkedList add(0, x)
		start = System.currentTimeMillis();
		for (int i = 0; i < length; i++) {
			linkedList.add(0, new Double(Math.random()*1000));
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedList mit "+length+" add(0, x)-Calls: "+(end-start)+"ms");

		// ---- GET ----

		// Messung ArrayList get
		start = System.currentTimeMillis();
		for (int i = 0; i < length; i++) {
			Double random = (Double) arrayList.get(i);
		}
		end = System.currentTimeMillis();
		System.out.println("ArrayList mit "+length+" get-Calls: "+(end-start)+"ms");
		
		// Messung LinkedList get
		start = System.currentTimeMillis();
		for (int i = 0; i < length; i++) {
			Double random = (Double) linkedList.get(i);
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedList mit "+length+" get-Calls: "+(end-start)+"ms");
	}
	
}
