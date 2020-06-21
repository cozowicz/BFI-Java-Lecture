/**
 * <b>Musterlösung</b><br>
 * Ein Taschenrechner mit den Operationen +, -, *, / und q.
 */
public class Taschenrechner {

	public static void main(String[] args) {
		double result = 0;
		System.out.println("Wert: 0");
		System.out.print("Operation: ");
		char op = In.read();
		while (op != 'q') {
			double value = In.readDouble();
			switch (op) {
				case '+':
					result += value;
					break;
				case '-':
					result -= value;
					break;
				case '*':
					result *= value;
					break;
				case '/':
					result /= value;
					break;
				default:
					System.out.println("Unbekannte Operation!");
			}
			In.readLine();
			System.out.println("Ergebnis: "+result);
			System.out.print("Operation: ");
			op = In.read();
		}
		System.out.print("Programm beendet!");
	}
}
