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
