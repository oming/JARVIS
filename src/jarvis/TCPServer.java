package jarvis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	private static MorphemeAnalysis ma;

	public static void main(String[] args) throws IOException{
		
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		
		serverSocket = new ServerSocket(5555);
		ma = new MorphemeAnalysis();
		
		try {
			clientSocket = serverSocket.accept();
			System.out.println("Client connect");
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			while (true) {
				String inputLine = null;
				inputLine = in.readLine();
				System.out.println("클라이언트로부터 받은 문자열 : " + inputLine);
				ma.analysis(ma.getParsing(inputLine));
				out.println(inputLine);
				if (inputLine.equals("quit"))
					break;
			}
			out.close();
			in.close();
			clientSocket.close();
			serverSocket.close();
			} catch (Exception e){
				e.printStackTrace();
		}
	}
}
