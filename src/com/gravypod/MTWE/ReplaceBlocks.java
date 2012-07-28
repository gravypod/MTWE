package com.gravypod.MTWE;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public class ReplaceBlocks extends Thread {

	MTWE plugin;
	volatile Location loc;
	int item;
	
	public ReplaceBlocks(MTWE plugin, Location l, int item) {

		this.plugin = plugin;
		this.loc = new Location(l.getWorld(), l.getX(), l.getY(), l.getZ());
		this.item = item;

	}

	@Override
	public void run() {
		
		setToBlock();
		
	}

	public void setToBlock() {
		final long time = System.nanoTime();
		World world = loc.getWorld();
		int firstX = loc.getBlockX();
		int firstY = loc.getBlockY();
		int firstZ = loc.getBlockZ();
		synchronized (world) {
			int maxHeight = world.getMaxHeight();
			for (int offsetZ = 0; offsetZ < 1; offsetZ++)
				for (int offsetX = 1; offsetX < 100; offsetX++) {
					Chunk chunk = world.getChunkAt(new Location(world, firstX + (offsetX * 16), firstY, firstZ + (offsetZ * 16)));
					synchronized (chunk) {
						for (int x = 0; x < 16; x++) {
							for (int z = 0; z < 16; z++) {
								for (int y = 0; y < maxHeight; y++) {
									if (!chunk.isLoaded()) {
										chunk.load();
									} 
									while (!chunk.isLoaded()) {
										
									}
									Block b = chunk.getBlock(x, y, z);
									synchronized (b) {
										b.setTypeId(item, false);
									}
								}
							}
						}
					}
				}
		}
		System.out.println(ChatColor.AQUA + "[MTWE] " + ChatColor.WHITE + "Done, took " + (System.nanoTime() - time) + " Ms");
	}

}
