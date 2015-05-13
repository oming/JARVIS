package jarvis;

import java.io.IOException;
import java.util.List;

import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.util.common.model.Pair;

import org.json.simple.parser.ParseException;

public class Jarvis {
	private static JsonParser jp;
	private static JavaSoundRecorder jsr;
	public static void main(String[] args) {

		 jsr = new JavaSoundRecorder();
		 jsr.setRecorder();
		 
		 try {
		 RequestGoogleSpeechAPI rj = new RequestGoogleSpeechAPI();
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }

		try {
			jp = new JsonParser();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// MainUI window = new MainUI(); // 메인 UI 출
		// window.frame.setVisible(true); // 보여지

		// SettingUI su = new SettingUI();
		// su.frame.setVisible(true);

		// Scanner scan = new Scanner(System.in);
		String message;
		Komoran komoran = new Komoran("./models/models-full/");

		// message = scan.nextLine();
		message = jp.getParserString();
		
		List<List<Pair<String, String>>> result = komoran.analyze(message);
		for (List<Pair<String, String>> eojeolResult : result) {
			for (Pair<String, String> wordMorph : eojeolResult) {
				System.out.println(wordMorph + "\n");
			}
			System.out.println();
		}
		System.out.println("end2");

	}
}
