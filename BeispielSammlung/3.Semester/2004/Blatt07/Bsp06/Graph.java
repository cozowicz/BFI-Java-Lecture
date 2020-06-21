public class Graph {
	
	private GrafischesObjekt[] objekte = new GrafischesObjekt[100];
	private int anzahlObjekte = 0;
	
	/**
	 * Nimmt ein grafisches Objekt in den Graphen auf.
	 * @param objekt Das aufzunehmende Objekt.
	 * @return true, wenn das Objekt aufgenommen werden konnte; ansonsten false.
	 */
	public boolean add(GrafischesObjekt objekt) {
		if (anzahlObjekte < objekte.length) {
			objekte[anzahlObjekte++] = objekt;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Liefert alle grafischen Objekte innerhalb des übergebenen Rechtecks. Ein
	 * grafisches Objekt wird selektiert, wenn dessen Mittelpunkt innerhalb des
	 * Selektionsrechtecks liegt.
	 * @param selektion Rechteck, über das selektiert werden soll.
	 * @return Alle selektierten grafischen Objekte.
	 */
	public GrafischesObjekt[] selektiere(Rechteck selektion) {
		// Zähle die Objekte in der Selektion.
		int anzahl = 0;
		for (int i = 0; i < anzahlObjekte; i++) {
			if (selektion.contains(objekte[i].getMittelpunkt())) {
				anzahl++;
			}
		}
		// Erzeuge das Ergebnisarray
		GrafischesObjekt[] selektierteObjekte = new GrafischesObjekt[anzahl];
		for (int i = 0; i < anzahlObjekte; i++) {
			if (selektion.contains(objekte[i].getMittelpunkt())) {
				selektierteObjekte[--anzahl] = objekte[i];
			} 
		}
		return selektierteObjekte;
	}

}
