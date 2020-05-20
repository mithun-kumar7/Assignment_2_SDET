package com.qa.utils;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileTestUtil {
	
	static String projectPath = System.getProperty("user.dir");
	static String jsonPath=projectPath + "/src/test/resources/testData/registration.json";

	public static String getJSONData(String Key) throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(jsonPath);
		Object obj = jsonParser.parse(reader);
		JSONObject registrationDetails = (JSONObject) obj;
		String data = (String) registrationDetails.get(Key);
		return data;
	}

}
