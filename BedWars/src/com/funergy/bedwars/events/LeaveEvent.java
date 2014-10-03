/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import com.funergy.bedwars.Bedwars;
import com.funergy.bedwars.gamemanager.InGameHandler;
import com.funergy.bedwars.gamemanager.Teams;

/**
 * @author Funergy
 *
 */
public class LeaveEvent implements Listener{
	@EventHandler
	public void onLeaveEvent(PlayerQuitEvent e){
		if(Bedwars.getGameState().equalsIgnoreCase("lobby")){
		    e.getPlayer().getInventory().setArmorContents(new ItemStack[4]);
			e.getPlayer().getInventory().clear();
			if(InGameHandler.getTeam(e.getPlayer())!=null){
			Teams.removePlayerFromTeam(e.getPlayer());
			}
		}
	}
	@EventHandler
	public void onKickEvent(PlayerKickEvent e){
		if(Bedwars.getGameState().equalsIgnoreCase("lobby")){
		    e.getPlayer().getInventory().setArmorContents(new ItemStack[4]);
			e.getPlayer().getInventory().clear();
			if(InGameHandler.getTeam(e.getPlayer())!=null){
			Teams.removePlayerFromTeam(e.getPlayer());
			}
		}
	}

}
