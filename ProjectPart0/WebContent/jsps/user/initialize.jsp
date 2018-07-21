<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Initialize Database</title>
    
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
  <h1>Initialize Database:</h1>
<p style="color: red; font-weight: 900"> ${msg}</p>
<form action="<c:url value='/ConfManagement'/>" method="post">
	<button type="submit" name="button" value="InitButton">Initialize</button>
</form>



<h1>Assign reviewers to paper.</h1>
<p style="color: red; font-weight: 900"> ${msg}</p>
<form action="${pageContext.request.contextPath}/ConfManagement" method="post">
	<input type="hidden" name="method" value="Initialize"/>
		Reviewer：	<input type="text" name="username1" /><br/>
		Reviewer：	<input type="text" name="username2" /><br/>
		Reviewer：	<input type="text" name="username3" /><br/>
		PaperID：	<input type="text" name="username3" /><br/>
	<button type="submit" name="button" value="ReviewButton">Submit</button>
</form>
  </body>
</html>
