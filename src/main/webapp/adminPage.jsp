<%@ page import="service.GameService" %>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Roman--%>
<%--  Date: 20.02.2024--%>
<%--  Time: 0:37--%>
<%--  To change this template use File | Settings | File Templates.--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet" href="styles/w3.css">
<html>
<head>
    <title>User`s List</title>

</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity-min w3-left-align">
    <header>
        <h1>Admin page</h1>
    </header>
</div>
        <div class="w3-container w3-blue w3-opacity w3-left-align">
            <h2>Users list</h2>
        </div>
                <c:set var = "service" scope = "session" value = "${GameService.getInstance()}"/>
                <c:set var = "users" scope="session" value="${service.getAllUsers()}" />
            <div class="w3-container w3-blue-grey w3-opacity w3-left-align">
                <ul>
                    <c:forEach var="user" items="${users}">
                        <li class="w3-animate-zoom">User id: <c:out value="${user.getId()}"/></li>
                        <li class="w3-animate-zoom">User name: <c:out value="${user.getName()}"/></li>
                        <li class="w3-animate-zoom">User nickname: <c:out value="${user.getNickName()}"/></li>
                        <li class="w3-animate-zoom">Total game: <c:out value="${user.getGameCount()}"/></li>
                        <br>
                    </c:forEach>

                </ul>
            </div>

    <div class="w3-container w3-blue-grey w3-opacity w3-left-align">
        <form action="del" method="post">
            <button  class="w3-btn w3-opacity-min w3-animate-bottom w3-gray w3-round-large" name="button" value="all" type="submit">Delete all users</button>
        </form>
    </div>
    <div class="w3-container w3-grayscale w3-left-align">
        <form action="del" method="post">
            <label for="name">User Name</label>
            <input class="w3-input w3-animate-input w3-border w3-round-large" type="text" name="name" id="name" required><br>
            <label for="nickName">User nickname</label>
            <input class="w3-input w3-animate-input w3-border w3-round-large" type="text" name="nickName" id="nickName" required><br>
            <label for="id">User Id</label>
            <input class="w3-input w3-animate-input w3-border w3-round-large" type="number" name="id" id="id" required><br>
            <button class="w3-btn w3-animate-bottom w3-gray w3-round-large" name="button" value="one" type="submit">Delete user</button><br>
        </form>
    </div>

    <div class="w3-container w3-grey w3-opacity-min w3-right-align w3-padding">
        <a href="index.jsp">Back to main</a>
    </div>
</body>
</html>
