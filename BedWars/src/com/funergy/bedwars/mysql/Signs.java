/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.mysql;
/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
import java.sql.ResultSet;
import java.sql.SQLException;

import com.funergy.bedwars.Bedwars;

import nl.soulpoint.api.mysql.SoulPointMySQL;

/**
 * @author Funergy
 *
 */
public class Signs {
	private static SoulPointMySQL connection;
	public static boolean inList = false;
	 
	public Signs() {
        connection = new SoulPointMySQL();
    }
	public static void openConnection(){
        connection = new SoulPointMySQL();
        connection.connect();
	}
	
    public static void setupDB() throws SQLException {
                connection.executeUpdate("CREATE TABLE IF NOT EXISTS `BWservers`(`ID` integer,`NAME` varchar(100),`MAP` varchar(100),`PLAYERC` integer,`MAXP` integer,`STATE` varchar(100))");
        }
    public static void setId(){
    	try{
    		connection.executeUpdate("INSERT INTO `BWservers`(ID,NAME,MAP,PLAYERC,MAXP,STATE)\nvalues ('"+Bedwars.getSignID()+"','"+Bedwars.getServerName()+"','" + Bedwars.getMapName() + "', '" +0+"','"+16+"','"+"LOBBY"+"');");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public static boolean isInList(){
    	if(inList)return true;
		return false;
    	
    }
    public static void setIsInList(boolean answer){
    	inList = answer;
    }
    
    public static void setStateIngame(){
    	try {
    		connection.executeUpdate("UPDATE `BWservers` SET STATE="+Bedwars.getGameState()+" WHERE ID="+Bedwars.getSignID()+";");
    } catch (Exception e) {
            e.printStackTrace();
    }
    }

    	public static void setStateLobby(){
        	try {
                connection.executeUpdate("UPDATE `BWservers` SET STATE="+"LOBBY"+" WHERE ID="+Bedwars.getSignID()+";");
        } catch (Exception e) {
                e.printStackTrace();
        }
    	
    }
    public static void setPlayerc(int playerc){
    	try {
            connection.executeUpdate("UPDATE `BWservers` SET PLAYERC="+Bedwars.getLobbyPCount()+" WHERE ID="+Bedwars.getSignID()+";");
    } catch (Exception e) {
            e.printStackTrace();
    }
    }
    public static String getid(){
 	   
	        try {
	             ResultSet result =connection.select("select STATE from BWservers where ID='" +1 + "'");

	               
	                if (result.next()) {
	                        return result.getString("STATE");
	                } else {
	                        return null;
	                }
	        } catch (Exception e) {
	                e.printStackTrace();
	                return null;
	        }
	    }
    public static void disconnectMySQL(){
    	connection.disconnect();
    }
}
