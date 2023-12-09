
function livePenaliserSearch() {
    var input = document.getElementById('searchInput').value;
    var filter = document.getElementById('filter').value;

    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'SearchPenaliserServlet?query=' + input + '&filter=' + filter, true);

    xhr.onload = function () {
        if (xhr.status == 200) {
            document.getElementById('userTableBody').innerHTML = xhr.responseText;
        }
    };

    xhr.send();
}
function liveOuvrageSearch() {
    var input = document.getElementById('searchInput').value;

    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'SearchOuvrageServlet?query=' + input, true);

    xhr.onload = function () {
        if (xhr.status == 200) {
            document.getElementById('userTableBody').innerHTML = xhr.responseText;
        }
    };

    xhr.send();
}
function liveOuvrageSearch1() {
    var input = document.getElementById('searchInput1').value;

    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'SearchOuvrageServlet?query=' + input, true);

    xhr.onload = function () {
        if (xhr.status == 200) {
            document.getElementById('userTableBody1').innerHTML = xhr.responseText;
        }
    };

    xhr.send();
}

function handleCheckboxChange(checkbox) {
    var selectedUsers = document.querySelectorAll('input[name="selectedUsers"]:checked');
    var selectedOuvrages = document.querySelectorAll('input[name="selectedOuvrages"]:checked');

    // Disable other user checkboxes if one is selected
    if (checkbox.name === 'selectedUsers' && selectedUsers.length > 1) {
        checkbox.checked = false;
        alert('You can only select one user.');
        return;
    }

    // Disable other ouvrage checkboxes if three are selected
    if (checkbox.name === 'selectedOuvrages' && selectedOuvrages.length > 3) {
        checkbox.checked = false;
        alert('You can only select up to three ouvrages.');
        return;
    }
}

function addEmprunt() {
    var selectedUsers = document.querySelectorAll('input[name="selectedUsers"]:checked');
    var selectedOuvrages = document.querySelectorAll('input[name="selectedOuvrages"]:checked');

    var userValues = Array.from(selectedUsers).map(userCheckbox => userCheckbox.value).join(',');
    var ouvrageValues = Array.from(selectedOuvrages).map(ouvrageCheckbox => ouvrageCheckbox.value).join(',');

    console.log('Selected Users:', userValues);
    console.log('Selected Ouvrages:', ouvrageValues);

    var hiddenForm = document.createElement('form');
    hiddenForm.method = 'post';
    hiddenForm.action = 'EmpruntServlet';

    var userInput = document.createElement('input');
    userInput.type = 'hidden';
    userInput.name = 'selectedUsers';
    userInput.value = userValues;

    var ouvrageInput = document.createElement('input');
    ouvrageInput.type = 'hidden';
    ouvrageInput.name = 'selectedOuvrages';
    ouvrageInput.value = ouvrageValues;

    hiddenForm.appendChild(userInput);
    hiddenForm.appendChild(ouvrageInput);

    document.body.appendChild(hiddenForm);

    hiddenForm.submit();
}

function liveSearch() {
    var input = document.getElementById('searchInput').value;
    var filter = document.getElementById('filter').value;

    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'SearchServlet?query=' + input + '&filter=' + filter, true);

    xhr.onload = function () {
        if (xhr.status == 200) {
            document.getElementById('userTableBody').innerHTML = xhr.responseText;
        }
    };

    xhr.send();
}

function loadComponent(component) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("root").innerHTML = this.responseText;
            sessionStorage.setItem('currentComponent', component);
        }
    };
    xhttp.open("GET", component, true);
    xhttp.send();
}


function disconnect() {
    sessionStorage.setItem('currentComponent', '../components/dashboard/home.jsp');
}
function loadLastComponent() {
    var lastComponent = sessionStorage.getItem('currentComponent');
    if (lastComponent) {
        loadComponent(lastComponent);
    }
}



// JavaScript to handle modal
function openDetailsModal(ref, titre, auteur, rayon, disponibilite) {
    const modal = document.getElementById('detailsModal');
    const content = document.getElementById('window')
    const modalContent = document.getElementById('modalContent');

    // Populate modal content with details
    modalContent.innerHTML = `
        <h2 class="text-2xl font-semibold mb-4">${titre}</h2>
        <p><strong>Référence:</strong> ${ref}</p>
        <p><strong>Auteur:</strong> ${auteur}</p>
        <p><strong>Rayon:</strong> ${rayon}</p>
        <p><strong>Disponibilité:</strong> ${disponibilite}</p>
    `;

    // Show the modal with animation
    modal.classList.remove('hidden');
    modal.classList.add('scale-100');
    content.classList.remove('scale-0')
}

