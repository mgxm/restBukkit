package com.bukkit.marciogm.restBukkit.services;

import org.bukkit.Server;

public class Globals {
	
	private static Server _server;

	public static void setServer(Server server) {
		_server = server;
	}

	public static Server getServer() {
		return _server;
	}

}
