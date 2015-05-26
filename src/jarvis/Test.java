package jarvis;

import java.util.List;
import java.util.StringTokenizer;

import javax.xml.ws.handler.MessageContext;

import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.util.common.model.Pair;

public class Test {

	public static void main(String[] args) {
//		String message[] = { "네이버에서 삼성 검색", "구글에서 삼성 홈페이지 검색", "내일 날씨 뭐니", "메모장 켜줘", "메모장 실행", "브라우저 켜", "브라우저 켜줘", "브라우저 실행", "음악 재생", "음악 실행", "내일 일정 알려줘",
//				"내일 일정", "금요일 날씨", "금요일 날씨 알려줘", "해바라기 뜻", "네이버에서 유재석 검색", "계산기 틀어줘", "위키피디아", "위키에서 이명박 검색", "롤 실행", "페이스북 접속", "페이스북 실행", "20분뒤에 컴퓨터 종료",
//				"오늘 야식 추천", "카카오톡 실행", "푸바 실행", "팟플레이어 실행", "대화모드 시작", "대화모드 종료", "자비스", "5200원 빼기 3900원", "음악 종료", "제어판 실행" };
//
//		Komoran komoran = new Komoran("./models/models-full/");
//
//		for (int i = 0; i < message.length; i++) {
//			System.out.println("["+message[i]+"]");
//			List<List<Pair<String, String>>> result = komoran.analyze(message[i]);
//
//			for (List<Pair<String, String>> eojeolResult : result) {
//				for (Pair<String, String> wordMorph : eojeolResult) {
//					System.out.println(wordMorph.getFirst() + "//" + wordMorph.getSecond());
//				}
//			}
//
//			System.out.println("---------------------------------------------");
//
//		}
		RunningApplications ra = new RunningApplications();
		ra.runKaKaoTalk();
	}

}
