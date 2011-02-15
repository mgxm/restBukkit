package com.bukkit.marciogm.restBukkit.services.resources;

import org.restlet.resource.Get;

public class TeleportResource extends PlayerResource {
	
	String otherPlayerName;
	
	Object otherPlayer;

	@Override
	public void doInit() {
		this.playerName = (String) getRequestAttributes().get("player");
		this.otherPlayerName = (String) getRequestAttributes().get("otherPlayer");
		this.otherPlayer = null; // Could be a lookup to a domain object.
	}
	
	@Get
	public String toString() {
		return "Teleporting \"" + this.playerName + "\" to \"" + this.otherPlayerName + "\"";
	}
}
