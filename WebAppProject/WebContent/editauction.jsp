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
AuctionDao ad=new AuctionDao();
Auction a1=ad.getAllAuctionById(id);
%>
<form action="./UpdateAuctionServlet" method="post">
Auction Id: <input type="hidden" name="auctionId" value="<%=a1.getAuctionId() %>"> <br><br>
Team Id: <input type="number" value="<%=a1.getTeamId()%>" name="teamId"><br><br>
Player Id: <input type="number" value="<%=a1.getPlayerId()%>" name="playerId"><br><br>
Amount: <input type="number" value="<%=a1.getAmount()%>" name="amount"><br><br>
Year: <input type="number" value="<%=a1.getYear()%>" name="year"><br><br>

<input type="submit" value="Update Team">

</form>
</body>
</html>