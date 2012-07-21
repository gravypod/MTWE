package com.gravypod.MTWE;

import org.bukkit.plugin.java.JavaPlugin;

public class MTWE extends JavaPlugin {
	
	@Override
	public void onEnable() {

		System.out.println("MTWE test started");
		getCommand("MTWE").setExecutor(new Commands(this));
		
	}
	
	@Override
	public void onDisable() {
		
		System.out.println("MTWE test ended");
		
	}
	
}
