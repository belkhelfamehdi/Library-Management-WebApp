<%@ page import="java.util.*" %>
<%@ page import="Models.Emprunt" %>
<%@ page import="com.bibliotheque.EmpruntBean" %>

<%
    EmpruntBean empruntBean = new EmpruntBean();
    List<Emprunt> emprunts = empruntBean.getEmprunts();
%>

<div class="mt-14 px-4 my-4 sm:px-8 flex-1 overflow-hidden ml-64 p-4">
    <div class="py-8">
        <div>
            <h2 class="text-2xl font-semibold leading-tight">Les ouvrages</h2>
        </div>
        <div class="my-2 flex sm:flex-row flex-col">
            <div class="block relative ml-auto">
                <button id="ajouterButton" onclick="loadComponent('./components/dashboard/bibliothecaire/AddEmprunt.jsp')" type="button" class="text-blue-700 hover:text-white border border-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2 text-center me-2 dark:border-blue-500 dark:text-blue-500 dark:hover:text-white dark:hover:bg-blue-500 dark:focus:ring-blue-800 transition-all duration-300 ease-in-out">
                    Ajouter
                </button>
            </div>
        </div>
        <div class="-mx-4 sm:-mx-8 px-4 sm:px-8 py-4 overflow-x-auto">
            <div class="inline-block min-w-full shadow rounded-lg overflow-hidden">        <table class="min-w-full leading-normal">
                <thead>
                <tr>
                    <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">ID</th>
                    <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Abonnée ID</th>
                    <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Ouvrage Ref</th>
                    <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Date Emprunt</th>
                    <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Date Limit</th>
                    <!-- Add more columns as needed -->
                </tr>
                </thead>
                <tbody id="userTableBody">
                <% for (Emprunt emprunt : emprunts) { %>
                <tr class="border-b border-gray-200">
                    <td class="px-5 py-5 bg-white text-sm">
                        <p class="text-gray-900 whitespace-no-wrap"><%= emprunt.getId() %></p>
                    </td>
                    <td class="px-5 py-5 bg-white text-sm">
                        <p class="text-gray-900 whitespace-no-wrap"><%= emprunt.getIdAbonnee() %></p>
                    </td>
                    <td class="px-5 py-5 bg-white text-sm">
                        <p class="text-gray-900 whitespace-no-wrap"><%= emprunt.getRefOuvrage() %></p>
                    </td>
                    <td class="px-5 py-5 bg-white text-sm">
                        <p class="text-gray-900 whitespace-no-wrap"><%= emprunt.getDateEmprunt() %></p>
                    </td>
                    <td class="px-5 py-5 bg-white text-sm">
                        <p class="text-gray-900 whitespace-no-wrap"><%= emprunt.getDateLimit() %></p>
                    </td>
                    <!-- Add more cells as needed -->
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

                    <div id="modifyOuvrageModal" class="hidden fixed inset-0 bg-black bg-opacity-50 overflow-y-auto h-full w-full z-50">
                        <div id="modalContentouvrage" class="relative p-8 bg-white max-w-2xl mx-auto mt-36 rounded-md">
                            <form action="UpdateOuvrageServlet" method="post">
                                <button type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Modifier</button>
                            </form>
                        </div>
                    </div>
                </table>
            </div>
        </div>
    </div>
</div>
