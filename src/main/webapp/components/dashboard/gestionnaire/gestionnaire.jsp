<%@ page import="com.bibliotheque.UserBean" %>
<%@ page import="Models.User" %>
<%@ page import="java.util.*" %>

<%
    UserBean userBean = new UserBean();
    List<User> users = userBean.getUsers();
%>

<div class="mt-14 px-4 my-4 sm:px-8 flex-1 overflow-hidden ml-64 p-4">
    <div class="py-8">
        <div>
            <h2 class="text-2xl font-semibold leading-tight">Utilisateurs</h2>
        </div>
        <div class="my-2 flex sm:flex-row flex-col">
            <div class="flex flex-row mb-1 sm:mb-0">
                <div class="relative">
                    <select id="filter"
                            onchange="liveSearch()"
                            class="appearance-none h-full rounded border sm:rounded-r-none sm:border-r-0 border-r border-b block appearance-none w-full bg-white border-gray-400 text-gray-700 py-2 px-4 pr-8 leading-tight focus:outline-none focus:border-l focus:border-r focus:bg-white focus:border-gray-500">
                        <option>All</option>
                        <option>Etudiant</option>
                        <option>Enseignant</option>
                    </select>
                    <div
                            class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700">
                        <svg class="fill-current h-4 w-4" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                            <path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z" />
                        </svg>
                    </div>
                </div>
            </div>
            <div class="block relative">
                    <span class="h-full absolute inset-y-0 left-0 flex items-center pl-2">
                        <svg viewBox="0 0 24 24" class="h-4 w-4 fill-current text-gray-500">
                            <path
                                    d="M10 4a6 6 0 100 12 6 6 0 000-12zm-8 6a8 8 0 1114.32 4.906l5.387 5.387a1 1 0 01-1.414 1.414l-5.387-5.387A8 8 0 012 10z">
                            </path>
                        </svg>
                    </span>
                <input id="searchInput" oninput="liveSearch()" placeholder="Search"
                       class="appearance-none rounded-r rounded-l sm:rounded-l-none border border-gray-400 border-b block pl-8 pr-6 py-2 w-full bg-white text-sm placeholder-gray-400 text-gray-700 focus:bg-white focus:placeholder-gray-600 focus:text-gray-700 focus:outline-none" />
            </div>
            <div class="block relative ml-auto">
                <button id="ajouterButton" onclick="loadComponent('./components/dashboard/gestionnaire/ajouterAbonnee.jsp')" type="button" class="text-blue-700 hover:text-white border border-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2 text-center me-2 dark:border-blue-500 dark:text-blue-500 dark:hover:text-white dark:hover:bg-blue-500 dark:focus:ring-blue-800 transition-all duration-300 ease-in-out">
                    Ajouter
                </button>
            </div>
        </div>
        <div class="-mx-4 sm:-mx-8 px-4 sm:px-8 py-4 overflow-x-auto">
            <div class="inline-block min-w-full shadow rounded-lg overflow-hidden">
                <table class="min-w-full leading-normal">
                    <thead>

                    <tr>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            User
                        </th>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">

                        </th>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            Date de naissance
                        </th>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            Role
                        </th>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            Statut
                        </th>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            Action
                        </th>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">

                        </th>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">

                        </th>
                    </tr>

                    </thead>
                    <tbody id="userTableBody">
                    <% for (User usr : users) { %>
                    <tr class="border-b border-gray-200">
                        <td class="px-5 py-5 bg-white text-sm">
                            <div class="flex items-center">
                                <div class="flex-shrink-0 w-11 h-10">
                                    <img class="w-full h-full rounded-full"
                                         src="../../../images/user.png"
                                         alt="" />
                                </div>
                                <div class="ml-3">
                                    <p class="capitalize text-gray-900 whitespace-no-wrap">
                                        <td><%= usr.getFname()%> <%= usr.getLname()%></td>
                                    </p>
                                </div>
                            </div>
                        </td>
                        <td class="px-5 py-5 bg-white text-sm">
                            <p class="text-gray-900 whitespace-no-wrap">
                                <%= usr.getBirthDate() %>
                            </p>
                        </td>
                        <td class="px-5 py-5 bg-white text-sm">
                            <p class="text-gray-900 whitespace-no-wrap"><%= usr.getRole() %></p>
                        </td>
                        <td class="px-5 py-5 bg-white text-sm">
                            <p class="capitalize text-gray-900 whitespace-no-wrap">
                                <%= usr.getStatus() %>
                            </p>
                        </td>
                        <td class="px-5 py-5 bg-white text-sm">
                            <button onclick="openUserModal('<%= usr.getId() %>', '<%= usr.getFname() %>', '<%= usr.getLname() %>', '<%= usr.getBirthDate() %>', '<%= usr.getRole() %>', '<%= usr.getStatus() %>')"
                                    class="text-blue-700 hover:text-blue-900">
                                Consulter
                            </button>
                        </td>
                        <td class="px-5 py-5 bg-white text-sm">
                            <button onclick="openModifyUserModal('<%= usr.getId() %>' ,'<%= usr.getFname() %>', '<%= usr.getLname() %>', '<%= usr.getBirthDate() %>', '<%= usr.getStatus() %>', '<%= usr.getRole() %>')"
                                    class="text-green-700 hover:text-green-900">
                                Modifier
                            </button>
                        </td>
                        <td class="px-5 py-5 bg-white text-sm">
                            <a href="DeleteUserServlet?id=<%= usr.getId() %>"
                               class="text-red-700 hover:text-red-900">
                                Supprimer
                            </a>
                        </td>
                    </tr>
                    <% } %>
                    </tbody>
                    <div id="detailsModal" class="hidden fixed inset-0 bg-black bg-opacity-50 overflow-y-auto h-full w-full z-50">
                        <div id="window" class="relative p-8 bg-white max-w-2xl mx-auto mt-36 rounded-md transform scale-0 transition-transform shadow-lg">
                            <div id="modalContent" class="text-left">
                            </div>
                            <button onclick="closeDetailsModal()" class="absolute top-0 right-0 p-4 text-gray-500 hover:text-gray-700">
                                <svg class="h-5 w-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12"></path>
                                </svg>
                            </button>
                        </div>
                    </div>

                    <div id="modifyUserModal" class="hidden fixed inset-0 bg-black bg-opacity-50 overflow-y-auto h-full w-full z-50">
                        <div id="modalContentuser" class="relative p-8 bg-white max-w-2xl mx-auto mt-36 rounded-md">
                            <form action="UpdateUserServlet" method="post">
                                <button type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Modifier</button>
                            </form>
                        </div>
                    </div>
                </table>
            </div>
        </div>
    </div>
</div>

