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
TeamDao td=new TeamDao();
Team t1=td.getAllTeamById(id);
%>
<form action="./UpdateTeamServlet" method="post">
Team Id: <input type="hidden" name="teamId" value="<%=t1.getTeamId() %>"> <br><br>
Team Name: <input type="text" value="<%=t1.getTeamName()%>" name="teamName"><br><br>
Owner Name: <input type="text" value="<%=t1.getOwnerName()%>" name="ownerName"><br><br>
Coach Name: <input type="text" value="<%=t1.getCoachName()%>" name="coachName"><br><br>
Player ID: <input type="number" value="<%=t1.getPlayerId()%>" name="playerId"><br><br>

<input type="submit" value="Update Team">

</form>
</body>
</html>