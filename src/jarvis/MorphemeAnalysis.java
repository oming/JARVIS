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
	RunningApplications ra;

	public MorphemeAnalysis() {
		komoran = new Komoran("./models/models-full/");
		ra = new RunningApplications();
	}

	public List<String> getParsing(String message) {
		List<String> mList = new ArrayList<String>();

		List<List<Pair<String, String>>> result = komoran.analyze(message);

		for (List<Pair<String, String>> eojeolResult : result) {
			for (Pair<String, String> wordMorph : eojeolResult) {
				if (wordMorph.getSecond().equals("NNG") || wordMorph.getSecond().equals("NNP"))
					// System.out.println(wordMorph.getFirst() + "//" +
					// wordMorph.getSecond());
					mList.add(wordMorph.getFirst());
			}
		}
		return mList;
	} // end getParsing

	public void analysis(List<String> list) {
		System.out.println("in analysis....");
		System.out.println(list);
		for (String s : list) {
			switch (s) {
			case "실행":
				for (String b : list) {
					switch (b) {
					case "네이버":
						break;
					case "구글":
						break;
					case "다음":
						break;
					} // end switch
				} // end for
				System.out.println("실행됨");
				break;
			case "검색":
				System.out.println("in 검색....");
				System.out.println(list);
				for (String b : list) {
					switch (b) {
					case "네이버":
						ra.runWebBrowser("http://search.naver.com/search.naver?ie=utf8&where=nexearch&query=", b);
						break;
					case "구글":
						break;
					case "다음":
						break;
					default:
						System.out.println("오류남.");
					} // end switch
				} // end for

				break;
			default:
				System.out.println(s);
				break;
			} // close switch
		} // close for

	} // end analysis
}
