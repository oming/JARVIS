package jarvis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {
	// JSON 데이터
	private String everString;
	public String pString;

	public JsonParser() throws ParseException, IOException {
		Path path = Paths.get("./temp/test.json");
		String filepath = path.toString();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filepath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			everString = sb.toString();
			System.out.println(everString);
		} finally {
			br.close();
		}

		JSONParser jsonParser = new JSONParser();
		// JSON데이터를 넣어 JSON Object 로 만들어 준다.
		JSONObject jsonObject = (JSONObject) jsonParser.parse(everString);
		// books의 배열을 추출
		JSONArray resultInfoArray = (JSONArray) jsonObject.get("result");
		JSONObject alternativeObject = (JSONObject) resultInfoArray.get(0);
		JSONArray alternativeInfoArray = (JSONArray) alternativeObject.get("alternative");

		System.out.println("* TEST JSON *");

		for (int i = 0; i < alternativeInfoArray.size(); i++) {

			System.out.println("=BOOK_" + i + " ===========================================");
			// 배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
			JSONObject transObject = (JSONObject) alternativeInfoArray.get(i);
			// JSON name으로 추출
			System.out.println(i + ": transcript==>" + transObject.get("transcript"));
			System.out.println(i + ": bookInfo: confidence==>" + transObject.get("confidence"));
			pString = (String) transObject.get("transcript");

		}

	}
	
	public String getParserString() {
		return pString;
		
	}
}
