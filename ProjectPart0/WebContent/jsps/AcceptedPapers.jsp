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
		    stmt.executeUpdate("CREATE VIEW Accept AS SELECT PapID, PapTitle From(SELECT p.PapID, PapTitle, Count(*) FROM Paper p INNER JOIN Review r ON r.PapID = p.PapID WHERE RevDecision = 1 GROUP BY PapID Having Count(*) >= 2) AS Accept");
		
		    Statement stmt1 = connect.createStatement();
		    ResultSet rs1; 
		    rs1 = stmt1.executeQuery("SELECT * FROM Accept");    
		    
		    while ( rs1.next() ) { %>
			<p>Paper ID:<input type= "text" value =<%=rs1.getString("PapID") %> >Title:<input type= "text" value =<%=rs1.getString("PapTitle") %> ></p><br>
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