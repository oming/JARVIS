package jarvis;

import java.io.IOException;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;

import com.gtranslate.Audio;
import com.gtranslate.Language;

public class RequestGoogleTextToSpeech {

	public RequestGoogleTextToSpeech() {
		Audio audio = Audio.getInstance();
		InputStream sound = null;

		try {
			sound = audio.getAudio("동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라만세.", Language.KOREAN);
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
