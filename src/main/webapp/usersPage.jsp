<%@ page import="java.util.List" %>
<%@ page import="ua.javarush.models.User" %><%--
  Created by IntelliJ IDEA.
  User: volodymyr_krokhmaliuk
  Date: 01.11.2023
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
</head>
<body>
<h1>Add new User</h1>
<form action="/users" method="post">
    FirstName : <input type="text" name="name"><br>
    Age : <input type="number" name="age"><br>
    Email : <input type="text" name="email"><br>
    <input type="submit" value="Add">
</form>

<h3>All Users:</h3>
<%
    List<User> users = (List<User>) request.getAttribute("users");
    for (User u : users) { %>
<%= u %>
<% } %>

%>
</body>
</html>
