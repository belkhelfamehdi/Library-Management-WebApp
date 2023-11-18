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
function liveSanctionSearch() {
    var input = document.getElementById('searchInput').value;
    var filter = document.getElementById('filter').value;

    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'SearchSanctionServlet?query=' + input + '&filter=' + filter, true);

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


window.onload = loadLastComponent;
