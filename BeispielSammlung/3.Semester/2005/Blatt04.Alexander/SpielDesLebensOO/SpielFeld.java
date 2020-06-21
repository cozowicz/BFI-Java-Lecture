/*
 * Created on 16.12.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package main;

/**
 * @author aw
 *
 * Diese Klasse repräsentiert ein Spielfeld zu einem Zeitpunkt.
 * 
 */
public class SpielFeld {
	private boolean[][] spielFeld;
	private int generation;

	/**
	 * 
	 * @param groesse
	 */
	public SpielFeld (int groesse)
	{
		spielFeld = new boolean[groesse][groesse];
		generation = 1;
	}
	
	public void initRandom ()
	{
		int anzahlZeilenSpalten = spielFeld.length;
		for (int idxZeile = 0; idxZeile < anzahlZeilenSpalten; idxZeile++)
		{
			for (int idxSpalte = 0; idxSpalte < anzahlZeilenSpalten; idxSpalte++)
			{
				if (Math.random () < 0.5)
					spielFeld[idxZeile][idxSpalte] = true;
				else
					spielFeld[idxZeile][idxSpalte] = false;
			}
		}
	}
	
	public SpielFeld neuesSpielfeldBerechnen()
	{
		int anzahlZeilen = getAnzahlZeilen();
		int anzahlSpalten = getAnzahlSpalten();
		
		// altesSpielfeld == this
		
//		boolean[][] neuesSpielfeld = new boolean [anzahlZeilen]
//												 [anzahlSpalten];
		SpielFeld neuesSpielfeld = new SpielFeld (anzahlZeilen);
		
		for (int idxZeile = 0; idxZeile < anzahlZeilen; idxZeile++)
		{
			for (int idxSpalte = 0; idxSpalte < anzahlSpalten; idxSpalte++)
			{
				int anzahlNachbarn = anzahlNachbarnBerechnen (this.spielFeld, 
															  idxZeile, idxSpalte);
				if (this.getZelle(idxZeile, idxSpalte))
				{
					// zelle lebendig
					if (anzahlNachbarn == 2 || anzahlNachbarn == 3)
						neuesSpielfeld.setZelle (idxZeile, idxSpalte, true);
					else
						neuesSpielfeld.setZelle (idxZeile, idxSpalte, false);
				}
				else
				{
					// zelle tot
					if (anzahlNachbarn == 3)
						neuesSpielfeld.setZelle (idxZeile, idxSpalte, true);
					else
						neuesSpielfeld.setZelle (idxZeile, idxSpalte, false);
				}
			}
		}
		// generation erhöhen
		neuesSpielfeld.generation = this.generation + 1;
		return neuesSpielfeld;
	}

	/**
	 * @param altesSpielfeld
	 * @param idxZeile
	 * @param idxSpalte
	 * @return
	 */
	private int anzahlNachbarnBerechnen(boolean[][] spielFeld, 
										int idxZeileAktuell, int idxSpalteAktuell) {
		final int ZEILE = 0;
		final int SPALTE = 1;
//		int [][] offsets = new int[8][2];
//		offsets[0][ZEILE] = -1;		// offset zeile
//		offsets[0][SPALTE] = -1;		// offset spalte
//		offsets[1][ZEILE] = -1;
//		offsets[1][SPALTE] = 0;
//		offsets[2][ZEILE] = -1;
//		offsets[2][SPALTE] = 1;
//		offsets[3][ZEILE] = 0;
//		offsets[3][SPALTE] = -1;
//		offsets[4][ZEILE] = 0;
//		offsets[4][SPALTE] = 1;
//		offsets[5][ZEILE] = 1;
//		offsets[5][SPALTE] = -1;
//		offsets[6][ZEILE] = 1;
//		offsets[6][SPALTE] = 0;
//		offsets[7][ZEILE] = 1;
//		offsets[7][SPALTE] = 1;

		final int [][] offsets = { 
				{ -1, -1 },  
				{ -1, 0 },
				{ -1, 1 }, 
				{ 0, -1 },
				{ 0, 1 },
				{ 1, -1 },
				{ 1, 0 },
				{ 1, 1 }
		};
				
		int anzahlNachbarn = 0;
		int anzahlZeilen = spielFeld.length;
		int anzahlSpalten = spielFeld[0].length;

		
		for (int idxOffset = 0; idxOffset < offsets.length; idxOffset++)
		{
			int idxZeileNeu = (idxZeileAktuell + offsets[idxOffset][ZEILE] + anzahlZeilen) % anzahlZeilen;
			int idxSpalteNeu = (idxSpalteAktuell + offsets[idxOffset][SPALTE] + anzahlSpalten) % anzahlSpalten;
			
			if (spielFeld [idxZeileNeu][idxSpalteNeu])
				anzahlNachbarn++;
		}
		
//		for (int idxZeile = idxZeileAktuell-1; idxZeile <= idxZeileAktuell+1; idxZeile++)
//		{
//			for (int idxSpalte = idxSpalteAktuell-1; idxSpalte < idxSpalteAktuell+1; idxSpalte++)
//			{
//				if (idxSpalte != idxSpalteAktuell && idxZeile != idxZeileAktuell)
//				{
//					int idxSpalteNeu = (idxSpalte+anzahlSpalten) % anzahlSpalten;
//					int idxZeileNeu = (idxZeile+anzahlZeilen) % anzahlZeilen;
//					
//					if (spielFeld [idxZeileNeu][idxSpalteNeu])
//						anzahlNachbarn++;
//				}
//			}
//		}
		
		return anzahlNachbarn;
	}


	public boolean getZelle (int zeile, int spalte)
	{
		return spielFeld[zeile][spalte];
	}

	/**
	 * @param idxZeile
	 * @param idxSpalte
	 * @param b
	 */
	private void setZelle(int idxZeile, int idxSpalte, boolean setzen) {
		spielFeld[idxZeile][idxSpalte] = setzen;
	}

	/**
	 * Liefert die Anzahl der Zeilen im Spielfeld
	 * @return
	 */
	public int getAnzahlZeilen() {
		return spielFeld.length;
	}

	/**
	 * Liefert die Anzahl der Spalten im Spielfeld
	 * @return
	 */
	public int getAnzahlSpalten() {
		return spielFeld[0].length;
	}

	/**
	 * @return
	 */
	public int getGeneration() {
		return generation;
	}
	
	public int getAnzahlLebendeZellen()
	{
		// TODO implementieren
		return 0;
	}
}
