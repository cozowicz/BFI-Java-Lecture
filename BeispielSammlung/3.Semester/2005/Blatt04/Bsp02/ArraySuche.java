/**
 * <b>Musterlösung</b><br>
 * Sucht nach einem Wert in einem zufällig initialisierten
 * Integer Array und bestimmt dessen Häufigkeit.
 */
public class ArraySuche {

	public static void main(String[] args) {
		System.out.print("Elementanzahl: ");
		int elementAnzahl = In.readInt();
		int[] array = new int[elementAnzahl];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random()*10);
		}
		System.out.print("Zu suchende Zahl: ");
		int wert = In.readInt();
		int anzahl = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == wert) {
				anzahl++;
			}
		}
		System.out.println(wert+" kommt "+anzahl+" mal im Array vor.");
		// Tipp: Prüfen Sie die Korrektheit der Ausgabe mit dem Debugger.
	}

}
