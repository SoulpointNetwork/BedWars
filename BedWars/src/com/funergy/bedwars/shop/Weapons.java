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
public class Weapons {
	 public static void open(Player p)
	  {
	    Merchant inv = new Merchant();
	    inv.setTitle("CombatWeapons");
	    
	    Item knockback =  new Item(Material.STICK, 1);
	    knockback.addEnchantment(Enchantment.KNOCKBACK, 1);
	    
	    Item knockback2 =  new Item(Material.STICK, 1);
	    knockback.addEnchantment(Enchantment.KNOCKBACK, 2);
	    
	    Item gold = new Item(Material.GOLD_SWORD, 1);
	    gold.addEnchantment(Enchantment.DAMAGE_ALL, 1);
	    gold.addEnchantment(Enchantment.DURABILITY, 1);

	    Item gold2 = new Item(Material.GOLD_SWORD, 1);
	    gold2.addEnchantment(Enchantment.DAMAGE_ALL, 2);
	    gold2.addEnchantment(Enchantment.DURABILITY, 1);

	    Item iron = new Item(Material.IRON_SWORD, 1);
	    iron.addEnchantment(Enchantment.DAMAGE_ALL, 2);
	    iron.addEnchantment(Enchantment.DURABILITY, 1);
	    iron.addEnchantment(Enchantment.KNOCKBACK, 1);
	    
	    Item iron2 = new Item(Material.IRON_SWORD, 1);
	    iron2.addEnchantment(Enchantment.DAMAGE_ALL, 2);
	    iron2.addEnchantment(Enchantment.DURABILITY, 2);
	    iron2.addEnchantment(Enchantment.KNOCKBACK, 2);

	    inv.addOffer(new MerchantOffer(Currency.getQuartz(p, 10), knockback.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getQuartz(p, 30), knockback2.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getGold(p, 1), gold.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getGold(p, 3), gold2.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getDiamond(p, 3), iron.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getDiamond(p, 6), iron2.getItem()));

	    
	    inv.setCustomer(p);
	    inv.openTrading(p);
	  }
}
