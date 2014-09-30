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

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.funergy.bedwars.Bedwars;

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
		System.out.println("[BedWars] Setting Gamestate to lobby");
		}
	}
	public static String getTeam(Player p){return teams.get(p);}
	
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
		//Teleport Players to map
		for(Player p : Bukkit.getOnlinePlayers()){
			if(!teams.containsKey(p)){
				Teams.randomTeam(p);
				p.sendMessage(Bedwars.getGamePrefix()+"You are in team "+teams.get(p));
			}
		}
		//Start dropping stuff
		
	}

}
