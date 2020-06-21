public class MusikprobeMitStepptaenzer {

	public static void main(String[] args) {
		Dirigent dirigent = new Dirigent();
		dirigent.nimmInsOrchesterAuf(new Saenger("Julia", "La-La"));
		dirigent.nimmInsOrchesterAuf(new Instrumentalist("Tom", "Gitarre", "Klimper"));
		dirigent.nimmInsOrchesterAuf(new Instrumentalist("Sandra", "Trommel", "Bada-Bumm"));
		dirigent.nimmInsOrchesterAuf(new Instrumentalist("Klaus", "Saxophon", "Quiiiietsch"));
		dirigent.nimmInsOrchesterAuf(new Stepptaenzer("Franz", "Klip-Klap"));
		System.out.print("Anzahl: ");
		int anzahl = In.readInt();
		dirigent.spiele(anzahl);
	}

}
