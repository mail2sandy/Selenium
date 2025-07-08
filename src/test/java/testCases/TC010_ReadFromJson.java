package testCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class TC010_ReadFromJson {
	
	//FileReader
	//JSONParser
	//Object
	//JSONObject
	//JSONArray
	
	
	@Test
	public void readFromJson() throws IOException, Exception {
		
		FileReader file = new FileReader(".//testData//emp.json");
		JSONParser jsonParse = new JSONParser();
		Object obj = jsonParse.parse(file);
		
		JSONObject jsonObj = (JSONObject) obj;
		
		JSONArray jsonArray = (JSONArray) jsonObj.get("Employees");
		
		for(int i = 0; i < jsonArray.size();i++) {
			JSONObject emp = (JSONObject) jsonArray.get(i);
			System.out.println((String)emp.get("userId"));
		}
	}

}
