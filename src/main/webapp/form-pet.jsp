
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Pet</title>
</head>
<body>

<form action="./create-pet">
        <h1>Base de datos Ciudadanos de 4 Patas! :D</h1>
    <div>
        Pet id: <input type="text" id="pet_id" name="pet_id" >
    </div>
        <div>
            Microchip: <input type="text" id="microchip" name="microchip" >
        </div>
        <div>
            Name:  <input type="text" id="name" name="name" required>
        </div>
        <div>
            <label for="species">Choose specie:</label>
            <select name="species" id="species">
                <option value="Dog">Dog</option>
                <option value="Cat">Cat</option>
            </select>
        </div>
    <div>
        Race:  <input type="text" id="race" name="race" required>
    </div>
    <div>
        <label for="size">Choose size:</label>
        <select name="size" id="size">
            <option value="Big">Big</option>
            <option value="Medium">Medium</option>
            <option value="Small">Small</option>
        </select>
    </div>
    <div>
        <label for="sex">Choose sex:</label>
        <select name="sex" id="sex">
            <option value="Female">Female</option>
            <option value="Male">Male</option>
        </select>
    </div>
    <div>
        Picture:  <input type="text" id="picture" name="picture" >
    </div>
    <div> Person Id: <input type="text" id="person_id" name="person_id" value ="<%= request.getParameter("person_id") %>" readonly></div>

    <input type="submit" value="Save Pet!">
</form>

</body>
</html>
