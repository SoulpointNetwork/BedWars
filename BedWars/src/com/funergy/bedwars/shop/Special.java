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
public class Special {
	public static void open(Player p)
	  {
	    Merchant inv = new Merchant();
	    inv.setTitle("Specials");

	    Item ladder = new Item(Material.LADDER, 1);
	    Item web = new Item(Material.WEB, 1);
	    Item fishing = new Item(Material.FISHING_ROD, 1);
	    Item flint = new Item(Material.FLINT_AND_STEEL, 1);
	    Item tnt = new Item(Material.TNT, 1);
	    Item ender = new Item(Material.ENDER_PEARL, 1);

	    inv.addOffer(new MerchantOffer(Currency.getQuartz(p, 1), ladder
	      .getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getQuartz(p, 20), web.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getGold(p, 5), fishing
	      .getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getGold(p, 4), flint.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getDiamond(p, 3), tnt.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getDiamond(p, 10), ender.getItem()));

	    inv.setCustomer(p);
	    inv.openTrading(p);
	  }
}
