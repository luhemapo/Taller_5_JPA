
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Visit</title>
</head>
<body>

<form action="./create-visit">
        <h1>Create Visit! :D</h1>
    <div> Pet Id: <input type="text" id="username" name="username" value ="<%= request.getParameter("username") %>" readonly></div>
    <div> Pet Id: <input type="text" id="pet_id" name="pet_id" value ="<%= request.getParameter("pet_id") %>" readonly></div>

    <div>
        <label for="type">Choose type:</label>
        <select name="type" id="type">
            <option value="Lost">Lost</option>
            <option value="Stole">Stole</option>
            <option value="Death">Death</option>
        </select>
    </div>

        <div>
            Description: <textarea id="description" name="description" > </textarea>
        </div>

    <input type="submit" value="Save Case!">
</form>

</body>
</html>
