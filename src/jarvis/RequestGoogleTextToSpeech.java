package jarvis;

import java.io.IOException;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;

import com.gtranslate.Audio;
import com.gtranslate.Language;

public class RequestGoogleTextToSpeech {

	public void TTSPlayer(String message) {
		Audio audio = Audio.getInstance();
		InputStream sound = null;

		try {
			sound = audio.getAudio(message, Language.KOREAN);
			audio.play(sound);
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
