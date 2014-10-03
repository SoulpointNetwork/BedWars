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
public class Diamond extends BukkitRunnable{
	public Diamond() {
	}

	@Override
	public void run() {
		Bukkit.getWorld("world").dropItemNaturally(new Location(Bukkit.getWorld("world"),-225,26,-230),itemStack(Material.DIAMOND,1,ChatColor.AQUA+"Diamond",null));

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
