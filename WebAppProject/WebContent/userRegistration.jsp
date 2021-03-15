
<%@ page import="java.sql.*"%>
<%
    String userName = request.getParameter("username");   
    String password = request.getParameter("password");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ashu", "root", "root");
    Statement st = con.createStatement();
    int i = st.executeUpdate("insert into userreg(first_name, last_name, email, username, password, regdate) values ('" + firstName + "','"
    + lastName + "','" + email + "','" + userName + "','" + password + "', CURDATE())");
    if (i > 0) {
        response.sendRedirect("success.jsp");
        
    } else {
        response.sendRedirect("userRegistration.jsp");
    }
%>