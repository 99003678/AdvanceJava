package com.ltts.WebAppProject.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ltts.WebAppProject.configure.MyConnection;
import com.ltts.WebAppProject.model.Auction;
import com.ltts.WebAppProject.model.Team;
import com.ltts.WebAppProject.model.Auction;

public class AuctionDao {


		
			public boolean insertAuction(Auction a) throws Exception
			{
				Connection c= MyConnection.getConnection();
				PreparedStatement ps= c.prepareStatement("insert into web_auction values(?,?,?,?,?)");
				ps.setInt(1, a.getAuctionId());
				ps.setInt(2, a.getTeamId());
				ps.setInt(3, a.getAuctionId());
				ps.setInt(4, a.getAmount());
				ps.setInt(5, a.getYear());
				
				return ps.execute();
			}
			public List<Auction> getAllAuctions() throws Exception{
				List<Auction> li=new ArrayList<Auction>();
				Connection mc=MyConnection.getConnection(); // TRanfers control to another 
				Statement ps=mc.createStatement();
				ResultSet rs=ps.executeQuery("select * from web_auction");
				//Auction p=new Auction();
				while(rs.next()) {
					li.add(new Auction(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5)));
					
				}
				return li;
				
			}
			
			public Auction getAllAuctionById(int id) throws Exception
			{
				Auction a=new Auction();
				List<Auction> li=new ArrayList<Auction>();
				li=getAllAuctions();
				
				for(Auction a1:li)
				{
					if(a1.getAuctionId()==id)
					{
						a.setAuctionId(id);
						a.setTeamId(a1.getTeamId());
						a.setPlayerId(a1.getPlayerId());
						a.setAmount(a1.getAmount());
						a.setYear(a1.getYear());
						
				
					}
				}
				return a;
			}
			public Boolean updateteam(int auctionId,int teamId,int playerId,int amount,int year) throws Exception
			{
				Connection c= MyConnection.getConnection();
				PreparedStatement ps=c.prepareStatement("UPDATE web_auction set teamId=?, playerId=?, amount=?, year=? where auctionId=?");
				ps.setInt(1,teamId);
				ps.setInt(2,playerId);
				ps.setInt(3,amount);
				ps.setInt(4,year);
				ps.setInt(5,auctionId);
				Boolean b=ps.execute();
				return b;
			}
}
