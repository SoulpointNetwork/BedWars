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

import com.funergy.bedwars.Bedwars;

/**
 * @author Funergy
 *
 */
public class Gold extends BukkitRunnable{
	public Gold() {
	}

	@Override
	public void run() {
		if(Bedwars.getGameState().equalsIgnoreCase("ingame")){

		Bukkit.getWorld("map").dropItemNaturally(new Location(Bukkit.getWorld("map"),-225,35,-175),itemStack(Material.GOLD_INGOT,1,ChatColor.GOLD+"Gold",null));
        Bukkit.getWorld("map").dropItemNaturally(new Location(Bukkit.getWorld("map"),-280,35,-230),itemStack(Material.GOLD_INGOT,1,ChatColor.GOLD+"Gold",null));
        Bukkit.getWorld("map").dropItemNaturally(new Location(Bukkit.getWorld("map"),-225,35,-285),itemStack(Material.GOLD_INGOT,1,ChatColor.GOLD+"Gold",null));
        Bukkit.getWorld("map").dropItemNaturally(new Location(Bukkit.getWorld("map"),-170,35,-230),itemStack(Material.GOLD_INGOT,1,ChatColor.GOLD+"Gold",null));        
		}
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
