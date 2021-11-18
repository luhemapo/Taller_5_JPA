
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List Pets</title>
</head>

<style>
    table, th, td {
        border: 1px solid black;
    }
</style>

<body>

<br>
<h1>Create Visit! :D</h1>

<h3>Pets</h3>

<input type="text" id="vet_id" name="vet_id" hidden value ="<%= request.getParameter("vet_id") %>">

<table id="petTbl">
    <thead>
    <tr>
        <th>Pet Id</th>
        <th>Microchip</th>
        <th>Name</th>
        <th>Race</th>
        <th>Species</th>
        <th>Size</th>
        <th>Sex</th>
        <th>Picture</th>
        <th>Person Id</th>
        <th>Action </th>

    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

</form>
<br>
<button onclick="location.href='./list-vet.jsp';">Back</button>
</body>
</html>

<script>
    function printTable(elementId, servlet, columns, actions = []) {

        var xhr = new XMLHttpRequest();
        var vet_id = document.getElementById("vet_id").value;
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

                    if (actions.includes('form-visit')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');

                        action.setAttribute('onclick', 'location.href="./form-visit.jsp?pet_id=' + d['pet_id']  + '&vet_id=' + vet_id  + '";');
                        var text = document.createTextNode('Create Appointment');
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
    printTable(elementId = 'petTbl', servlet = 'list-pets', columns = ['pet_id','microchip', 'name', 'race', 'species', 'size', 'sex', 'picture', 'person_id'],actions = ['form-visit']);

</script>

