/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.shop.nms;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * @author Funergy
 *
 */
	public class Currency
	{
	  public static ItemStack getGold(Player p, int amount)
	  {
	    Item i = new Item(Material.GOLD_INGOT, amount);

	    i.setName(ChatColor.GOLD+"gold");

	    return i.getItem();
	  }

	  public static ItemStack getIron(Player p, int amount) {
	    Item i = new Item(Material.IRON_INGOT, amount);

	    i.setName(ChatColor.WHITE+"iron");

	    return i.getItem();
	  }

	  public static ItemStack getBronze(Player p, int amount) {
	    Item i = new Item(Material.CLAY_BRICK, amount);

	    i.setName(ChatColor.DARK_RED+"bronze");

	    return i.getItem();
	  }
	}
