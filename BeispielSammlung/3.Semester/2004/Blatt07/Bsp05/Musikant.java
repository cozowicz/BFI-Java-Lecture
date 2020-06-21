public abstract class Musikant {

	private String name;

	public Musikant(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void spiele();

}
