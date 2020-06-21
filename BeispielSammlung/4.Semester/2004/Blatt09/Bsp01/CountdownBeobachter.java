public interface CountdownBeobachter {

	/**
	 * Wird vom Countdown jede Sekunde aufgerufen.
	 * @param sekundenBisNull Anzahl Sekunden bis 0.
	 */
	void countdown(int sekundenBisNull);
	
	/**
	 * Wird vom Countdown aufgerufen, wenn 0 erreicht wurde.
	 */
	void letsGo();

}
