package jarvis;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Jarvis {

	public static void main(String[] args) {
		
		JavaSoundRecorder jsr = new JavaSoundRecorder();
		
		 try {
		 RequestGoogleSpeechAPI rj = new RequestGoogleSpeechAPI();
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		
		 try {
		 JsonParser jp = new JsonParser();
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
		// String message;
		// Komoran komoran = new Komoran("./models/models-full/");
		// while (true) {
		// message = scan.nextLine();
		// List<List<Pair<String, String>>> result = komoran.analyze(message);
		// for (List<Pair<String, String>> eojeolResult : result) {
		// for (Pair<String, String> wordMorph : eojeolResult) {
		// System.out.println(wordMorph + "\n");
		// }
		// System.out.println();
		// }
		// System.out.println("end2");
		// }

	}

}
