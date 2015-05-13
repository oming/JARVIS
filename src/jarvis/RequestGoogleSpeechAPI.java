package jarvis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RequestGoogleSpeechAPI {
	public URL url;

	public RequestGoogleSpeechAPI() throws IOException {
//		Path path = Paths.get("./temp/test.flac");
		Path path = Paths.get("./temp/RecordAudio.wav");
		byte[] data = Files.readAllBytes(path);

		String urlString = "https://www.google.com/" + "speech-api/v2/recognize?" + "output=json&lang=ko-kr&key=AIzaSyCMxPcCfxrBCcwfNjCazKTPIthFtHRlECY";

		try {
			url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			StringBuilder stringBuilder;

			connection.setDefaultUseCaches(true);
			connection.setConnectTimeout(20000);
			connection.setReadTimeout(60000);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestMethod("POST");
//			connection.setRequestProperty("Content-Type", "audio/x-flac;rate=44100");	// flac 파일 사용
			connection.setRequestProperty("Content-Type", "audio/l16; rate=16000;");	// wav 파일 사용

			/* Write the audio on bufferI/O */
			String filepath = path.toString();
			File file = new File(filepath);
			byte[] buffer = new byte[(int) file.length()];
			FileInputStream fis = new FileInputStream(file);
			fis.read(buffer);
			fis.close();
			OutputStream os = connection.getOutputStream();
			os.write(buffer);
			os.close();

			connection.connect();
			System.out.println("connect to google server!");
			connection.getResponseMessage();
			System.out.println("receive the reponse!");
			InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream(), "UTF-8");
			BufferedReader br = new BufferedReader(inputStreamReader);

			stringBuilder = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				stringBuilder.append(line);
			}
			System.out.println(stringBuilder);

			String finishResult = stringBuilder.toString().replace("{\"result\":[]}", "");
			System.out.println(finishResult);
			/*
			 * To write contents of StringBuffer to a file, use BufferedWriter
			 * class.
			 */

			String saveFileName = "/test.json";
			Path saveFilePath = Paths.get("./temp/");
			BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(saveFilePath + saveFileName)));

			// write contents of StringBuffer to a file
			bwr.write(finishResult);

			// flush the stream
			bwr.flush();

			// close the stream
			bwr.close();

			System.out.println("Content of StringBuffer written to File.");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
