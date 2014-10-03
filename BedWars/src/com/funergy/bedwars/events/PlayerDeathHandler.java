/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.funergy.bedwars.Bedwars;
import com.funergy.bedwars.gamemanager.BedHandler;
import com.funergy.bedwars.gamemanager.InGameHandler;
import com.funergy.bedwars.gamemanager.ScoreBoardManager;
import com.funergy.bedwars.gamemanager.Teams;

/**
 * @author Funergy
 *
 */
public class PlayerDeathHandler implements Listener{
	@EventHandler
	public void onRespawnEvent(PlayerRespawnEvent e){
		if(InGameHandler.getTeam(e.getPlayer())!=null){
			Bukkit.broadcastMessage("respawned");
			String s = InGameHandler.getTeam(e.getPlayer());
			if(s.equalsIgnoreCase("red")){
				e.setRespawnLocation(new Location(Bukkit.getWorld("world"),-225,25,-178));
			}
			if(s.equalsIgnoreCase("blue")){
				e.setRespawnLocation(new Location(Bukkit.getWorld("world"),-277,25,-230));
			}
			if(s.equalsIgnoreCase("green")){
				e.setRespawnLocation(new Location(Bukkit.getWorld("world"),-225,25,-282));
			}
			if(s.equalsIgnoreCase("yellow")){
				e.setRespawnLocation(new Location(Bukkit.getWorld("world"),-173,25,-230));
			}
			e.getPlayer().sendMessage(Bedwars.getGamePrefix()+"You've respawned because your bed hasn't been broken.");
		
		}else{
        e.getPlayer().setAllowFlight(true);
        e.getPlayer().setFlying(true);
		}
	}
	@EventHandler
	public void onDeathEvent(PlayerDeathEvent e){
		if(e.getEntity() instanceof Player){
			Player p = e.getEntity();
			if(!BedHandler.hasBed(InGameHandler.getTeam(p))){
			Teams.removePlayerFromTeam(p);

		}
	}
	}

}
