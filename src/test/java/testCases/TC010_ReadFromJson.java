package testCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.POJO;

@Listeners(utilities.listener.class)
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
		POJO captureValue = new POJO();
		for(int i = 0; i < jsonArray.size();i++) {
			JSONObject emp = (JSONObject) jsonArray.get(i);
			System.out.println((String)emp.get("userId"));
			captureValue.setFirstName((String)emp.get("firstName"));
			captureValue.setJobTitleName((String)emp.get("jobTitleName"));
			captureValue.setLastName((String)emp.get("lastName"));
			captureValue.setUserId((String)emp.get("userId"));
			
			if(emp.containsKey("billTo")) {
			JSONObject billTo = (JSONObject) emp.get("billTo");

			System.out.println((String)billTo.get("name"));
			
			if(billTo.containsKey("addressInfo")) {
				JSONObject addInfo = (JSONObject) billTo.get("addressInfo");
				System.out.println(addInfo.get("address"));
			}
			
			}
		}
		
		System.out.println(captureValue.getFirstName());
		
	}

}
