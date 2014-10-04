/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.timers;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.funergy.bedwars.gamemanager.AntiSpawnKill;

/**
 * @author Funergy
 *
 */
public class SpawnKillTimer extends BukkitRunnable{
	int i = 5;
	public Player p;
	
	public SpawnKillTimer(Player pl){
		this.p = pl;
	}
	
	@Override
	public void run() {
		if(i == 0){
			p.setLevel(0);
			AntiSpawnKill.removePlayer(p);
			this.cancel();
			return;
		}
		
		p.setLevel(i);
		i--;
		
	}

}
