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
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.funergy.bedwars.Bedwars;

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
    }
    
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		if(Bedwars.getGameState().equalsIgnoreCase("lobby")){
			e.setCancelled(true);
		}
		if(Bedwars.getGameState().equalsIgnoreCase("ingame")){
			if(!materials.contains(e.getBlock().getType())){
				e.setCancelled(true);
			}
		}
	}

}
