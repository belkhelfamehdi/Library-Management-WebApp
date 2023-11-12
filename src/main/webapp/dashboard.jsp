<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    String userType = (String) session.getAttribute("userType");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<h1>Welcome, <%= userType %>!</h1>
<form action="logout" method="post">
    <input type="submit" value="Disconnect" />
</form>
</body>
</html>