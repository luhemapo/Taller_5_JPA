
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Owner</title>
</head>

<body>

<form action="./update-owner">
    <h1>Update Vet! :D</h1>
    <div> Username:  <input type="text" readonly id="username" name="username" value ="<%= request.getParameter("username") %>"></div>
    <div> Name: <input type="text" id="name" name="name" value ="<%= request.getParameter("name") %>"></div>
    <div> Address: <input type="text" id="address" name="address" value ="<%= request.getParameter("address") %>"></div>
    <div> Neighborhood: <input type="text" id="neighborhood" name="neighborhood" value ="<%= request.getParameter("neighborhood") %>"></div>

    <input type="submit" value="Update owner!">
</form>
<button onclick="location.href='./list-owner.jsp';">Back</button>
</body>
</html>


