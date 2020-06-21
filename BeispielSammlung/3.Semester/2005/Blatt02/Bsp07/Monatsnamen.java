public class Monatsnamen {

	public static void main(String[] args) {
		System.out.print("Monat: ");
		int monat = In.readInt();
		String ausgabe;
		switch (monat) {
			case 1:
				System.out.println("Jänner");
				break;
			case 2:
				System.out.println("Februar");
				break;
			case 3:
				System.out.println("März");
				break;
			case 4:
				System.out.println("April");
				break;
			case 5:
				System.out.println("Mai");
				break;
			case 6:
				System.out.println("Juni");
				break;
			case 7:
				System.out.println("Juli");
				break;
			case 8:
				System.out.println("August");
				break;
			case 9:
				System.out.println("September");
				break;
			case 10:
				System.out.println("Oktober");
				break;
			case 11:
				System.out.println("November");
				break;
			case 12:
				System.out.println("Dezember");
				break;
			default:
				System.out.println("Sie müssen eine Zahl zwischen 1 und 12 eingeben!");
		}
	}

}
