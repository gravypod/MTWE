package com.gravypod.MTWE;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class ReplaceBlocks extends Thread {

	MTWE plugin;
	Player player;
	int item;
	
	public ReplaceBlocks(MTWE plugin, Player player, int item) {

		this.plugin = plugin;
		this.player = player;
		this.item = item;

	}

	@Override
	public void run() {
		
		setToStone(this.player);
		
	}

	public void setToStone(Player player) {

		World world = player.getWorld();
		int firstX, firstY, firstZ;
		firstX = player.getLocation().getBlockX();
		firstY = player.getLocation().getBlockY();
		firstZ = player.getLocation().getBlockZ();
		for (int offset = 1; offset < 100; offset++) {
			Chunk chunk = world.getChunkAt(new Location(player.getWorld(), firstX + (offset * 16), firstY, firstZ));
			int maxHeight = world.getMaxHeight();
			
			for (int x = 0; x < 16; x++) {
				for (int z = 0; z < 16; z++) {
					for (int y = 0; y < maxHeight; y++) {
						synchronized (chunk) {
							if (!chunk.isLoaded()) {
								chunk.load();
							}
							chunk.getBlock(x, y, z).setTypeId(item, false);

						}
					}
				}
			}
			
			world.refreshChunk(firstX + (offset * 16), firstY);
		
		}
	}

}
