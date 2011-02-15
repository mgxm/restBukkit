package com.bukkit.marciogm.restBukkit.services.resources;

import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class ChatResource extends ServerResource {
	
	String chatMessage;
	
	@Override
	public void doInit() {
		this.chatMessage = (String) getRequestAttributes().get("message");
	}
	
	@Post
	public void acceptSay(Representation entity) {
		//TODO: IMPLEMENTATION
	}

}
