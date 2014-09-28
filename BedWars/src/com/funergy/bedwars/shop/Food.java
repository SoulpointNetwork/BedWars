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
public class Food {
	public static void open(Player p)
	  {
	    Merchant inv = new Merchant();

	    inv.setTitle("Food");

	    Item apple = new Item(Material.APPLE, 1);
	    Item meat = new Item(Material.GRILLED_PORK, 1);
	    Item cake = new Item(Material.CAKE, 1);
	    Item gapple = new Item(Material.GOLDEN_APPLE, 1);

	    inv.addOffer(new MerchantOffer(Currency.getBronze(p, 1), apple.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getBronze(p, 2), meat.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getIron(p, 1), cake.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getGold(p, 2), gapple.getItem()));

	    inv.setCustomer(p);
	    inv.openTrading(p);
	  }
}
