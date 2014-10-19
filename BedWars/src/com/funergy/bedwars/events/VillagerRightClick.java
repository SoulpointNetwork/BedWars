/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.events;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.funergy.bedwars.gamemanager.SpectatorHandler;

/**
 * @author Funergy
 *
 */
public class VillagerRightClick implements Listener {
	
	@EventHandler
	public void onRightClickEntity(PlayerInteractEntityEvent e){
		if(e.getRightClicked().getType()== EntityType.VILLAGER){
			if(!SpectatorHandler.spectators.contains(e.getPlayer())){
			ShopCategories.showShop(e.getPlayer());
			
			}
			e.setCancelled(true);
		}
		
	}
}
