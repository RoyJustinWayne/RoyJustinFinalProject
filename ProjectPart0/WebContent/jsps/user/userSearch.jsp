<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Search Functionalities</title>
   
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
  <h1>-User- Single Author Search:</h1>
<p style="color: red; font-weight: 900"> ${msg}</p>
<form action="<c:url value='/ConfManagement'/>" method="post">
	<input type="hidden" name="method" value="Initialize"/>
			Name to search：	<input type="text" name="username" /><br/>
	<button type="submit" name="button" value="InitButton">Search</button>
</form>

 <h1>-User- First Author Search:</h1>
<p style="color: red; font-weight: 900"> ${msg}</p>
<form action="<c:url value='/ConfManagement'/>" method="post">
	<input type="hidden" name="method" value="Initialize"/>
			Name to search：	<input type="text" name="username" /><br/>
	<button type="submit" name="button" value="InitButton">Search</button>
</form>

 <h1>-User- Co-Author Search:</h1>
<p style="color: red; font-weight: 900"> ${msg}</p>
<form action="<c:url value='/ConfManagement'/>" method="post">
	<input type="hidden" name="method" value="Initialize"/>
	<button type="submit" name="button" value="InitButton">Search</button>
</form>

 <h1>-User- PC Most Reviewed Search:</h1>
<p style="color: red; font-weight: 900"> ${msg}</p>
<form action="<c:url value='/ConfManagement'/>" method="post">
	<input type="hidden" name="method" value="Initialize"/>
	<button type="submit" name="button" value="InitButton">Search</button>
</form>

 <h1>-User- PC NOT Reviewing Search:</h1>
<p style="color: red; font-weight: 900"> ${msg}</p>
<form action="<c:url value='/ConfManagement'/>" method="post">
	<input type="hidden" name="method" value="Initialize"/>
	<button type="submit" name="button" value="InitButton">Search</button>
</form>

<h1>-User- Paper Rejected By:</h1>
<p style="color: red; font-weight: 900"> ${msg}</p>
<form action="<c:url value='/ConfManagement'/>" method="post">
	<input type="hidden" name="method" value="Initialize"/>
		Name to search (Required)：	<input type="text" name="username" /><br/>
		Name to search (Required)：	<input type="text" name="username" /><br/>
	<button type="submit" name="button" value="InitButton">Search</button>
</form>

<h1>-User- All Accepted Paper:</h1>
<p style="color: red; font-weight: 900"> ${msg}</p>
<form action="<c:url value='/ConfManagement'/>" method="post">
	<input type="hidden" name="method" value="Initialize"/>
	<button type="submit" name="button" value="InitButton">Search</button>
</form>


  </body>
</html>
