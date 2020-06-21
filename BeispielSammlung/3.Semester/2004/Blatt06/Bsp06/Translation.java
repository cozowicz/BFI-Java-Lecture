/**
 * <b>Musterlösung</b><br>
 * Ein Wörterpaar, um eine Übersetzung im
 * Wörterbuch verwalten zu können.
 */
public class Translation {

	private String wortSprache1;
	private String wortSprache2;
	
	public Translation(String wortSparche1, String wortSparche2) {
		this.wortSprache1 = wortSparche1;
		this.wortSprache2 = wortSparche2;
	}
	
	public String getWortSprache1() {
		return wortSprache1;
	}

	public String getWortSprache2() {
		return wortSprache2;
	}

}
