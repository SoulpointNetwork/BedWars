/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.gamemanager;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * @author Funergy
 *
 */
public class SpectatorHandler implements Listener{
	public static ArrayList<Player> spectators = new ArrayList<Player>();

	public static void addSpectator(Player p){
		p.teleport(new Location(Bukkit.getWorld("world"),-303,28,-304));
		p.setGameMode(GameMode.CREATIVE);
	        spectators.add(p);
	        for(Player pl : Bukkit.getOnlinePlayers()){
	        		pl.hidePlayer(p);
	        		
	        }
	        for(Player pl : spectators){
	        	p.hidePlayer(pl);
	        }
			p.teleport(new Location(Bukkit.getWorld("world"),-303,28,-304));
	        p.getInventory().setItem(0, itemStack(Material.COMPASS,1,null,"§aTeleporter","Right click to use"));
	}
	public static void removeSpectator(Player p){
		spectators.remove(p);
	
	}
	@SuppressWarnings("deprecation")
	public static ItemStack itemStack(Material mat, Integer amount,DyeColor c ,String displayname, String Lore){
		ItemStack im;
		if(c !=null){
		im = new ItemStack(mat,amount,c.getData());
		}else{
	    im = new ItemStack(mat,amount);
		}
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
