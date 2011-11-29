package com.tricedesigns.enterprisedata.model;

import java.io.Serializable;

public class VehicleUpdate implements Serializable {

    static final long serialVersionUID = 123456123412341237L;

	private int vehicleId;
	private double latitude;
	private double longitude;
	private double speed;
	private double direction;
	
	public VehicleUpdate() {
	
	}
	
	public VehicleUpdate( Vehicle vehicle ) {
		this.vehicleId = vehicle.getVehicleId();
		this.latitude = vehicle.getLatitude();
		this.longitude = vehicle.getLongitude();
		this.speed = vehicle.getSpeed();
		this.direction = vehicle.getDirection();
	}
	
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
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
