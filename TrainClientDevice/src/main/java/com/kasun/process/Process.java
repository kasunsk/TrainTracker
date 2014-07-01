package com.kasun.process;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;

import com.kasun.client.TrainClient;

public class Process {

	public static void run() throws MalformedURLException, IOException,
			ParseException {

		int i = 0;
		String id = "abc";

		double lngd = 80.60000000000002;
		double latd = 7.266666699999999;
		
		String lan;  
		String lat;  
		

		while (i < 30) {

			lan = lngd + "";
			lat = latd + "";
			
			TrainClient.SendLocationAndSpeed(id, lan, lat);
			
			lngd = Double.parseDouble(lan)+0.0002;
			latd = Double.parseDouble(lat)+0.0001;
			
			
			try {
				// to sleep 5 seconds
				System.out.println("Thread Slept... wait 5 second please");
				Thread.sleep(5000);

			} catch (InterruptedException e) {
				// recommended because catching InterruptedException clears
				// interrupt flag
				Thread.currentThread().interrupt();
				// you probably want to quit if the thread is interrupted
			}
			i++;
		}
	}

}
