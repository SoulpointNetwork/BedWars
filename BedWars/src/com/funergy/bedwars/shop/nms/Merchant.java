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
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Merchant
{
  private NMSMerchant h;
  private String title = null;

  public Merchant() {
    this.h = new NMSMerchant();
    this.h.proxy = Proxy.newProxyInstance(Bukkit.class.getClassLoader(), new Class[] { ReflectionUtils.getClassByName(ReflectionUtils.getNMSPackageName() + ".IMerchant") }, this.h);
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<MerchantOffer> getOffers()
  {
    List offerList = new ArrayList();
    for (Iterator localIterator = ((List)this.h.getOffers(null)).iterator(); localIterator.hasNext(); ) { Object recipe = localIterator.next();
      if (recipe.getClass().isInstance(ReflectionUtils.NMSMerchantRecipe.getNMSClass()))
        offerList.add(new MerchantOffer(new ReflectionUtils.NMSMerchantRecipe(recipe)));
    }
    return offerList;
  }

  public Merchant addOffer(MerchantOffer offer) {
    this.h.a(offer.getHandle().getMerchantRecipe());
    return this;
  }

  public Merchant addOffers(MerchantOffer[] offers) {
    for (MerchantOffer o : offers) {
      addOffer(o);
    }
    return this;
  }

  public Merchant setOffers(List<MerchantOffer> offers) {
    this.h.clearRecipes();
    for (MerchantOffer o : offers)
      addOffer(o);
    return this;
  }

  public boolean hasCustomer()
  {
    return this.h.b() != null;
  }

  public Player getCustomer() {
    return this.h.b() == null ? null : this.h.getBukkitEntity();
  }

  public Merchant setCustomer(Player player) {
    this.h.a_(player == null ? null : ReflectionUtils.toEntityHuman(player));
    return this;
  }

  public void openTrading(Player player) {
    this.h.openTrading(ReflectionUtils.toEntityHuman(player), this.title);
  }

  protected NMSMerchant getHandle() {
    return this.h;
  }

  public Merchant clone()
  {
    return new Merchant().setOffers(getOffers()).setCustomer(getCustomer());
  }
}