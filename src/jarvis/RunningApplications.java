package jarvis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunningApplications {
	public static void main(String[] args) {
		String addr = "http://www.naver.com";
		Process process = null;
		String[] cmd;

		String os = System.getProperty("os.name"); // 운영체제 정보 확인
		System.out.println(os);

		// 운영체제 선택
		if (os.equals("Mac OS X")) {
			cmd = new String[] { "open", "-a", "Safari", addr }; // OSX
		} else if (os.equals("WINDOWS")) {
			cmd = new String[] { "rundll32", "url.dll", "FileProtocolHandler", addr }; // WINDOWS
		} else {
			cmd = new String[] {"null"}; // 오류시
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
