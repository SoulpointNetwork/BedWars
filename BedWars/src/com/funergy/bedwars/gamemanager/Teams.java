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
			p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.RED+"RED");
			ScoreBoardManager.updateSB();
			return;
		}
		if(InGameHandler.green.size() !=4){
			InGameHandler.addToTeam(p, "green");
			p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.GREEN+"GREEN");
			ScoreBoardManager.updateSB();
			return;
		}
		if(InGameHandler.yellow.size() !=4){
			InGameHandler.addToTeam(p, "yellow");
			p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.YELLOW+"YELLOW");
			ScoreBoardManager.updateSB();
			return;
		}
		if(InGameHandler.blue.size() !=4){
			InGameHandler.addToTeam(p, "blue");
			p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.AQUA+"BLUE");
			ScoreBoardManager.updateSB();
			return;
		}
	}
	public static void addToTeam(Player p,String team){
		int red = InGameHandler.red.size();
		int blue = InGameHandler.blue.size();
		int yellow = InGameHandler.yellow.size();
		int green = InGameHandler.green.size();
		if(InGameHandler.teams.size() != 0){
		if(team.equalsIgnoreCase("red")){
			if(red <= blue && red <= yellow && red <= green){
				InGameHandler.addToTeam(p, team);
				p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.RED+"RED");
			}else{
				p.sendMessage(Bedwars.getGamePrefix()+ChatColor.RED+"That team is not joinable!");
			}
		}
		if(team.equalsIgnoreCase("blue")){
			if(blue <= red && blue <=yellow && blue <= green){
				InGameHandler.addToTeam(p, team);
				p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.AQUA+"BLUE");
			}else{
				p.sendMessage(Bedwars.getGamePrefix()+ChatColor.RED+"That team is not joinable!");
			}
		}
		if(team.equalsIgnoreCase("green")){
			if(green <= blue && green <= yellow && green <= red){
				InGameHandler.addToTeam(p, team);
				p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.GREEN+"GREEN");

			}else{
				p.sendMessage(Bedwars.getGamePrefix()+ChatColor.RED+"That team is not joinable!");
			}
		}
		if(team.equalsIgnoreCase("yellow")){
			if(yellow <= blue && yellow <= red && yellow<= green){
				InGameHandler.addToTeam(p, team);

			}else{
				p.sendMessage(Bedwars.getGamePrefix()+ChatColor.RED+"That team is not joinable!");
			}
		}
		}else{
			InGameHandler.addToTeam(p, team);
			if(team.equalsIgnoreCase("yellow")){
			p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.YELLOW+team.toUpperCase());
			}
			if(team.equalsIgnoreCase("green")){
				p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.GREEN+team.toUpperCase());
				}
			if(team.equalsIgnoreCase("blue")){
				p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.AQUA+team.toUpperCase());
				}
			if(team.equalsIgnoreCase("red")){
				p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.RED+team.toUpperCase());
				}
		}
		ScoreBoardManager.updateSB();

	}
	public static void removePlayerFromTeam(Player p){

			InGameHandler.red.remove(p);
			InGameHandler.teams.remove(p);

			InGameHandler.green.remove(p);
			InGameHandler.teams.remove(p);
		
			InGameHandler.blue.remove(p);
			InGameHandler.teams.remove(p);
		
			InGameHandler.yellow.remove(p);
			InGameHandler.teams.remove(p);

		
	}

}
