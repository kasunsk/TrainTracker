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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TrainClient {
	
	private static final Logger log = LoggerFactory.getLogger(TrainClient.class);

	@SuppressWarnings("finally")
	public static String SendLocationAndSpeed(String id, String lan, String lat)
			throws MalformedURLException, IOException,
			org.json.simple.parser.ParseException {
		
		log.info("id: "+id);
		log.info("lan: "+lan);
		log.info("lat: "+lat);

		URL url = new URL(
				"http://localhost:8080/MainServerHost/rest/location/send/?id="
						+ id + "&lan=" + lan + "&lat=" + lat);
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
			while ((line = reader.readLine()) != null) {
				result += line;
			}

			JSONParser parser = new JSONParser();
			JSONObject rsp = (JSONObject) parser.parse(result);

			if (rsp.containsKey("location")) {
				JSONArray matches = (JSONArray) rsp.get("location");
				JSONObject data = (JSONObject) matches.get(0); // TODO: check if
				// idx=0 exists
				formattedAddress = (String) data.get("location");
			}

			return "returned ...";
		} finally {
			urlConnection.disconnect();
			return formattedAddress;
		}
	}
}
