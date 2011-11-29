package com.tricedesigns.enterprisedata.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SharedVehicleModel {

	private static List<Vehicle> _vehicles = new ArrayList<Vehicle>();

	public static List<Vehicle> getVehicles() {
		
		if (_vehicles.isEmpty() )
		{
			for ( int i = 0; i < 50; i++ ) {
				_vehicles.add( new Vehicle( i, "Flight 0" + i, 0, generateLatitude(), generateLongitude(), Math.random()*5, Math.random() * 360  ) );
			}
		}
		return _vehicles;
	}
	
	private static double generateLatitude() {
		double min = -70;
		double max = 70;
		
		return (min + Math.random() * (max-min));
	}
	
	private static double generateLongitude() {
		double min = -180;
		double max = 180;
		
		return (min + Math.random() * (max-min));
	}
	
	public static VehicleUpdate updateRandomVehicle() {
		
		if (  _vehicles.isEmpty() ) return null;
		
		Random random = new Random();
		
		int vehicleId = random.nextInt( _vehicles.size() );
		Vehicle vehicle = _vehicles.get(vehicleId);
		
		double lat = vehicle.getLatitude();
		double lon = vehicle.getLongitude();
		double speed = vehicle.getSpeed();
		double direction = vehicle.getDirection();

		direction += ((random.nextInt() % 2 == 0) ? -1 : 1) * Math.random()*15;

		direction += 0.5;

		if ( direction > 360 )
			direction -= 360;
		if ( direction < -360 )
			direction += 360;

		double rads = direction * (Math.PI/180);
		double rads2 = (90-lat) * (Math.PI/180);
		
		//update position relative to "great circle" position
		lat += (Math.cos( rads ) * Math.sin(rads2) ) * speed;
		lon += Math.sin( rads ) * speed;

		if ( lat > 80 )
			lat -= Math.abs(speed);
		else if ( lat < -80 )
			lat += Math.abs(speed);
		
		if ( lon > 180 )
			lon -= 360;
		else if ( lon < -180 )
			lon += 360;
		
		
		
		vehicle.setLatitude( lat );
		vehicle.setLongitude( lon );
		vehicle.setSpeed( speed );
		vehicle.setDirection(direction);
		
		VehicleUpdate vehicleUpdate = new VehicleUpdate(vehicle);
		return vehicleUpdate;
	}
	
	
}
