/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars;

import nl.soulpoint.api.mysql.SoulPointMySQL;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.funergy.bedwars.categorychooser.ShopCategories;
import com.funergy.bedwars.events.BlockBreakevent;
import com.funergy.bedwars.events.FoodLevelChange;
import com.funergy.bedwars.events.InteractEvent;
import com.funergy.bedwars.events.ItemDropEvent;
import com.funergy.bedwars.events.JoinEvent;
import com.funergy.bedwars.events.LeaveEvent;
import com.funergy.bedwars.events.PlaceBlockEvent;
import com.funergy.bedwars.events.PlayerDeathHandler;
import com.funergy.bedwars.events.TnTExplosionEvent;
import com.funergy.bedwars.events.VillagerRightClick;
import com.funergy.bedwars.gamemanager.BedHandler;
import com.funergy.bedwars.gamemanager.InGameHandler;
import com.funergy.bedwars.mysql.Signs;

/**
 * @author Funergy
 *
 */
public class Bedwars extends JavaPlugin{
	static int lobbypcount = 0;
	static int ingamecount = 0;
	 static int spectatecount = 0;
	 static String gameState = "lobby";
	
	 static String mapName ="Quartz";
	 static String serverName ="BW1";
	 static int id = 0;
	 public Signs s;

	 static String gamePrefix = ChatColor.GRAY+"["+ChatColor.RED+"BedWars"+ChatColor.GRAY+"]: "+ChatColor.WHITE;
	
	public void onEnable() {
        
		Bukkit.getPluginManager().registerEvents(new ShopCategories(), this);
		Bukkit.getPluginManager().registerEvents(new VillagerRightClick(), this);
		Bukkit.getPluginManager().registerEvents(new PlaceBlockEvent(), this);
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
		Bukkit.getPluginManager().registerEvents(new InteractEvent(), this);
		Bukkit.getPluginManager().registerEvents(new LeaveEvent(), this);
		Bukkit.getPluginManager().registerEvents(new FoodLevelChange(), this);
		Bukkit.getPluginManager().registerEvents(new ItemDropEvent(), this);
		Bukkit.getPluginManager().registerEvents(new BlockBreakevent(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerDeathHandler(), this);
		Bukkit.getPluginManager().registerEvents(new TnTExplosionEvent(), this);



		/*Bukkit.getServer().createWorld(new WorldCreator("map"));
		Bukkit.getWorld("map").setAutoSave(false);
		
		putInList();
		*/
	    InGameHandler.loadGameSettings();{
	    System.out.println("[BedWars] Loaded game settings");}
			
	}

	
	public static String getGamePrefix(){return gamePrefix;}
	public static String getGameState(){return gameState;}
	public static String getMapName(){return mapName;}
	public static String getServerName(){return serverName;}

	public static void setGameState(String i){gameState=i;}
	
	public static  Integer getLobbyPCount(){return lobbypcount;}
	public static Integer getIngameCount(){return ingamecount;}
	public static Integer getSpectateCount(){return spectatecount;}
	public static Integer getSignID(){return id;}

	public static void setIngameCount(Integer i){ingamecount=i;}
	public static void setLobbyCount(Integer i){lobbypcount=i; if(Signs.isInList()){
		SoulPointMySQL connection = new SoulPointMySQL();
		connection.connect();
		Signs.setPlayerc(i);
		connection.disconnect();
		}}
	public static void setSpectateCount(Integer i){spectatecount=i;}

	
	public void putInList(){
		Signs.openConnection();
		new BukkitRunnable(){

			@Override
			public void run() {
				if(getGameState().equalsIgnoreCase("lobby")){
					if(Signs.getid() == null){
					Signs.setId();
					Signs.setIsInList(true);
					Signs.disconnectMySQL();
					this.cancel();
					return;
					}
				}else{
					this.cancel();
					return;
				}
				
			}
			
		}.runTaskTimer(this, 0, 10);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd,
			String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("intro")){
			  InGameHandler.startGame();
			  
		}
		if(cmd.getName().equalsIgnoreCase("red")){
			if(BedHandler.hasBed("red")){
			sender.sendMessage("true");
			}else{
				sender.sendMessage("false");
			}
		}
		
		return false;
	}
	
	

}
