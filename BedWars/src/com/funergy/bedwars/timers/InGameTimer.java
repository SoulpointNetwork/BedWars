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
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.funergy.bedwars.Bedwars;
import com.funergy.bedwars.gamemanager.InGameHandler;

/**
 * @author Funergy
 *
 */
public class InGameTimer extends BukkitRunnable{
      int i = 3600;
     	
	  public InGameTimer(){
				Bukkit.broadcastMessage(Bedwars.getGamePrefix() +"Game ending in 60 minutes");
	  }
	
       @Override
       public void run() {
    	   
   		if(Bedwars.getGameState().equalsIgnoreCase("INGAME")){
   			if (i == 0) {
   				InGameHandler.end();
   				this.cancel();
   				return;
   			}
   			if(i < 11){
   				Bukkit.broadcastMessage(Bedwars.getGamePrefix() +"Game ending in "+i);
   				for(Player p : Bukkit.getOnlinePlayers()){
   					p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1, 1);
   				}
   			}
   			if(i == 3000){
   				Bukkit.broadcastMessage(Bedwars.getGamePrefix() +"Game ending in 50 minutes");
   			}
   			if(i == 2400){
   				Bukkit.broadcastMessage(Bedwars.getGamePrefix() +"Game ending in 40 minutes");
   			}
   			if(i == 1800){
   				Bukkit.broadcastMessage(Bedwars.getGamePrefix() +"Game ending in 30 minutes");
   			}
   			if(i == 1200){
   				Bukkit.broadcastMessage(Bedwars.getGamePrefix() +"Game ending in 20 minutes");
   			}
   			if(i == 600){
   				Bukkit.broadcastMessage(Bedwars.getGamePrefix() +"Game ending in 10 minutes");
   			}
   			if(i == 300){
   				Bukkit.broadcastMessage(Bedwars.getGamePrefix() +"Game ending in 5 minutes");
   			}
   			if(i == 60){
   				Bukkit.broadcastMessage(Bedwars.getGamePrefix() +"Game ending in 1 minute");
   			}

   			
   			
   			i--;
	   
       }
       }
}
