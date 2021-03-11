package com.ltts.WebAppProject.controller;

import com.ltts.WebAppProject.dao.PlayerDao;
import com.ltts.WebAppProject.model.Player;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class UpdatePlayerServlet
 */
@WebServlet("/UpdatePlayerServlet")
public class UpdatePlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int playerId=Integer.parseInt(request.getParameter("playerId"));
		String playerName=request.getParameter("playerName");
		String dateOfBirth=request.getParameter("dateOfBirth");
		Date dateOfBirth1=Date.valueOf(dateOfBirth);
		String skills=request.getParameter("skills");
		int teamId=Integer.parseInt(request.getParameter("teamId"));
		int numberOfMatches=Integer.parseInt(request.getParameter("numberOfMatches"));
		int wickets=Integer.parseInt(request.getParameter("wickets"));
		String Nationality=request.getParameter("Nationality");
		int runs=Integer.parseInt(request.getParameter("runs"));
		
		
		
		RequestDispatcher rd=null;
		PlayerDao po=new PlayerDao();
		try {
			po.getPlayerById(playerId,playerName,dateOfBirth1,skills,teamId,numberOfMatches,wickets,Nationality,runs);
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
