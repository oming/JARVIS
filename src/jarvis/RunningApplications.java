package jarvis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author hyosang
 *
 */
public class RunningApplications {
	private String getOS;
	String[] cmd;

	public RunningApplications() {
		OSValidator osv = new OSValidator(); // 운영체제 선택
		getOS = osv.getOS();
	}

	/**
	 * @author hyosang
	 * @param addr
	 *            : 검색할 주소
	 * @param word
	 *            : 검색할 단어
	 * @return 웹브라우저를 통해 검색 내용 결과 출력
	 */
	public void runWebBrowser(String addr, String word) {

		switch (getOS) {
		case "win":
			cmd = new String[] { "rundll32", "url.dll", "FileProtocolHandler", addr + word };
			break;
		case "osx":
			cmd = new String[] { "open", "-a", "Safari", addr + word };
			break;
		case "uni":
			System.out.println("에러 발생 webBrowser");
			break;
		case "sol":
			System.out.println("에러 발생 webBrowser");
			break;
		case "err":
			System.out.println("에러 발생 webBrowser");
			break;
		default:
			System.out.println("디폴트 영역 실행됨.");
		} // end switch
		(new RunThread()).start();
	}

	/**
	 * 음악 플레이어 실행
	 */
	public void runMusicPlayer() {
		switch (getOS) {
		case "win":
			cmd = new String[] { "C:\\Program Files\\iTunes\\iTunes.exe" };
			break;
		case "osx":
			cmd = new String[] { "open", "-a", "iTunes.app" };
			break;
		case "uni":
			System.out.println("에러 발생 webBrowser");
			break;
		case "sol":
			System.out.println("에러 발생 webBrowser");
			break;
		case "err":
			System.out.println("에러 발생 webBrowser");
			break;
		default:
			System.out.println("디폴트 영역 실행됨.");

		} // end switch
		System.out.println("runMusicPlayer");
		(new RunThread()).start();
	}

	/**
	 * 카카오톡 실행
	 */
	public void runKaKaoTalk() {
		switch (getOS) {
		case "win":
			cmd = new String[] { "C:\\Program Files (x86)\\Kakao\\KakaoTalk\\KakaoTalk.exe" };
			break;
		case "osx":
			cmd = new String[] { "open", "-a", "KaKaoTalk" };
			break;
		case "uni":
			System.out.println("에러 발생 webBrowser");
			break;
		case "sol":
			System.out.println("에러 발생 webBrowser");
			break;
		case "err":
			System.out.println("에러 발생 webBrowser");
			break;
		default:
			System.out.println("디폴트 영역 실행됨.");

		} // end switch
		System.out.println("runKakaoTalk");
		(new RunThread()).start();
	}

	/**
	 * 메모장 실행
	 */
	public void runMemoPad() {
		switch (getOS) {
		case "win":
			cmd = new String[] { "notepad.exe" };
			System.out.println("memo in " + cmd);
			break;
		case "osx":
			cmd = new String[] { "open", "-a", "Notes" };
			break;
		case "uni":
			System.out.println("에러 발생 webBrowser");
			break;
		case "sol":
			System.out.println("에러 발생 webBrowser");
			break;
		case "err":
			System.out.println("에러 발생 webBrowser");
			break;
		default:
			System.out.println("디폴트 영역 실행됨.");

		} // end switch
		System.out.println("runMemopad");
		(new RunThread()).start();
	}

	/**
	 * 계산기 실행
	 */
	public void runCalculator() {
		switch (getOS) {
		case "win":
			cmd = new String[] { "calc.exe" };
			System.out.println("calc in" + cmd);
			break;
		case "osx":
			cmd = new String[] { "open", "-a", "Calculator" };
			break;
		case "uni":
			System.out.println("에러 발생 webBrowser");
			break;
		case "sol":
			System.out.println("에러 발생 webBrowser");
			break;
		case "err":
			System.out.println("에러 발생 webBrowser");
			break;
		default:
			System.out.println("디폴트 영역 실행됨.");

		} // end switch
		System.out.println("runCalculate");
		(new RunThread()).start();
	}

	// 스레드를 내부 클래스로 만들어 필드에 접근하기 쉽게 한다.
	class RunThread extends Thread {
		public void run() {

			Process process = null;
			String str = null;

			try {

				// 프로세스 빌더를 통하여 외부 프로그램 실행
				System.out.println("thread in :" + cmd);
				process = new ProcessBuilder(cmd).start();

				// 외부 프로그램의 표준출력 상태 버퍼에 저장
				BufferedReader stdOut = new BufferedReader(new InputStreamReader(process.getInputStream()));

				// 표준출력 상태를 출력
				while ((str = stdOut.readLine()) != null) {
					System.out.println(str);
				}

			} catch (IOException e) {
				e.printStackTrace();

			}

		}
	}

}
