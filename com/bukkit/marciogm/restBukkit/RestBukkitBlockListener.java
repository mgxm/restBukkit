package com.bukkit.marciogm.restBukkit;

import org.bukkit.event.block.BlockListener;

/**
 * restBukkit block listener
 * @author marciogm
 */
public class RestBukkitBlockListener extends BlockListener {
    private final restBukkit plugin;

    public RestBukkitBlockListener(final restBukkit plugin) {
        this.plugin = plugin;
    }

    //put all Block related code here
}
