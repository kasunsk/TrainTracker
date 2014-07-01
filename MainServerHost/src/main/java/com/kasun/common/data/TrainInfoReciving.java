package com.kasun.common.data;

public class TrainInfoReciving {
	
	public String id;
	public String lan;
	public String lat;
	
	public TrainInfoReciving() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TrainInfoReciving(String id, String lan, String lat) {
		super();
		this.id = id;
		this.lan = lan;
		this.lat = lat;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
