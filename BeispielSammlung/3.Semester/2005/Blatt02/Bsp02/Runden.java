/**
 * <b>Musterlösung</b><br>
 * Rundet eine Zahl auf das nächstliegende Vielfache von 100.
 */
public class Runden {

	public static void main(String[] args) {
		System.out.print("Zahl: ");
		int zahl = In.readInt();
		int rest = zahl%100;
		int gerundeteZahl = (rest <= 49 ? zahl-rest : zahl-rest+100);
		System.out.println("gerundete Zahl: "+gerundeteZahl);
	}
	
}
