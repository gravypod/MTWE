package com.gravypod.MTWE;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

	MTWE plugin;

	public Commands(MTWE plugin) {
		
		this.plugin = plugin;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		
		if (sender instanceof Player) {
			new ReplaceBlocks(plugin, (Player) sender, Integer.parseInt(args[0])).start();
			sender.sendMessage("Stuff");
			return true;
		}
		return false;
	}
	
	
	
	
}
