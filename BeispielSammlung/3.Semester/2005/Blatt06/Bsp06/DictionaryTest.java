/**
 * <b>Musterlösung</b><br>
 * Eine einfache Testklasse.
 */
public class DictionaryTest {

	public static void main(String[] args) {
		// Tipp: Verwenden Sie den Debugger, um die Korrektheit
		// des Programms nachzuvollziehen.
		Dictionary d = new Dictionary();
		d.insert("Auto", "car");
		d.insert("Hund", "dog");
		d.insert("Haus", "house");
		System.out.println(d.lookup("Hund"));
		d.remove("Hund");
	}

}
