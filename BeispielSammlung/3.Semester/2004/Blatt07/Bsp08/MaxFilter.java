public class MaxFilter extends FilterAlgorithmus {
	
	private int max;

	public MaxFilter(int max) {
		this.max = max;
	}

	public boolean keepElement(int element) {
		return element <= max;
	}

}
