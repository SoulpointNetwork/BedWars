/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars;

import java.sql.SQLException;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.funergy.bedwars.categorychooser.ShopCategories;
import com.funergy.bedwars.events.JoinEvent;
import com.funergy.bedwars.events.PlaceBlockEvent;
import com.funergy.bedwars.events.VillagerRightClick;
import com.funergy.bedwars.gamemanager.InGameHandler;
import com.funergy.bedwars.mysql.Signs;

/**
 * @author Funergy
 *
 */
public class Bedwars extends JavaPlugin{
	 public static Bedwars instance;
	 int lobbypcount = 0;
	 int ingamecount = 0;
	 int spectatecount = 0;
	 String gameState;
	
	 String mapName ="Quartz";
	 String serverName ="BW1";
	 int id = 0;

	 String gamePrefix = ChatColor.GRAY+"["+ChatColor.RED+"BedWars"+ChatColor.GRAY+"]: "+ChatColor.WHITE;
	
	public void onEnable() {
		Signs.openConnection();
		try {
			Signs.setupDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Signs.disconnectMySQL();
		Bukkit.getPluginManager().registerEvents(new ShopCategories(), this);
		Bukkit.getPluginManager().registerEvents(new VillagerRightClick(), this);
		Bukkit.getPluginManager().registerEvents(new PlaceBlockEvent(), this);
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);

		instance = this;
		/*Bukkit.getServer().createWorld(new WorldCreator("map"));
		Bukkit.getWorld("map").setAutoSave(false);
		
		putInList();
		*/
	    InGameHandler.loadGameSettings();{
	    System.out.println("[BedWars] Loaded game settings");}
			
	}

	
	public  String getGamePrefix(){return gamePrefix;}
	public  String getGameState(){return gameState;}
	public  String getMapName(){return mapName;}
	public  String getServerName(){return serverName;}

	public void setGameState(String i){gameState=i;}
	
	public  Integer getLobbyPCount(){return lobbypcount;}
	public  Integer getIngameCount(){return ingamecount;}
	public  Integer getSpectateCount(){return spectatecount;}
	public  Integer getSignID(){return id;}

	public void setIngameCount(Integer i){ingamecount=i;}
	public void setLobbyCount(Integer i){lobbypcount=i; if(Signs.isInList()){Signs.setPlayerc(i);}}
	public void setSpectateCount(Integer i){spectatecount=i;}

	
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
	
	

}
