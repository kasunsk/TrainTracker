package com.kasun.common.gsonObject;

public class ResivingData {
	
	public String id;
	public String lon;
	public String lat;
	
	
	
	public ResivingData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ResivingData(String id, String lon, String lat) {
		super();
		this.id = id;
		this.lon = lon;
		this.lat = lat;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	
	
	

}
