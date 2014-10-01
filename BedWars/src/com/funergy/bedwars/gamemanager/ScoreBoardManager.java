/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.gamemanager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

/**
 * @author Funergy
 *
 */
public class ScoreBoardManager {
	
	@SuppressWarnings("deprecation")
	public static void openScoreboard(Player p){
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		 
		Objective objective = board.registerNewObjective("teams", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(ChatColor.GOLD+"Teams");
	    objective.getScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red")).setScore(InGameHandler.red.size());;
	    objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN+"Green")).setScore(InGameHandler.green.size());;
	    objective.getScore(Bukkit.getOfflinePlayer(ChatColor.YELLOW+"Yellow")).setScore(InGameHandler.yellow.size());;
	    objective.getScore(Bukkit.getOfflinePlayer(ChatColor.AQUA+"Blue")).setScore(InGameHandler.blue.size());;

		p.setScoreboard(board);
	}
	@SuppressWarnings("deprecation")
	public static void updateSB(){
	
		for(Player p : Bukkit.getOnlinePlayers()){
			Scoreboard board = p.getScoreboard();
			Objective objective =  board.getObjective("teams");
		    objective.getScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red")).setScore(InGameHandler.red.size());;
		    objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN+"Green")).setScore(InGameHandler.green.size());;
		    objective.getScore(Bukkit.getOfflinePlayer(ChatColor.YELLOW+"Yellow")).setScore(InGameHandler.yellow.size());;
		    objective.getScore(Bukkit.getOfflinePlayer(ChatColor.AQUA+"Blue")).setScore(InGameHandler.blue.size());;

		}
	}


}
