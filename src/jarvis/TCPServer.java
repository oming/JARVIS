package jarvis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class TCPServer implements Runnable {

	ServerSocket serverSocket = null;
	Socket clientSocket = null;
	PrintWriter out = null;
	BufferedReader in = null;
	MorphemeAnalysis ma;
	List<String> list;

	public TCPServer(MorphemeAnalysis ma) {
		this.ma = ma;
		try {
			serverSocket = new ServerSocket(5555);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			clientSocket = serverSocket.accept();
			System.out.println("Client connect");
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			System.out.println("mobijarvis의 접속을 기다립니다.");
			while (true) {

				String inputLine = null;
				inputLine = in.readLine();
				System.out.println("클라이언트로부터 받은 문자열 : " + inputLine);

				list = ma.getParsing(inputLine);

				loop: for (String s : list) {
					switch (s) {
					case "원격":
					case "리모트":
					case "컴퓨터":
						// 실행 분기 실행
						list.remove(s); // 현재 검색된 내용을 삭제함
						ma.analysis(ma.getParsing(inputLine));
						break loop;
					// 실행 분기 종료

					// 호출 분기 종료.
					default:
						System.out.println("외부 명령 실행 아님");
					} // close switch
				} // close for

				out.println(ma.getParsing(inputLine));
				if (inputLine.equals("종료")) {
					System.out.println("클라이언트 접속 종료됨.");
					break;
				}		
			}

			out.close();
			in.close();
			clientSocket.close();
			serverSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
