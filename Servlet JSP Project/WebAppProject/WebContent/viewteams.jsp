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
TeamDao pd=new TeamDao();
List<Team> li=pd.getAllTeams();
%>
<table>
<tr>
<th>Team Id</th>
<th>Team Name</th>
<th>Owner Name</th>
<th>Coach Name</th>
<th>Player ID</th>


</tr>
<%
for(Team t:li){
%>
<tr>
<td><%=t.getTeamId() %></td>
<td><%=t.getTeamName() %></td>
<td><%=t.getOwnerName() %></td>
<td><%=t.getCoachName() %></td>
<td><%=t.getPlayerId() %></td>

<td><a href="editteam.jsp?id=<%=t.getTeamId()%>">Update</a></td>
</tr>
<%} %>
</table>

</body>
</html>