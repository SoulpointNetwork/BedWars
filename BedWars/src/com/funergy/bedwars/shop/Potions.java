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
public class Potions {
	public static void open(Player p)
	  {
	    Merchant inv = new Merchant();
	    inv.setTitle("Potions");

	    Item heal = new Item(Material.POTION, 1);
	    heal.setPotion(8197);

	    Item heal2 = new Item(Material.POTION, 1);
	    heal2.setPotion(8229);

	    Item speed = new Item(Material.POTION, 1);
	    speed.setPotion(8194);

	    Item strength = new Item(Material.POTION, 1);
	    strength.setPotion(8201);

	    inv.addOffer(new MerchantOffer(Currency.getIron(p, 3), heal.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getIron(p, 6), heal2.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getIron(p, 7), speed.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getGold(p, 8), strength
	      .getItem()));

	    inv.setCustomer(p);
	    inv.openTrading(p);
	  }
}
