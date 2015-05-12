package jarvis;

import java.io.IOException;

public class Jarvis {

	public static void main(String[] args) {
		MainUI window = new MainUI();
		window.frame.setVisible(true);
		try {
			RequestGoogleSpeechAPI rj = new RequestGoogleSpeechAPI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
