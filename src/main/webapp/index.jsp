<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>JSP Tutorial</title>

        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>

        <h1>Base de datos Ciudadanos de 4 Patas! :D</h1>

        <button onclick="location.href='./form-vet.jsp';">Create Vet</button>
        <button onclick="location.href='./form-owner.jsp';">Create Owner</button>
        <button onclick="location.href='./form-official.jsp';">Create Official</button>

        <h3>Usuarios</h3>

        <table id="usersappTbl">
            <thead>
            <tr>
                <th>Username</th>
                <th>Email</th>
                <th>Role</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>

        <br>
        <button onclick="location.href='./list-vet.jsp';">Show Vets</button>
        <button onclick="location.href='./list-owner.jsp';">Show Owners</button>
        <button onclick="location.href='./list-official.jsp';">Show Officials</button>

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

                            if (actions.includes('create-book')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-book.jsp?authorId=' + d['authorId'] + '";');
                                var text = document.createTextNode('Create book');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('delete-author')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./delete-author?authorId=' + d['authorId'] + '";');
                                var text = document.createTextNode('Delete author');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                        });

                    }
                }
                xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
                xhr.send(null);

            }

            // Printing libraries
            printTable(elementId = 'librariesTbl', servlet = 'list-libraries', columns = ['libraryId', 'name']);

            // Printing authors
            printTable(elementId = 'authorsTbl', servlet = 'list-authors', columns = ['authorId', 'name', 'numBooks'], actions = ['create-book', 'delete-author']);

            // Printing users
            printTable(elementId = 'usersappTbl', servlet = 'list-usersapp', columns = ['username', 'email', 'role']);



        </script>

    </body>
</html>