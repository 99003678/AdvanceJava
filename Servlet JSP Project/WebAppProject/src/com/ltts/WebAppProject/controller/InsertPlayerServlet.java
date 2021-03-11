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

import com.ltts.WebAppProject.dao.PlayerDao;
import com.ltts.WebAppProject.model.Player;

/**
 * Servlet implementation class InsertPlayerServlet
 */
@WebServlet("/InsertPlayerServlet")
public class InsertPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPlayerServlet() {
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
		//doGet(request, response);
		 PrintWriter out = response.getWriter();  
		int pid=Integer.parseInt(request.getParameter("playerId"));
		String name=request.getParameter("playerName");
		String dob=request.getParameter("dateOfBirth");
		Date dob1=Date.valueOf(dob);
		String skills=request.getParameter("skills");
		int tid=Integer.parseInt(request.getParameter("teamId"));
		int nom=Integer.parseInt(request.getParameter("numberOfMatches"));
		int w=Integer.parseInt(request.getParameter("wickets"));
		String nationality=request.getParameter("Nationality");
		int r=Integer.parseInt(request.getParameter("runs"));
		Player p=new Player(pid,name,dob1,skills,tid,nom,w,nationality,r);
		System.out.println("Inside Servlet: "+p);
		PlayerDao pd=new PlayerDao();
		boolean b=false;
		RequestDispatcher rd=null;
		try {
			b=pd.insertPlayer(p); // Control TRanfers to Dao file
			System.out.println("Successfully Inserted...");
			rd=request.getRequestDispatcher("Success.html");
			rd.forward(request, response);
			//System.out.println("Successfully Inserted...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.write("Already Player id Used: "+e);
			rd=request.getRequestDispatcher("AddTeam.html");
			rd.include(request, response);
			e.printStackTrace();
		}
	}

	
}
