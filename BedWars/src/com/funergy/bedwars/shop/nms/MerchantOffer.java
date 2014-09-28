/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.shop.nms;

/**
 * @author Funergy
 *
 */
import org.bukkit.inventory.ItemStack;

public class MerchantOffer
{
  private ItemStack[] items = new ItemStack[3];

  public MerchantOffer(ItemStack is1, ItemStack is2, ItemStack re) {
    this.items[0] = is1;
    this.items[1] = is2;
    this.items[2] = re;
  }

  public MerchantOffer(ItemStack is, ItemStack re) {
    this(is, null, re);
  }

  protected MerchantOffer(ReflectionUtils.NMSMerchantRecipe handle) {
    this.items[0] = ReflectionUtils.OBCCraftItemStack.asBukkitCopy(handle.getBuyItem1());
    this.items[1] = (handle.getBuyItem2() == null ? null : ReflectionUtils.OBCCraftItemStack.asBukkitCopy(handle.getBuyItem2()));
    this.items[2] = ReflectionUtils.OBCCraftItemStack.asBukkitCopy(handle.getBuyItem3());
  }

  protected ReflectionUtils.NMSMerchantRecipe getHandle()
  {
    if (this.items[1] == null) {
      return new ReflectionUtils.NMSMerchantRecipe(ReflectionUtils.OBCCraftItemStack.asNMSCopy(this.items[0]), ReflectionUtils.OBCCraftItemStack.asNMSCopy(this.items[2]));
    }
    return new ReflectionUtils.NMSMerchantRecipe(ReflectionUtils.OBCCraftItemStack.asNMSCopy(this.items[0]), ReflectionUtils.OBCCraftItemStack.asNMSCopy(this.items[1]), ReflectionUtils.OBCCraftItemStack.asNMSCopy(this.items[2]));
  }

  public ItemStack getFirstInput() {
    return this.items[0];
  }

  public ItemStack getSecondInput() {
    return this.items[1];
  }

  public ItemStack getOutput() {
    return this.items[2];
  }
}