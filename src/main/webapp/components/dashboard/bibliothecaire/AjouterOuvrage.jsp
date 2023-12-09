<div class="mx-auto bg-white p-16 mt-14 px-4 my-4 sm:px-8 flex-1 overflow-hidden ml-64 p-4">

    <form action="AddOuvrageServlet" method="post">
        <div class="grid gap-6 mb-6 lg:grid-cols-2">
            <div>
                <label for="ref" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Reference</label>
                <input type="text" id="ref" name="ref" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>
            </div>
            <div>
                <label for="titre" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Titre</label>
                <input type="text" id="titre" name="titre" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>
            </div>
            <div>
                <label for="auteur" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Auteur</label>
                <input type="text" id="auteur" name="auteur" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>
            </div>
            <div>
                <label for="rayon" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Rayon</label>
                <input type="text" id="rayon" name="rayon" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>
            </div>
            <div>
                <label for="disponibilite" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Disponibilite</label>
                <input type="number" id="disponibilite" name="disponibilite" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>
            </div>

        </div>
        <button type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Ajouter</button>
    </form>
</div>
