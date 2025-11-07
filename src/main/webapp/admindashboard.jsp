<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
</head>
<body>
    <p>Hello Admin, ${sessionScope.user.email}</p>

    <h2>All Registered Users</h2>
    
    <c:if test="${empty sessionScope.users}">
        <p>No users found.</p>
    </c:if>

    <c:if test="${not empty sessionScope.users}">
        <table border="1" cellpadding="5" cellspacing="0">
            <tr>
                <th>S.No</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Contact Number</th>
                <th>Role</th>
            </tr>

            <c:forEach var="u" items="${sessionScope.users}">
                <tr>
                    <td>${u.sno}</td>
                    <td>${u.firstName}</td>
                    <td>${u.lastName}</td>
                    <td>${u.email}</td>
                    <td>${u.contactNumber}</td>
                    <td>${u.role}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <form action="logout" method="get" style="margin-top: 20px;">
        <button type="submit">Logout</button>
    </form>
</body>
</html>
