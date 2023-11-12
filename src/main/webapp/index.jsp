<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
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
<header class="bg-gray-800 text-white fixed w-full top-0 z-50">
    <div class="max-w-7xl mx-auto flex items-center justify-between py-4 px-6">
        <div class="flex items-center">
            <svg class="h-8 w-auto mr-4" height="32px" width="32px" version="1.1" id="_x32_" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 512.00 512.00" xml:space="preserve" fill="#ffffff" stroke="#ffffff" stroke-width="0.00512"><g id="SVGRepo_bgCarrier" stroke-width="0"></g><g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g><g id="SVGRepo_iconCarrier"> <style type="text/css"> .st0{fill:#ffffff;} </style> <g> <polygon class="st0" points="1.914,293.73 1.914,293.714 1.897,293.657 "></polygon> <path class="st0" d="M10.027,313.061l-0.12-0.145c-0.008-0.008-0.008-0.008-0.008-0.008L10.027,313.061z"></path> <path class="st0" d="M10.027,223.738l-0.12-0.145c-0.008,0-0.008,0-0.008,0L10.027,223.738z"></path> <path class="st0" d="M1.914,204.423c0,0,0-0.024-0.008-0.04l-0.008-0.024L1.914,204.423z"></path> <path class="st0" d="M512,204.688c0.008-2.275-0.435-4.479-1.15-6.569c0.7-1.93,1.07-3.876,1.078-5.758 c0.016-2.96-0.805-5.822-2.05-8.122l-0.04-0.072c-0.378-0.691-0.893-1.423-1.464-2.155v-55.268 c2.268-3.257,3.619-7.173,3.627-11.378c0-8.138-4.905-15.448-12.408-18.527l-185.36-77.446h-0.539 c-3.892-1.367-7.928-2.187-12.022-2.187c-3.996,0-8.001,0.78-11.852,2.106h-0.482L17.667,128.786l-0.676,0.378l0.016,0.024 c-3.466,1.825-6.031,4.358-7.8,6.81c-3.095,4.302-4.679,8.838-5.83,12.955l-0.008,0.056c-1.728,6.393-2.452,12.882-2.894,18.375 l-0.008,0.048c-0.41,5.516-0.434,10.18-0.466,12.095v0.048v1.022c0.008,6.698,0.378,15.406,1.906,23.786l0.024,0.089 c0.805,4.213,1.938,8.491,3.869,12.657l0.032,0.064l0.007,0.016c0.982,2.051,2.26,4.246,4.029,6.337l0.04,0.048 c0.128,0.153,0.314,0.29,0.459,0.435c-0.37,0.434-0.853,0.852-1.159,1.294c-3.104,4.294-4.679,8.83-5.83,12.938l-0.008,0.04v0.016 c-1.728,6.393-2.452,12.89-2.894,18.382l-0.008,0.04C0.056,262.264,0.032,266.92,0,268.842v0.04v1.029 c0.008,6.707,0.378,15.416,1.914,23.803l0.016,0.064c0.805,4.222,1.938,8.508,3.869,12.673l0.039,0.072 c0.974,2.035,2.252,4.23,4.029,6.344l0.04,0.049c0.322,0.386,0.796,0.732,1.174,1.117c-0.636,0.7-1.367,1.392-1.874,2.091 c-3.104,4.302-4.679,8.838-5.83,12.938l-0.024,0.113l0.016-0.049c-1.728,6.393-2.452,12.891-2.894,18.383l-0.008,0.048 c-0.41,5.516-0.434,10.18-0.466,12.11v0.048v0.997c0.008,6.714,0.378,15.431,1.914,23.819l0.016,0.064 c0.805,4.214,1.938,8.5,3.869,12.657l0.039,0.08c0.974,2.043,2.252,4.23,4.029,6.345l-0.128-0.145l0.169,0.201 c1.696,1.97,4.028,3.876,6.94,5.299l-0.032,0.048l0.056,0.032l0.41,0.233l199.948,82.52l0.458,0.193 c4.431,1.81,9.143,2.734,13.879,2.734c4.648,0,9.304-0.892,13.694-2.686l255.907-103.99v-0.008c2.951-1.19,5.734-3.128,7.865-6.24 l0.008,0.008c0,0,0.008-0.024,0.016-0.04c0.008-0.008,0.016-0.008,0.024-0.024h-0.008c2.018-3.056,2.838-6.272,2.855-9.328 c0.016-2.96-0.805-5.822-2.05-8.122l-0.04-0.072v0.008c-0.378-0.692-0.893-1.431-1.464-2.163v-55.26 c2.268-3.257,3.619-7.189,3.627-11.386c0.008-2.541-0.531-5.01-1.44-7.318c0.917-2.171,1.359-4.382,1.367-6.498 c0.016-2.967-0.805-5.813-2.05-8.13l-0.04-0.072c-0.378-0.684-0.893-1.424-1.464-2.156v-55.252 C510.64,212.802,511.992,208.877,512,204.688z M216.272,469.136L25.852,390.539l-0.716-0.836c-0.595-0.925-1.358-2.686-1.97-4.873 c-0.948-3.273-1.6-7.535-1.994-11.845c-0.394-4.302-0.531-8.636-0.531-12.271v-0.86c0.032-2.806,0.136-10.928,1.294-18.568 c0.547-3.812,1.392-7.487,2.436-10.092l0.218-0.474l191.681,77.76V469.136z M216.272,378.324L43.005,306.789l-17.152-7.06 l-0.716-0.836c-0.595-0.933-1.358-2.686-1.97-4.866c-0.948-3.289-1.6-7.543-1.994-11.852c-0.394-4.302-0.531-8.636-0.531-12.264 v-0.868c0.032-2.814,0.136-10.928,1.294-18.576c0.547-3.804,1.392-7.487,2.436-10.084l0.218-0.474l191.681,77.759V378.324z M216.272,233.291v3.682v52.036l-175.108-72.3l-15.311-6.297l-0.716-0.844c-0.595-0.925-1.358-2.686-1.97-4.856 c-0.948-3.282-1.6-7.535-1.994-11.854c-0.394-4.31-0.531-8.636-0.531-12.262v-0.869c0.032-2.806,0.136-10.928,1.294-18.568 c0.547-3.812,1.392-7.486,2.436-10.092l0.218-0.466l191.681,77.752V233.291z M487.731,371.313L238.16,472.706l-0.66,0.297 c-1.922,0.756-3.924,1.15-5.934,1.15c-0.716,0-1.447-0.105-2.155-0.217v-61.412c0.941,0.105,1.914,0.161,2.855,0.161 c3.756,0,7.519-0.74,11.033-2.187l0.241-0.104l244.192-99.664V371.313z M487.731,280.156v0.338L238.16,381.895l-0.66,0.29 c-1.922,0.764-3.924,1.15-5.934,1.15c-0.716,0-1.447-0.104-2.155-0.201v-61.42c0.941,0.104,1.914,0.161,2.855,0.161 c3.756,0,7.519-0.74,11.033-2.18l0.241-0.112l171.272-69.896l72.919-29.77V280.156z M487.731,189.345v1.841L238.16,292.58 l-0.66,0.289c-1.922,0.764-3.924,1.158-5.934,1.158c-0.716,0-1.447-0.105-2.155-0.208v-56.145v-5.283 c0.941,0.113,1.914,0.16,2.855,0.16c3.756,0,7.519-0.731,11.033-2.17l0.241-0.105l244.192-99.672V189.345z"></path> <polygon class="st0" points="1.914,384.549 1.914,384.533 1.897,384.484 "></polygon> </g> </g></svg>
            <span class="text-lg font-semibold">Bibliotheque Universitaire</span>
        </div>
        <button class="md:hidden focus:outline-none">
            <svg class="h-6 w-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16m-7 6h7"></path>
            </svg>
        </button>
    </div>
</header>
<section class="min-h-screen flex flex-col md:flex-row justify-center space-y-10 md:space-y-0 md:space-x-16 items-center my-0 mx-0 md:mx-0 md:my-0 pt-16">
    <div class="md:w-1/2 max-w-md mr-16">
        <img src="./images/draw2.webp" alt="Sample image" class="w-full h-auto" />
    </div>
    <div class="md:w-1/3 max-w-sm ml-16 pb-6">
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