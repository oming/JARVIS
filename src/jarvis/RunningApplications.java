package jarvis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author hyosang
 *
 */
public class RunningApplications {

	public static void main(String[] args) {
		String addr = "http://www.naver.com";
		Process process = null;
		String[] cmd = null;
		// 운영체제 선택
		OSValidator osv = new OSValidator();
		switch (osv.getOS()) {
		case "win":
			cmd = new String[] { "rundll32", "url.dll", "FileProtocolHandler", addr };
			break;
		case "osx":
			cmd = new String[] { "open", "-a", "Safari", addr };
			break;
		case "uni":
			break;
		case "sol":

			break;
		case "err":

			break;
		default:
		}

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
