package jarvis;

import java.util.ArrayList;
import java.util.List;

import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.util.common.model.Pair;

/**
 * 형태소 분석을 위한 클래스 메시지를 입력받아 형태소를 분석하여 상황에 맞는 명령어를 실행시킬수 있도록 하는 클래스.
 * 
 * @author hyosang
 *
 */
public class MorphemeAnalysis {
	Komoran komoran;

	public MorphemeAnalysis() {
		komoran = new Komoran("./models/models-full/");
	}

	public List<String> getParsing(String message) {
		List<String> mList = new ArrayList<String>();

		List<List<Pair<String, String>>> result = komoran.analyze(message);

		for (List<Pair<String, String>> eojeolResult : result) {
			for (Pair<String, String> wordMorph : eojeolResult) {
				if (wordMorph.getSecond().equals("NNG"))
					// System.out.println(wordMorph.getFirst() + "//" +
					// wordMorph.getSecond());
					mList.add(wordMorph.getFirst());
			}
		}
		return mList;
	} // end getParsing

	public void analysis(List<String> list) {
		for (String s : list) {
			switch (s) {
			case "실행":
				System.out.println("실행됨");
				break;
			case "검색":
				System.out.println("검색됨");
				break;
			default:
				break;
			} // close switch
		} // close for

	} // end analysis
}
