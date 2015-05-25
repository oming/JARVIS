package jarvis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author hyosang
 *
 */
public class RunningApplications {
	private static String getOS;
	String[] cmd = null;

	public RunningApplications() {
		OSValidator osv = new OSValidator(); // 운영체제 선택
		getOS = osv.getOS();
	}

	public void webBrowser(String addr, String word) {
		switch (getOS) {
		case "win":
			cmd = new String[] { "rundll32", "url.dll", "FileProtocolHandler", addr + word };
			break;
		case "osx":
			cmd = new String[] { "open", "-a", "Safari", addr + word };
			break;
		case "uni":
			break;
		case "sol":

			break;
		case "err":

			break;
		default:
		} // end switch
		runProcess(); // 프로그램 실행
	}

	private void runProcess() {
		Process process = null;

		String str = null;

		try {

			// 프로세스 빌더를 통하여 외부 프로그램 실행
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
