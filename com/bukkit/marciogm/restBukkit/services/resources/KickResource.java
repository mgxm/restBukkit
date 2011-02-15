package com.bukkit.marciogm.restBukkit.services.resources;

import org.restlet.resource.Get;

public class KickResource extends PlayerResource {
	
	@Override
	public void doInit() {
		super.doInit();
	}
	
	@Get
	public String toString() {
		return this.playerName + ": was kicked";
	}
}
