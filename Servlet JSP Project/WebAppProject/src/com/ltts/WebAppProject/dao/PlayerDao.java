package com.ltts.WebAppProject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import java.sql.Date;

import com.ltts.WebAppProject.configure.MyConnection;
import com.ltts.WebAppProject.model.Player;

public class PlayerDao {
		
			public boolean insertPlayer(Player p) throws Exception
			{
				Connection c= MyConnection.getConnection();
				PreparedStatement ps= c.prepareStatement("insert into web_player values(?,?,?,?,?,?,?,?,?)");
				ps.setInt(1, p.getPlayerId());
				ps.setString(2, p.getPlayerName());
				ps.setDate(3, (Date) p.getDateOfBirth());
				ps.setString(4, p.getSkills());
				ps.setInt(5, p.getTeamId());
				ps.setInt(6, p.getNumberOfMatches());
				ps.setInt(7, p.getWickets());
				ps.setString(8, p.getNationality());
				ps.setInt(9, p.getRuns());
				return ps.execute();
			}
			
			public List<Player> getAllPlayers() throws Exception{
				List<Player> li=new ArrayList<Player>();
				Connection mc=MyConnection.getConnection(); // TRanfers control to another 
				Statement ps=mc.createStatement();
				ResultSet rs=ps.executeQuery("select * from web_player");
				//Player p=new Player();
				while(rs.next()) {
					li.add(new Player(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getInt(9)));
					
				}
				return li;
				
			}
			public boolean getPlayerById(int id, boolean rowUpdated) throws Exception 
			{
				Connection c= MyConnection.getConnection();
				PreparedStatement ps= c.prepareStatement("update web_player set playerName=?, dateOfBirth=?, skills=?, teamId=?, numberOfMatches=?, wickets=?,Nationality=?, runs=? where playerId=?");
	
				List<Player> li=getAllPlayers();
				for(Player p1:li) {
					if(p1.getPlayerId()==id) {
						((Player) ps).setPlayerId(id);
						((Player) ps).setPlayerName(p1.getPlayerName());
						((Player) ps).setDateOfBirth(p1.getDateOfBirth());
						((Player) ps).setSkills(p1.getSkills());
						((Player) ps).setTeamId(p1.getTeamId());
						((Player) ps).setNumberOfMatches(p1.getNumberOfMatches());
						((Player) ps).setWickets(p1.getWickets());
						((Player) ps).setNationality(p1.getNationality());
						((Player) ps).setRuns(p1.getRuns());
						
						  rowUpdated = ps.executeUpdate() > 0;
					        ps.close();
					    
					    
						
					}
				}
				return rowUpdated;
			}
}
			
			
