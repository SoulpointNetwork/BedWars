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
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import com.funergy.bedwars.shop.nms.Currency;
import com.funergy.bedwars.shop.nms.Item;
import com.funergy.bedwars.shop.nms.Merchant;
import com.funergy.bedwars.shop.nms.MerchantOffer;
/**
 * @author Funergy
 *
 */
public class Bows {
	 public static void open(Player p)
	  {
	    Merchant inv = new Merchant();
	    inv.setTitle("Bows");

	    Item bow1 = new Item(Material.BOW, 1);
	    bow1.addEnchantment(Enchantment.ARROW_INFINITE, 1);

	    Item bow2 = new Item(Material.BOW, 1);
	    bow2.addEnchantment(Enchantment.ARROW_INFINITE, 1);
	    bow2.addEnchantment(Enchantment.ARROW_DAMAGE, 1);

	    Item bow3 = new Item(Material.BOW, 1);
	    bow3.addEnchantment(Enchantment.ARROW_INFINITE, 1);
	    bow3.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
	    bow3.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);

	    Item arrow = new Item(Material.ARROW, 1);

	    inv.addOffer(new MerchantOffer(Currency.getGold(p, 3), bow1.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getGold(p, 7), bow2.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getGold(p, 15), bow3.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getGold(p, 1), arrow.getItem()));

	    inv.setCustomer(p);
	    inv.openTrading(p);
	  }
}
