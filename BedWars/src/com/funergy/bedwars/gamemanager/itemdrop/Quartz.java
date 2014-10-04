/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.gamemanager.itemdrop;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * @author Funergy
 *
 */
public class Quartz extends BukkitRunnable{
	
	public Quartz() {
	}

	@Override
	public void run() {
    Bukkit.getWorld("map").dropItemNaturally(new Location(Bukkit.getWorld("map"),-225,35,-175),itemStack(Material.QUARTZ,1,"Quartz",null));
    Bukkit.getWorld("map").dropItemNaturally(new Location(Bukkit.getWorld("map"),-280,35,-230),itemStack(Material.QUARTZ,1,"Quartz",null));
    Bukkit.getWorld("map").dropItemNaturally(new Location(Bukkit.getWorld("map"),-225,35,-285),itemStack(Material.QUARTZ,1,"Quartz",null));
    Bukkit.getWorld("map").dropItemNaturally(new Location(Bukkit.getWorld("map"),-170,35,-230),itemStack(Material.QUARTZ,1,"Quartz",null));

	}
	
	
	public static ItemStack itemStack(Material mat, Integer amount, String displayname, String Lore){
		ItemStack im = new ItemStack(mat,amount);
		ItemMeta m = im.getItemMeta();
		if(displayname !=null){
		m.setDisplayName(ChatColor.translateAlternateColorCodes('&',displayname));
		}
		if(Lore != null){
		ArrayList<String> lore = new ArrayList<String>();
		m.setLore(lore);
		}
		im.setItemMeta(m);
		
		return im;
	}

}
