package com.bukkit.marciogm.restBukkit.services.resources;

import org.restlet.resource.Get;

public class BanResource extends PlayerResource {
	
	String urlAccess;
	String message;
	
	@Override
	public void doInit() {
		super.doInit();
		this.urlAccess = (String) getReference().getLastSegment();
		
		verifyLastSegment();
	}
	
	@Get
	public String toString() {
		return message;
	}
	
	private void banPlayer() {
		//TODO: IMPLEMENTATION
	}
	
	private void pardonPlayer() {
		//TODO: IMPLEMENTATION
	}
	
	private void verifyLastSegment() {
		if(this.urlAccess.equals("ban"))
		{
			banPlayer();
			this.message = this.playerName + ": was banned";
		}
		else {
			pardonPlayer();
			this.message = this.playerName + ": was unbanned";
		}
	}

}