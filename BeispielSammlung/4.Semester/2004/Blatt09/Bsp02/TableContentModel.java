/**
 * <b>Angabe</b><br>
 * Schnittstelle zwischen GUI und Datenverwaltung. 
 */
public interface TableContentModel {

	/**
	 * Gibt zur�ck, wieviele Spalten die Tabelle besitzen soll.
	 * @return Anzahl der Tabellenspalten.
	 */
	public int getColumnCount();

	/**
	 * Gibt den Spaltentitel der Tabellenspalten am gefragten Index zur�ck.
	 * @param columnIndex Index der Spalte (mit 0 beginnend).
	 * @return Spaltentitel der Spalte.
	 */
	public String getColumnName(int columnIndex);

	/**
	 * Gibt zur�ck, ob die Zellen einer Tabellenspalte editierbar sind. 
	 * @param columnIndex Index der Spalte (mit 0 beginnend).
	 * @return true f�r editierbar; ansonsten false.
	 */
	public boolean isColumnEditable(int columnIndex);

	/**
	 * Gibt an, wieviele Zeilen die Tabelle besitzen soll.
	 * @return Anzahl der Tabellenzeilen.
	 */
	public int getRowCount();
	
	/**
	 * Gibt den Wert der Tabellenzelle an einem bestimmen Zeilen- und Spaltenindex zur�ck.
	 * @param rowIndex Index der Zeile (mit 0 beginnend).
	 * @param columnIndex Index der Spalte (mit 0 beginnend).
	 * @return Wert der Tabellenzelle.
	 */
	public String getValueAt(int rowIndex, int columnIndex);
	
	/**
	 * Setzt den Wert einer Tabellenzelle nach dem Editieren.
	 * @param value Wert der Tabellenzelle.
	 * @param rowIndex Zeilenindex der Tabellenzelle (mit 0 beginnend).
	 * @param columnIndex Spaltenindex der Tabellenzelle (mit 0 beginnend).
	 */
	public void setValueAt(String value, int rowIndex, int columnIndex);
	
	/**
	 * F�gt eine Zeile unmittelbar vor dem �bergenen Index ein. 
	 * @param rowIndex Index, an dem eine Zeile eingef�gt werden soll (0 bedeutet vor der ersten Zeile).
	 */
	public void insertRowBefore(int rowIndex);
	
	/**
	 * L�scht eine Zeile am �bergebenen Index.
	 * @param rowIndex Index, an dem die Zeile gel�scht werden soll (0 bedeutet erste Zeile).
	 */
	public void removeRowAt(int rowIndex);
	
	/**
	 * L�dt eine zuvor gespeicherte Artikelliste von einer Datei.
	 */
	public void load();
	
	/**
	 * Speichert die Artikelliste in eine Datei. 
	 */
	public void save();
		
}
