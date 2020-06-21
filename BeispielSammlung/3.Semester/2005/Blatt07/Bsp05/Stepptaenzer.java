public class Stepptaenzer extends Musikant {

	private String klang;
	
	public Stepptaenzer(String name, String klang) {
		super(name);
		this.klang = klang;
	}

	public void spiele() {
		System.out.println(getName() + " steppt: " + klang);
	}

}
