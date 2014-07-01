package com.kasun.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Client {
	
	private static final Logger log = LoggerFactory.getLogger(Client.class);

	@SuppressWarnings("finally")
	public static String locationAndSpeed(String id)
			throws MalformedURLException, IOException,
			org.json.simple.parser.ParseException {

		URL url = new URL("http://localhost:8080/MainServerHost/rest/location/get/"+id);
		log.info("url: " + url);

		HttpURLConnection urlConnection = (HttpURLConnection) url
				.openConnection();
		String formattedAddress = "";
		String result = "";

		try {
			InputStream in = url.openStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String line = reader.readLine();
			result = line;
			log.info("Result: "+result);
			while ((line = reader.readLine()) != null) {
				result += line;
			}

			JSONParser parser = new JSONParser();
			JSONObject rsp = (JSONObject) parser.parse(result);
			
//			if (rsp.containsKey("location")) {
//				System.out.println("IF ");
//				JSONArray matches = (JSONArray) rsp.get("location");
//				System.out.println("Kasun");
//				System.out.println("matches: "+matches);
//				JSONObject data = (JSONObject) matches.get(0); // TODO: check if
//											// idx=0 exists
//				System.out.println("data: "+data);
//				formattedAddress = (String) data.get("location");
//				System.out.println("formattedAddress111 ... " + formattedAddress);	
//			}

			return "returned ...";
		} finally {
			urlConnection.disconnect();
			return result;
		}
	}

}
