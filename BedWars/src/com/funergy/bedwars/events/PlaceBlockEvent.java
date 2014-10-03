/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.events;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.util.Vector;

import com.funergy.bedwars.Bedwars;
import com.funergy.bedwars.gamemanager.ChestHandler;
import com.funergy.bedwars.gamemanager.InGameHandler;

/**
 * @author Funergy
 *
 */
public class PlaceBlockEvent implements Listener {
	public static ArrayList<Material> materials = new ArrayList<Material>();
	public static void setup(){
		materials.add(Material.SANDSTONE);
		materials.add(Material.ENDER_STONE);
		materials.add(Material.GLOWSTONE);
		materials.add(Material.IRON_BLOCK);
		materials.add(Material.FIRE);
		materials.add(Material.CAKE_BLOCK);
		materials.add(Material.LADDER);
		materials.add(Material.WEB);
		materials.add(Material.TNT);
		materials.add(Material.CHEST);
		materials.add(Material.ENDER_CHEST);

	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlockPlaceEvent(BlockPlaceEvent e){
		if(Bedwars.getGameState().equalsIgnoreCase("lobby")){
			e.setCancelled(true);
			e.getPlayer().updateInventory();
		}
		if(Bedwars.getGameState().equalsIgnoreCase("ingame")){
			if(!materials.contains(e.getBlock().getType())){
				e.setCancelled(true);
			}
			if(e.getBlock().getType() == Material.TNT){
				e.getBlockPlaced().setType(Material.AIR);
				TNTPrimed tnt = e.getPlayer().getWorld().spawn(e.getBlockPlaced().getLocation(), TNTPrimed.class);
				tnt.setFuseTicks(60);
				tnt.setVelocity(new Vector(0, 0.3, 0));
			}
			if(e.getBlock().getType() == Material.ENDER_CHEST){
				e.getBlock().setType(Material.CHEST);
				ChestHandler.addChest(e.getBlock().getLocation(), InGameHandler.getTeam(e.getPlayer()));
			}
		}
	
	}

}
