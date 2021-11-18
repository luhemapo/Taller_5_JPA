
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List Owners</title>
</head>

<style>
    table, th, td {
        border: 1px solid black;
    }
</style>

<body>

<br>
<h1>All Owners! :D</h1>

<h3>Owners</h3>


<table id="vetTbl">
    <thead>
    <tr>
        <th>Person Id</th>
        <th>Username</th>
        <th>Name</th>
        <th>Address</th>
        <th >Neighborhood </th>
        <th colspan="2">Action </th>

    </tr>
    </thead>
    <tbody>
    </tbody>
</table>


<h3>Pets</h3>


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
        <th colspan="2">Action </th>

    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

<h3>Petcases</h3>

<table id="caseTbl">
    <thead>
    <tr>
        <th>Pet Case</th>
        <th>Created date</th>
        <th>Type</th>
        <th>Description</th>
        <th>Pet Id</th>

    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

<h3>Visits</h3>

<table id="visitTbl">
    <thead>
    <tr>
        <th>Visit Id</th>
        <th>Created Date</th>
        <th>Type</th>
        <th>Description</th>
        <th>Vet Id</th>
        <th>Pet Id</th>
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

                    if (actions.includes('update-owner')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./update-owner.jsp?username=' + d['username'] + '&name=' + d['name'] + '' +
                            '&address=' + d['address'] + '&neighborhood=' + d['neighborhood'] + '";');
                        var text = document.createTextNode('Update Owner');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }

                    if (actions.includes('form-pet')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./form-pet.jsp?person_id=' + d['person_id'] + '";');
                        var text = document.createTextNode('Create Pet');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }

                    if (actions.includes('update-pet')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./update-pet.jsp?pet_id=' + d['pet_id'] + '&name=' + d['name'] + '' +
                            '&species=' + d['species'] + '&race=' + d['race'] + '&size=' + d['size'] + '&sex=' + d['sex'] + '&picture=' + d['picture'] + '";');
                        var text = document.createTextNode('Update Pet');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }

                    if (actions.includes('form-petcase')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./form-petcase.jsp?pet_id=' + d['pet_id'] + '";');
                        var text = document.createTextNode('Create Petcase');
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
    printTable(elementId = 'vetTbl', servlet = 'list-owners', columns = ['person_id','username', 'name', 'address', 'neighborhood'],actions = ['update-owner','form-pet']);
    printTable(elementId = 'petTbl', servlet = 'list-pets', columns = ['pet_id','microchip', 'name', 'race', 'species', 'size', 'sex', 'picture', 'person_id'],actions = ['update-pet','form-petcase']);
    printTable(elementId = 'caseTbl', servlet = 'list-petcases', columns = ['case_id','created_at', 'type', 'description', 'pet_id']);
    // Printing Visits
    printTable(elementId = 'visitTbl', servlet = 'list-visit', columns = ['visit_id', 'created_at', 'type', 'description', 'vet_id', 'pet_id']);

</script>

