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

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.material.Bed;

import com.funergy.bedwars.Bedwars;
import com.funergy.bedwars.gamemanager.BedHandler;
import com.funergy.bedwars.gamemanager.ChestHandler;
import com.funergy.bedwars.gamemanager.InGameHandler;
import com.funergy.bedwars.gamemanager.SpectatorHandler;

/**
 * @author Funergy
 *
 */
public class BlockBreakevent implements Listener {
	public static ArrayList<Material> materials = new ArrayList<Material>();
	
    public static void setup(){
	materials.add(Material.SANDSTONE);
	materials.add(Material.ENDER_STONE);
	materials.add(Material.GLOWSTONE);
	materials.add(Material.IRON_BLOCK);
	materials.add(Material.FIRE);
	materials.add(Material.LADDER);
	materials.add(Material.WEB);
	materials.add(Material.TNT);
	materials.add(Material.CHEST);
	materials.add(Material.ENDER_CHEST);
	materials.add(Material.BED_BLOCK);
	materials.add(Material.BED);
	materials.add(Material.CAKE_BLOCK);
    }
    
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onBlockBreak(BlockBreakEvent e){
		if(Bedwars.getGameState().equalsIgnoreCase("lobby")){
			e.setCancelled(true);
		}
		if(Bedwars.getGameState().equalsIgnoreCase("ingame")||Bedwars.getGameState().equalsIgnoreCase("end")){
			if(e.getBlock().getType() == Material.BED_BLOCK){
				Location b = e.getBlock().getLocation();
				if(BedHandler.isTeamBed(InGameHandler.getTeam(e.getPlayer()).toLowerCase(), b)){
					e.setCancelled(true);
					return;
				}				
				Bukkit.broadcastMessage(Bedwars.getGamePrefix()+"The bed from team "+BedHandler.getTeamFromBed(b)+" has been broken!");
				BedHandler.removeBed(BedHandler.getTeamFromBed(b));
				e.getBlock().getDrops().clear();
				
			}
			if(e.getBlock().getType() == Material.CHEST){
				if(ChestHandler.isChest(e.getBlock().getLocation())){
				ChestHandler.removeChest(e.getBlock().getLocation());
				e.getBlock().getDrops().clear();
				
				}
			}
			if(!materials.contains(e.getBlock().getType())){
				e.setCancelled(true);
			}
			
		}
		if(SpectatorHandler.spectators.contains(e.getPlayer())){
			e.setCancelled(true);
		}
	}

}
