
/**
 * @author Clemens Klee<br>
 * Erstellt am 25.10.2005<br>
 * Version 1.0
 */
public class Dreieck {
	
	/**
	 * Berechnet die Symmetrieachse um die das Dreieck 
	 * gespiegelt wird aus den zu verwendenden Zeilen.
	 * @param zeilen Die Anzahl der Zeilen mit denen das Dreieck gezeichnet werden soll.
	 * @return Die Symmetrieachse des Dreiecks.
	 */
	static int getAchse(int zeilen){
		int rest = zeilen%2;
		int achse = 0;
		if(rest != 0){
			achse = zeilen/2 + 1;
		}
		else{
			achse = zeilen/2;
		}
		return achse;
	}
	
	/**
	 * Zeichnet ein Dreieck mit einer übergebenen Anzahl Zeilen.
	 * @param zeilen Die Anzahl der Zeilen, aus denen das Dreieck bestehen soll.
	 */
	static void printDreieck(int zeilen){
		int achse = getAchse(zeilen);
		
		for(int i = 1;i<= zeilen;i++){
			int j;
			if(i<=achse){
				j = 1;
				while(j<=i){
					System.out.print("*");
					j++;
				}
				System.out.println();
				}
			else{
				j = zeilen - i;
				int z = 0;
				while(z<=j){
					System.out.print("*");
					z++;
				}
				System.out.println();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("Anzahl Zeilen eingeben: ");
		int anzZeilen = In.readInt();
		
		if (In.done()){
			printDreieck(anzZeilen);
		}
		else{
			System.out.println("Fehlerhafte Eingabe - Zahl erwartet!");
		}

	}

}
