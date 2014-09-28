/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.shop.nms;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
/**
 * @author Funergy
 *
 */
public class Item
{
  private ItemStack i;
  private ItemMeta m;
  private List<String> l = new ArrayList();
  private byte dyecolor = 20;
  private byte potion = 0;
  LeatherArmorMeta lc;

  public Item(Material m, int amount)
  {
    this.i = new ItemStack(m, amount);
    this.m = this.i.getItemMeta();
    if (isLeather())
      this.lc = ((LeatherArmorMeta)this.i.getItemMeta());
  }

  public void setName(String name) {
    this.m.setDisplayName(name);
  }

  public Material getMaterial() {
    return this.i.getType();
  }

  public int getAmount() {
    return this.i.getAmount();
  }

  public void setLore(String[] lore) {
    for (String s : lore)
      this.l.add(s);
  }

  public void setMaterial(Material m) {
    this.i.setType(m);
  }

  public void setAmount(int amount) {
    this.i.setAmount(amount);
  }

  public void setColor(int colorid) {
    this.dyecolor = ((byte)colorid);
  }

  public void addEnchantment(Enchantment ench, int level) {
    this.m.addEnchant(ench, level, true);
  }

  private boolean isLeather() {
    if ((getMaterial() == Material.LEATHER_BOOTS) || 
      (getMaterial() == Material.LEATHER_CHESTPLATE) || 
      (getMaterial() == Material.LEATHER_HELMET) || 
      (getMaterial() == Material.LEATHER_LEGGINGS)) {
      return true;
    }
    return false;
  }

  public void setLeatherColor(Color c)
  {
    if (isLeather())
      this.lc.setColor(c);
  }

  public void setPotion(int id)
  {
    this.potion = ((byte)id);
  }

  public ItemStack getItem() {
    if (this.dyecolor < 20) {
      this.i = new ItemStack(this.i.getType(), this.i.getAmount(), this.dyecolor);
    }
    if (this.potion > 0) {
      this.i = new ItemStack(this.i.getType(), this.i.getAmount(), this.potion);
    }
    this.m.setLore(this.l);
    if (isLeather()) {
      this.lc.setDisplayName(this.m.getDisplayName());
      this.lc.setLore(this.l);
      this.i.setItemMeta(this.lc);
    } else {
      this.i.setItemMeta(this.m);
    }
    return this.i;
  }
}