public class Stepptaenzer extends Musikant {

	private String schrittfolge;
	
	public Stepptaenzer(String name, String schrittfolge) {
		super(name);
		this.schrittfolge = schrittfolge;
	}

	public void spiele() {
		System.out.println(getName() + " steppt: " + schrittfolge);
	}

}
