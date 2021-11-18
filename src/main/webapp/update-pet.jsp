
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Pet</title>
</head>

<body>

<form action="./update-pet">
    <h1>Update Pet! :D</h1>
    <div> Pet Id:  <input type="text" readonly id="pet_id" name="pet_id" value ="<%= request.getParameter("pet_id") %>"></div>
    <div> Name: <input type="text" id="name" name="name" value ="<%= request.getParameter("name") %>"></div>
    <div>
        <label for="species" >Choose specie:</label>
        <select name="species" id="species" value ="<%= request.getParameter("species") %>">
            <option  value ="<%= request.getParameter("species") %>"><%= request.getParameter("species") %></option>
            <option value="Dog">Dog</option>
            <option value="Cat">Cat</option>
        </select>
    </div>
    <div>
        Race:  <input type="text" id="race" name="race" value ="<%= request.getParameter("race") %>" required>
    </div>
    <div>
        <label for="size">Choose size:</label>
        <select name="size" id="size">
            <option  value ="<%= request.getParameter("size") %>"><%= request.getParameter("size") %></option>
            <option value="Big">Big</option>
            <option value="Medium">Medium</option>
            <option value="Small">Small</option>
        </select>
    </div>
    <div>
        <label for="sex">Choose sex:</label>
        <select name="sex" id="sex">
            <option  value ="<%= request.getParameter("sex") %>"><%= request.getParameter("sex") %></option>
            <option value="Female">Female</option>
            <option value="Male">Male</option>
        </select>
    </div>
    <div>
        Picture:  <input type="text" id="picture" name="picture" value ="<%= request.getParameter("picture") %>" >
    </div>

<br>
    <input type="submit" value="Update vet!">
</form>
<button onclick="location.href='./list-owner.jsp';">Back</button>

</body>
</html>


