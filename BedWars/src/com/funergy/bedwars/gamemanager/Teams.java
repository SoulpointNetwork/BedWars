/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.gamemanager;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.funergy.bedwars.Bedwars;

/**
 * @author Funergy
 *
 */
public class Teams {
	
	public static void setRandomTeam(Player p){
		int red =InGameHandler.red.size();
		int blue =InGameHandler.blue.size();
		int yellow =InGameHandler.yellow.size();
		int green =InGameHandler.green.size();
		if(getHighestTeam() == null){
			String team = getRandomTeam();
			InGameHandler.addToTeam(p,team);
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
				ScoreBoardManager.updateSB();

			return;
		}
		if(red < getHighestTeam()){
			InGameHandler.addToTeam(p, "red");
			p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.RED+"RED");
			ScoreBoardManager.updateSB();
			return;
		}
		if(green < getHighestTeam()){
			InGameHandler.addToTeam(p, "green");
			p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.GREEN+"GREEN");
			ScoreBoardManager.updateSB();
			return;
		}
		if(yellow < getHighestTeam()){
			InGameHandler.addToTeam(p, "yellow");
			p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.YELLOW+"YELLOW");
			ScoreBoardManager.updateSB();
			return;
		}
		if(blue < getHighestTeam()){
			InGameHandler.addToTeam(p, "blue");
			p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.AQUA+"BLUE");
			ScoreBoardManager.updateSB();
			return;
		}
	}
	private static String getRandomTeam(){
		int i = new Random().nextInt(3);
		if(i == 0){
			return "green";
		}
		if(i == 1){
			return "yellow";
		}
		if(i == 2){
			return "blue";
		}
		if(i == 3){
			return "red";
		}
		return null;
		
	}
	public static Integer getHighestTeam(){
		int red =InGameHandler.red.size();
		int blue =InGameHandler.blue.size();
		int yellow =InGameHandler.yellow.size();
		int green =InGameHandler.green.size();
		if(red > blue && red > green && red > yellow){
			return red;
		}
		if(green > red && green > yellow && green > blue){
			return green;
		}
		if(yellow > red && yellow > blue && yellow > green){
			return yellow;
		}
		if(blue > red && blue > yellow && blue > green){
			return green;
		}
		return null;
		
	}
	public static void addToTeam(Player p,String team){
		int red = InGameHandler.red.size();
		int blue = InGameHandler.blue.size();
		int yellow = InGameHandler.yellow.size();
		int green = InGameHandler.green.size();
		if(InGameHandler.teams.size() != 0){
		if(team.equalsIgnoreCase("red")){
			if(red <= blue && red <= yellow && red <= green){
				if(InGameHandler.getTeam(p)!=null){
					Teams.removePlayerFromTeam(p);
				}
				InGameHandler.addToTeam(p, team);
				p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.RED+"RED");
			}else{
				p.sendMessage(Bedwars.getGamePrefix()+ChatColor.RED+"That team is not joinable!");
			}
		}
		if(team.equalsIgnoreCase("blue")){
			if(blue <= red && blue <= yellow && blue <= green){
				if(InGameHandler.getTeam(p)!=null){
					Teams.removePlayerFromTeam(p);
				}
				InGameHandler.addToTeam(p, team);
				p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.AQUA+"BLUE");
			}else{
				p.sendMessage(Bedwars.getGamePrefix()+ChatColor.RED+"That team is not joinable!");
			}
		}
		if(team.equalsIgnoreCase("green")){
			if(green <= blue && green <= yellow && green <= red){
				if(InGameHandler.getTeam(p)!=null){
					Teams.removePlayerFromTeam(p);
				}
				InGameHandler.addToTeam(p, team);
				p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.GREEN+"GREEN");

			}else{
				p.sendMessage(Bedwars.getGamePrefix()+ChatColor.RED+"That team is not joinable!");
			}
		}
		if(team.equalsIgnoreCase("yellow")){
			if(yellow <= blue && yellow <= red && yellow <= green){
				if(InGameHandler.getTeam(p)!=null){
					Teams.removePlayerFromTeam(p);
				}
				InGameHandler.addToTeam(p, team);
				p.sendMessage(Bedwars.getGamePrefix()+"You've joined team "+ ChatColor.YELLOW+"YELLOW");

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
			ScoreBoardManager.updateSB();

		
	}

}
