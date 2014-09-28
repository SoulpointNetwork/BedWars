/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.funergy.bedwars.categorychooser.ShopCategories;
import com.funergy.bedwars.shop.Armor;

/**
 * @author Funergy
 *
 */
public class Bedwars extends JavaPlugin{
	 public static Bedwars instance;
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new ShopCategories(), this);
		instance = this;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd,
			String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("armor")){
			sender.sendMessage("opened");
			Player p = (Player) sender; 
			Armor.open(p);
		}
		return false;
	}

}
