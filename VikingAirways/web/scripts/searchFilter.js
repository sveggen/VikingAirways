function sortTable() {
    var table, rows, switching, i, x, y, shouldSwitch, selectedFilter;
    table = document.getElementById("resultTable");
    selectedFilter = document.getElementById("selectedFilter").value;
    switching = true;

    while (switching) {
        switching = false;
        rows = table.rows;

        for(i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;

            if (selectedFilter.includes("Price")) {
                x = rows[i].getElementsByTagName("TD")[6];
                x = x.innerHTML.replace( /[^\d.]/g, '' );
                y = rows[i + 1].getElementsByTagName("TD")[6];
                y = y.innerHTML.replace( /[^\d.]/g, '' );
            } else if (selectedFilter.includes("Time")) {
                x = rows[i].getElementsByTagName("TD")[3].innerHTML;
                y = rows[i + 1].getElementsByTagName("TD")[3].innerHTML;
            }

            if (parseInt(x) > parseInt(y)) {
                shouldSwitch = true;
                break;
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
}