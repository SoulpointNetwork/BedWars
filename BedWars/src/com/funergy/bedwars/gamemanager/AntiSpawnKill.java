/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.gamemanager;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.funergy.bedwars.Bedwars;
import com.funergy.bedwars.timers.SpawnKillTimer;

/**
 * @author Funergy
 *
 */
public class AntiSpawnKill {
	public static ArrayList<Player> list = new ArrayList<Player>();
	public static void addPlayer(Player p){
		list.add(p);
		p.sendMessage(Bedwars.getGamePrefix()+"Your protection will be removed in "+ChatColor.RED+"5 seconds");
		new SpawnKillTimer(p).runTaskTimer(Bedwars.getPlugin(Bedwars.class), 0, 20);
	}
	public static void removePlayer(Player p){
		list.remove(p);
		p.sendMessage(Bedwars.getGamePrefix()+"Your spawn protection has been removed!");
	}
	public static boolean isInList(Player p){
		if(list.contains(p))return true;
		return false;
	}
}
