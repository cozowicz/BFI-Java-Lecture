/**
 * <b>Musterlösung</b><br>
 * Beispiel Artikelliste; Startklasse.
 */
public class RunArtikelliste {

	public static void main(String[] args) {
		TableContentModel tableContentModel = new MyTableModel();
		TabelleFrame frame = new TabelleFrame(tableContentModel);
		frame.show();
	}
	
}
