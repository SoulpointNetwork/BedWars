/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.gamemanager;

import java.util.HashMap;

import org.bukkit.Location;

/**
 * @author Funergy
 *
 */
public class ChestHandler {
	public static HashMap<Location,String> chests = new HashMap<Location,String>();
	public static String getTeamFromChest(Location loc){
		if(chests.containsKey(loc)){
			return chests.get(loc);
		}
		return null;
	}
	public static void addChest(Location loc,String team){
		chests.put(loc, team);
	}
	public static void removeChest(Location loc){
		chests.remove(loc);
	}
	public static boolean isChest(Location loc){
		if(chests.containsKey(loc)){
			return true;
		}
		return false;
	}
	

}
