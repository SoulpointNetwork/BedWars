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
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import com.funergy.bedwars.Bedwars;
import com.funergy.bedwars.gamemanager.InGameHandler;
import com.funergy.bedwars.gamemanager.SpectatorHandler;
import com.funergy.bedwars.gamemanager.Teams;

/**
 * @author Funergy
 *
 */
public class LeaveEvent implements Listener{
	@EventHandler
	public void onLeaveEvent(PlayerQuitEvent e){
		e.setQuitMessage(null);
		if(Bedwars.getGameState().equalsIgnoreCase("lobby")){
		    e.getPlayer().getInventory().setArmorContents(new ItemStack[4]);
			e.getPlayer().getInventory().clear();
				Bedwars.setLobbyCount(Bukkit.getOnlinePlayers().length-1);
			}
		
			if(Bedwars.getGameState().equalsIgnoreCase("ingame")){
			Teams.removePlayerFromTeam(e.getPlayer());
			if(InGameHandler.blue.size() == 0 && InGameHandler.green.size() == 0 && InGameHandler.yellow.size() == 0){
				InGameHandler.redWins();
			}
			if(InGameHandler.green.size() == 0 && InGameHandler.red.size() == 0 && InGameHandler.yellow.size()==  0){
				InGameHandler.blueWins();
			}
			if(InGameHandler.blue.size() == 0 && InGameHandler.yellow.size() == 0 && InGameHandler.red.size() == 0){
				InGameHandler.greenWins();
			}
			if(InGameHandler.green.size() == 0 && InGameHandler.red.size() == 0 && InGameHandler.blue.size() == 0){
				InGameHandler.yellowWins();
			}
			e.getPlayer().getInventory().setArmorContents(new ItemStack[4]);
			e.getPlayer().getInventory().clear();

			
		}
			Teams.removePlayerFromTeam(e.getPlayer());
			if(SpectatorHandler.spectators.contains(e.getPlayer())){
				SpectatorHandler.removeSpectator(e.getPlayer());
			}
		    e.getPlayer().getInventory().setArmorContents(new ItemStack[4]);
			e.getPlayer().getInventory().clear();
	}
	@EventHandler
	public void onKickEvent(PlayerKickEvent e){
		e.setLeaveMessage(null);
		if(Bedwars.getGameState().equalsIgnoreCase("lobby")){
		    e.getPlayer().getInventory().setArmorContents(new ItemStack[4]);
			e.getPlayer().getInventory().clear();
			Bedwars.setLobbyCount(Bukkit.getOnlinePlayers().length-1);
			
		}
			if(Bedwars.getGameState().equalsIgnoreCase("ingame")){
			Teams.removePlayerFromTeam(e.getPlayer());
			if(InGameHandler.blue.size() == 0 && InGameHandler.green.size() == 0 && InGameHandler.yellow.size() == 0){
				InGameHandler.redWins();
			}
			if(InGameHandler.green.size() == 0 && InGameHandler.red.size() == 0 && InGameHandler.yellow.size()==  0){
				InGameHandler.blueWins();
			}
			if(InGameHandler.blue.size() == 0 && InGameHandler.yellow.size() == 0 && InGameHandler.red.size() == 0){
				InGameHandler.greenWins();
			}
			if(InGameHandler.green.size() == 0 && InGameHandler.red.size() == 0 && InGameHandler.blue.size() == 0){
				InGameHandler.yellowWins();
			}
			e.getPlayer().getInventory().setArmorContents(new ItemStack[4]);
			e.getPlayer().getInventory().clear();

			
		}
			Teams.removePlayerFromTeam(e.getPlayer());
			
	}

}
