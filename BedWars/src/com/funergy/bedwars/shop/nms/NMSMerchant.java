/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.shop.nms;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.bukkit.entity.Player;
/**
 * @author Funergy
 *
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.bukkit.entity.Player;

public class NMSMerchant
  implements InvocationHandler
{
  private ReflectionUtils.NMSMerchantRecipeList o = new ReflectionUtils.NMSMerchantRecipeList();
  private transient Object c;
  public Object proxy;

  public Object invoke(Object proxy, Method m, Object[] args)
  {
    try
    {
      if ((m == null) || (m.getName() == null)) return null;
      Class entityHuman = ReflectionUtils.getClassByName(ReflectionUtils.getNMSPackageName() + ".EntityHuman");
      if ((m.getName().equals("a_")) && (args.length == 1) && (args[0] != null) && (args[0].getClass().isInstance(entityHuman))) {
        a_(args[0]); } else {
        if ((m.getName().equals("b")) || (m.getName().equals("m_")))
          return b();
        if ((m.getName().equals("getOffers")) && (args.length == 1))
          return getOffers(args[0]);
        if (m.getName().equals("a"))
          a(args[0]); 
      }
    } catch (Exception e) { e.printStackTrace(); }

    return null;
  }

  public void a_(Object player) {
    this.c = player;
  }

  public Object b() {
    return this.c;
  }

  public Object getOffers(Object player) {
    return this.o.getHandle();
  }

  public void a(Object recipe) {
    this.o.add(new ReflectionUtils.NMSMerchantRecipe(recipe));
  }

  public Player getBukkitEntity()
  {
    try
    {
      Class c = ReflectionUtils.getClassByName(ReflectionUtils.getNMSPackageName() + ".EntityHuman");
      Method m = c.getDeclaredMethod("getBukkitEntity", new Class[0]);
      m.setAccessible(true);
      return (Player)m.invoke(this.c, new Object[0]);
    } catch (Exception e) {
      e.printStackTrace();
    }return null;
  }

  public void clearRecipes()
  {
    this.o.clear();
  }

  public void setRecipes(ReflectionUtils.NMSMerchantRecipeList recipes) {
    this.o = recipes;
  }

  public void openTrading(Object player, String title)
  {
    this.c = player;
    try
    {
      Class classs = ReflectionUtils.getClassByName(ReflectionUtils.getNMSPackageName() + ".EntityPlayer");
      Method m = classs.getDeclaredMethod("openTrade", new Class[] { 
        ReflectionUtils.getClassByName(ReflectionUtils.getNMSPackageName() + ".IMerchant"), 
        String.class });
      m.setAccessible(true);
      m.invoke(player, new Object[] { this.proxy, title });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}