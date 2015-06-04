package jarvis;

import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		RunningApplications ra = new RunningApplications();
		
		MorphemeAnalysis ma = new MorphemeAnalysis();
		String message;
		Scanner s = new Scanner(System.in);
		while(true) {
			message = s.nextLine();
			
			List<String> mList = ma.getParsing(message);
			ma.analysis(mList);
		}


	}

}
