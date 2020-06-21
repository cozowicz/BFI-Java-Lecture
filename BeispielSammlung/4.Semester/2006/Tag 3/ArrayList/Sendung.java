/**
 * 
 */
package fh_vie.ac.at.Vorbereitung.Einheit3;

/**
 * @author Clemens Klee<br>
 * Erstellt am 15.02.2006<br>
 * Version 1.0
 */
public class Sendung {
	private int beginStunde;
	private int beginMinute;
	private int endStunde;
	private int endMinute;
	private String kanal;
	private String titel;
	
	public Sendung(int beginStunde, int beginMinute, int endStunde,int endMinute,String kanal, String titel){
		this.beginStunde=beginStunde;
		this.beginMinute=beginMinute;
		this.endMinute=endMinute;
		this.endStunde = endStunde;
		this.kanal = kanal;
		this.titel=titel;
	}
	
	
	
	/**
	 * @return Returns the kanal.
	 */
	public String getKanal() {
		return kanal;
	}



	/**
	 * @param kanal The kanal to set.
	 */
	public void setKanal(String kanal) {
		this.kanal = kanal;
	}



	/**
	 * @return Returns the titel.
	 */
	public String getTitel() {
		return titel;
	}



	/**
	 * @param titel The titel to set.
	 */
	public void setTitel(String titel) {
		this.titel = titel;
	}



	/**
	 * @return Returns the beginMinute.
	 */
	public int getBeginMinute() {
		return beginMinute;
	}

	/**
	 * @param beginMinute The beginMinute to set.
	 */
	public void setBeginMinute(int beginMinute) {
		this.beginMinute = beginMinute;
	}

	/**
	 * @return Returns the beginStunde.
	 */
	public int getBeginStunde() {
		return beginStunde;
	}

	/**
	 * @param beginStunde The beginStunde to set.
	 */
	public void setBeginStunde(int beginStunde) {
		this.beginStunde = beginStunde;
	}

	/**
	 * @return Returns the endMinute.
	 */
	public int getEndMinute() {
		return endMinute;
	}

	/**
	 * @param endMinute The endMinute to set.
	 */
	public void setEndMinute(int endMinute) {
		this.endMinute = endMinute;
	}

	/**
	 * @return Returns the endStunde.
	 */
	public int getEndStunde() {
		return endStunde;
	}

	/**
	 * @param endStunde The endStunde to set.
	 */
	public void setEndStunde(int endStunde) {
		this.endStunde = endStunde;
	}
	
//	public int getDauer(){
//		return (endStunde-beginStunde)*60 + (endMinute-beginMinute);
//	}
	
	public int getDauer(){
		int begininmin = beginStunde*60 + beginMinute;;
		int endinmin = endStunde*60 + endMinute;
		
		//falls über Mitternacht aufgenommen wird:
		// zb: 23:30 - 0:30
		if (beginStunde <= 24 && endStunde < beginStunde){
			endinmin = (endStunde+24)*60 + endMinute;
		}
		return endinmin - begininmin;
	}
	
	public String toString(){
		return "Titel: "+getTitel()+", Dauer: "+getDauer();
	}
}
