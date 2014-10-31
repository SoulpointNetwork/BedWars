/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.shop;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.funergy.bedwars.shop.nms.Currency;
import com.funergy.bedwars.shop.nms.Item;
import com.funergy.bedwars.shop.nms.Merchant;
import com.funergy.bedwars.shop.nms.MerchantOffer;

/**
 * @author Funergy
 *
 */
public class Blocks {
	 public static void open(Player p)
	  {
	    Merchant inv = new Merchant();
	    inv.setTitle("Blocks");

	    Item sandstone = new Item(Material.SANDSTONE, 1);
	    Item endstone = new Item(Material.ENDER_STONE, 3);
	    Item ironblock = new Item(Material.IRON_BLOCK, 4);
	    Item glowstone = new Item(Material.GLOWSTONE, 4);

	    
	    inv.addOffer(new MerchantOffer(Currency.getQuartz(p, 1), sandstone.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getQuartz(p, 5), endstone
	      .getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getQuartz(p, 20), glowstone
	  	      .getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getGold(p, 3), ironblock
	      .getItem()));
	    

	    inv.setCustomer(p);
	    inv.openTrading(p);
	  }
}
