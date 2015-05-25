package jarvis;

import java.util.List;
import java.util.StringTokenizer;

import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.util.common.model.Pair;

public class Test {

	public static void main(String[] args) {

		String message = "네이버에서 삼성 검색";
		Komoran komoran = new Komoran("./models/models-full/");

		List<List<Pair<String, String>>> result = komoran.analyze(message);

		for (List<Pair<String, String>> eojeolResult : result) {
			for (Pair<String, String> wordMorph : eojeolResult) {

				System.out.println(wordMorph.getFirst());
				System.out.println(wordMorph.getSecond());
			}
		}
		
		System.out.println("===========================");
		
		message = "음악 틀어줘";


		result = komoran.analyze(message);
		for (List<Pair<String, String>> eojeolResult : result) {
			for (Pair<String, String> wordMorph : eojeolResult) {

				System.out.println(wordMorph.getFirst());
				System.out.println(wordMorph.getSecond());
			}
		}
	}

}
