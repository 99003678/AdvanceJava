package com.ltts.WebAppProject.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ltts.WebAppProject.configure.MyConnection;
import com.ltts.WebAppProject.model.Player;
import com.ltts.WebAppProject.model.Team;

public class TeamDao {


	public boolean insertTeam(Team t) throws Exception
	{
		Connection c= MyConnection.getConnection();
		
		PreparedStatement ps= c.prepareStatement("insert into web_team values(?,?,?,?,?)");
		ps.setInt(1,t.getTeamId());
		ps.setString(2, t.getTeamName());
		ps.setString(3, t.getOwnerName());
		ps.setString(4, t.getCoachName());
		ps.setInt(5,t.getPlayerId());
		
		return ps.execute();
}
	public List<Team> getAllTeams() throws Exception{
		List<Team> li=new ArrayList<Team>();
		Connection mc=MyConnection.getConnection(); // TRanfers control to another 
		Statement ps=mc.createStatement();
		ResultSet rs=ps.executeQuery("select * from web_team");
		//Team p=new Team();
		while(rs.next()) {
			li.add(new Team(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
			
		}
		return li;
		
	}
	public Team getAllTeamById(int id) throws Exception
	{
		Team t=new Team();
		List<Team> li=new ArrayList<Team>();
		li=getAllTeams();
		
		for(Team t1:li)
		{
			if(t1.getTeamId()==id)
			{
				t.setTeamId(id);
				t.setTeamName(t1.getTeamName());
				t.setOwnerName(t1.getOwnerName());
				t.setCoachName(t1.getCoachName());
				t.setPlayerId(t1.getPlayerId());
				
		
			}
		}
		return t;
	}
	public Boolean updateteam(int teamId,String teamName,String ownerName,String coachName,int playerId) throws Exception
	{
		Connection c= MyConnection.getConnection();
		PreparedStatement ps=c.prepareStatement("UPDATE web_team set teamName=?, ownerName=?, coachName=?, playerId=? where teamId=?");
		ps.setString(1,teamName);
		ps.setString(2,ownerName);
		ps.setString(3,coachName);
		ps.setInt(4,playerId);
		ps.setInt(5,teamId);
		Boolean b=ps.execute();
		return b;
	}
}