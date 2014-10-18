/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.events;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.funergy.bedwars.Bedwars;
import com.funergy.bedwars.gamemanager.ChestHandler;
import com.funergy.bedwars.gamemanager.InGameHandler;
import com.funergy.bedwars.gamemanager.SpectatorHandler;
import com.funergy.bedwars.gamemanager.Teams;

/**
 * @author Funergy
 *
 */
public class InteractEvent implements Listener {
	public static ArrayList<Player> plist = new ArrayList<Player>();
	@EventHandler
	public void onRightClickEvent(PlayerInteractEvent e){
		if(Bedwars.getGameState().equalsIgnoreCase("lobby")){
			ItemStack is = e.getPlayer().getItemInHand();
			if(is.getType() == Material.WOOL){
				if(!plist.contains(e.getPlayer())){
				
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
		    antiSpamTimer(e.getPlayer());
			}

			
			}
		}
		if(Bedwars.getGameState().equalsIgnoreCase("ingame")){
			if(e.getClickedBlock().getType() == Material.CHEST){
				if(SpectatorHandler.spectators.contains(e.getPlayer())){
					if(e.getPlayer().getItemInHand().getType() ==  Material.COMPASS){
					Inventory inv = Bukkit.createInventory(null, 18,"Teleporter");
					inv.setItem(3, itemStack(Material.WOOL,1, DyeColor.CYAN, "&bBlue team", null));
					inv.setItem(4, itemStack(Material.WOOL,1, DyeColor.GREEN, "&aGreen team", null));
					inv.setItem(5, itemStack(Material.WOOL,1, DyeColor.YELLOW, "&eYellow team", null));
					inv.setItem(13, itemStack(Material.WOOL,1, DyeColor.RED, "&cRed team", null));
					e.getPlayer().openInventory(inv);
					}else{
						e.setCancelled(true);
					}
				}
				if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(ChestHandler.isChest(e.getClickedBlock().getLocation())){
				if(!ChestHandler.getTeamFromChest(e.getClickedBlock().getLocation()).equalsIgnoreCase(InGameHandler.getTeam(e.getPlayer()))){
					e.setCancelled(true);
				}
			}

			}
			}
			if(e.getClickedBlock().getType() ==Material.BED_BLOCK){
				if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
				e.setCancelled(true);
				}	}
			}
			

			
	}
	public static void antiSpamTimer(final Player p){
		plist.add(p);
		new BukkitRunnable(){

			@Override
			public void run() {
				plist.remove(p);
			}
			
		}.runTaskLater(Bedwars.getPlugin(Bedwars.class), 30);
	}
	@SuppressWarnings("deprecation")
	public static ItemStack itemStack(Material mat, Integer amount,DyeColor c ,String displayname, String Lore){
		ItemStack im;
		if(c !=null){
		im = new ItemStack(mat,amount,c.getData());
		}else{
	    im = new ItemStack(mat,amount);
		}
		ItemMeta m = im.getItemMeta();
		if(displayname !=null){
		m.setDisplayName(ChatColor.translateAlternateColorCodes('&',displayname));
		}
		if(Lore != null){
		ArrayList<String> lore = new ArrayList<String>();
		m.setLore(lore);
		}
		im.setItemMeta(m);
		
		return im;
	}

}
