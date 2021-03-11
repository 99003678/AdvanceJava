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
PlayerDao pd=new PlayerDao();
List<Player> li=pd.getAllPlayers();
%>
<table>
<tr>
<th>Player Id</th>
<th>Player Name</th>
<th>Player DOB</th>
<th>Skills</th>
<th>Team ID</th>
<th>No of Matches</th>
<th>Wickets</th>
<th>Nationality</th>
<th>Runs</th>

</tr>
<%
for(Player p:li){
%>
<tr>
<td><%=p.getPlayerId() %></td>
<td><%=p.getPlayerName() %></td>
<td><%=p.getDateOfBirth() %></td>
<td><%=p.getSkills() %></td>
<td><%=p.getTeamId() %></td>
<td><%=p.getNumberOfMatches() %></td>
<td><%=p.getWickets() %></td>
<td><%=p.getNationality() %></td>
<td><%=p.getRuns() %></td>

<td><a href="editplayer.jsp?id=<%=p.getPlayerId()%>">Update</a></td>
</tr>
<%} %>
</table>

</body>
</html>