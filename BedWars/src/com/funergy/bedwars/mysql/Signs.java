/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.bedwars.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.funergy.bedwars.Bedwars;

/**
 * @author Funergy
 *
 */
public class Signs {
	private static Connection connection;
	 
	public Signs() {
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://eu.hostskool.com/joey" + "?user=joey" + "&password=xCj2mQmvSW7jHMRj" );
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	
    public static void setupDB() throws SQLException {
    	try{
    		PreparedStatement statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS `BWservers`(`ID` integer,`NAME` varchar(100),`MAP` varchar(100),`PLAYERC` integer,`MAXP` integer,`STATE` varchar(100))");
    		statement.executeUpdate();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	}
    	
    public static void setId(){
    	try{
    		PreparedStatement statement = connection.prepareStatement("INSERT INTO `BWservers`(ID,NAME,MAP,PLAYERC,MAXP,STATE)\nvalues ('"+Bedwars.getSignID()+"','"+Bedwars.getServerName()+"','" + Bedwars.getMapName() + "', '" +0+"','"+16+"','"+"LOBBY"+"');");
             statement.executeUpdate();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
   
    public static void setStateIngame(){
    	try {
    		PreparedStatement statement = connection.prepareStatement("UPDATE `BWservers` SET STATE='"+"INGAME"+"' WHERE ID='"+Bedwars.getSignID()+"';");
            statement.executeUpdate();
    	} catch (Exception e) {
            e.printStackTrace();
    }
    }

    	public static void setStateLobby(){
        	try {
        		PreparedStatement statement = connection.prepareStatement("UPDATE `BWservers` SET STATE="+"LOBBY"+" WHERE ID="+Bedwars.getSignID()+";");
                statement.executeUpdate();
        	} catch (Exception e) {
                e.printStackTrace();
        }
    	
    }
    public static void setPlayerc(int playerc){
    	try {
    		PreparedStatement statement = connection.prepareStatement("UPDATE `BWservers` SET PLAYERC="+Bedwars.getLobbyPCount()+" WHERE ID="+Bedwars.getSignID()+";");
            statement.executeUpdate();
    	} catch (Exception e) {
            e.printStackTrace();
    }
    }
    public static String getid(){
 	   
	        try {
	        	PreparedStatement statement = connection.prepareStatement("select STATE from BWservers where ID='" +Bedwars.getSignID() + "'");
	             ResultSet result = statement.executeQuery();

	               
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
    	try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
