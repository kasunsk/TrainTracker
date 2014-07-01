package com.kasun.common.data;

public class Train {

	private String id;
	public String name;
	public GPSLocation gpslocation;
	public String location;
	public int speed;
	
	

	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Train(String id, String name, GPSLocation gpslocation,String location, int speed) {
		super();
		this.id = id;
		this.name = name;
		this.gpslocation = gpslocation;
		this.location = location;
		this.speed = speed;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GPSLocation getGpslocation() {
		return gpslocation;
	}

	public void setGpslocation(GPSLocation gpslocation) {
		this.gpslocation = gpslocation;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	


}
