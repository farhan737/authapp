<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dashboard page</title>
</head>
<body>
	<p>hello, ${sessionScope.user.email}</p>
	<form action="logout" method="get">
		<button type="submit">Logout</button>
	</form>
</body>
</html>