package com.bukkit.marciogm.restBukkit.services;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.bukkit.marciogm.restBukkit.services.resources.*;

public class ServicesApplication extends Application {
	
	/**
	 * Create a root Restlet that will receive all incoming calls
	 */
	@Override
	public synchronized Restlet createInboundRoot() {
		// Create a router Restlet that routes each call to a  
        // new instance of HelloWorldResource.
		Router router = new Router(getContext());
		
		// Define only one route
		router.attach("/players/online", PlayerResource.class);
		router.attach("/player/{player}", PlayerResource.class);
		router.attach("/player/{player}/kick", KickResource.class);
		router.attach("/player/{player}/ban", BanResource.class);		
		router.attach("/player/{player}/pardon", BanResource.class);
		router.attach("/player/{player}/teleport/{otherPlayer}", TeleportResource.class);
		router.attach("/server/say/{message}", ChatResource.class);
//		router.attach("/server/stop", ChatResource.class);
//		router.attach("/server/save_all", SaveResource.class);
//		router.attach("/server/save_on", SaveResource.class);
//		router.attach("/server/save_off", SaveResource.class);
		
		return router;
	}

}
