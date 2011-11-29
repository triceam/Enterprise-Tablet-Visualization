package com.tricedesigns.enterprisedata;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class VehicleNotificationServlet implements ServletContextListener {

	private static Logger log = Logger.getLogger("VehicleNotificationServlet");
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
		log.debug( "VehicleNotificationServlet context destroyed" );
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		log.debug( "VehicleNotificationServlet context initialized" );
		
		VehicleNotificationThread thread = new VehicleNotificationThread();
		thread.start();

	}

}
