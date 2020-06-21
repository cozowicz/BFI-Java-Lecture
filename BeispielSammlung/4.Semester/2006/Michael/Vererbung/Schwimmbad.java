
public class Schwimmbad {

	
    private java.util.Set buildings;
	
	// Konstruktor
    public Schwimmbad()
	{
		buildings = new java.util.HashSet();
	}
	
	// Methoden
	public void addBuilding(Bau b)
	{
		buildings.add(b);
	}
	
	public void removeBuilding(Bau b)
	{
		buildings.remove(b);
	}
	
    // Main Methode zum testen
	public static void main(String[] args) {


		Elektroheizer h = new Elektroheizer("h1");
		
		h.setOperationStatus(false);
		
		
		Schwimmbad bad = new Schwimmbad();
		
		Bau bau1 = new Bau("Bau-1");
		Bau bau2 = new Bau("Bau-2");
		
		bad.addBuilding(bau1);
		bad.addBuilding(bau2);
		
		Sauna s11 = new Sauna("Sauna-A");
		Sauna s12 = new Sauna("Sauna-B");
		
		s11.setMax(20);
		s12.setMax(10);
		
		s11.setMaxTemp(100);
		s11.setTemp(90);
		
		s12.setMaxTemp(110);
		s12.setTemp(105);
		
		bau1.addRoom(s11);
		bau1.addRoom(s12);
		
		
		Wasserrutsche r1 = new Wasserrutsche("Schnelle Rutsche");
		Wasserrutsche r2 = new Wasserrutsche("Langsame Rutsche");
		
		r1.setMax(1);
		r2.setMax(1);
		
		
		bau2.addRoom(r1);
		bau2.addRoom(r2);
		
		Wasserpumpe wp1 = new Wasserpumpe("R1-Pumpe-1");
		wp1.setSollDurchfluss(100);
		wp1.setActDurchfluss(95);
		r1.addEquipment(wp1);
		
		Wasserpumpe wp2 = new Wasserpumpe("R1-Pumpe-2");
		wp2.setSollDurchfluss(100);
		wp2.setActDurchfluss(103);
		r1.addEquipment(wp2);
		
		
		Wasserpumpe wp3 = new Wasserpumpe("R2-Pumpe");
		wp3.setSollDurchfluss(70);
		wp3.setActDurchfluss(75);
		r1.addEquipment(wp3);
		
		
		Elektroheizer h1 = new Elektroheizer("Heizung Sauna-A");
		s11.addEquipment(h1);
		
		Elektroheizer h2 = new Elektroheizer("Heizung Sauna-B");
		s11.addEquipment(h2);		
		
		
		Raum halle = new Raum("Halle"); 
		
		Schwimmbecken becken1 = new Schwimmbecken("Grosses Becken");
		Schwimmbecken becken2 = new Schwimmbecken("Kinderbecken");
		
		becken1.setWasserguete(95);
		becken2.setWasserguete(75);
		
		halle.addEquipment(becken1);
		halle.addEquipment(becken2);
		
		
		System.out.println(bau1.locationString());
		System.out.println(s11.locationString());
		System.out.println(r1.locationString());
		
		System.out.println(wp3.locationString());
		
		
		
		for (int i=0; i< 100; i++)
			s11.enterPerson();
	
		System.out.println("In "+s11.locationString()+" befinden sich "+s11.getAct()+" Personen");
		
		s11.leavePerson();
		
		System.out.println("In "+s11.locationString()+" befinden sich "+s11.getAct()+" Personen");
		
	}
}
