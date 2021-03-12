package com.ltts.WebAppProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltts.WebAppProject.dao.AuctionDao;
import com.ltts.WebAppProject.model.Auction;

/**
 * Servlet implementation class InsertAuctionServlet
 */
@WebServlet("/InsertAuctionServlet")
public class InsertAuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAuctionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);		 PrintWriter out = response.getWriter();  
		int auctionId=Integer.parseInt(request.getParameter("auctionId"));
		int teamId=Integer.parseInt(request.getParameter("teamId"));
		int playerId=Integer.parseInt(request.getParameter("playerId"));
		int amount=Integer.parseInt(request.getParameter("amount"));
		int year=Integer.parseInt(request.getParameter("year"));
		
		Auction a=new Auction(auctionId,teamId,playerId,amount,year);
		System.out.println("Inside Servlet: "+a);
	    AuctionDao pd=new AuctionDao();
		boolean b=false;
		RequestDispatcher rd=null;
		try {
			b=pd.insertAuction(a); // Control TRanfers to Dao file
			System.out.println("Successfully Inserted...");
			rd=request.getRequestDispatcher("Success.html");
			rd.forward(request, response);
			//System.out.println("Successfully Inserted...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.write("Already Player id Used: "+e);
			rd=request.getRequestDispatcher("AddAuction.html");
			rd.include(request, response);
			e.printStackTrace();
	}

}
}
