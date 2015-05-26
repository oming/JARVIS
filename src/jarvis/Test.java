package jarvis;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		RunningApplications ra = new RunningApplications();
		
		MorphemeAnalysis ma = new MorphemeAnalysis();
		List<String> mList = ma.getParsing("네이버에서 삼성을 검색하고 결과 실행");

		ma.analysis(mList);

	}

}
