<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Models.User" %>
<%
    User user = (User) session.getAttribute("userInfo");
    if (session != null && session.getAttribute("username") != null) {
        response.sendRedirect("dashboard.jsp");
    }


%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css" rel="stylesheet">
    <title>Bibliotheque</title>
</head>
<body>
<%@include file="./components/dashboard/navbar.jsp" %>
<section class="min-h-screen flex flex-col md:flex-row justify-center space-y-10 md:space-y-0 md:space-x-16 items-center my-0 mx-0 md:mx-0 md:my-0 pt-16">
    <div class="md:w-1/2 max-w-md max-md:mx-auto md:mr-16">
        <img src="./images/draw2.webp" alt="Sample image" class="w-full h-auto" />
    </div>
    <div class="md:w-1/3 max-w-sm max-md:mx-auto md:ml-16 pb-6">
        <form action="login" method="post">
            <div class="my-8 flex flex-col items-center">
                <svg class="mx-auto" fill="#1f2937" width="91px" height="91px" viewBox="0 -64 640 640" xmlns="http://www.w3.org/2000/svg">
                    <g id="SVGRepo_bgCarrier" stroke-width="0"></g>
                    <g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g>
                    <g id="SVGRepo_iconCarrier">
                        <path d="M96 224c35.3 0 64-28.7 64-64s-28.7-64-64-64-64 28.7-64 64 28.7 64 64 64zm448 0c35.3 0 64-28.7 64-64s-28.7-64-64-64-64 28.7-64 64 28.7 64 64 64zm32 32h-64c-17.6 0-33.5 7.1-45.1 18.6 40.3 22.1 68.9 62 75.1 109.4h66c17.7 0 32-14.3 32-32v-32c0-35.3-28.7-64-64-64zm-256 0c61.9 0 112-50.1 112-112S381.9 32 320 32 208 82.1 208 144s50.1 112 112 112zm76.8 32h-8.3c-20.8 10-43.9 16-68.5 16s-47.6-6-68.5-16h-8.3C179.6 288 128 339.6 128 403.2V432c0 26.5 21.5 48 48 48h288c26.5 0 48-21.5 48-48v-28.8c0-63.6-51.6-115.2-115.2-115.2zm-223.7-13.4C161.5 263.1 145.6 256 128 256H64c-35.3 0-64 28.7-64 64v32c0 17.7 14.3 32 32 32h65.9c6.3-47.4 34.9-87.3 75.2-109.4z"></path>
                    </g>
                </svg>
                <p class="mb-0 mx-auto text-center font-semibold text-slate-500 text-2xl text-gray-800">Bibliotheque Universitaire</p>
            </div>
            <%
                String error = request.getParameter("error");
                if (error != null) {
                    if (error.equals("empty")) {
            %>
            <p class="mx-auto my-4 -mt-5 error-msg bg-red-100 text-red-700 rounded p-2">Veuillez entrez vos informations.</p>
            <%
            } else if (error.equals("invalid")) {
            %>
            <p class="mx-auto my-4 -mt-5 error-msg bg-red-100 text-red-700 rounded p-2">Nom d'utilisateur ou mot de passe invalide.</p>
            <%
                    }
                }
            %>
            <input class="text-sm w-full px-4 py-2 border border-solid border-gray-300 focus:border-gray-800 rounded" name="username" type="text" placeholder="Nom d'utilisateur" />
            <input class="text-sm w-full px-4 py-2 border border-solid border-gray-300 focus:border-gray-800 rounded mt-4" name="password" type="password" placeholder="Mot de passe" />
            <div class="text-center md:text-left">
                <button class="mt-8 bg-blue-600 hover:bg-blue-700 px-6 py-3 text-white uppercase rounded text-sm tracking-wider float-right" type="submit">Connexion</button>
            </div>
        </form>
    </div>
</section>
</body>
</html>