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
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.funergy.bedwars.Bedwars;
import com.funergy.bedwars.gamemanager.LobbyPlayerHandler;
import com.funergy.bedwars.gamemanager.ScoreBoardManager;
import com.funergy.bedwars.gamemanager.SpectatorHandler;
import com.funergy.bedwars.timers.LobbyTimer;



/**
 * @author Funergy
 *
 */
public class JoinEvent implements Listener {

	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent e){
		  ScoreBoardManager.openScoreboard(e.getPlayer());
		if(Bedwars.getGameState().equalsIgnoreCase("lobby")){
		  LobbyPlayerHandler.setLobbyPlayerCount(Bukkit.getOnlinePlayers().length);
		  LobbyPlayerHandler.giveItems(e.getPlayer());
		  LobbyPlayerHandler.teleportPlayer(e.getPlayer());
		  e.getPlayer().setFoodLevel(20);
		  e.getPlayer().setHealth(20);
		  e.setJoinMessage(Bedwars.getGamePrefix()+ChatColor.GREEN+e.getPlayer().getName()+ChatColor.WHITE+" Has joined the game ("+Bedwars.getLobbyPCount()+"/16)");
		  
		  if(Bedwars.getLobbyPCount() >= 4){
			  if(!LobbyPlayerHandler.counting){
			  new LobbyTimer(30).runTaskTimer(Bedwars.getPlugin(Bedwars.class), 0, 20);
			  LobbyPlayerHandler.counting = true;
			  }
		}
		}
		if(Bedwars.getGameState().equalsIgnoreCase("ingame")||Bedwars.getGameState().equalsIgnoreCase("end")){
			e.setJoinMessage(null);
			SpectatorHandler.addSpectator(e.getPlayer());
			  e.getPlayer().setFoodLevel(20);
			  e.getPlayer().setHealth(20);
			
		}
		
	}
}
