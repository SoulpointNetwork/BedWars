/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.shop;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import com.funergy.bedwars.gamemanager.InGameHandler;
import com.funergy.bedwars.shop.nms.Currency;
import com.funergy.bedwars.shop.nms.Item;
import com.funergy.bedwars.shop.nms.Merchant;
import com.funergy.bedwars.shop.nms.MerchantOffer;
/**
 * @author Funergy
 *
 */
public class Armor{
	
	public static InGameHandler ingame;
  public static void open(Player p)
  {
    Merchant inv = new Merchant();
    inv.setTitle("Armor");

    Color color = Color.WHITE;
     /*String t = ingame.getTeam(p);
      if (t.equalsIgnoreCase("green"))
        color = Color.GREEN;
      if (t.equalsIgnoreCase("blue"))
        color = Color.BLUE;
      if (t.equalsIgnoreCase("red"))
        color = Color.RED;
      if (t.equalsIgnoreCase("yellow")) {
        color = Color.YELLOW;
      }
    */
  
    Item helmet = new Item(Material.LEATHER_HELMET, 1);
    helmet.setLeatherColor(color);
    helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
    helmet.addEnchantment(Enchantment.DURABILITY, 1);

    Item leggings = new Item(Material.LEATHER_LEGGINGS, 1);
    leggings.setLeatherColor(color);
    leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
    leggings.addEnchantment(Enchantment.DURABILITY, 1);

    Item boots = new Item(Material.LEATHER_BOOTS, 1);
    boots.setLeatherColor(color);
    boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
    boots.addEnchantment(Enchantment.DURABILITY, 1);

    Item chestplate1 = new Item(Material.CHAINMAIL_CHESTPLATE, 1);
    chestplate1.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
    chestplate1.addEnchantment(Enchantment.DURABILITY, 1);

    Item chestplate2 = new Item(Material.CHAINMAIL_CHESTPLATE, 1);
    chestplate2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
    chestplate2.addEnchantment(Enchantment.DURABILITY, 1);

    Item chestplate3 = new Item(Material.CHAINMAIL_CHESTPLATE, 1);
    chestplate3.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
    chestplate3.addEnchantment(Enchantment.DURABILITY, 1);

    inv.addOffer(new MerchantOffer(Currency.getBronze(p, 5), helmet.getItem()));
    inv.addOffer(new MerchantOffer(Currency.getBronze(p, 10), leggings.getItem()));
    inv.addOffer(new MerchantOffer(Currency.getBronze(p, 5), boots.getItem()));
    inv.addOffer(new MerchantOffer(Currency.getIron(p, 15), chestplate1.getItem()));
    inv.addOffer(new MerchantOffer(Currency.getIron(p, 20), chestplate2.getItem()));
    inv.addOffer(new MerchantOffer(Currency.getIron(p, 25), chestplate3.getItem()));

    inv.setCustomer(p);
    inv.openTrading(p);
  }
}