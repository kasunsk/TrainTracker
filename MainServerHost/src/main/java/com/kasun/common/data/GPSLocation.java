package com.kasun.common.data;

public class GPSLocation {

	public String lan;
	public String lat;
	
	public GPSLocation(String lan, String lat) {
		super();
		this.lan = lan;
		this.lat = lat;
	}

	public String getLan() {
		return lan;
	}

	public void setLan(String lan) {
		this.lan = lan;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

}
