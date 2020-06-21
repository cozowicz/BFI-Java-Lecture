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
public class SpielDesLebensOO {

	public static void main(String[] args) {
		SpielFeld spielFeld;
		
		char eingabe = ' ';
		
		try {
			// spielFeld = leseSpielFeld ("spiel1.dat");

			// spielFeld = initSpielfeld (16);
			spielFeld = new SpielFeld (16);
			spielFeld.initRandom();

			spielFeldAusgeben (spielFeld, spielFeld.getGeneration());
			
			do
			{
				 spielFeld = spielFeld.neuesSpielfeldBerechnen ();
				 spielFeldAusgeben(spielFeld, spielFeld.getGeneration());
				 
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

	/**
	 * @param spielFeld
	 */
	private static void spielFeldAusgeben(SpielFeld spielFeld, int generation) {
		System.out.println ("Generation: " + generation);
		for (int idxZeile = 0; idxZeile < spielFeld.getAnzahlZeilen(); idxZeile++)
		{
			for (int idxSpalte = 0; idxSpalte < spielFeld.getAnzahlSpalten(); idxSpalte++)
			{
				if (spielFeld.getZelle(idxZeile, idxSpalte))
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
