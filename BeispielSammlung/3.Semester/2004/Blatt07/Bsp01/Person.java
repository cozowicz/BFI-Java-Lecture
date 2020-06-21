/**
 * <b>Musterlösung</b><br>
 * Eine Person bestehend aus Adresse und Telefonnummer.
 */
public abstract class Person {

	private String adresse;
	private String telefonnummer;
	
	public Person(String adresse) {
		this.adresse = adresse;
	}
	
	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}
	
	public String getTelefonnummer() {
		return telefonnummer;
	}
		
	public abstract String getName();

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String string) {
		adresse = string;
	}

}
