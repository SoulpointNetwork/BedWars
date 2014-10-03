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
public class Pickaxe {
	 public static void open(Player p)
	  {
	    Merchant inv = new Merchant();
	    inv.setTitle("Pickaxes");

	    Item wood = new Item(Material.WOOD_PICKAXE, 1);
	    wood.addEnchantment(Enchantment.DIG_SPEED, 2);
	    wood.addEnchantment(Enchantment.DURABILITY, 1);

	    Item stone = new Item(Material.STONE_PICKAXE, 1);
	    stone.addEnchantment(Enchantment.DIG_SPEED, 1);
	    stone.addEnchantment(Enchantment.DURABILITY, 1);

	    Item iron = new Item(Material.IRON_PICKAXE, 1);
	    iron.addEnchantment(Enchantment.DIG_SPEED, 1);
	    iron.addEnchantment(Enchantment.DURABILITY, 1);

	    inv.addOffer(new MerchantOffer(Currency.getQuartz(p, 10), wood.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getGold(p, 2), stone.getItem()));
	    inv.addOffer(new MerchantOffer(Currency.getDiamond(p, 1), iron.getItem()));

	    inv.setCustomer(p);
	    inv.openTrading(p);
	  }
	}
