
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Visit</title>
</head>
<body>

<form action="./create-visit">
        <h1>Create Visit! :D</h1>
    <div> Vet: <input type="text" id="vet_id" name="vet_id" value ="<%= request.getParameter("vet_id") %>" readonly></div>
    <div> Pet Id: <input type="text" id="pet_id" name="pet_id" value ="<%= request.getParameter("pet_id") %>" readonly></div>

    <div>
        <label for="type">Visit type:</label>
        <select name="type" id="type">
            <option value="Sterilization">Sterilization</option>
            <option value="Microchip implantation">Microchip implantation</option>
            <option value="Vaccination">Vaccination</option>
            <option value="Deworming">Deworming</option>
            <option value="Urgency">Urgency</option>
            <option value="Control">Control</option>
        </select>
    </div>

        <div>
            Description: <textarea id="description" name="description" > </textarea>
        </div>

    <input type="submit" value="Create!">
</form>

</body>
</html>
