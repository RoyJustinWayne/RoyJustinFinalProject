<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Report Changes</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <h1>-User- Report Changes:</h1>
<p style="color: red; font-weight: 900"> ${msg}</p>
<form action="<c:url value='/ConfManagement'/>" method="post">
	<input type="hidden" name="method" value="Initialize"/>
			Report ID to Change：	<input type="text" name="username" /><br/>
			What column do you want to change (UPDATE ONLY)? <input type="password" name="password" /><br/>
			What do you want the new value to be (UPDATE ONLY)? <input type="password" name="password" /><br/>
	<button type="submit" name="button" value="InitButton">Delete</button>
	<button type="submit" name="button" value="InitButton">Update</button>
</form>

<h1>-User- Report INSERT:</h1>
<form action="<c:url value='/ConfManagement'/>" method="post">
	<input type="hidden" name="method" value="Initialize"/>
			Report Name：	<input type="text" name="username" /><br/>
			Report Description: <input type="password" name="password" /><br/>
			Report Accepted/Rejected: <input type="password" name="password" /><br/>
			Report Date: <input type="password" name="password" /><br/>
	<button type="submit" name="button" value="InitButton">Insert</button>
</form>

  </body>
</html>
