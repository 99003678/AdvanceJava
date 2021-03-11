<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import ="java.util.*,com.ltts.WebAppProject.model.*,com.ltts.WebAppProject.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int id=Integer.parseInt(request.getParameter("id"));
PlayerDao pd=new PlayerDao();
Player p1=pd.getPlayerById(playerId,playerName,dateOfBirth,skills,teamId,numberOfMatches,wickets,Nationality,runs);
%>
<form action="./UpdatePlayerServlet" method="post">
Player Id: <%=p1.getPlayerId() %> <br><br>
Player Name: <input type="text" value="<%=p1.getPlayerName()%>" name="playerName"><br><br>
Player DOB: <input type="date" value="<%=p1.getPlayerName()%>" name="dateOfBirth"><br><br>
Player Skills: <input type="text" value="<%=p1.getPlayerName()%>" name="skills"><br><br>
Team ID: <input type="number" value="<%=p1.getPlayerName()%>" name="teamId"><br><br>
No of Matches: <input type="number" value="<%=p1.getPlayerName()%>" name="numberOfMatches"><br><br>
Wickets: <input type="number" value="<%=p1.getPlayerName()%>" name="wickets"><br><br>
Nationality: <input type="text" value="<%=p1.getPlayerName()%>" name="Nationality"><br><br>
Runs: <input type="number" value="<%=p1.getPlayerName()%>" name="runs"><br><br>

<input type="submit" value="Update Player">

</form>
</body>
</html>