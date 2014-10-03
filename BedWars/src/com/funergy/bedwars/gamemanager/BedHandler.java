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

import org.bukkit.Bukkit;
import org.bukkit.Location;

/**
 * @author Funergy
 *
 */
public class BedHandler {
	public static ArrayList<Location> red = new ArrayList<Location>();
	public static ArrayList<Location> green = new ArrayList<Location>();
	public static ArrayList<Location> yellow = new ArrayList<Location>();
	public static ArrayList<Location> blue = new ArrayList<Location>();


	public static void setupBed(){
		Location red1 = new Location(Bukkit.getWorld("world"),-225,16,-175);
		Location red2 = new Location(Bukkit.getWorld("world"),-225,16,-174);

		Location yellow1 = new Location(Bukkit.getWorld("world"),-170,16,-230);
		Location yellow2 = new Location(Bukkit.getWorld("world"),-169,16,-230);

		Location green1 = new Location(Bukkit.getWorld("world"),-225,16,-285);
		Location green2 = new Location(Bukkit.getWorld("world"),-225,16,-286);

		Location blue1 = new Location(Bukkit.getWorld("world"),-280,16,-230);
		Location blue2 = new Location(Bukkit.getWorld("world"),-281,16,-230);

		red.add(red1);
		red.add(red2);

		yellow.add(yellow1);
		yellow.add(yellow2);
		
		green.add(green1);
		green.add(green2);
		
		blue.add(blue1);
		blue.add(blue2);

		System.out.println("Added beds");
	}
	public static boolean isTeamBed(String team, Location loc){
		if(team.equalsIgnoreCase("red")){
			Location red1 = new Location(Bukkit.getWorld("world"),-225,16,-175);
			Location red2 = new Location(Bukkit.getWorld("world"),-225,16,-174);
			if(red1.getX()==loc.getX()&&red1.getY()==loc.getY()&&red1.getBlockZ()==loc.getZ()){
				return true;
			}
			if(red2.getX()==loc.getX()&&red2.getY()==loc.getY()&&red2.getBlockZ()==loc.getZ()){
				return true;
			}
			return false;
		}
		if(team.equalsIgnoreCase("yellow")){
			Location yellow1 = new Location(Bukkit.getWorld("world"),-170,16,-230);
			Location yellow2 = new Location(Bukkit.getWorld("world"),-169,16,-230);
			if(yellow1.getX()==loc.getX()&&yellow1.getY()==loc.getY()&&yellow1.getBlockZ()==loc.getZ()){
				return true;
			}
			if(yellow2.getX()==loc.getX()&&yellow2.getY()==loc.getY()&&yellow2.getBlockZ()==loc.getZ()){
				return true;
			}
			return false;
		}
		if(team.equalsIgnoreCase("green")){
			Location green1 = new Location(Bukkit.getWorld("world"),-225,16,-285);
			Location green2 = new Location(Bukkit.getWorld("world"),-225,16,-286);
			if(green1.getX()==loc.getX()&&green1.getY()==loc.getY()&&green1.getBlockZ()==loc.getZ()){
				return true;
			}
			if(green2.getX()==loc.getX()&&green2.getY()==loc.getY()&&green2.getBlockZ()==loc.getZ()){
				return true;
			}
			return false;
		}
		if(team.equalsIgnoreCase("blue")){
			Location blue1 = new Location(Bukkit.getWorld("world"),-280,16,-230);
			Location blue2 = new Location(Bukkit.getWorld("world"),-281,16,-230);
			if(blue1.getX()==loc.getX()&&blue1.getY()==loc.getY()&&blue1.getBlockZ()==loc.getZ()){
				return true;
			}
			if(blue2.getX()==loc.getX()&&blue2.getY()==loc.getY()&&blue2.getBlockZ()==loc.getZ()){
				return true;
			}
			return false;
		}
		return false;
	}
	public static String getTeamFromBed(Location loc){
		if(red.contains(loc)){
			return "red";
		}
		if(blue.contains(loc)){
			return "blue";
		}
		if(green.contains(loc)){
			return "green";
		}
		if(yellow.contains(loc)){
			return "yellow";
		}
		return null;
	}
	
	public static void removeBed(String team){
		if(team.equalsIgnoreCase("red")){
			red.clear();
		}
		if(team.equalsIgnoreCase("yellow")){
			yellow.clear();
		}
		if(team.equalsIgnoreCase("green")){
			green.clear();
		}
		if(team.equalsIgnoreCase("blue")){
			blue.clear();
		}
	}
	public static boolean hasBed(String team){
		if(team.equalsIgnoreCase("red")){
			if(red.size()==0){
				return false;
			}else{
				return true;
			}
		}
		if(team.equalsIgnoreCase("blue")){
			if(blue.size()==0){
				return false;
			}else{
				return true;
			}
		}
		if(team.equalsIgnoreCase("green")){
			if(green.size()==0){
				return false;
			}else{
				return true;
			}
		}
		if(team.equalsIgnoreCase("yellow")){
			if(yellow.size()==0){
				return false;
			}else{
				return true;
			}
		}
		return false;
	}


}
