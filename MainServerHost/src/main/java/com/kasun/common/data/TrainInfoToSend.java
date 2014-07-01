package com.kasun.common.data;

public class TrainInfoToSend {

	public String Location;
	public String speed;

	public TrainInfoToSend() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrainInfoToSend(String location, String speed) {
		super();
		Location = location;
		this.speed = speed;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

}
