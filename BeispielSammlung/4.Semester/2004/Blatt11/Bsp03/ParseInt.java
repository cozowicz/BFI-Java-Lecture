public class ParseInt {

	public static void main(String[] args) {
		String wort = In.readWord();
		try {
			Integer.parseInt(wort);
			System.out.println("Sie haben eine Integerzahl eingegeben.");
		} catch (NumberFormatException nfex) {
			System.out.println("Sie haben keine Integerzahl eingegeben.");
		}
	}
	
}
