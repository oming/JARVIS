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
				
				for(int i=0; i<list.size(); i++)
				{
					if(list.get(i).equals("원격"))
					{
						list.remove(i); // 현재 검색된 내용을 삭제함
						ma.analysis(list);
						out.println(ma.getParsing(inputLine));

					}
				}
				
				out.println(ma.getParsing(inputLine)); // 파싱된 문자열을 보냄
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
