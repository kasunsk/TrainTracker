package com.kasun.common.services;

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

import com.kasun.common.controller.JSONController;
import com.kasun.common.data.GPSLocation;

public class LocationGoogle {
	
	private static final Logger log = LoggerFactory.getLogger(LocationGoogle.class);

	@SuppressWarnings({ "unused", "finally" })
	public static String getAddressByGpsCoordinates(String lng, String lat)
			throws MalformedURLException, IOException,
			org.json.simple.parser.ParseException {

		URL url = new URL(
				"http://maps.googleapis.com/maps/api/geocode/json?latlng="
						+ lat + "," + lng + "&sensor=true");

		HttpURLConnection urlConnection = (HttpURLConnection) url
				.openConnection();
		String formattedAddress = "";

		try {
			InputStream in = url.openStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String result, line = reader.readLine();
			result = line;
			while ((line = reader.readLine()) != null) {
				result += line;
			}
			log.info("result: "+result);
			JSONParser parser = new JSONParser();
			JSONObject rsp = (JSONObject) parser.parse(result);
			

			if (rsp.containsKey("results")) {
				JSONArray matches = (JSONArray) rsp.get("results");

				JSONObject data = (JSONObject) matches.get(0); // TODO: check if
																// idx=0 exists

				formattedAddress = (String) data.get("formatted_address");
			}

			return "returned ...";
		} finally {
			urlConnection.disconnect();
			if(formattedAddress == null){
				return "No Placess in Google map ";
			}
			return formattedAddress;
		}
	}
}
