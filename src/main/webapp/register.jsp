<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register user</title>
</head>
	<body>
		<c:if test="${requestScope.status == 'success'}">
    		<p style="color: green;">User registered successfully!</p>
		</c:if>
		<c:if test="${requestScope.status == 'failed'}">
    		<p style="color: red;">Registration failed!</p>
		</c:if>

		<form method="post" action="register" name="registration">
			<input type="text" name="firstName" placeholder="enter firstname">
			<input type="text" name="lastName" placeholder="enter lastname">
			<input type="email" name="email" placeholder="enter email address">
			<input type="number" name="contactNumber" placeholder="enter phone number">
			<input type="password" name="password" placeholder="enter password">
			<button>register</button>
		</form>
		<button onclick="window.location.href='index.jsp'">go back</button>
	</body>
</html>