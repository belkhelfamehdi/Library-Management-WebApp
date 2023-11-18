<%@ page import="Models.User" %><%
    User user = (User) session.getAttribute("userInfo");
%>
<div class="mt-14 px-4 my-4 sm:px-8 flex-1 overflow-hidden ml-64 p-4">
    <div class="bg-white p-8 rounded-lg shadow-lg w-full w-full">
        <h1 class="text-3xl font-semibold my-auto text-gray-800">Bienvenue, <span class="capitalize"><%= user.getFname() %> <%= user.getLname() %></span></h1>
    </div>
</div>