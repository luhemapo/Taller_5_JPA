
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List Officials</title>
</head>

<style>
    table, th, td {
        border: 1px solid black;
    }
</style>

<body>

<br>
<h1>All Officials! :D</h1>

<h3>Officials</h3>


<table id="vetTbl">
    <thead>
    <tr>
        <th>Username</th>
        <th>Name</th>
        <th >Action </th>

    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

</form>
<br>
<button onclick="location.href='./index.jsp';">Back</button>

</body>
</html>

<script>
    function printTable(elementId, servlet, columns, actions = []) {

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4) {
                var data = JSON.parse(xhr.responseText);

                var tbodyRef = document.getElementById(elementId).getElementsByTagName('tbody')[0];

                data.map(d => {
                    var newRow = tbodyRef.insertRow();
                    columns.map(c => {
                        var cell = newRow.insertCell();
                        var text = document.createTextNode(d[c]);
                        cell.appendChild(text);
                    });

                    if (actions.includes('update-official')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./update-official.jsp?username=' + d['username'] + '&name=' + d['name'] + '";');
                        var text = document.createTextNode('Update Official');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }

                });
            }
        }
        xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
        xhr.send(null);

    }
    // Printing vets
    printTable(elementId = 'vetTbl', servlet = 'list-officials', columns = ['username', 'name'],actions = ['update-official']);
</script>

