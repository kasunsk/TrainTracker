package com.kasun.common.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.kasun.common.controller.JSONController;
import com.kasun.common.data.Train;
import com.kasun.common.gsonObject.ResivingData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetTrainLocation {
	
	private static final Logger log = LoggerFactory.getLogger(GetTrainLocation.class);

	@SuppressWarnings("finally")
	public static String getTrainLocationById(String id)
			throws MalformedURLException, IOException,
			org.json.simple.parser.ParseException {

		URL url = new URL(
				"http://localhost:8080/TrainClientServer/rest/location/" + id);
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

			
//			Train train = new ObjectMapper().readValue(result, Train.class);
			
//			System.out.println("Id... "+train.getId());
			
			//fromJson(rsp,Train.class);
			
			//JSONObject json = (JSONObject)new JSONParser().parse("{\"id\":\"MyNode\", \"lon\":200, \"lat\":100}");

			 if (rsp.containsKey("id")) {
			 JSONArray matches = (JSONArray) rsp.get("id");
			
			 JSONObject data = (JSONObject) matches.get(0); // TODO: check if
			 // idx=0 exists
			
			 formattedAddress = (String) data.get("id");
			}

			return "returned ...";
		} finally {
			urlConnection.disconnect();
			return result;
		}
	}

}
