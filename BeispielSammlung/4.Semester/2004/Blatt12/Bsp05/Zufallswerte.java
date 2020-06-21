import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Zufallswerte {

	public static void main(String[] args) {
		List l1 = new ArrayList();
		for (int i = 0; i < 10; i++) {
			l1.add(new Double(Math.random()));
		}
		List l2 = new LinkedList();
		l2.addAll(l1);
		for (int i = 0; i < l2.size(); i++) {
			Double zufallswert = (Double) l1.get(i);
			System.out.println((i+1)+": "+zufallswert);
		}
	}
	
}
