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
import org.bukkit.event.player.PlayerJoinEvent;

import com.funergy.bedwars.Bedwars;
import com.funergy.bedwars.gamemanager.LobbyPlayerHandler;
import com.funergy.bedwars.timers.LobbyTimer;



/**
 * @author Funergy
 *
 */
public class JoinEvent implements Listener {
public static Bedwars main = Bedwars.instance;

	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent e){
		if(main.getGameState().equalsIgnoreCase("lobby")){
		  LobbyPlayerHandler.setLobbyPlayerCount(Bukkit.getOnlinePlayers().length);
		  LobbyPlayerHandler.giveItems(e.getPlayer());
		  LobbyPlayerHandler.teleportPlayer(e.getPlayer());
		  if(main.getLobbyPCount() >= 8){
			  LobbyTimer.start();
		  }
		  
		}else if(main.getGameState().equalsIgnoreCase("INGAME")){
			//add them to the spectator handler
			//teleport them,...
		
		}
	}
}
