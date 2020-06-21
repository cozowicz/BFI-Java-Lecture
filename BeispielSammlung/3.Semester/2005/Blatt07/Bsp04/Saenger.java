public class Saenger extends Musikant {
	
	private String text;

	public Saenger(String name, String text) {
		super(name);
		this.text = text;
	}
	
	public void spiele() {
		System.out.println(getName() + " singt: " + text);
	}
	
}
