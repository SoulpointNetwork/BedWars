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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("unused")
public class ReflectionUtils
{
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static Object toEntityHuman(Player player)
  {
    try
    {
      Class c = getClassByName(getOBCPackageName() + 
        ".entity.CraftPlayer");
      Method m = c.getDeclaredMethod("getHandle", new Class[0]);
      m.setAccessible(true);
      return m.invoke(player, new Object[0]);
    } catch (Exception e) {
      e.printStackTrace();
    }return null;
  }

  @SuppressWarnings("rawtypes")
public static Class getClassByName(String name)
  {
    try
    {
      return Class.forName(name);
    } catch (Exception e) {
      e.printStackTrace();
    }return null;
  }

  public static Object getField(@SuppressWarnings("rawtypes") Class c, Object obj, String key)
    throws Exception
  {
    Field field = c.getDeclaredField(key);
    field.setAccessible(true);
    return field.get(obj);
  }

  public static void replaceField(@SuppressWarnings("rawtypes") Class c, Object obj, String key, Object value)
    throws Exception
  {
    Field field = c.getDeclaredField(key);
    field.setAccessible(true);
    field.set(obj, value);
  }

  public static String getNMSPackageName()
  {
    return "net.minecraft.server." + 
      org.bukkit.Bukkit.getServer().getClass().getPackage().getName()
      .replace(".", ",").split(",")[3];
  }

  public static String getOBCPackageName()
  {
    return "org.bukkit.craftbukkit." + 
      org.bukkit.Bukkit.getServer().getClass().getPackage().getName()
      .replace(".", ",").split(",")[3];
  }

  public static class NMSMerchantRecipe
  {
    private Object merchantRecipe;

    public NMSMerchantRecipe(Object merchantRecipe)
    {
      this.merchantRecipe = merchantRecipe;
    }

    public NMSMerchantRecipe(Object item1, Object item3) {
      this(item1, null, item3);
    }

    @SuppressWarnings("unchecked")
	public NMSMerchantRecipe(Object item1, Object item2, Object item3) {
      try {
        @SuppressWarnings("rawtypes")
		Class isClass = ReflectionUtils.getClassByName(
          ReflectionUtils.getNMSPackageName() + ".ItemStack");
        this.merchantRecipe = getNMSClass().getDeclaredConstructor(new Class[] { 
          isClass, isClass, isClass }).newInstance(new Object[] { 
          item1, item2, 
          item3 });
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    @SuppressWarnings("rawtypes")
	public static Class getNMSClass() {
      return ReflectionUtils.getClassByName(
        ReflectionUtils.getNMSPackageName() + ".MerchantRecipe");
    }

    @SuppressWarnings("unchecked")
	public Object getBuyItem1() {
      try {
        Method m = getNMSClass().getDeclaredMethod("getBuyItem1", new Class[0]);
        m.setAccessible(true);
        return m.invoke(this.merchantRecipe, new Object[0]);
      } catch (Exception e) {
        e.printStackTrace();
      }return null;
    }

    @SuppressWarnings("unchecked")
	public Object getBuyItem2()
    {
      try {
        Method m = getNMSClass().getDeclaredMethod("getBuyItem2", new Class[0]);
        m.setAccessible(true);
        return m.invoke(this.merchantRecipe, new Object[0]);
      } catch (Exception e) {
        e.printStackTrace();
      }return null;
    }

    @SuppressWarnings("unchecked")
	public Object getBuyItem3()
    {
      try {
        Method m = getNMSClass().getDeclaredMethod("getBuyItem3", new Class[0]);
        m.setAccessible(true);
        return m.invoke(this.merchantRecipe, new Object[0]);
      } catch (Exception e) {
        e.printStackTrace();
      }return null;
    }

    public Object getMerchantRecipe()
    {
      return this.merchantRecipe;
    }
  }

  public static class NMSMerchantRecipeList
  {
    private Object handle;

    @SuppressWarnings("rawtypes")
	public static Class getNMSClass()
    {
      return ReflectionUtils.getClassByName(
        ReflectionUtils.getNMSPackageName() + ".MerchantRecipeList");
    }

    public NMSMerchantRecipeList() {
      try {
        this.handle = getNMSClass().newInstance();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    public NMSMerchantRecipeList(Object handle) {
      this.handle = handle;
    }

    public Object getHandle() {
      return this.handle;
    }

    @SuppressWarnings("unchecked")
	public void clear() {
      try {
        Method m = getNMSClass().getDeclaredMethod("clear", new Class[0]);
        m.setAccessible(true);
        m.invoke(this.handle, new Object[0]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    public void add(ReflectionUtils.NMSMerchantRecipe recipe) {
      try {
        Method m = ArrayList.class.getDeclaredMethod("add", new Class[] { 
          Object.class });

        m.setAccessible(true);
        m.invoke(this.handle, new Object[] { recipe.getMerchantRecipe() });
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ReflectionUtils.NMSMerchantRecipe> getRecipes() {
      List recipeList = new ArrayList();
      for (Iterator localIterator = ((List)this.handle).iterator(); localIterator.hasNext(); ) { Object obj = localIterator.next();
        recipeList.add(new ReflectionUtils.NMSMerchantRecipe(obj));
      }
      return recipeList;
    }
  }

  public static class OBCCraftItemStack
  {
    @SuppressWarnings("rawtypes")
	public static Class getOBCClass()
    {
      return ReflectionUtils.getClassByName(
        ReflectionUtils.getOBCPackageName() + ".inventory.CraftItemStack");
    }

    @SuppressWarnings("unchecked")
	public static ItemStack asBukkitCopy(Object nmsItemStack) {
      try {
        Method m = getOBCClass().getDeclaredMethod(
          "asBukkitCopy", new Class[] { 
          ReflectionUtils.getClassByName(
          ReflectionUtils.getNMSPackageName() + ".ItemStack") });
        m.setAccessible(true);
        return (ItemStack)m.invoke(null, new Object[] { nmsItemStack });
      } catch (Exception e) {
        e.printStackTrace();
      }return null;
    }

    @SuppressWarnings("unchecked")
	public static Object asNMSCopy(ItemStack stack)
    {
      try {
        Method m = getOBCClass().getDeclaredMethod("asNMSCopy", new Class[] { 
          ItemStack.class });
        m.setAccessible(true);
        return m.invoke(null, new Object[] { stack });
      } catch (Exception e) {
        e.printStackTrace();
      }return null;
    }
  }
}