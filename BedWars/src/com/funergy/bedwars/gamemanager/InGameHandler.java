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

import nl.soulpoint.api.mysql.SoulPointMySQL;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.funergy.bedwars.Bedwars;
import com.funergy.bedwars.events.BlockBreakevent;
import com.funergy.bedwars.events.PlaceBlockEvent;
import com.funergy.bedwars.gamemanager.itemdrop.Diamond;
import com.funergy.bedwars.gamemanager.itemdrop.Gold;
import com.funergy.bedwars.gamemanager.itemdrop.Quartz;
import com.funergy.bedwars.mysql.Signs;

/**
 * @author Funergy
 *
 */
public class InGameHandler {
	public static HashMap<Player,String> teams = new HashMap<Player,String>();
	public static ArrayList<Player> red = new ArrayList<Player>();
	public static ArrayList<Player> blue = new ArrayList<Player>();
	public static ArrayList<Player> green = new ArrayList<Player>();
	public static ArrayList<Player> yellow = new ArrayList<Player>();

	public static void loadGameSettings(){
		Bedwars.setGameState("lobby");{
		BedHandler.setupBed();
		PlaceBlockEvent.setup();
		BlockBreakevent.setup();
		}
	}
	
	public static String getTeam(Player p){
		if(teams.containsKey(p)){
		return teams.get(p);
		}else{
			return null;
		}
		}
	
	public static void addToTeam(Player p,String team){
		teams.put(p, team);
		if(team.equalsIgnoreCase("red"))red.add(p);
		if(team.equalsIgnoreCase("blue"))blue.add(p);
		if(team.equalsIgnoreCase("green"))green.add(p);
		if(team.equalsIgnoreCase("yellow"))yellow.add(p);
		
		
	}
	public static void removeFromTeam(Player p){
		teams.remove(p);
	}
	public static void startGame(){
		Bedwars.setGameState("ingame");
		if(Signs.isInList()){
		SoulPointMySQL connection = new SoulPointMySQL();
		connection.connect();
		Signs.setStateIngame();
		connection.disconnect();
		}
		Bukkit.broadcastMessage(Bedwars.getGamePrefix()+"Game started!");
		for(Player p : Bukkit.getOnlinePlayers()){
			p.getInventory().clear();
			if(!teams.containsKey(p)){
				Teams.randomTeam(p);
			}
		}
		//The world will change to map when Waiting lobby is done
		for(Player p:red){
			p.teleport(new Location(Bukkit.getWorld("world"),-225,25,-178));
		}
		for(Player p:blue){
			p.teleport(new Location(Bukkit.getWorld("world"),-277,25,-230));
		}
		for(Player p:green){
			p.teleport(new Location(Bukkit.getWorld("world"),-225,25,-282));
		}
		for(Player p:yellow){
			p.teleport(new Location(Bukkit.getWorld("world"),-173,25,-230));
		}
		new Quartz().runTaskTimer(Bedwars.getPlugin(Bedwars.class), 100, 30);
		new Gold().runTaskTimer(Bedwars.getPlugin(Bedwars.class), 100, 320);
		new Diamond().runTaskTimer(Bedwars.getPlugin(Bedwars.class),100, 400);
		//Start dropping stuff
		
	}
	

}
