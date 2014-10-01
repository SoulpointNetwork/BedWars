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
import com.funergy.bedwars.gamemanager.InGameHandler;
import com.funergy.bedwars.gamemanager.LobbyPlayerHandler;
import com.funergy.bedwars.timers.LobbyTimer;



/**
 * @author Funergy
 *
 */
public class JoinEvent implements Listener {

	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent e){
		if(Bedwars.getGameState().equalsIgnoreCase("lobby")){
		  LobbyPlayerHandler.setLobbyPlayerCount(Bukkit.getOnlinePlayers().length);
		  LobbyPlayerHandler.giveItems(e.getPlayer());
		  LobbyPlayerHandler.teleportPlayer(e.getPlayer());
		  e.setJoinMessage(Bedwars.getGamePrefix()+ChatColor.GREEN+e.getPlayer().getName()+ChatColor.WHITE+" Has joined the game ("+Bedwars.getLobbyPCount()+"/16)");
		  if(Bedwars.getLobbyPCount() >= 8){
				int red = InGameHandler.red.size();
				int blue = InGameHandler.blue.size();
				int yellow = InGameHandler.yellow.size();
				int green = InGameHandler.green.size();
				if(red >= 2 && blue >= 2 && yellow>=2&&green>=2){
			  new LobbyTimer(30).runTaskTimer(Bedwars.getPlugin(Bedwars.class), 0, 1000);
				}
		  }
		  
		}else if(Bedwars.getGameState().equalsIgnoreCase("INGAME")){
			//add them to the spectator handler
			//teleport them,...
		
		}
	}
}
