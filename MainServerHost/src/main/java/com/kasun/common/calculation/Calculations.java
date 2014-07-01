package com.kasun.common.calculation;

import java.awt.geom.Arc2D.Float;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kasun.common.data.GPSLocation;

public class Calculations {
	
	private static final Logger log = LoggerFactory.getLogger(Calculations.class);
	
//	public static void main(String [] args){
//		GPSLocation loc1 = new GPSLocation("80.58997219999992","7.257163200000001");
//		GPSLocation loc2 = new GPSLocation("81.5","7.357163200000001");
//		System.out.println("Distance: "+distFrom(loc1,loc2));
//	}
	
	public static int calculateSpeed(GPSLocation loc1 , GPSLocation loc2){
		int speed = 0;
		if(loc1.equals(loc2)){
			return speed;
		}
		speed = (int)distFrom(loc1,loc2)/5;
		return speed;
	}
	
	public static double distance2GPS(GPSLocation loc1 , GPSLocation loc2 ) {
		double lat1 = Long.parseLong(loc1.getLat());
		double lng1 = Long.parseLong(loc1.getLan());
		double lat2 = Long.parseLong(loc2.getLat());
		double lng2 = Long.parseLong(loc2.getLan());
		
	    int r = 6371; // average radius of the earth in km
	    double dLat = Math.toRadians(lat2 - lat1);
	    double dLon = Math.toRadians(lng2 - lng1);
	    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
	       Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) 
	      * Math.sin(dLon / 2) * Math.sin(dLon / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double d = r * c;
	    return d;
	}
	public static double distFrom(GPSLocation loc1 , GPSLocation loc2 ) {
		double lat1 = Double.parseDouble(loc1.getLat());
		double lng1 = Double.parseDouble(loc1.getLan());
		double lat2 = Double.parseDouble(loc2.getLat());
		double lng2 = Double.parseDouble(loc2.getLan());
	    double earthRadius = 3958.75;
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double sindLat = Math.sin(dLat / 2);
	    double sindLng = Math.sin(dLng / 2);
	    double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
	            * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    double dist = earthRadius * c;
	    log.info("Distance between two points: "+dist);
	    return dist;
	    }
}
