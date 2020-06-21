import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class AudioTicker implements CountdownBeobachter {

	public void countdown(int sekundenBisNull) {
		System.out.println(sekundenBisNull+" seconds to go");
		playAudio("beep.wav");
	}

	public void letsGo() {
		System.out.println("lets go!");
		playAudio("go.wav");
	}
	
	private void playAudio(String file) {
		URL url = getClass().getClassLoader().getResource(file);
		if (url != null) {
			AudioClip clip = Applet.newAudioClip(url);
			clip.play();
		} else {
			System.err.println("Audiodatei nicht gefunden!");
		}
	}
	
}
