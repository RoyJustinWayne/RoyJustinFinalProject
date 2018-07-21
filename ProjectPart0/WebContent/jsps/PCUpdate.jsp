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
		<p>Program Committee Member Alteration </p>
<tr>
<td>Member ID</td>
<td>Name</td>
<td>Number Assigned</td>
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
	    rs = stmt.executeQuery("SELECT * FROM ProgramCommittee"); 
		    
		while (rs.next()) 
	    { %>
		<form action="/ProjectPart0/UpdateServ" method="post">
		<tr><td><input type="text" name="PCID" readonly="readonly" value="<%=rs.getString("PCID") %>"></td>
		<td><input type="text" name="PCName" value="<%=rs.getString("PCName") %>"></td>
		<td><input type="text" name="PCNumAssigned" value="<%=rs.getString("PCNumAssigned") %>"></td>
		<td><input type="submit" name="Update" value="Update"/> 
		<input type="submit" name="Delete" value="Delete"/></td></tr>
		</form>
		 <%
		}
		%>
	</table>
		<form action="/ProjectPart0/UpdateServ" method="post"><tr>
		<td><input type="text" name="PCNameAdd" placeholder="Name">></td>
		<td><input type="text" name="PCNumAssignedAdd" placeholder="Number Assigned">></td>
		<td><input type="submit" name="Add" value="Add New PC Member"/>
	</td></tr>
	
	<%
		rs.close();
		stmt.close();
		connect.close();
	}
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