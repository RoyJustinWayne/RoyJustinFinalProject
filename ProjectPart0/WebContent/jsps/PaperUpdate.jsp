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
<p>Paper Alteration </p>
<tr>
<td>Paper ID</td>
<td>Author Name</td>
<td>Author #2 Name</td>
<td>Title</td>
<td>Paper Abstract</td>
<td>Paper PDF</td>
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
	    rs = stmt.executeQuery("SELECT * FROM Paper"); 
		    
		while (rs.next()) 
	    { %>
		<form action="/ProjectPart0/PaperServ" method="post">
		<tr><td><input type="text" name="PapID" readonly="readonly" value="<%=rs.getString("PapID") %>"></td>
		<td><input type="text" name="PapAuthor" value="<%=rs.getString("PapAuthor") %>"></td>
		<td><input type="text" name="PapAuthor2" value="<%=rs.getString("PapAuthor2") %>"></td>
		<td><input type="text" name="PapTitle" value="<%=rs.getString("PapTitle") %>"></td>
		<td><input type="text" name="PapAbstract" value="<%=rs.getString("PapAbstract") %>"></td>
		<td><input type="text" name="PapPDF" value="<%=rs.getString("PapPDF") %>"></td>
		<td><input type="submit" name="Update" value="Update"/> 
		<input type="submit" name="Delete" value="Delete"/></td></tr>
		</form>
		 <%
		}
		%>
	</table>
		<form action="/ProjectPart0/PaperServ" method="post"><tr>
		<td><input type="text" name="PapAuthorAdd" placeholder="Author">></td>
		<td><input type="text" name="PapAuthor2Add" placeholder="Author 2 (NOT REQ)">></td>
		<td><input type="text" name="PapTitleAdd" placeholder="Title">></td>
		<td><input type="text" name="PapAbstractAdd" placeholder="Abstract">></td>
		<td><input type="text" name="PapPDFAdd" placeholder="PDF">></td>
		<td><input type="submit" name="Add" value="Add New Paper"/>
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