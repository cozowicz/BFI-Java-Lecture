/**
 * 
 */
package fh_vie.ac.at.Vorbereitung.Einheit1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * @author Clemens Klee<br>
 * Erstellt am 22.02.2006<br>
 * Version 1.0
 */
public class ToDo {
	private String aufgabe;
	private Date erstelldatum;
	private Date faelligkeitsdatum;
	private Date letzteAenderung;
	
	public ToDo(String aufgabe, int dayfaellig, int monthfaellig, int yearfaellig){
		this.aufgabe = aufgabe;
		GregorianCalendar cal = new GregorianCalendar();
		erstelldatum = cal.getTime();
		letzteAenderung = erstelldatum;
		cal.clear();
		cal.set(yearfaellig,monthfaellig-1,dayfaellig);
		faelligkeitsdatum = cal.getTime();
	}

	/**
	 * @return Returns the aufgabe.
	 */
	public String getAufgabe() {
		return aufgabe;
	}

	/**
	 * @param aufgabe The aufgabe to set.
	 */
	public void setAufgabe(String aufgabe) {
		this.aufgabe = aufgabe;
	}

	/**
	 * @return Returns the faelligkeitsdatum.
	 */
	public Date getFaelligkeitsdatum() {
		return faelligkeitsdatum;
	}

	/**
	 * @param faelligkeitsdatum The faelligkeitsdatum to set.
	 */
	public void setFaelligkeitsdatum(Date faelligkeitsdatum) {
		this.faelligkeitsdatum = faelligkeitsdatum;
	}

	/**
	 * @return Returns the erstelldatum.
	 */
	public Date getErstelldatum() {
		return erstelldatum;
	}

	/**
	 * @return Returns the letzteAenderung.
	 */
	public Date getLetzteAenderung() {
		return letzteAenderung;
	}
	
	public void print(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		System.out.println("\""+aufgabe + "\""+", erstellt am: "+ formatter.format(erstelldatum));
		System.out.println("Zu erledigen bis: "+ formatter.format(faelligkeitsdatum));
		System.out.println("Datum der letzten Änderung: "+formatter.format(letzteAenderung));
	}
	
}
