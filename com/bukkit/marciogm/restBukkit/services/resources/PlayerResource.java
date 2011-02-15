package com.bukkit.marciogm.restBukkit.services.resources;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.restlet.resource.*;

import com.bukkit.marciogm.restBukkit.services.Globals;

public class PlayerResource extends ServerResource {
	String playerName;
	String urlAcces;
	Object player;
	
	public Server plugin = Globals.getServer();
	
	@Override
	public void doInit() {
		this.playerName = (String) getRequestAttributes().get("player");
		this.urlAcces = (String) getReference().getLastSegment();
		this.player = null; // Could be a lookup to a domain object.
	}
	
	@Get
	public String toJson() {
		String message = getCurrentUsersOnline();
		return message;
	}
	
	private String getCurrentUsersOnline() {
		Player[] players = plugin.getOnlinePlayers();
		if(players.length != 0 ) {
			String users_online = "";
			for(int i=0; i < players.length; i++){
				users_online += players[i].getDisplayName() + " ";
			}
			return users_online;
		}
		else {
			return "No users online :(";
		}
	}
}
