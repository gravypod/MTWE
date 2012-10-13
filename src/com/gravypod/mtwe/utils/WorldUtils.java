package com.gravypod.mtwe.utils;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public class WorldUtils {
	
	public static synchronized final ArrayList<Location> getCuboid(final World world, final Location loc1, final Location loc2) {
		
		final ArrayList<Location> blocks = new ArrayList<Location>();
		
		final int start_x = Math.min(loc1.getBlockX(), loc2.getBlockX());
		final int start_y = Math.min(loc1.getBlockY(), loc2.getBlockY());
		final int start_z = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
		final int end_x = Math.max(loc1.getBlockX(), loc2.getBlockX());
		final int end_y = Math.max(loc1.getBlockY(), loc2.getBlockY());
		final int end_z = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
		
		for (int x = start_x; x <= end_x; x++) {
			
			for (int y = start_y; y <= end_y; y++) {
				
				for (int z = start_z; z <= end_z; z++) {
					
					blocks.add(new Location(world, x, y, z));
					
				}
				
			}
			
		}
		
		return blocks;
		
	}
	
	public static synchronized final ArrayList<Block> getBlocks(final World world, final Location loc1, final Location loc2) {
		
		final ArrayList<Block> blocks = new ArrayList<Block>();
		
		final int start_x = Math.min(loc1.getBlockX(), loc2.getBlockX());
		final int start_y = Math.min(loc1.getBlockY(), loc2.getBlockY());
		final int start_z = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
		final int end_x = Math.max(loc1.getBlockX(), loc2.getBlockX());
		final int end_y = Math.max(loc1.getBlockY(), loc2.getBlockY());
		final int end_z = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
		
		for (int x = start_x; x <= end_x; x++) {
			
			for (int y = start_y; y <= end_y; y++) {
				
				for (int z = start_z; z <= end_z; z++) {
					
					blocks.add(world.getBlockAt(x, y, z));
					
				}
				
			}
			
		}
		
		return blocks;
		
	}
	
}