function openUserModal(id, nom, prenom, dateN, role, statut) {
    const modal = document.getElementById('detailsModal');
    const content = document.getElementById('window')
    const modalContent = document.getElementById('modalContent');

    // Populate modal content with details
    modalContent.innerHTML = `
        <h2 class="text-2xl font-semibold mb-4">${nom} ${prenom}</h2>
        <p><strong>id:</strong> ${id}</p>
        <p><strong>Date de naissance:</strong> ${dateN}</p>
        <p><strong>Role:</strong> ${role}</p>
        <p><strong>Statut:</strong> ${statut}</p>
    `;

    // Show the modal with animation
    modal.classList.remove('hidden');
    modal.classList.add('scale-100');
    content.classList.remove('scale-0')
}

function closeDetailsModal() {
    const modal = document.getElementById('detailsModal');
    const content = document.getElementById('window')
    // Hide the modal with animation
    modal.classList.remove('scale-100');
    modal.classList.add('scale-0');
    content.classList.add('scale-0');

    setTimeout(() => {
        modal.classList.add('hidden');
    }, 200);
}

window.onload = loadLastComponent;


function openModifyOuvrageModal(ref, titre, auteur, rayon, disponibilite) {
    const modal = document.getElementById('modifyOuvrageModal');
    const content = document.getElementById('window');
    const modalContent = document.getElementById('modalContentouvrage');

    // Populate modal content with details
    modalContent.innerHTML = `
            <form action="UpdateOuvrageServlet" method="post">
                <label for="ref" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Reference</label>
                <input type="text" id="ref" name="ref" value="${ref}" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>

                <label for="titre" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Titre</label>
                <input type="text" id="titre" name="titre" value="${titre}" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>

                <label for="auteur" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Auteur</label>
                <input type="text" id="auteur" name="auteur" value="${auteur}" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>

                            <label for="rayon" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Rayon</label>
            <input type="text" id="rayon" name="rayon" value="${rayon}" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>

            <label for="disponibilite" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Disponibilite</label>
            <input type="number" id="disponibilite" name="disponibilite" value="${disponibilite}" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>

                <button type="submit" class="text-white my-2 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Modifier</button>
            </form>
                <button onclick="closeModifyOuvrageModal()" class="absolute top-0 right-0 p-4 text-gray-500 hover:text-gray-700">
                    <svg class="h-5 w-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12"></path>
                    </svg>
                </button>
        `;

    modal.classList.remove('hidden');
    modal.classList.add('scale-100');
    content.classList.remove('scale-0');
}

function openModifyUserModal(id, fname, lname, birthDate, status, role) {
    const modal = document.getElementById('modifyUserModal');
    const content = document.getElementById('window');
    const modalContent = document.getElementById('modalContentuser');

    modalContent.innerHTML = `
        <form action="UpdateUserServlet" method="post">
            <label for="userId" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">User ID</label>
            <input type="text" id="userId" name="userId" value="${id}" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>

            <label for="fname" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">First Name</label>
            <input type="text" id="fname" name="fname" value="${fname}" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>

            <label for="lname" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Last Name</label>
            <input type="text" id="lname" name="lname" value="${lname}" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>

            <label for="birthDate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Birth Date</label>
            <input type="text" id="birthDate" name="birthDate" value="${birthDate}" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>

            <label for="status" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Status</label>
            <input type="text" id="status" name="status" value="${status}" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>

            <label for="role" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Role</label>
            <input type="text" id="role" name="role" value="${role}" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>

            <button type="submit" class="text-white my-2 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Modifier</button>
        </form>
        <button onclick="closeModifyUserModal()" class="absolute top-0 right-0 p-4 text-gray-500 hover:text-gray-700">
            <svg class="h-5 w-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12"></path>
            </svg>
        </button>
    `;

    // Show the modal with animation
    modal.classList.remove('hidden');
    modal.classList.add('scale-100');
    content.classList.remove('scale-0');
}


function closeModifyOuvrageModal() {
    const modal = document.getElementById('modifyOuvrageModal');
    const content = document.getElementById('window');
    // Hide the modal with animation
    modal.classList.remove('scale-100');
    modal.classList.add('scale-0');
    content.classList.add('scale-0');

    setTimeout(() => {
        modal.classList.add('hidden');
    }, 200);
}
function closeModifyUserModal() {
    const modal = document.getElementById('modifyUserModal');
    const content = document.getElementById('window');
    // Hide the modal with animation
    modal.classList.remove('scale-100');
    modal.classList.add('scale-0');
    content.classList.add('scale-0');

    setTimeout(() => {
        modal.classList.add('hidden');
    }, 200);
}