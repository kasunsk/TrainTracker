package com.kasun.common.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kasun.common.calculation.Calculations;
import com.kasun.common.data.Train;
import com.kasun.common.data.GPSLocation;
import com.kasun.common.data.TrainInfoReciving;
import com.kasun.common.data.TrainInfoToSend;
import com.kasun.common.db.DBConncetion;
import com.kasun.common.gsonObject.ResivingData;
import com.kasun.common.run.Run;
import com.kasun.common.services.GetTrainLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/location")
public class JSONController {
	
	private static final Logger log = LoggerFactory.getLogger(JSONController.class);

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody
	TrainInfoToSend TrainDetails(@PathVariable String id) {

		// GPSLocation gpsLoc = new GPSLocation("25","22");
		// Train train = new Train(id,"kasun",gpsLoc,"Peradeniya",30);
		// return train;

		Train train = DBConncetion.getTrain("abc");
		TrainInfoToSend trainInfoToSend = new TrainInfoToSend();

		String location = train.getLocation();
		String speed = train.getSpeed() + "";

		log.info("location: " + location);
		log.info("speed: " + speed);

		trainInfoToSend.setLocation(location);
		trainInfoToSend.setSpeed(speed);

		// trainInfoToSend.setLocation("Kandy");
		// trainInfoToSend.setSpeed("30 km/h");
		return trainInfoToSend;
	}

	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public @ResponseBody
	GPSLocation trainDataToSave(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "lan", required = true) String lan,
			@RequestParam(value = "lat", required = true) String lat)
			throws MalformedURLException, ClassNotFoundException, IOException,
			ParseException {

		log.info("id: " + id);
		log.info("lan: " + lan);
		log.info("lat: " + lat);

		Run.addingData(id,lan,lat);

		GPSLocation jps = new GPSLocation("0.01", "2.31");

		return jps;
	}

}