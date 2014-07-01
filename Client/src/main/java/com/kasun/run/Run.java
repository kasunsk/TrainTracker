package com.kasun.run;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;

import com.kasun.client.Client;

public class Run {
	
	public static void main(String[] args) throws MalformedURLException, IOException, ParseException {
		String locationandspeed = Client.locationAndSpeed("abc");
		System.out.println("Location and Speed: "
				+locationandspeed);

	}

}
