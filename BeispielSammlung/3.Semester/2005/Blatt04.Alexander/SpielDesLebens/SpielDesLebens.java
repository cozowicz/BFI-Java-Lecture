/*
 * Created on 25.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package main;

import ConsoleIO.In;

/**
 * @author aw
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SpielDesLebens {

	public static void main(String[] args) {
		boolean spielFeld[][];
		int generation;
		
		char eingabe = ' ';
		
		try {
			// spielFeld = leseSpielFeld ("spiel1.dat");
			generation = 1;
			spielFeld = initSpielfeld (16);

			spielFeldAusgeben (spielFeld, generation);
			
			do
			{
				 generation++;
				 spielFeld = neuesSpielfeldBerechnen (spielFeld);
				 spielFeldAusgeben(spielFeld, generation);
				 
				 System.out.print ("Weiter (Q) zum beenden ");
				 
				 String eingabeLine = In.readLine();
				 if (eingabeLine.length() >= 1)
				 	eingabe = eingabeLine.charAt (0);
			} while (eingabe != 'q');
		}
		catch (Exception e)
		{
			System.err.println ("Etwas schlimmes ist passiert");
			System.err.println (e.getMessage());
			e.printStackTrace();
		}
	}

	private static boolean[][] initSpielfeld (int anzahlZeilenSpalten)
	{
		boolean[][] spielFeld = new boolean[anzahlZeilenSpalten][anzahlZeilenSpalten];

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
		return spielFeld;
	}

	private static boolean[][] neuesSpielfeldBerechnen(boolean[][] altesSpielFeld)
	{
		int anzahlZeilen = altesSpielFeld.length;
		int anzahlSpalten = altesSpielFeld[0].length;
		
		boolean[][] neuesSpielfeld = new boolean [anzahlZeilen]
												 [anzahlSpalten];
		
		for (int idxZeile = 0; idxZeile < anzahlZeilen; idxZeile++)
		{
			for (int idxSpalte = 0; idxSpalte < anzahlSpalten; idxSpalte++)
			{
				int anzahlNachbarn = anzahlNachbarnBerechnen (altesSpielFeld, 
															  idxZeile, idxSpalte);
				if (altesSpielFeld [idxZeile][idxSpalte])
				{
					// zelle lebendig
					if (anzahlNachbarn == 2 || anzahlNachbarn == 3)
						neuesSpielfeld [idxZeile][idxSpalte] = true;
					else
						neuesSpielfeld [idxZeile][idxSpalte] = false;
				}
				else
				{
					// zelle tot
					if (anzahlNachbarn == 3)
						neuesSpielfeld [idxZeile][idxSpalte] = true;
					else
						neuesSpielfeld [idxZeile][idxSpalte] = false;
				}
			}
		}
		// generation erhöhen
		return neuesSpielfeld;
	}

	/**
	 * @param altesSpielfeld
	 * @param idxZeile
	 * @param idxSpalte
	 * @return
	 */
	private static int anzahlNachbarnBerechnen(boolean[][] spielFeld, 
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
	
	/**
	 * @param spielFeld
	 */
	private static void spielFeldAusgeben(boolean[][] spielFeld, int generation) {
		System.out.println ("Generation: " + generation);
		for (int idxZeile = 0; idxZeile < spielFeld.length; idxZeile++)
		{
			for (int idxSpalte = 0; idxSpalte < spielFeld[0].length; idxSpalte++)
			{
				if (spielFeld[idxZeile][idxSpalte])
				{
					System.out.print (" *");
				}
				else
				{
					System.out.print (" .");
				}
			}
			System.out.println ();
		}
		System.out.println();
	}

	private static boolean [][] leseSpielFeld (String dateiName)
	{
		int groesse = 0;
		boolean[][] spielFeld = null;

		In.open (dateiName);
		if (In.done ())
		{
			String strGroesse = In.readLine ();
			groesse = Integer.parseInt(strGroesse);
			
			spielFeld = new boolean[groesse][groesse];
			
			System.out.println ("Groesse = " + groesse);
				
			for (int idxZeile = 0; idxZeile < groesse; idxZeile++)
			{
				String zeile = In.readLine();
				
				System.out.println ("Zeile " + idxZeile + ": " + zeile);
				
				if (zeile.length() != groesse)
				{
					throw new RuntimeException ("Zeile " + idxZeile + " hat eine falsche Groesse.");
				}
				for (int idxSpalte = 0; idxSpalte < groesse; idxSpalte++)
				{
					char c = zeile.charAt(idxSpalte);
					if (c == '0')
					{
						spielFeld[idxZeile][idxSpalte] = false;
					}
					else if (c == '1')
					{
						spielFeld[idxZeile][idxSpalte] = true;
					}
					else
					{
						throw new RuntimeException ("Ungültiges Zeichen in Spielfelddatei");
					}
				} // for idxSpalte
			} // for idxZeile
		}
		else
		{
			throw new RuntimeException ("Datei " + dateiName + " nicht gefunden.");
		}
		// TODO do this also in case of exception
		In.close ();
		
		return spielFeld;
	} // leseSpielFeld
}
