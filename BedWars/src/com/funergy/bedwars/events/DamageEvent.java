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
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import com.funergy.bedwars.Bedwars;
import com.funergy.bedwars.gamemanager.AntiSpawnKill;
import com.funergy.bedwars.gamemanager.SpectatorHandler;

/**
 * @author Funergy
 *
 */
public class DamageEvent implements Listener{
	
	@EventHandler
	public void damageEvent(EntityDamageEvent e){
		if(e.getEntity() instanceof Player){
		Player p = (Player) e.getEntity();
		if(Bedwars.getGameState().equalsIgnoreCase("lobby")){
			e.setCancelled(true);
		}
		if(Bedwars.getGameState().equalsIgnoreCase("ingame")){
			if(e.getEntity() instanceof Villager){
				e.setCancelled(true);
			}
			
		
		}
		if(SpectatorHandler.spectators.contains(p)){
			e.setCancelled(true);
		}
		if(Bedwars.getGameState().equalsIgnoreCase("end")){
			e.setCancelled(true);
		}
		}
	}


}
