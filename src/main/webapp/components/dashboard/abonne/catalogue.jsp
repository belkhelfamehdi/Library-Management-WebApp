<%@ page import="com.bibliotheque.UserBean" %>
<%@ page import="Models.User" %>
<%@ page import="java.util.*" %>
<%@ page import="com.bibliotheque.OuvrageBean" %>
<%@ page import="Models.Ouvrage" %>

<%
    OuvrageBean ouvrageBean = new OuvrageBean();
    List<Ouvrage> ouvrages = ouvrageBean.getOuvrages();
%>

<div class="mt-14 px-4 my-4 sm:px-8 flex-1 overflow-hidden ml-64 p-4">
    <div class="py-8">
        <div>
            <h2 class="text-2xl font-semibold leading-tight">Les ouvrages</h2>
        </div>
        <div class="my-2 flex sm:flex-row flex-col">
            <div class="block relative">
                    <span class="h-full absolute inset-y-0 left-0 flex items-center pl-2">
                        <svg viewBox="0 0 24 24" class="h-4 w-4 fill-current text-gray-500">
                            <path
                                    d="M10 4a6 6 0 100 12 6 6 0 000-12zm-8 6a8 8 0 1114.32 4.906l5.387 5.387a1 1 0 01-1.414 1.414l-5.387-5.387A8 8 0 012 10z">
                            </path>
                        </svg>
                    </span>
                <input id="searchInput" oninput="liveOuvrageSearch()" placeholder="Search"
                       class="appearance-none rounded border border-gray-400 border-b block pl-8 pr-6 py-2 w-full bg-white text-sm placeholder-gray-400 text-gray-700 focus:bg-white focus:placeholder-gray-600 focus:text-gray-700 focus:outline-none" />
            </div>
        </div>
        <div class="-mx-4 sm:-mx-8 px-4 sm:px-8 py-4 overflow-x-auto">
            <div class="inline-block min-w-full shadow rounded-lg overflow-hidden">
                <table class="min-w-full leading-normal">
                    <thead>

                    <tr>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            Ref
                        </th>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            Titre
                        </th>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            Auteur
                        </th>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            Rayon
                        </th>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            Quantite
                        </th>
                    </tr>

                    </thead>
                    <tbody id="userTableBody">
                    <% for (Ouvrage ouvrage : ouvrages) { %>
                    <tr class="border-b border-gray-200">
                        <td class="px-5 py-5 bg-white text-sm">
                            <p class="text-gray-900 whitespace-no-wrap">
                                <%= ouvrage.getRef() %>
                            </p>
                        </td>
                        <td class="px-5 py-5 bg-white text-sm">
                            <p class="text-gray-900 whitespace-no-wrap"><%= ouvrage.getTitre() %></p>
                        </td>
                        <td class="px-5 py-5 bg-white text-sm">
                            <p class="capitalize text-gray-900 whitespace-no-wrap">
                                <%= ouvrage.getAuteur() %>
                            </p>
                        </td>
                        <td class="px-5 py-5 bg-white text-sm">
                            <p class="capitalize text-gray-900 whitespace-no-wrap">
                                <%= ouvrage.getRayon() %>
                            </p>
                        </td>
                        <td class="px-5 py-5 bg-white text-sm">
                            <p class="text-gray-900 whitespace-no-wrap">
                                <%= ouvrage.getDisponibilite() %>
                            </p>
                        </td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
