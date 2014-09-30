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
public class LobbyTimer {
public static Bedwars main = Bedwars.instance;
	
	public static void start(){
		Bukkit.broadcastMessage(main.getGamePrefix()+"Lobby timer starting.");
		new BukkitRunnable(){
			int i = 40;
			@Override
			public void run() {
				if(main.getGameState().equalsIgnoreCase("LOBBY")){
				if(i == 1){
					if(main.getLobbyPCount() >=8){
						//start game
						this.cancel();
						return;
					}else{
						Bukkit.broadcastMessage(main.getGamePrefix()+"Not enough players online restarting timer!");
						i = 30;
					}
				}
				for(Player p : Bukkit.getOnlinePlayers()){
					p.setLevel(i);
				}
				i-=1;
			}else{
				this.cancel();
				return;
			}
			}
			
		}.runTaskTimer(main, 0, 20);
	}
}
