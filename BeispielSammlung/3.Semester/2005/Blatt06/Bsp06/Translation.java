/**
 * <b>Musterl�sung</b><br>
 * Ein W�rterpaar, um eine �bersetzung im
 * W�rterbuch verwalten zu k�nnen.
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
