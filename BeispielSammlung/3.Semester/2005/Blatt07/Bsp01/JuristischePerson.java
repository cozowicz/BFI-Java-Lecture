/**
 * <b>Musterlösung</b><br>
 * Juristische Person: Ergänzt die Daten einer Person um
 * Firmenname und Gesellschaftsform.
 */
public class JuristischePerson extends Person {

	private String firmenname;
	private String gesellschaftsform;
	
	public JuristischePerson(String firmenname, String gesellschaftsform, String adresse) {
		super(adresse);
		this.firmenname = firmenname;
		this.gesellschaftsform = gesellschaftsform;
	}

	public String getFirmenname() {
		return firmenname;
	}

	public void setFirmenname(String string) {
		firmenname = string;
	}

	public String getName() {
		return firmenname+" "+gesellschaftsform;
	}

	public String getGesellschaftsform() {
		return gesellschaftsform;
	}

	public void setGesellschaftsform(String string) {
		gesellschaftsform = string;
	}

}
