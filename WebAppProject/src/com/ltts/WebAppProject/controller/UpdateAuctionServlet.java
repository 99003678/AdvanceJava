package com.ltts.WebAppProject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltts.WebAppProject.dao.AuctionDao;

/**
 * Servlet implementation class UpdateAuctionServlet
 */
@WebServlet("/UpdateAuctionServlet")
public class UpdateAuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAuctionServlet() {
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
		doGet(request, response);
		
		int auctionId=Integer.parseInt(request.getParameter("auctionId"));
		int teamId=Integer.parseInt(request.getParameter("teamId"));
		int playerId=Integer.parseInt(request.getParameter("playerId"));
		int amount=Integer.parseInt(request.getParameter("amount"));
		int year=Integer.parseInt(request.getParameter("year"));
		RequestDispatcher rd=null;
		AuctionDao po=new AuctionDao();
		try {
			po.updateauction(auctionId,teamId,playerId,amount,year);
			rd=request.getRequestDispatcher("Success.html");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
			e.printStackTrace();
		}
	}
	}


