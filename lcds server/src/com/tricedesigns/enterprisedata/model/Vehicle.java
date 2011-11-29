package com.tricedesigns.enterprisedata.model;

import java.io.Serializable;

public class Vehicle implements Serializable {

    static final long serialVersionUID = 123456123412341236L;
    
	private int vehicleId;
	private int icon;
	private String name;
	private double latitude;
	private double longitude;
	private double speed;
	private double direction;
	
	public Vehicle() {
		
	}
	
	public Vehicle( int vehicleId, String name, int icon, double latitude, double longitude, double speed, double direction ) {
		this.vehicleId = vehicleId;
		this.name = name;
		this.icon = icon;
		this.latitude = latitude;
		this.longitude = longitude;
		this.speed = speed;
		this.direction = direction;
	}
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public int getIcon() {
		return icon;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getDirection() {
		return direction;
	}
	public void setDirection(double direction) {
		this.direction = direction;
	}
}
