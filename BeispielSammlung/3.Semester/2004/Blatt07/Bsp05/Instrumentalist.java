public class Instrumentalist extends Musikant {

	private String instrument;
	private String klang;

	public Instrumentalist(String name, String instrument, String klang) {
		super(name);
		this.instrument = instrument;
		this.klang = klang;
	}
	
	public void spiele() {
		System.out.println(getName() + " mit " + instrument + ": " + klang);
	}

}
