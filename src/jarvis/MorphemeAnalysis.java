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
	RequestGoogleTextToSpeech rgtts;

	public MorphemeAnalysis() {
		komoran = new Komoran("./models/models-full/");
		ra = new RunningApplications();
		rgtts = new RequestGoogleTextToSpeech();
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
		loop: for (String s : list) {
			switch (s) {
			case "실행":
				// 실행 분기 실행
				list.remove(s); // 현재 검색된 내용을 삭제함
				for (String b : list) {
					switch (b) {
					case "브라우저":
					case "인터넷":
						ra.runWebBrowser();
						rgtts.TTSPlayer("브라우저를 실행합니다.");
						break loop;

					case "메모장":
						ra.runMemoPad();
						rgtts.TTSPlayer("메모장을 실행합니다.");
						break loop;

					case "음악":
					case "노래":
						ra.runMusicPlayer();
						rgtts.TTSPlayer("음악을 실행합니다.");
						break loop;

					case "카카오톡":
					case "카톡":
						ra.runKaKaoTalk();
						rgtts.TTSPlayer("카카오톡을 실행합니다.");
						break loop;

					case "계산기":
						ra.runCalculator();
						rgtts.TTSPlayer("계산기를 실행합니다.");
						break loop;
					} // end switch
				} // end for
				break;
			// 실행 분기 종료

			case "검색":
				// 검색 분기 시작
				list.remove(s); // 현재 검색된 내용을 삭제함

				for (String b : list) {
					switch (b) {
					case "네이버":
						list.remove(b); // 현재 검색된 내용을 삭제함
						ra.runWebBrowser("http://search.naver.com/search.naver?ie=utf8&where=nexearch&query=", list.get(0));
						rgtts.TTSPlayer("네이버에서 " + list.get(0) + "를 검색합니다.");
						break loop;
					case "구글":
						list.remove(b);// 현재 검색된 내용을 삭제함
						ra.runWebBrowser("http://www.google.co.kr/search?q=", list.get(0));
						rgtts.TTSPlayer("구글에서 " + list.get(0) + "를 검색합니다.");
						break loop;
					case "다음":
						break loop;
					default:
						System.out.println("오류남.");
					} // end switch
				} // end for

				break;
			// 검색 분기 종료

			case "자비스":
				// 호출 분기 시작
				for (String b : list) {
					switch (b) {
					case "안녕":
						list.remove(b); // 현재 검색된 내용을 삭제함
						rgtts.TTSPlayer("예스 마스터 안녕하세요.");
						break loop;
					case "뭐해":
						list.remove(b);// 현재 검색된 내용을 삭제함
						rgtts.TTSPlayer("대기 중입니다.");
						break loop;

					default:
						rgtts.TTSPlayer("예스 마스터!");
						break loop;
					} // end switch
				} // end for

				break;
			// 호출 분기 종료.
			default:
				System.out.println("명령어 실행 오류");
			} // close switch
		} // close for

	} // end analysis
}
