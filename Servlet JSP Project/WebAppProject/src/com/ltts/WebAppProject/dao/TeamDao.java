package com.ltts.WebAppProject.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ltts.WebAppProject.configure.MyConnection;
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
		ps.setInt(5,t.getTeamId());
		
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
}