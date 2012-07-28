package com.gravypod.MTWE;

import org.bukkit.ChatColor;
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
			new ReplaceBlocks(plugin, ((Player) sender).getLocation(), Integer.parseInt(args[0])).start();
			sender.sendMessage(ChatColor.AQUA + "[MTWE] " + ChatColor.WHITE + "Starting the edit, do not log out until you get the 'Done' message!");
			return true;
		}
		return false;
	}
	
	
	
	
}
