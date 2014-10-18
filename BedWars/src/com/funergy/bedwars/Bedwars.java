/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.funergy.bedwars.events.BlockBreakevent;
import com.funergy.bedwars.events.DamageEvent;
import com.funergy.bedwars.events.FoodLevelChange;
import com.funergy.bedwars.events.HitEvent;
import com.funergy.bedwars.events.InteractEvent;
import com.funergy.bedwars.events.ItemDropEvent;
import com.funergy.bedwars.events.ItemPickupevent;
import com.funergy.bedwars.events.JoinEvent;
import com.funergy.bedwars.events.LeaveEvent;
import com.funergy.bedwars.events.PlaceBlockEvent;
import com.funergy.bedwars.events.PlayerDeathHandler;
import com.funergy.bedwars.events.ShopCategories;
import com.funergy.bedwars.events.TnTExplosionEvent;
import com.funergy.bedwars.events.VillagerRightClick;
import com.funergy.bedwars.gamemanager.InGameHandler;
import com.funergy.bedwars.gamemanager.SpectatorHandler;
import com.funergy.bedwars.mysql.Signs;
import com.funergy.bedwars.timers.LobbyTimer;

/**
 * @author Funergy
 *
 */
public class Bedwars extends JavaPlugin{
	static int lobbypcount = 0;
	static int ingamecount = 0;
	 static int spectatecount = 0;
	 static String gameState = "lobby";
	public static boolean isInList=false;
	 static String mapName ="Quartz";
	 static String serverName ="BW01";
	 static int id = 1;
	 public Signs s;
	    private static Signs mysql;

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
		Bukkit.getPluginManager().registerEvents(new HitEvent(), this);
		Bukkit.getPluginManager().registerEvents(new DamageEvent(), this);
		Bukkit.getPluginManager().registerEvents(new SpectatorHandler(), this);
		Bukkit.getPluginManager().registerEvents(new ItemPickupevent(), this);
	    this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");


		Bukkit.getServer().createWorld(new WorldCreator("map"));
		Bukkit.getWorld("map").setAutoSave(false);
	
		putInList();
		
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
	@SuppressWarnings("static-access")
	public static void setLobbyCount(Integer i){
		lobbypcount=i; 
	    if(isInList){
		mysql = new Signs();
		Signs.setPlayerc(i);
		mysql.disconnectMySQL();
		}}
	public static void setSpectateCount(Integer i){spectatecount=i;}

	
	public static void putInList(){
		
		new BukkitRunnable(){

			@SuppressWarnings("static-access")
			@Override
			public void run() {
				if(getGameState().equalsIgnoreCase("lobby")){
					mysql = new Signs();
					if(Signs.getid() == null){
					Signs.setId();
					System.out.println("Sign is in mysql");
					isInList = true;
					mysql.disconnectMySQL();
					this.cancel();
					return;
					}
				}else{
					this.cancel();
					return;
				}
				
			}
			
		}.runTaskTimer(Bedwars.getPlugin(Bedwars.class), 0, 20);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd,
			String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("start")){
			if(sender.isOp()){
				InGameHandler.startGame();
			}
		}
		if(cmd.getName().equalsIgnoreCase("ending")){
			if(sender.isOp()){
				InGameHandler.end();
				InGameHandler.resetmap();
			}
		}
	return false;
	}
	
	
	

}
