<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.bibliotheque.UserBean" %>
<%@ page import="Models.User" %>
<%@ page import="java.util.*" %>
<%
    User user = (User) session.getAttribute("userInfo");
    UserBean userBean = new UserBean();
    List<User> users = userBean.getUsers();
%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css" rel="stylesheet">
    <title>Dashboard</title>
</head>
<body>
<%@include file="components/dashboard/navbar.jsp" %>
<div id="root"></div>
<script src="js/main.js"></script>
<script rel="preload" src="https://cdn.jsdelivr.net/npm/alpinejs@2.8.2/dist/alpine.js" defer></script>
</body>
</html>
