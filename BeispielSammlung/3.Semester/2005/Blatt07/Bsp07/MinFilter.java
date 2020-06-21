public class MinFilter extends FilterAlgorithmus {

	private int min;

	public MinFilter(int min) {
		this.min = min;
	}

	public boolean keepElement(int element) {
		return element >= min;
	}

}
