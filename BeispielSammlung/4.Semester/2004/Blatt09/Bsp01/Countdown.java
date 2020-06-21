public class Countdown {

	private int sekunden;
	
	public Countdown(int sekunden) {
		this.sekunden = sekunden;
	}
	
	public void start(CountdownBeobachter beobachter) {
		int sekundenBisNull = sekunden;
		while (sekundenBisNull > 0) {
			beobachter.countdown(sekundenBisNull);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
			}
			sekundenBisNull--;
		}
		beobachter.letsGo();
	}

}
