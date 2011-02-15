package com.bukkit.marciogm.restBukkit.services;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class ServicesMain {
	
    public ServicesMain() throws Exception {
    	// Create a new Component
	    Component component = new Component();
	    
	    // Add a new HTTP server listening on port 8182.  
	    component.getServers().add(Protocol.HTTP, 8182);
	    
	    // Attach the sample application.  
	    component.getDefaultHost().attach("/server", new ServicesApplication());
	    
	    // Start the component.  
	    component.start();
    }

}
