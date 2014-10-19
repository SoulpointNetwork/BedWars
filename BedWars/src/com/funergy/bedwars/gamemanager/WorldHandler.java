/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.gamemanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.World;

/**
 * @author Funergy
 *
 */
public class WorldHandler {
		public static World world;
		public static World unload = Bukkit.getWorld("map");
		
		public static World delete = Bukkit.getWorld("map");
		public static File deleteFolder = delete.getWorldFolder();
		
		// The world to copy
		public static World source = Bukkit.getWorld("BedwarsMap");
		public static File sourceFolder = source.getWorldFolder();
		 
		// The world to overwrite when copying
		public static World target = Bukkit.getWorld("map");
		public static File targetFolder = target.getWorldFolder();
		
		public static void unloadWorld(World world) {
		    world = Bukkit.getWorld("");
		    if(!world.equals(null)) {
		        Bukkit.getServer().unloadWorld(world, true);
		    }
		}
		public static boolean deleteWorld(File path) {
		      if(path.exists()) {
		          File files[] = path.listFiles();
		          for(int i=0; i<files.length; i++) {
		              if(files[i].isDirectory()) {
		                  deleteWorld(files[i]);
		              } else {
		                  files[i].delete();
		              }
		          }
		      }
		      return(path.delete());
		}
		
		
		public static void copyWorld(File source, File target){
		    try {
		        ArrayList<String> ignore = new ArrayList<String>(Arrays.asList("uid.dat", "session.dat"));
		        if(!ignore.contains(source.getName())) {
		            if(source.isDirectory()) {
		                if(!target.exists())
		                target.mkdirs();
		                String files[] = source.list();
		                for (String file : files) {
		                    File srcFile = new File(source, file);
		                    File destFile = new File(target, file);
		                    copyWorld(srcFile, destFile);
		                }
		            } else {
		                InputStream in = new FileInputStream(source);
		                OutputStream out = new FileOutputStream(target);
		                byte[] buffer = new byte[1024];
		                int length;
		                while ((length = in.read(buffer)) > 0)
		                    out.write(buffer, 0, length);
		                in.close();
		                out.close();
		            }
		        }
		    } catch (IOException e) {
		 
		    }
		}
	}