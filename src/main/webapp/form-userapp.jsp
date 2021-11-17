
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create User</title>
</head>
<body>

<form action="./create-userapp">
        <h1>Base de datos Ciudadanos de 4 Patas! :D</h1>
        <div>
            Username: <input type="text" id="username" name="username" required>
        </div>
        <div>
            Password:  <input type="password" id="password" name="password" required>
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div>
            <label for="role">Choose role:</label>
            <select name="role" id="role">
                <option value="official">Official</option>
                <option value="owner">Owner</option>
                <option value="vet">Vet</option>
            </select>
        </div>

    <input type="submit" value="Save User!">
</form>

</body>
</html>
