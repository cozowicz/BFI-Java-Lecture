/**
 * 
 */
package fh_vie.ac.at.Vorbereitung.Einheit3;

/**
 * @author Clemens Klee<br>
 * Erstellt am 16.03.2006<br>
 * Version 1.0
 */
public class DVDTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DVDRekorder d = new DVDRekorder(100);
		d.addSendung(new Film(20,15,22,00,"ORF 1","Spiderman","Maguire"));
		d.addSendung(new Sendung(20,00,20,10,"ORF 1","Sport"));
		
		//d.print();
		d.insertSendung(new Sendung(20,00,20,10,"ORF 2","Seitenblicke"),1);
		d.print();
	}

}
