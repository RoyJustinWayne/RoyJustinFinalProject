<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
</style>
</head>
<body>
<center>
			
<p>Program Committee Member Alteration </p>
<table border="1">		
<tr>
<td>Member ID</td>
<td>Name</td>
<td>Number Assigned</td>
<td>Email</td>
<td>Affiliation</td>
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
			<td><input type="text" name="PCEmail" value="<%=rs.getString("PCEmail") %>"></td>
			<td><input type="text" name="PCAffiliation" value="<%=rs.getString("PCAffiliation") %>"></td>
			 
		 <%
		}
		%>
	</table>
		<form action="/ProjectPart0/UpdateServ" method="post">
		<input type="text" name="PCNameAdd" placeholder="Name">>
		<input type="text" name="PCNumAssignedAdd" placeholder="Number Assigned">
		<input type="text" name="PCEmailAdd" placeholder="Email">>
		<input type="text" name="PCAffiliationAdd" placeholder="Affiliation">
		<input type="submit" name="Add" value="Add New PC Member"/>
		</form>
		
		<p> </p>
		<form action="/ProjectPart0/UpdateServ" method="post">
		<input type="text" name="PCIDDel" placeholder="PCIDDel">
		<input type="submit" name="Delete" value="Delete Member"/>
		</form>
		
		<p> </p>
		<form action="/ProjectPart0/UpdateServ" method="post">
		<input type="text" name="PCIDMod" placeholder="ID TO CHANGE">
		<input type="text" name="PCNameMod" placeholder="Name Change">
		<input type="text" name="PCNumAssignedMod" placeholder="Num Assigned Change">
		<input type="text" name="PCEmailMod" placeholder="Email Change">
		<input type="text" name="PCAffiliationMod" placeholder="PCAffiliationMod">
		<td><input type="submit" name="Update" value="Update"/>
		</form>
		
		<p> </p>
		<form action="/ProjectPart0/UpdateServ" method="post">
		<input type="text" name="PapIDAdd1" placeholder="PaperID">
		<input type="text" name="PCNameAdd1" placeholder="Name">
		<input type="text" name="PCNameAdd2" placeholder="Name">
		<input type="text" name="PCNameAdd3" placeholder="Name">
		<input type="submit" name="Assign" value="Add Members to Paper"/>
		
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

	<form action="/ProjectPart0/jsps/main.jsp">
		<input type="submit" value="Homepage">
	</form>
	</center>			
</body>
</html>