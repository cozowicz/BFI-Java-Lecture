public class RunCountdown {

	public static void main(String[] args) {
		Countdown countdown = new Countdown(10);
		CountdownBeobachter ticker = new AudioTicker();
		countdown.start(ticker);
	}
	
}
