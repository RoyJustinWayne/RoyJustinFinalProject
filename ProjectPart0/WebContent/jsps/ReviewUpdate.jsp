<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
</style>
</head>
<body>
<center>
<table border="1">
<tr>
<td>Review ID</td>
<td>Review Name</td>
<td>Review Description</td>
<td>Review Decision</td>
<td>Review Date</td>
<td>Paper ID</td>
</tr>
<%
		try {
			String URL = "jdbc:mysql://localhost:3306/sampledb";
			String USER = "john";
			String PASS = "pass1234";
			Connection connect = DriverManager.getConnection(URL, USER, PASS);
		    Statement stmt = connect.createStatement();
		    ResultSet rs; 
		    rs = stmt.executeQuery("SELECT * FROM Review"); 
		    
		    while ( rs.next() ) 
		    { %>
			<form action="/ProjectPart0/ReviewServ" method="post">
			<tr><td><input type="text" name="RevID" readonly="readonly" value="<%=rs.getString("RevID") %>"></td>
			<td><input type="text" name="RevName" value="<%=rs.getString("RevName") %>"></td>
			<td><input type="text" name="RevDescript" value="<%=rs.getString("RevDescript") %>"></td>
			<td><input type="text" name="RevDecision" value="<%=rs.getString("RevDecision") %>"></td>
			<td><input type="text" name="RevDate" value="<%=rs.getString("RevDate") %>"></td>
			<td><input type="text" name="PapID" value="<%=rs.getString("PapID") %>"></td>
			<%
			}
			%>
			</table>
			
			<p> </p>
			<form action="/ProjectPart0/ReviewServ" method="post"><tr>
			<td><input type="text" name="RevNameAdd" placeholder="Name"></td>
			<td><input type="text" name="RevDescriptAdd" placeholder="Description"></td>
			<td><input type="text" name="RevDecisionAdd" placeholder="Decision (True/False)"></td>
			<td><input type="text" name="RevDateAdd" placeholder="Date"></td>
			<td><input type="text" name="PapIDAdd" placeholder="PaperID"></td>
			<td><input type="submit" name="Add" value="Add New Review"/>
			</td></tr>
			</form>
			
			<p> </p>
			<form action="/ProjectPart0/ReviewServ" method="post">
			<input type="text" name="RevIDMod" placeholder="ID TO CHANGE">
			<input type="text" name="RevNameMod" placeholder="Name Change">
			<input type="text" name="RevDescriptMod" placeholder="Description Change">
			<input type="text" name="RevDecisionMod" placeholder="Decision Change">
			<input type="text" name="RevDateMod" placeholder="Date Change">
			<input type="text" name="PapIDMod" placeholder="Paper ID Change">
			<td><input type="submit" name="Update" value="Update"/>
			</form>
			
			
			<p> </p>
			<form action="/ProjectPart0/ReviewServ" method="post">
			<input type="text" name="RevIDDel" placeholder="RevIDDel">
			<input type="submit" name="Delete" value="Delete Review"/>
			</form>
<%
			rs.close();
			stmt.close();
			connect.close();
			}
			catch(Exception e)
			{
			e.printStackTrace();
			}
%>
	<form action="/ProjectPart0/jsps/main.jsp">
		<input type="submit" value="Homepage">
	</form>
	</center>		
</body>
</html>