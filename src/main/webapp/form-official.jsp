
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form Official</title>
</head>
<body>

<form action="./create-official">
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
    <div> Name: <input type="text" id="name" name="name"></div>

    <input type="submit" value="Save official!">
</form>

</body>
</html>

