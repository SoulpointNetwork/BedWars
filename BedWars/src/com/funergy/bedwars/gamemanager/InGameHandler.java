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
import java.util.HashMap;

import org.bukkit.entity.Player;

/**
 * @author Funergy
 *
 */
public class InGameHandler {
	public static HashMap<Player,String> teams = new HashMap<Player,String>();
	public static ArrayList<Player> players = new ArrayList<Player>();
	
	public static String getTeam(Player p){return teams.get(p);}
	
	public static boolean isPlaying(Player p){
		if(players.contains(p))return true;
		return false;
	}
	

}
