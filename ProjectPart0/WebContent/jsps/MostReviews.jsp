<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style type="text/css">
</style>
</head>
<body>
	<content id="content">
	<form>
		<%@ page import="java.sql.*" %>		
		<%
		try {
			String URL = "jdbc:mysql://localhost:3306/sampledb";
			String USER = "john";
			String PASS = "pass1234";
			Connection connect = DriverManager.getConnection(URL, USER, PASS);
		    
		    Statement stmt = connect.createStatement();
		    ResultSet rs; 
		    rs = stmt.executeQuery("SELECT * FROM ProgramCommittee WHERE PCNumAssigned = (SELECT MAX(PCNumAssigned) FROM ProgramCommittee)");
		
		    while ( rs.next() ) { %>
			<p>Asset ID:<input type= "text" value =<%=rs.getString("PCName") %> >Assigned:<input type= "text" value =<%=rs.getString("PCNumAssigned") %> ></p><br>
		  <%   }
		    connect.close();
		} catch (Exception e) {
		    System.err.println(e.getMessage());
		} 
		%>
	</form>
		<form action="/ProjectPart0/jsps/main.jsp">
		<input type="submit" value="Homepage">
		</form>	
	</content>
</body>
</html>