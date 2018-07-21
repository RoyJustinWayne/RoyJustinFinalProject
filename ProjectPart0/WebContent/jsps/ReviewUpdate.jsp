<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
</style>
</head>
<body>
<center>
		<%@ page import="java.sql.*" %>		
		<p>Reviews Alteration </p>
<tr>
<td>Review ID</td>
<td>Review Name</td>
<td>Review Description</td>
<td>Review Decision</td>
<td>Review Date</td>
<td>Paper ID</td>
<td>Actions:</td>
</tr>
<%
	try 
	{
		String URL = "jdbc:mysql://localhost:3306/sampledb";
		String USER = "john";
		String PASS = "pass1234";
		Connection connect = DriverManager.getConnection(URL, USER, PASS);
	    Statement stmt = connect.createStatement();
	    ResultSet rs; 
	    rs = stmt.executeQuery("SELECT * FROM Review"); 
		    
		while (rs.next()) 
	    { %>
		<form action="/ProjectPart0/ReviewServ" method="post">
		<tr><td><input type="text" name="RevID" readonly="readonly" value="<%=rs.getString("RevID") %>"></td>
		<td><input type="text" name="RevName" value="<%=rs.getString("RevName") %>"></td>
		<td><input type="text" name="RevDescript" value="<%=rs.getString("RevDescript") %>"></td>
		<td><input type="text" name="RevDecision" value="<%=rs.getString("RevDecision") %>"></td>
		<td><input type="text" name="RevDate" value="<%=rs.getString("RevDate") %>"></td>
		<td><input type="text" name="PapID" value="<%=rs.getString("PapID") %>"></td>
		<td><input type="submit" name="Update" value="Update"/> 
		<input type="submit" name="Delete" value="Delete"/></td></tr>
		</form>
		 <%
		}
		%>
	</table>
		<form action="/ProjectPart0/ReviewServ" method="post"><tr>
		<td><input type="text" name="RevNameAdd" placeholder="Name">></td>
		<td><input type="text" name="RevDescriptAdd" placeholder="Description">></td>
		<td><input type="text" name="RevDecisionAdd" placeholder="Decision (True/False)">></td>
		<td><input type="text" name="RevDateAdd" placeholder="Date">></td>
		<td><input type="text" name="PapIDAdd" placeholder="PaperID">></td>
		<td><input type="submit" name="Add" value="Add New Review"/>
	</td></tr>
	<%
		rs.close();
		stmt.close();
		connect.close();
	}//End of Try
	catch(Exception e)
	{
	}
	%>

</form>
	</form>
	<form action="/ProjectPart0/jsps/main.jsp">
		<input type="submit" value="Homepage">
	</form>
	</center>			
	</content>
</body>
</html>