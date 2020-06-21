/**
 * <b>Musterlösung</b><br>
 * Beispiel Artikelliste 
 */
public class Artikel {

	private String name = "";
	private int stueckzahl = 0;
	private float stueckpreis = 0;

	public Artikel() {
	}
	
	public String getName() {
		return name;
	}

	public float getStueckpreis() {
		return stueckpreis;
	}

	public int getStueckzahl() {
		return stueckzahl;
	}

	public void setName(String string) {
		name = string;
	}

	public void setStueckpreis(float f) {
		stueckpreis = f;
	}

	public void setStueckzahl(int i) {
		stueckzahl = i;
	}

}
