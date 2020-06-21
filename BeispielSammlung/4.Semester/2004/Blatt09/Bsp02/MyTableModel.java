/**
 * <b>Musterlösung</b><br>
 * Beispiel Artikelliste 
 */
public class MyTableModel implements TableContentModel {

	private static final String[] columns = { "Artikel", "Stückzahl", "Stückpreis", "Wert" };

	private Artikel[] rows = new Artikel[15];
	private int rowCount = 0;

	public int getColumnCount() {
		return columns.length;
	}

	public String getColumnName(int columnIndex) {
		return columns[columnIndex];
	}

	public boolean isColumnEditable(int columnIndex) {
		return columnIndex < 3;
	}

	public int getRowCount() {
		return rowCount;
	}

	public String getValueAt(int rowIndex, int columnIndex) {
		Artikel artikel = rows[rowIndex];
		switch (columnIndex) {
			case 0 :
				return artikel.getName();
			case 1 :
				return Integer.toString(artikel.getStueckzahl());
			case 2 :
				return Float.toString(artikel.getStueckpreis());
			case 3 :
				return Float.toString(artikel.getStueckzahl() * artikel.getStueckpreis());
		}
		return null;
	}

	public void setValueAt(String value, int rowIndex, int columnIndex) {
		Artikel artikel = rows[rowIndex];
		switch (columnIndex) {
			case 0 :
				artikel.setName(value);
				break;
			case 1 :
				artikel.setStueckzahl(Integer.parseInt(value));
				break;
			case 2 :
				artikel.setStueckpreis(Float.parseFloat(value));
				break;
		}
	}

	public void insertRowBefore(int rowIndex) {
		// ist noch Platz im rows Array?
		if (rowCount < rows.length) {
			// ja -> füge die Zeile ein
			for (int i = rowCount; i > rowIndex; i--) {
				rows[i] = rows[i-1];
			}
			rows[rowIndex] = new Artikel();
			rowCount++;
		}
	}

	public void removeRowAt(int rowIndex) {
		rowCount--;
		for (int i = rowIndex; i < rowCount; i++) {
			rows[i] = rows[i+1];
		}
	}

	public void load() {
		rowCount = 0;
		In.open("artikel.dat");
		if (In.done()) {
			while (In.done() && rowCount < rows.length) {
				Artikel artikel = new Artikel();
				artikel.setStueckzahl(In.readInt());	
				artikel.setStueckpreis(In.readFloat());
				In.read(); // überspringe Space (siehe save)
				artikel.setName(In.readLine());
				rows[rowCount++] = artikel;
			}
			In.close();
		}
	}

	public void save() {
		Out.open("artikel.dat");
		if (Out.done()) {
			for (int i = 0; i < rowCount && Out.done(); i++) {
				Artikel artikel = rows[i];
				Out.print(artikel.getStueckzahl());	
				Out.print(" ");	
				Out.print(artikel.getStueckpreis());	
				Out.print(" ");	
				Out.println(artikel.getName());
			}
			Out.close();
		}
	}

}
