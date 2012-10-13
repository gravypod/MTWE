package com.gravypod.mtwe;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.gravypod.mtwe.utils.WorldUtils;

public class WorldEditing extends JavaPlugin {
	
	HashMap<String, Location> locations = new HashMap<String, Location>();
	
	HashMap<String, Thread> threads = new HashMap<String, Thread>();
	
	public void onEnabled() {
		getCommand("mtwe").setExecutor(this);
	}
	
	public void onDisable() {
		
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if (args.length == 1) {
			
			if (args[0].equalsIgnoreCase("set"))
				
				synchronized (p.getWorld()) {
					
					threads.get(p.getName()).start();
					
				}
			
		}
		
		if (locations.containsKey(p.getName())) {
				
			World world = p.getWorld();
				
			
			threads.put(p.getName(), new Thread(new SetThread(WorldUtils.getBlocks(world , locations.get(p.getName()), p.getEyeLocation()))));
			
			p.sendMessage("Now use /mtwe set to set all the blocks to stone");
			locations.remove(p);
				
		} else {
			
			locations.put(p.getName(), p.getEyeLocation());
			p.sendMessage("Block 1 set, click another block");
			
		}
		
		return true;
	}
	
	
}
