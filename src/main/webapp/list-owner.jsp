
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

                });
            }
        }
        xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
        xhr.send(null);

    }
    // Printing vets
    printTable(elementId = 'vetTbl', servlet = 'list-owners', columns = ['person_id','username', 'name', 'address', 'neighborhood'],actions = ['update-owner','form-pet']);
</script>
