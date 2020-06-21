/**
 * 
 */
package fh_vie.ac.at.Vorbereitung.Einheit3;

/**
 * @author Clemens Klee<br>
 * Erstellt am 15.02.2006<br>
 * Version 1.0
 */
public class Film extends Sendung{
	
	private String hauptdarsteller;
	
	public Film(int beginStunde, int beginMinute, int endStunde,
			int endMinute,String kanal, String titel,String hauptdarsteller){
		super(beginStunde,beginMinute,
				endStunde,endMinute,kanal, titel);
		this.hauptdarsteller = hauptdarsteller;
	}

	/**
	 * @return Returns the hauptdarsteller.
	 */
	public String getHauptdarsteller() {
		return hauptdarsteller;
	}

	/**
	 * @param hauptdarsteller The hauptdarsteller to set.
	 */
	public void setHauptdarsteller(String hauptdarsteller) {
		this.hauptdarsteller = hauptdarsteller;
	}
	
	public String toString(){
		return super.toString()+", Hauptdarsteller: "+getHauptdarsteller();
	}
}
