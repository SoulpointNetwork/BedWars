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
	  public static ItemStack getQuartz(Player p, int amount)
	  {
	    Item i = new Item(Material.QUARTZ, amount);

	    i.setName("Quartz");

	    return i.getItem();
	  }

	  public static ItemStack getGold(Player p, int amount) {
	    Item i = new Item(Material.GOLD_INGOT, amount);

	    i.setName(ChatColor.GOLD+"Gold");

	    return i.getItem();
	  }

	  public static ItemStack getDiamond(Player p, int amount) {
	    Item i = new Item(Material.DIAMOND, amount);

	    i.setName(ChatColor.AQUA+"Diamond");

	    return i.getItem();
	  }
	}
