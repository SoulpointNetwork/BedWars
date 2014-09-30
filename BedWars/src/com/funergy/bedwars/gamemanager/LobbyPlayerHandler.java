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

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.funergy.bedwars.Bedwars;


/**
 * @author Funergy
 *
 */
public class LobbyPlayerHandler {
	public static Bedwars plugin = Bedwars.instance;
	
	public static void setLobbyPlayerCount(Integer pcount){
		plugin.setLobbyCount(pcount);
	}
	public static void giveItems(Player p){
		p.getInventory().setItem(0, itemStack(Material.WOOL,DyeColor.CYAN, 1, "&bBlue team", "Right click to open the GUI"));
		p.getInventory().setItem(1, itemStack(Material.WOOL,DyeColor.GREEN, 1, "&aGreen team", "Right click to open the GUI"));
		p.getInventory().setItem(2, itemStack(Material.WOOL,DyeColor.RED, 1, "&cRed Team", "Right click to open the GUI"));
		p.getInventory().setItem(3, itemStack(Material.WOOL,DyeColor.YELLOW, 1, "&eYellow Team", "Right click to open the GUI"));

	}
	public static void teleportPlayer(Player p){
		//teleport the player to the lobby
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack itemStack(Material mat,DyeColor color, Integer amount, String displayname, String Lore){
		ItemStack im = new ItemStack(mat,amount,color.getData());
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
