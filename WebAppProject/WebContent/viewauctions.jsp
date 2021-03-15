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
AuctionDao pd=new AuctionDao();
List<Auction> li=pd.getAllAuctions();
%>
<table>
<tr>
<th>Auction Id</th>
<th>Team ID</th>
<th>Player ID</th>
<th>Amount</th>
<th>Year</th>


</tr>
<%
for(Auction a:li){
%>
<tr>
<td><%=a.getAuctionId() %></td>
<td><%=a.getTeamId() %></td>
<td><%=a.getPlayerId() %></td>
<td><%=a.getAmount() %></td>
<td><%=a.getYear() %></td>
<td><a href="editauction.jsp?id=<%=a.getAuctionId()%>">Update</a></td>
</tr>
<%} %>
</table>

</body>
</html>