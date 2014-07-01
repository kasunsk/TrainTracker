package com.kasun.common.run;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.kasun.common.calculation.Calculations;
import com.kasun.common.data.GPSLocation;
import com.kasun.common.data.Train;
import com.kasun.common.data.TrainInfoReciving;
import com.kasun.common.db.DBConncetion;
import com.kasun.common.gsonObject.ResivingData;
import com.kasun.common.services.GetTrainLocation;
import com.kasun.common.services.LocationGoogle;

public class Run {

	
	public static void addingData(String id,String lan,String lat) throws MalformedURLException, IOException, ParseException, ClassNotFoundException{
				
		Train trainPreviasdata = DBConncetion.getTrain(id);

		GPSLocation gps = new GPSLocation(lan, lat);
		String location = LocationGoogle.getAddressByGpsCoordinates(lan,
				lat);
		GPSLocation gpsPrev = trainPreviasdata.getGpslocation();
		double speed = Calculations.calculateSpeed(gpsPrev, gps);

		Train train = new Train();
		
		train.setId(id);
		train.setGpslocation(gps);
		train.setLocation(location);
		train.setName("Udarata Manike");
		train.setSpeed((int) Math.round(speed));
		
		DBConncetion.addTrain(train);
		
		System.out.println("Train Details added.. ");
		
	}
}
