import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatumZuWochentag {
	
	public static void main(String[] args) {
		SimpleDateFormat parseFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = null;
		while (date == null) {
			try {
				System.out.print("Datum eingeben: ");
				date = parseFormat.parse(In.readLine());
			} catch (ParseException e) {
				System.out.println("Ungültiges Datum!");
			}
		}
		SimpleDateFormat outputFormat = new SimpleDateFormat("E");
		System.out.println(outputFormat.format(date));
	}
	
}



