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
import java.util.Random;

import nl.soulpoint.api.SoulPointAPI;
import nl.soulpoint.api.mysql.SoulPointMySQL;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import com.funergy.bedwars.Bedwars;
import com.funergy.bedwars.events.BlockBreakevent;
import com.funergy.bedwars.events.PlaceBlockEvent;
import com.funergy.bedwars.gamemanager.itemdrop.Diamond;
import com.funergy.bedwars.gamemanager.itemdrop.Gold;
import com.funergy.bedwars.gamemanager.itemdrop.Quartz;
import com.funergy.bedwars.mysql.Signs;
import com.funergy.bedwars.timers.InGameTimer;

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
		new InGameTimer().runTaskTimer(Bedwars.getPlugin(Bedwars.class), 0, 20);
		new Quartz().runTaskTimer(Bedwars.getPlugin(Bedwars.class), 100, 30);
		new Gold().runTaskTimer(Bedwars.getPlugin(Bedwars.class), 100, 320);
		new Diamond().runTaskTimer(Bedwars.getPlugin(Bedwars.class),100, 400);
		//Start dropping stuff
		
	}
	public static void end(){
		for(Player p : Bukkit.getOnlinePlayers()){
			p.getInventory().setArmorContents(new ItemStack[4]);
			p.getInventory().clear();
			SoulPointAPI.getServers().sendToLobby(p);
		}
		Bukkit.unloadWorld("map", false);{
			Bukkit.shutdown();
		}

	}
	public static void yellowWins(){
		Bukkit.broadcastMessage(Bedwars.getGamePrefix()+ChatColor.YELLOW+"Yellow team has won the Bedwars Game!");
		Bukkit.broadcastMessage(Bedwars.getGamePrefix()+ChatColor.GREEN+"All Yellow player tributes:");
		 StringBuilder msgBuilder = new StringBuilder();
		for (Player p : yellow) {
            msgBuilder.append(p.getName()).append(", ");
    }
		String s = msgBuilder.toString();
		Bukkit.broadcastMessage(ChatColor.BLUE+s);

		for(Player p : yellow){
		 Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
         FireworkMeta fwm = fw.getFireworkMeta();
        
         Random r = new Random();   

         int rt = r.nextInt(4) + 1;
         Type type = Type.BALL;       
         if (rt == 1) type = Type.BALL;
         if (rt == 2) type = Type.BALL_LARGE;
         if (rt == 3) type = Type.BURST;
         if (rt == 4) type = Type.CREEPER;
         if (rt == 5) type = Type.STAR;
        
         int r1i = r.nextInt(17) + 1;
         int r2i = r.nextInt(17) + 1;
         Color c1 = getColor(r1i);
         Color c2 = getColor(r2i);
        
         FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
        
         fwm.addEffect(effect);
        
         int rp = r.nextInt(2) + 1;
         fwm.setPower(rp);
        
         fw.setFireworkMeta(fwm); 
		}
		
		
	}
	public static void greenWins(){
		Bukkit.broadcastMessage(Bedwars.getGamePrefix()+ChatColor.GREEN+"Green team has won the Bedwars Game!");
		Bukkit.broadcastMessage(Bedwars.getGamePrefix()+ChatColor.GREEN+"All Green player tributes:");
		 StringBuilder msgBuilder = new StringBuilder();
		for (Player p : green) {
            msgBuilder.append(p.getName()).append(", ");
    }
		String s = msgBuilder.toString();
		Bukkit.broadcastMessage(ChatColor.BLUE+s);

		for(Player p : green){
		 Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
         FireworkMeta fwm = fw.getFireworkMeta();
        
         Random r = new Random();   

         int rt = r.nextInt(4) + 1;
         Type type = Type.BALL;       
         if (rt == 1) type = Type.BALL;
         if (rt == 2) type = Type.BALL_LARGE;
         if (rt == 3) type = Type.BURST;
         if (rt == 4) type = Type.CREEPER;
         if (rt == 5) type = Type.STAR;
        
         int r1i = r.nextInt(17) + 1;
         int r2i = r.nextInt(17) + 1;
         Color c1 = getColor(r1i);
         Color c2 = getColor(r2i);
        
         FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
        
         fwm.addEffect(effect);
        
         int rp = r.nextInt(2) + 1;
         fwm.setPower(rp);
        
         fw.setFireworkMeta(fwm); 
		}
		
	}
	public static void redWins(){
		Bukkit.broadcastMessage(Bedwars.getGamePrefix()+ChatColor.RED+"Red team has won the Bedwars Game!");
		Bukkit.broadcastMessage(Bedwars.getGamePrefix()+ChatColor.GREEN+"All Red player tributes:");
		 StringBuilder msgBuilder = new StringBuilder();
		for (Player p : green) {
            msgBuilder.append(p.getName()).append(", ");
    }
		String s = msgBuilder.toString();
		Bukkit.broadcastMessage(ChatColor.BLUE+s);

		for(Player p : green){
		 Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
         FireworkMeta fwm = fw.getFireworkMeta();
        
         Random r = new Random();   

         int rt = r.nextInt(4) + 1;
         Type type = Type.BALL;       
         if (rt == 1) type = Type.BALL;
         if (rt == 2) type = Type.BALL_LARGE;
         if (rt == 3) type = Type.BURST;
         if (rt == 4) type = Type.CREEPER;
         if (rt == 5) type = Type.STAR;
        
         int r1i = r.nextInt(17) + 1;
         int r2i = r.nextInt(17) + 1;
         Color c1 = getColor(r1i);
         Color c2 = getColor(r2i);
        
         FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
        
         fwm.addEffect(effect);
        
         int rp = r.nextInt(2) + 1;
         fwm.setPower(rp);
        
         fw.setFireworkMeta(fwm); 
		}
		
	}
	public static void blueWins(){
		Bukkit.broadcastMessage(Bedwars.getGamePrefix()+ChatColor.AQUA+"Blue team has won the Bedwars Game!");
		Bukkit.broadcastMessage(Bedwars.getGamePrefix()+ChatColor.GREEN+"All Blue player tributes:");
		 StringBuilder msgBuilder = new StringBuilder();
		for (Player p : blue) {
            msgBuilder.append(p.getName()).append(", ");
    }
		String s = msgBuilder.toString();
		Bukkit.broadcastMessage(ChatColor.BLUE+s);

		for(Player p : blue){
		 Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
         FireworkMeta fwm = fw.getFireworkMeta();
        
         Random r = new Random();   

         int rt = r.nextInt(4) + 1;
         Type type = Type.BALL;       
         if (rt == 1) type = Type.BALL;
         if (rt == 2) type = Type.BALL_LARGE;
         if (rt == 3) type = Type.BURST;
         if (rt == 4) type = Type.CREEPER;
         if (rt == 5) type = Type.STAR;
        
         int r1i = r.nextInt(17) + 1;
         int r2i = r.nextInt(17) + 1;
         Color c1 = getColor(r1i);
         Color c2 = getColor(r2i);
        
         FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
        
         fwm.addEffect(effect);
        
         int rp = r.nextInt(2) + 1;
         fwm.setPower(rp);
        
         fw.setFireworkMeta(fwm); 
		}
		
	}
	
	private static Color getColor(int i) {
		Color c = null;
		if(i==1){
		c=Color.AQUA;
		}
		if(i==2){
		c=Color.BLACK;
		}
		if(i==3){
		c=Color.BLUE;
		}
		if(i==4){
		c=Color.FUCHSIA;
		}
		if(i==5){
		c=Color.GRAY;
		}
		if(i==6){
		c=Color.GREEN;
		}
		if(i==7){
		c=Color.LIME;
		}
		if(i==8){
		c=Color.MAROON;
		}
		if(i==9){
		c=Color.NAVY;
		}
		if(i==10){
		c=Color.OLIVE;
		}
		if(i==11){
		c=Color.ORANGE;
		}
		if(i==12){
		c=Color.PURPLE;
		}
		if(i==13){
		c=Color.RED;
		}
		if(i==14){
		c=Color.SILVER;
		}
		if(i==15){
		c=Color.TEAL;
		}
		if(i==16){
		c=Color.WHITE;
		}
		if(i==17){
		c=Color.YELLOW;
		}
		 
		return c;
		}
	

}
