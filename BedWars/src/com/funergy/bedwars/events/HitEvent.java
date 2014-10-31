/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.events;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import com.funergy.bedwars.Bedwars;
import com.funergy.bedwars.gamemanager.AntiSpawnKill;
import com.funergy.bedwars.gamemanager.InGameHandler;
import com.funergy.bedwars.gamemanager.SpectatorHandler;

/**
 * @author Funergy
 *
 */
public class HitEvent implements Listener{
	
	@EventHandler
	public void onHitEvent(final EntityDamageByEntityEvent e){
		if(Bedwars.getGameState().equalsIgnoreCase("lobby")){
			e.setCancelled(true);
		}
		if(Bedwars.getGameState().equalsIgnoreCase("ingame")){
			if(e.getEntity() instanceof Villager){
				e.setCancelled(true);
			}
			if(e.getEntity() instanceof Player && e.getDamager() instanceof Arrow){
				Arrow r = (Arrow) e.getDamager();
				Player d = (Player) r.getShooter();
				Player p = (Player) e.getEntity();
				String ps = InGameHandler.getTeam(p);
				String ds = InGameHandler.getTeam(d);
				if(ps.equalsIgnoreCase(ds)){
					e.setCancelled(true);
					return;
				}
				
			}
			
			if(e.getEntity() instanceof Player&&e.getDamager() instanceof Player){
			Player p = (Player) e.getEntity();
			Player d = (Player) e.getDamager();
			String ps = InGameHandler.getTeam(p);
			String ds = InGameHandler.getTeam(d);
			if(ps.equalsIgnoreCase(ds)){
				e.setCancelled(true);
				return;
			}
			if(AntiSpawnKill.isInList(p)){
				e.setCancelled(true);
				d.sendMessage(Bedwars.getGamePrefix()+"That player has spawn protection");
			}
			if(AntiSpawnKill.isInList(d)){
				e.setCancelled(true);
				d.sendMessage(Bedwars.getGamePrefix()+"You can't hit players with spawn protection!");
			}
			if(SpectatorHandler.spectators.contains(d)){
				e.setCancelled(true);
			}
			
		}
		}
		if(Bedwars.getGameState().equalsIgnoreCase("end")){
			e.setCancelled(true);
		}
	}
	
}
