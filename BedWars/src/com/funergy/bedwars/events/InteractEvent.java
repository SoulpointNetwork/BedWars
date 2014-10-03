/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.funergy.bedwars.Bedwars;
import com.funergy.bedwars.gamemanager.ChestHandler;
import com.funergy.bedwars.gamemanager.InGameHandler;
import com.funergy.bedwars.gamemanager.Teams;

/**
 * @author Funergy
 *
 */
public class InteractEvent implements Listener {

	@EventHandler
	public void onRightClickEvent(PlayerInteractEvent e){
		if(Bedwars.getGameState().equalsIgnoreCase("lobby")){
			ItemStack is = e.getPlayer().getItemInHand();
			if(is.getType() == Material.WOOL){
				
			if(is.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA+"Blue team")){
				
				
					Teams.addToTeam(e.getPlayer(), "blue");


			
			}
			if(is.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED+"Red team")){
				
			
				Teams.addToTeam(e.getPlayer(), "red");

				
			}
			if(is.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW+"Yellow team")){
				
				
					Teams.addToTeam(e.getPlayer(), "yellow");

				
			}
		    if(is.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN+"Green team")){
		    	
		    
				
				
					Teams.addToTeam(e.getPlayer(), "green");

				}
		    
			}
			}
		if(Bedwars.getGameState().equalsIgnoreCase("ingame")){
			if(e.getClickedBlock().getType() == Material.CHEST){
			if(ChestHandler.isChest(e.getClickedBlock().getLocation())){
				if(!ChestHandler.getTeamFromChest(e.getClickedBlock().getLocation()).equalsIgnoreCase(InGameHandler.getTeam(e.getPlayer()))){
					e.setCancelled(true);
				}

			}
			}
			if(e.getClickedBlock().getType() ==Material.BED_BLOCK){
				if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
				e.setCancelled(true);
				}
			}
		
		}
	}

}
