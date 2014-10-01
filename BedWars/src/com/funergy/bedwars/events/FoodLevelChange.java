/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import com.funergy.bedwars.Bedwars;

/**
 * @author Funergy
 *
 */
public class FoodLevelChange implements Listener{
	@EventHandler
	public void onFoodLevelChangeEvent(FoodLevelChangeEvent e){
	if(e.getEntity() instanceof Player){
		if(Bedwars.getGameState().equalsIgnoreCase("lobby")){
			e.setCancelled(true);
		}
	}
	}

}
