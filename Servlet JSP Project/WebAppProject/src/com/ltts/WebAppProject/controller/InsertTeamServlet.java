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

import com.ltts.WebAppProject.dao.TeamDao;
import com.ltts.WebAppProject.model.Team;

/**
 * Servlet implementation class InsertTeamServlet
 */
@WebServlet("/InsertTeamServlet")
public class InsertTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTeamServlet() {
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
		int tid=Integer.parseInt(request.getParameter("teamId"));
		String name=request.getParameter("teamName");
		String on=request.getParameter("ownerName");
		String cn=request.getParameter("coachName");
		int pid=Integer.parseInt(request.getParameter("playerId"));
	
		Team t=new Team(tid,name,on,cn,pid);
		System.out.println("Inside Servlet: "+t);
		TeamDao pd=new TeamDao();
		boolean b=false;
		RequestDispatcher rd=null;
		try {
			b=pd.insertTeam(t); // Control TRanfers to Dao file
			System.out.println("Successfully Inserted...");
			rd=request.getRequestDispatcher("Success.html");
			rd.forward(request, response);
			//System.out.println("Successfully Inserted...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.write("Already Player id Used: "+e);
			rd=request.getRequestDispatcher("Addplayer.html");
			rd.include(request, response);
			e.printStackTrace();
		}
		
	}

	
}


