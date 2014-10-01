/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.timers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.funergy.bedwars.Bedwars;


/**
 * @author Funergy
 *
 */
public class LobbyTimer extends BukkitRunnable{
	private int i;
	
	public LobbyTimer(int start) {
		i = start;
		Bukkit.broadcastMessage(Bedwars.getGamePrefix()+"Game starting in 30 seconds!");
	}

	@Override
	public void run() {
		if(Bedwars.getGameState().equalsIgnoreCase("LOBBY")){
		if (i == 0) {
			if(Bedwars.getLobbyPCount() >=8){
				//start game
				this.cancel();
				return;
			}else{
				Bukkit.broadcastMessage(Bedwars.getGamePrefix()+"Not enough players online! 8 players needed to start");
				for(Player p : Bukkit.getOnlinePlayers()){
					p.setLevel(0);
				}
				this.cancel();
				return;
			}
		}
		if(i < 11){
			Bukkit.broadcastMessage(Bedwars.getGamePrefix() +"Game starting in "+i);
		}
		for(Player p : Bukkit.getOnlinePlayers()){
			p.setLevel(i);
		}
		
		i--;
	}
}

}
