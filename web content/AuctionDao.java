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
}
