/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.gamemanager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.funergy.bedwars.Bedwars;

/**
 * @author Funergy
 *
 */
public class Teams {
	
	public static void randomTeam(Player p){
		if(InGameHandler.red.size() !=4){
			InGameHandler.addToTeam(p, "red");
		}
		if(InGameHandler.green.size() !=4){
			InGameHandler.addToTeam(p, "green");
		}
		if(InGameHandler.yellow.size() !=4){
			InGameHandler.addToTeam(p, "yellow");
		}
		if(InGameHandler.blue.size() !=4){
			InGameHandler.addToTeam(p, "blue");
		}
	}
	public static void addToTeam(Player p,String team){
		int red = InGameHandler.red.size();
		int blue = InGameHandler.blue.size();
		int yellow = InGameHandler.yellow.size();
		int green = InGameHandler.green.size();
		if(team.equalsIgnoreCase("red")){
			if(red < blue && red < yellow && red < green){
				InGameHandler.addToTeam(p, team);
			}else{
				p.sendMessage(Bedwars.instance.getGamePrefix()+ChatColor.RED+"That team is not joinable!");
				p.sendMessage(Bedwars.instance.getGamePrefix()+ChatColor.RED+"The other teams needs to be filled too");
			}
		}
		if(team.equalsIgnoreCase("blue")){
			if(blue < red && blue < yellow && blue < green){
				InGameHandler.addToTeam(p, team);
			}else{
				p.sendMessage(Bedwars.instance.getGamePrefix()+ChatColor.RED+"That team is not joinable!");
				p.sendMessage(Bedwars.instance.getGamePrefix()+ChatColor.RED+"The other teams needs to be filled too");
			}
		}
		if(team.equalsIgnoreCase("green")){
			if(green < blue && green < yellow && green < red){
				InGameHandler.addToTeam(p, team);
			}else{
				p.sendMessage(Bedwars.instance.getGamePrefix()+ChatColor.RED+"That team is not joinable!");
				p.sendMessage(Bedwars.instance.getGamePrefix()+ChatColor.RED+"The other teams needs to be filled too");
			}
		}
		if(team.equalsIgnoreCase("yellow")){
			if(yellow < blue && yellow < red && yellow< green){
				InGameHandler.addToTeam(p, team);
			}else{
				p.sendMessage(Bedwars.instance.getGamePrefix()+ChatColor.RED+"That team is not joinable!");
				p.sendMessage(Bedwars.instance.getGamePrefix()+ChatColor.RED+"The other teams need to be filled too");
			}
		}
	}

}
