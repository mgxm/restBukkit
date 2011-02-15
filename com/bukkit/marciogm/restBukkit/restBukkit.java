package com.bukkit.marciogm.restBukkit;

import java.io.File;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.Server;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import org.restlet.Component;
import org.restlet.data.Protocol;

import com.bukkit.marciogm.restBukkit.services.Globals;
import com.bukkit.marciogm.restBukkit.services.ServicesApplication;

/**
 * restBukkit for Bukkit
 *
 * @author marciogm
 */
public class restBukkit extends JavaPlugin {
//    private final RestBukkitPlayerListener playerListener = new RestBukkitPlayerListener(this);
//    private final RestBukkitBlockListener blockListener = new RestBukkitBlockListener(this);
    private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();

    public restBukkit(PluginLoader pluginLoader, Server instance, PluginDescriptionFile desc, File folder, File plugin, ClassLoader cLoader) {
        super(pluginLoader, instance, desc, folder, plugin, cLoader);
        // TODO: Place any custom initialisation code here
        
        // NOTE: Event registration should be done in onEnable not here as all events are unregistered when a plugin is disabled
    }
    
    public void startService() {
        try {
        	tryToStartServices();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void tryToStartServices() throws Exception {
    	// Create a new Component
	    Component component = new Component();
	    
	    // Add a new HTTP server listening on port 8182.  
	    component.getServers().add(Protocol.HTTP, 8182);
	    
	    // Attach the sample application.  
	    component.getDefaultHost().attach("/server", new ServicesApplication());
	    
	    // Start the component.  
	    component.start();    	
    }

    public void onEnable() {
        // TODO: Place any custom enable code here including the registration of any events

        // Register our events
        PluginManager pm = getServer().getPluginManager();
        	
        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
        
        //Start service
        startService();
        Globals.setServer(this.getServer());

    }
    public void onDisable() {
        // TODO: Place any custom disable code here

        // NOTE: All registered events are automatically unregistered when a plugin is disabled

        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        System.out.println("Goodbye world!");
    }
    public boolean isDebugging(final Player player) {
        if (debugees.containsKey(player)) {
            return debugees.get(player);
        } else {
            return false;
        }
    }

    public void setDebugging(final Player player, final boolean value) {
        debugees.put(player, value);
    }
}

