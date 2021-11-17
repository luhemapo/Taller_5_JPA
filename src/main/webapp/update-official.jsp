
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Official</title>
</head>

<body>

<form action="./update-official">
    <h1>Update Vet! :D</h1>
    <div> Username:  <input type="text" readonly id="username" name="username" value ="<%= request.getParameter("username") %>"></div>
    <div> Name: <input type="text" id="name" name="name" value ="<%= request.getParameter("name") %>"></div>

    <input type="submit" value="Update official!">
</form>

<button onclick="location.href='./list-official.jsp';">Back</button>
</body>
</html>


