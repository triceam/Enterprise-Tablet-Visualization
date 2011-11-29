package com.tricedesigns.enterprisedata;

import org.apache.log4j.Logger;

import com.adobe.internal.util.UUID;
import com.tricedesigns.enterprisedata.model.SharedVehicleModel;
import com.tricedesigns.enterprisedata.model.VehicleUpdate;

import flex.messaging.MessageBroker;
import flex.messaging.messages.AsyncMessage;

public class VehicleNotificationThread extends Thread implements Runnable {

	private static Logger log = Logger.getLogger("VehicleNotificationThread");
	private static String uid = UUID.createUUID();
	
	@Override
	public void run() {
		
		try { 
			Thread.sleep(5000); 
			log.debug( "Realtime Simulation Started..." );
			while( true ) {
				VehicleUpdate update = SharedVehicleModel.updateRandomVehicle();
				
				if ( update != null ) {
					
					AsyncMessage message = new AsyncMessage();
					message.setClientId( uid );
					message.setDestination( "distributionDestination" );
	
					message.setMessageId( UUID.createUUID() );
					message.setTimestamp( System.currentTimeMillis() );
	
					message.setBody( update ); 
					MessageBroker.getMessageBroker(null).routeMessageToService(message, null);
				}
				Thread.sleep(500); 
			} 
		} catch (InterruptedException e) { 
			log.error(e.getMessage());
			e.printStackTrace();
		} 
		log.error( "exiting VehicleNotificationThread" );
	} 
	
}
