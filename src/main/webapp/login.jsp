<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
</head>
<body>
	<c:if test="${authenticated == 'false'}">
    	<p style="color:red">Invalid email or password</p>
	</c:if>
	
	<form method="post" action="login" name="login">
		<input type="email" name="email" placeholder="enter email address">
		<input type="password" name="password" placeholder="enter password">
		<button>login</button>
	</form>
	<button onclick="window.location.href='index.jsp'">go back</button>
</body>
</html>